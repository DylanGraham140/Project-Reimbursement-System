package dev.graham.DAOs;

import java.util.List;


import dev.graham.entities.Managaers;

public interface ManagaerDAO {
		//Create
		Managaers createManagaers(Managaers currentManagaers);
		
		//Read
		Managaers getManagaersById(int id);
		List<Managaers> getAllManagaers();
		
		
		//Update
		Managaers updateEmployee(Managaers currentManagaers);
		
		//Delete
		boolean deleteManagaer(Managaers currentManagaers);
}
