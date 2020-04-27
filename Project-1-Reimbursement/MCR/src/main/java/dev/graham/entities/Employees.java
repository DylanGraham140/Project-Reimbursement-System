package dev.graham.entities;

public class Employees {
	int employeesId;
	String employeesName;
	int pin;
	int managersId;

	public Employees(int employeesId, String employeesName, int pin, int managersId) {
		super();
		this.employeesId = employeesId;
		this.employeesName = employeesName;
		this.pin = pin;
		this.managersId = managersId;
	}

	public Employees() {
		super();
	}

	public int getEmployeesId() {
		return employeesId;
	}

	public void setEmployeesId(int employeesId) {
		this.employeesId = employeesId;
	}

	public String getEmployeesName() {
		return employeesName;
	}

	public void setEmployeesName(String employeesName) {
		this.employeesName = employeesName;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getManagersId() {
		return managersId;
	}

	public void setManagersId(int managersId) {
		this.managersId = managersId;
	}

}
