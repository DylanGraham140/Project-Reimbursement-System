package dev.graham.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.graham.DAOs.ManagaerDAO;
import dev.graham.entities.Employees;
import dev.graham.entities.Managaers;
import dev.graham.utils.ConnectionUtils;

public class ManagaerDAOMariadb implements ManagaerDAO {

	@Override
	public Managaers createManagaers(Managaers currentManagaers) {
		try (Connection conn = ConnectionUtils.createConnection()) {
			String sql = "INSERT INTO reimbursement.MANAGERS VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, 0);
			ps.setString(2, currentManagaers.getManagerName());
			ps.setInt(3, currentManagaers.getBudget());
			ps.setInt(4, currentManagaers.getPin());
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int key = rs.getInt("MANAGERS_ID");
			currentManagaers.setManagerId(key);
			return currentManagaers;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Managaers getManagaersById(int id) {
		
		String sql = "SELECT * FROM reimbursement.MANAGERS WHERE MANAGERS_ID = ?";
		try (Connection conn = ConnectionUtils.createConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Managaers Managaer = new Managaers();

			Managaer.setManagerId(rs.getInt("MANAGERS_ID"));
			Managaer.setManagerName(rs.getString("MANAGERS_NAME"));
			Managaer.setBudget(rs.getInt("BUDGET"));
			Managaer.setPin(rs.getInt("PIN"));

			return Managaer;
		} catch (SQLException e) {
			System.out.println(id + " = User Id");
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public List<Managaers> getAllManagaers() {
		try (Connection conn = ConnectionUtils.createConnection()) {

			String sql = "SELECT * FROM reimbursement.MANAGERS";
			List<Managaers> managersList = new ArrayList<Managaers>();

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Managaers managaer = new Managaers();

				managaer.setManagerId(rs.getInt("MANAGERS_ID"));
				managaer.setManagerName(rs.getString("MANAGERS_NAME"));
				managaer.setBudget(rs.getInt("BUDGET"));
				managaer.setPin(rs.getInt("PIN"));
				managersList.add(managaer);
			}
			return managersList;
		} catch (SQLException e) {
			System.out.println("Line 88: managaer list has failed!");
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Managaers updateEmployee(Managaers currentManagaers) {
		try (Connection conn = ConnectionUtils.createConnection()) {
			
			String sql = "UPDATE  reimbursement.Managaers SET MANAGERS_ID = ?, MANAGERS_NAME = ?, BUDGET = ?, PIN = ?";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, 0);
			ps.setString(2, currentManagaers.getManagerName());
			ps.setInt(3, currentManagaers.getBudget());
			ps.setInt(4, currentManagaers.getPin());
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("Line 107: Managaers UPDATE! has failed!");
			e.printStackTrace();
		}

		return null;	
	}

	@Override
	public boolean deleteManagaer(Managaers currentManagaers) {
		// TODO Auto-generated method stub
		return false;
	}

}
