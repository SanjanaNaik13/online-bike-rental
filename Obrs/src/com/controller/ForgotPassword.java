package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.obrs.ForgotPasswordDAO;


@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		PrintWriter out = response.getWriter();
		String email_id=request.getParameter("email_id");
		String s_quest=request.getParameter("s_quest");
		String s_ans=request.getParameter("s_ans");
		HttpSession session1=request.getSession();
		if(session1.getAttribute("email_d")==null)
			  session1.setAttribute("email_id",email_id);
		if(session1.getAttribute("s_quest")==null)
		  session1.setAttribute("s_quest",s_quest);
		if(session1.getAttribute("s_ans")==null)
			  session1.setAttribute("s_ans",s_ans);
		 
		
		if(s_quest!=null && s_ans!=null && email_id!=null)
		{
			if(ForgotPasswordDAO.forgotpassword1(email_id,s_quest)==true && ForgotPasswordDAO.forgotpassword2(email_id, s_ans))
				
			{
				rd=request.getRequestDispatcher("resetpassword.html");
				rd.forward(request, response);
	}
			else {
				out.println("invalid credentials entered");
				rd=request.getRequestDispatcher("forgotp.html");
				rd.forward(request, response);
			}
		
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

