package dev.graham.service;

import java.util.ArrayList;
import java.util.List;

import dev.graham.entities.*;
import dev.graham.DAOs.*;

public class EmployeesService {

	EmployeesDAO edao = new EmployeesDAOMariadb();
	ReimbursementDAO rdao = new ReimbursementDAOMariadb();
	ManagaerDAO mdao = new ManagaerDAOMariadb();

	public Employees employeeLogin(String name, int password) {
		int listEmployees = 0;
		int foundemployee = 0;
		boolean nameFound = false;
		boolean passwordFound = false;
		List<Employees> allEmployeesList = edao.getAllEmployees();

		while (listEmployees < allEmployeesList.size()) {

			if (allEmployeesList.get(listEmployees).getEmployeesName().equalsIgnoreCase(name)) {
				System.out.println("Success: Name: " + name);
				nameFound = true;
			} else {
				System.out.println("Failed: Name: " + name);
				System.out.println(allEmployeesList.get(listEmployees).getEmployeesName());
			}

			if (allEmployeesList.get(listEmployees).getPin() == password) {
				System.out.println("Success: Password: " + password);
				passwordFound = true;
			} else {
				System.out.println("Failed: Password: " + password);
				System.out.println(allEmployeesList.get(listEmployees).getPin());
				foundemployee = listEmployees;
			}

			listEmployees++;
		}

		if (nameFound == true && passwordFound == true) {

			return allEmployeesList.get(foundemployee);
		}

		return null;

	}
}
