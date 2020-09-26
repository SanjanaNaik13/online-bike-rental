package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.ResetPasswordModel;
import com.obrs.RegistrationDAO;
import com.obrs.ResetPasswordDAO;

@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd;
		response.setContentType("text/html");
		PrintWriter out= response.getWriter(); 
		String email_id=request.getParameter("email_id");
		String password=request.getParameter("password");
		String password1=request.getParameter("npassword");
		if(password.equalsIgnoreCase(password1))
		{
		ResetPasswordModel rp=new ResetPasswordModel(email_id,password);
		 if(ResetPasswordDAO.resetPassword(rp)==true)
		    {
		    	rd=request.getRequestDispatcher("bike_login.html");
		    	rd.forward(request, response);
		    }
		    else
		    {
		    	out.println("passwords aren't matching");
		    	rd=request.getRequestDispatcher("resetpassword.html");
		    	rd.forward(request, response);
		    }
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
