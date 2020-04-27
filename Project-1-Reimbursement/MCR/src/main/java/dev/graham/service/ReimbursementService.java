package dev.graham.service;

import dev.graham.DAOs.ReimbursementDAOMariadb;
import java.util.ArrayList;
import java.util.List;

import dev.graham.entities.*;
import dev.graham.DAOs.*;

public class ReimbursementService {
	
	private ReimbursementDAO rdao = new ReimbursementDAOMariadb();
	
	public Reimbursements createReimbursements(Reimbursements Reimbursements) {
		System.out.println(Reimbursements);
		rdao.createReimbursements(Reimbursements);
		return Reimbursements;
	}

	public List<Reimbursements> getAllReimbursements() {		
		return rdao.getAllReimbursements();
	}


}
