package dev.graham.entities;

public class Reimbursements {
	int reimbursementId;
	String title;
	int cost;
	String reason;
	String status;
	int employeesId;
	
	@Override
	public String toString() {
		return "Reimbursements [reimbursementId=" + reimbursementId + ", title=" + title + ", cost=" + cost
				+ ", reason=" + reason + ", status=" + status + ", employeesId=" + employeesId + "]";
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Reimbursements() {
		super();
	}
	
	public Reimbursements(String title, int cost, String reason, String status, int employeesId) {
		super();
		this.title = title;
		this.cost = cost;
		this.reason = reason;
		this.employeesId = employeesId;
		this.status = status;
	}
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getEmployeesId() {
		return employeesId;
	}

	public void setEmployeesId(int employeesId) {
		this.employeesId = employeesId;
	}

}
