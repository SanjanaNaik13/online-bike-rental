package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.obrs.Login;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		String email_id=request.getParameter("email");
		String password=request.getParameter("password");
		HttpSession session1=request.getSession();
		if(session1.getAttribute("email_id")==null)
		  session1.setAttribute("email_id",email_id);
		if(session1.getAttribute("password")==null)
			  session1.setAttribute("password",password);
		 
		
		if(email_id!=null && password!=null)
		{
			if(Login.login(email_id,password).equals("user"))
				
			{
				rd=request.getRequestDispatcher("bike_home.jsp");
				rd.forward(request, response);
	}
			else {
				rd=request.getRequestDispatcher("bike_admin.html");
				rd.forward(request, response);
			}
		}
			else if(email_id==null)
		{
			request.setAttribute("errormsg", "Please enter the credentials");
			rd=request.getRequestDispatcher("bike_login.html");
			rd.forward(request, response);
		}
		else if(password==null)
		{
			request.setAttribute("errormsg", "Please enter the password");
			rd=request.getRequestDispatcher("bike_login.html");
			rd.forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
