package dev.graham.DAOs;

import java.util.List;

import dev.graham.entities.*;

public interface ReimbursementDAO {
	
	//CREATE
		Reimbursements createReimbursements(Reimbursements reimbursement);
		
		//READ
		Reimbursements getReimbursementsById(int id);
		List<Reimbursements> getAllReimbursements();
		List<Reimbursements> getCompletedReimbursements();
		List<Reimbursements> getPendingReimbursements();
		
		//UPDATE
		Reimbursements updateReimbursements(Reimbursements reimbursement);
		
		//DELETE
		boolean deleteTask(Reimbursements reimbursement);

}
