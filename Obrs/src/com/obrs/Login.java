package com.obrs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Login {
	private static Connection con; 
	  private static PreparedStatement stmt;
	  
	public static void getConnection()
	  {	 	
		  String JdbcURL = "jdbc:mysql://localhost:3307/bikedatabase?" + "autoReconnect=true&useSSL=false";
	      String Username = "root";
	      String password = "";
	       con = null;      
	      try 
	      {
	    	 Class.forName("com.mysql.jdbc.Driver");   // Driver should be registered
	    	 // con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test1","root","");  
	         con = DriverManager.getConnection(JdbcURL, Username, password);
	         
	      } 
	      catch (Exception e) 
	      {
	         e.printStackTrace();
	      }
		   
		 
	  }
	  public static void closeConnection()
	  {
		  try{
			  if(con.isClosed()==false)
		          con.close();   // closing the connection
		  }
		  catch(Exception e)
		  { e.printStackTrace();	 }
	  }  
	  
	  public static String login(String email,String password)
	  {  
		  String utype=null;
		  try
		  {
		  getConnection();
		  int nor=0;
	      stmt=con.prepareStatement("select u_type from user_details where email_id=? and password=? "); 
	      stmt.setString(1, email);
	      stmt.setString(2, password);
		  ResultSet rs=stmt.executeQuery();  
		  while(rs.next())
			  {  
			    	utype=rs.getString(1);		
			  }  
		     closeConnection();	 
		     return utype;
		   
		  }
		  catch(SQLException e)
		  {	  e.printStackTrace();	 return null; }
		  catch(Exception e)
		  {	  e.printStackTrace();	 return null; }  	  
	  }
}
