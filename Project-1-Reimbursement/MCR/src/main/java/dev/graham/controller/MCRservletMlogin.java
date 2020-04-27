package dev.graham.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import dev.graham.entities.*;
import dev.graham.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dev.graham.controller.*;

/**
 * Servlet implementation class MCRservletDispacter
 */
public class MCRservletMlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeController eController = new EmployeeController();
	

	public MCRservletMlogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uri = request.getRequestURI();
		System.out.println("The url entered " + uri);

		switch (uri) {
		
		case "/MCR/MCRservletMlogin":
			System.out.println("entered login");
			eController.managaerLogin(request, response);
			break;
			
		default:
			response.getWriter().append("your request uri did not match anything");
			break;

		}
	}

	private void employeeLogin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
