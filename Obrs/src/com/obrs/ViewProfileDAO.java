package com.obrs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.RegistrationModel;

public class ViewProfileDAO {
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
	  
	  public static ArrayList<RegistrationModel> ViewProfileDAO(String email_id)
	  {
		  ArrayList <RegistrationModel> arr=new ArrayList<RegistrationModel>();
		  RegistrationModel reg;
		  try
		  {
		  getConnection();
	      stmt=con.prepareStatement("select email_id,name,ph_no,location from user_details where email_id=? "); 
	      stmt.setString(1, email_id);
		  ResultSet rs=stmt.executeQuery();
		  while(rs.next())
		  {
			  reg=new RegistrationModel(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4));
			  arr.add(reg);
			  System.out.println(reg);
		  }
		  closeConnection();	 
		     return arr;
			 
		  }
		  catch(SQLException e)
		  {	  e.printStackTrace();	
		  return null;
		  }
		  catch(Exception e)
		  {	  e.printStackTrace();	 
		  return null;
		  }  	  
}
}