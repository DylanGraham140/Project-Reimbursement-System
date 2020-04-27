package dev.graham.DAOs;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.graham.entities.Employees;
import dev.graham.utils.ConnectionUtils;

public class EmployeesDAOMariadb implements EmployeesDAO {

	@Override
	public Employees createEmployee(Employees currentEmployees) {

		try (Connection conn = ConnectionUtils.createConnection()) {
			String sql = "INSERT INTO reimbursement.EMPLOYEES VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, 0);
			ps.setString(2, currentEmployees.getEmployeesName());
			ps.setInt(3, currentEmployees.getPin());
			ps.setInt(4, currentEmployees.getManagersId());
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int key = rs.getInt("EMPLOYEES_ID");
			currentEmployees.setEmployeesId(key);
			return currentEmployees;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Employees getEmployeeById(int id) {

		String sql = "SELECT * FROM reimbursement.EMPLOYEES WHERE EMPLOYEES_ID = ?";
		try (Connection conn = ConnectionUtils.createConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Employees employee = new Employees();

			employee.setEmployeesId(rs.getInt("EMPLOYEES_ID"));
			employee.setEmployeesName(rs.getString("EMPLOYEES_NAME"));
			employee.setPin(rs.getInt("PIN"));
			employee.setManagersId(rs.getInt("MANAGERS_ID"));

			return employee;
		} catch (SQLException e) {
			System.out.println(id + " = User Id");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employees> getAllEmployees() {
		try (Connection conn = ConnectionUtils.createConnection()) {

			String sql = "SELECT * FROM reimbursement.EMPLOYEES";
			List<Employees> employeesList = new ArrayList<Employees>();

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employees employee = new Employees();

				employee.setEmployeesId(rs.getInt("EMPLOYEES_ID"));
				employee.setEmployeesName(rs.getString("EMPLOYEES_NAME"));
				employee.setPin(rs.getInt("PIN"));
				employee.setManagersId(rs.getInt("MANAGERS_ID"));
				employeesList.add(employee);
			}
			return employeesList;
		} catch (SQLException e) {
			System.out.println("Line 88: Employees list has failed!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employees updateEmployee(Employees currentEmployees) {
		try (Connection conn = ConnectionUtils.createConnection()) {
			String sql = "UPDATE  reimbursement.EMPLOYEES SET EMPLOYEES_ID = ?, EMPLOYEES_NAME = ?, PIN = ?, MANAGERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, 0);
			ps.setString(2, currentEmployees.getEmployeesName());
			ps.setInt(3, currentEmployees.getPin());
			ps.setInt(4, currentEmployees.getManagersId());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Line 107: Employees UPDATE! has failed!");
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean deleteEmployee(Employees currentEmployees) {
		// TODO Auto-generated method stub
		return false;
	}

}
