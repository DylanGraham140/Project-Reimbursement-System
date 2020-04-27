package dev.graham.service;

import java.util.List;

import dev.graham.DAOs.EmployeesDAO;
import dev.graham.DAOs.EmployeesDAOMariadb;
import dev.graham.DAOs.ManagaerDAO;
import dev.graham.DAOs.ManagaerDAOMariadb;
import dev.graham.DAOs.ReimbursementDAO;
import dev.graham.DAOs.ReimbursementDAOMariadb;
import dev.graham.entities.Employees;
import dev.graham.entities.Managaers;

public class ManagaerService {

	EmployeesDAO edao = new EmployeesDAOMariadb();
	ReimbursementDAO rdao = new ReimbursementDAOMariadb();
	ManagaerDAO mdao = new ManagaerDAOMariadb();

	public Managaers managaerLogin(String name, int password) {
		int listManagaer = 0;
		int foundManagaer = 0;
		boolean nameFound = false;
		boolean passwordFound = false;
		List<Managaers> allManagaerList = mdao.getAllManagaers();

		while (listManagaer < allManagaerList.size()) {

			if (allManagaerList.get(listManagaer).getManagerName().equals(name)) {
				System.out.println("Success: Name: " + name);
				nameFound = true;
			} else {
				System.out.println("Failed: Name: " + name);
				System.out.println(allManagaerList.get(listManagaer).getManagerName());
			}

			if (allManagaerList.get(listManagaer).getPin() == password) {
				System.out.println("Success: Password: " + password);
				passwordFound = true;
				foundManagaer = listManagaer;

			} else {
				System.out.println("Failed: Password: " + password);
				System.out.println(allManagaerList.get(listManagaer).getPin());
			}

			listManagaer++;
		}

		if (nameFound == true && passwordFound == true) {

			return allManagaerList.get(foundManagaer);

		}

		return null;

	}
}
