package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import com.model.RegistrationModel;
import com.obrs.ViewProfileDAO;

@WebServlet("/ViewProfile")
public class ViewProfile extends HttpServlet {
	
   
 
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		HttpSession  session1=request.getSession();
		String email_id=(String) session1.getAttribute("email_id");
		ArrayList <RegistrationModel>arr=new ArrayList<RegistrationModel>();
		if(ViewProfileDAO.ViewProfileDAO(email_id)!=null)
		{
			arr=ViewProfileDAO.ViewProfileDAO(email_id);
			request.setAttribute("arr", arr);
			rd=request.getRequestDispatcher("viewprofile.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
