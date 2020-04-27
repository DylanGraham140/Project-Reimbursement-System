package dev.graham.DAOs;
import dev.graham.entities.Employees;
import java.util.List;


public interface EmployeesDAO {
	
	//Create
	Employees createEmployee(Employees currentEmployees);
	
	//Read
	Employees getEmployeeById(int id);
	List<Employees> getAllEmployees();
	
	//Update
	Employees updateEmployee(Employees currentEmployees);
	
	//Delete
	boolean deleteEmployee(Employees currentEmployees);
}
