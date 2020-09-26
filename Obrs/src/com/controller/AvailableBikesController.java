package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.obrs.*;


import com.model.*;



@WebServlet("/AvailableBikesController")
public class AvailableBikesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		RequestDispatcher rd;
		String rent_type=request.getParameter("rent_type");
		HttpSession session1=request.getSession();
		ArrayList<RegistrationModel> arr=new ArrayList<RegistrationModel>();
		arr=AvailableBikesDAO.allbikes(rent_type);
		request.setAttribute("arr", arr);
		rd=request.getRequestDispatcher("bike_home.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
