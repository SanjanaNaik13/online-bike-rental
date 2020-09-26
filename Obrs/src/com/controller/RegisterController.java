package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.obrs.RegistrationDAO;
import com.model.RegistrationModel;

/**
 * Servlet implementation class Register
 */
@WebServlet("/registerController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int n=1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		response.setContentType("text/html");
		PrintWriter out= response.getWriter(); 
		String utype="user";
		String email_id=request.getParameter("email_id");
        String name=request.getParameter("name");
        String dl_no=request.getParameter("dl_no");
		String ph_no=request.getParameter("ph_no");
		String password=request.getParameter("password");
		String location=request.getParameter("location");
		String s_quest=request.getParameter("s_quest");
		String s_ans=request.getParameter("s_ans");
		String u_id=request.getParameter("u_id");
	    RegistrationModel r1=new  RegistrationModel(email_id, name, dl_no, ph_no, password, location,utype, s_quest, s_ans,u_id);
			r1.setU_id(u_id);
			n++;
	    if(RegistrationDAO.register(r1)==true)
	    {
	    	rd=request.getRequestDispatcher("bike_login.html");
	    	rd.forward(request, response);
	    }
	    else
	    {
	    	out.println("please enter the credential");
	    	rd=request.getRequestDispatcher("bike_registration.html");
	    	rd.forward(request, response);
	    }
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


