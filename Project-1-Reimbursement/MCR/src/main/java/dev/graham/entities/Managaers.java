package dev.graham.entities;

public class Managaers {
	int managerId;
	String managerName;
	int budget;
	int pin;

	public Managaers() {
		super();
	}

	public Managaers(int managerId, String managerName, int budget, int pin) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.budget = budget;
		this.pin = pin;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

}
