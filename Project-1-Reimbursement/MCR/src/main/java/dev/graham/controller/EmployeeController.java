package dev.graham.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.graham.entities.*;
import dev.graham.DAOs.*;
import dev.graham.servlet.*;
import dev.graham.controller.*;
import dev.graham.service.*;
import dev.graham.servlet.*;

public class EmployeeController {

	EmployeesService eserv = new EmployeesService();
	ManagaerService mserv = new ManagaerService();
	ReimbursementService rserv = new ReimbursementService();
	private ReimbursementDAO rdao = new ReimbursementDAOMariadb();
	public int currentid;
	public int currentmanid;

	public void employeeLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		out.print(name + " the name and password " + password);
		if (password == "") {
			out.print("no password given");
			response.sendRedirect("http://localhost:8080/MCR/employeelogin.html");

		}
		int pin = Integer.parseInt(password);

		Employees empCurrent = new Employees();
		if (eserv.employeeLogin(name, pin) != null) {
			empCurrent = eserv.employeeLogin(name, pin);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("id", empCurrent.getEmployeesId());
			currentid = empCurrent.getEmployeesId();
			System.out.println(currentid);
			response.sendRedirect("http://localhost:8080/MCR/employeehomepage.html");
		} else {
			// comeback to this
			response.sendRedirect("http://localhost:8080/MCR/employeelogin.html");
		}
	}

	public void managaerLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		out.print(name + "the name and password" + password);
		if (password == "") {
			out.print("no password given");
		}
		int pin = Integer.parseInt(password);

		Managaers manCurrent = new Managaers();
		if (mserv.managaerLogin(name, pin) != null) {
			manCurrent = mserv.managaerLogin(name, pin);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("id", manCurrent.getManagerId());
			currentid = manCurrent.getManagerId();
			response.sendRedirect("http://localhost:8080/MCR/manhomepage.html");
		} else {
			// comeback to this
			response.sendRedirect("http://localhost:8080/MCR/managerlogin.html");
		}
	}

	public void reimbursementsAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Entered reimbursmentsall");
		Gson gson = new Gson();
		List<Reimbursements> rList = rserv.getAllReimbursements();
		PrintWriter pw = response.getWriter();
		String json = gson.toJson(rList);
		pw.append(json);

	}

	public void reimbursementsAllbyId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Entered reimbursmentsallbyid");
		Gson gson = new Gson();
		List<Reimbursements> rList = rserv.getAllReimbursements();
		List<Reimbursements> rListid = new ArrayList<Reimbursements>();
		int counterlistr = 0;

		while (counterlistr < rList.size()) {
			if (currentid == rList.get(counterlistr).getEmployeesId()) {
				System.out.println(rList.size() + " " + counterlistr);
				rListid.add(rList.get(counterlistr));
				counterlistr++;
			}
		}

		PrintWriter pw = response.getWriter();
		String json = gson.toJson(rListid);
		pw.append(json);

	}

	public void reimbursementsAllByDone(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Entered reimbursementsAllByDone");
		Gson gson = new Gson();
		List<Reimbursements> rList = rdao.getCompletedReimbursements();
		
		
		/*List<Reimbursements> rListid = new ArrayList<Reimbursements>();
		int counterlistr = 0;
		String done = "Done";

		
		while (counterlistr < rList.size()) {
			if (rList.get(counterlistr).getStatus().equalsIgnoreCase(done)) {
				System.out.println(rList.size() + " " + counterlistr);
				rListid.add(rList.get(counterlistr));
				counterlistr++;
			}
		}
		*/

		PrintWriter pw = response.getWriter();
		String json = gson.toJson(rList);
		pw.append(json);

	}

	public void reimbursementsAllByPending(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("Entered Pending");
		Gson gson = new Gson();
		List<Reimbursements> rList = rdao.getPendingReimbursements();
		
		PrintWriter pw = response.getWriter();
		String json = gson.toJson(rList);
		pw.append(json);

	}

	public void reimbursementsNew(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
		Gson gson = new Gson();

		// turn a json into an object you have to tell it what type of object to turn it
		System.out.println("Enter new reim");

		Reimbursements reimbursement = gson.fromJson(body, Reimbursements.class);
		System.out.println(reimbursement);
		reimbursement.setEmployeesId(currentid);
		reimbursement.setStatus("Pending");
		System.out.println(reimbursement);

		rserv.createReimbursements(reimbursement);
		response.getWriter().append("Success!!!!");

	}
	
	public void reimbursementsUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
		Gson gson = new Gson();

		// turn a json into an object you have to tell it what type of object to turn it
		System.out.println("Enter update!");

		Reimbursements reimbursement = gson.fromJson(body, Reimbursements.class);
		System.out.println(reimbursement);
		rdao.updateReimbursements(reimbursement);
	}

}
