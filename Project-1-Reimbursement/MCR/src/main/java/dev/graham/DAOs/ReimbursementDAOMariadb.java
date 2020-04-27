package dev.graham.DAOs;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dev.graham.utils.*;
import dev.graham.entities.Reimbursements;

public class ReimbursementDAOMariadb implements ReimbursementDAO {

	@Override
	public Reimbursements createReimbursements(Reimbursements reimbursement) {
		try (Connection conn = ConnectionUtils.createConnection()) {
			String sql = "INSERT INTO reimbursement.REIMBURSEMENT VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//(1, "Test", 10, "This is test the system", "Pending", 1);
			//ID, INT, TITLE, COST, REASON, STATUS, EMPLOYEES_ID
			ps.setInt(1, reimbursement.getReimbursementId());
			ps.setString(2, reimbursement.getTitle());
			ps.setInt(3, reimbursement.getCost());
			ps.setString(4, reimbursement.getReason());
			ps.setString(5, reimbursement.getStatus());
			ps.setInt(6, reimbursement.getEmployeesId());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int key = rs.getInt("REIMBURSEMENT_ID");
			reimbursement.setReimbursementId(key);
			return reimbursement;
		}
		catch (SQLException e) {
			return null;
		}
	}

	
	
	
	@Override
	public Reimbursements getReimbursementsById(int id) {
		try (Connection conn = ConnectionUtils.createConnection()) {
			
		String sql = 
		"SELECT * FROM reimbursement.REIMBURSEMENT WHERE REIMBURSEMENT_ID = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Reimbursements reimbursement = new Reimbursements();
		reimbursement.setReimbursementId(rs.getInt("REIMBURSEMENT_ID"));
		reimbursement.setTitle(rs.getString("TITLE"));
		reimbursement.setCost(rs.getInt("COST"));
		reimbursement.setReason(rs.getString("REASON"));
		reimbursement.setStatus(rs.getString("STATUS"));
		reimbursement.setEmployeesId(rs.getInt("EMPLOYEES_ID"));
		return reimbursement;
		}catch (SQLException e) {
			return null;
		}
	}

	@Override
	public List<Reimbursements> getAllReimbursements() {
		try (Connection conn = ConnectionUtils.createConnection()) {
		List<Reimbursements> reimbursementList = new ArrayList<Reimbursements>();
		String sql = "SELECT * FROM reimbursement.REIMBURSEMENT"; 
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Reimbursements reimbursement = new Reimbursements();
			reimbursement.setReimbursementId(rs.getInt("REIMBURSEMENT_ID"));
			reimbursement.setTitle(rs.getString("TITLE"));
			reimbursement.setCost(rs.getInt("COST"));
			reimbursement.setReason(rs.getString("REASON"));
			reimbursement.setStatus(rs.getString("STATUS"));
			reimbursement.setEmployeesId(rs.getInt("EMPLOYEES_ID"));
			reimbursementList.add(reimbursement);
		}
		return reimbursementList;
		}catch (SQLException e) {
			return null;
		}
	}

	@Override
	public List<Reimbursements> getCompletedReimbursements() {
		try (Connection conn = ConnectionUtils.createConnection()) {
			List<Reimbursements> reimbursementList = new ArrayList<Reimbursements>();
			String sql = "SELECT * FROM reimbursement.REIMBURSEMENT WHERE STATUS = 'Done' "; 
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setReimbursementId(rs.getInt("REIMBURSEMENT_ID"));
				reimbursement.setTitle(rs.getString("TITLE"));
				reimbursement.setCost(rs.getInt("COST"));
				reimbursement.setReason(rs.getString("REASON"));
				reimbursement.setStatus(rs.getString("STATUS"));
				reimbursement.setEmployeesId(rs.getInt("EMPLOYEES_ID"));
				reimbursementList.add(reimbursement);
			}
			return reimbursementList;
			}catch (SQLException e) {
				return null;
			}	
		
	}

	@Override
	public List<Reimbursements> getPendingReimbursements() {
		try (Connection conn = ConnectionUtils.createConnection()) {
			List<Reimbursements> reimbursementList = new ArrayList<Reimbursements>();
			String sql = "SELECT * FROM reimbursement.REIMBURSEMENT WHERE STATUS != 'Done' "; 
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setReimbursementId(rs.getInt("REIMBURSEMENT_ID"));
				reimbursement.setTitle(rs.getString("TITLE"));
				reimbursement.setCost(rs.getInt("COST"));
				reimbursement.setReason(rs.getString("REASON"));
				reimbursement.setStatus(rs.getString("STATUS"));
				reimbursement.setEmployeesId(rs.getInt("EMPLOYEES_ID"));
				reimbursementList.add(reimbursement);
			}
			return reimbursementList;
			}catch (SQLException e) {
				return null;
			}	
	}

	@Override
	public Reimbursements updateReimbursements(Reimbursements reimbursement) {
		try (Connection conn = ConnectionUtils.createConnection()) {
			String sql = "UPDATE reimbursement.REIMBURSEMENT SET \r\n" + 
					"STATUS = \"Done\" WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbursement.getReimbursementId());
			ps.execute();
			return reimbursement;	
		}catch (SQLException e) {
			return null;
		}
		

		
	}

	@Override
	public boolean deleteTask(Reimbursements reimbursement) {
		// TODO Auto-generated method stub
		return false;
	}

}
