package com.obrs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForgotPasswordDAO {
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
	  
	  public static Boolean forgotpassword1(String email_id,String s_quest)
	  {  
		  try
		  {
		  getConnection();
		  int nor=0;
	      stmt=con.prepareStatement("select * from user_details where email_id=? and s_quest=? "); 
	      stmt.setString(1, email_id);
	      stmt.setString(2, s_quest);

		  ResultSet rs=stmt.executeQuery();  
		  while(rs.next())
			  {  
			    	nor=1;		
			  }  
		     closeConnection();	 
		    if(nor>0)
		    {
		    	return true;
		    }
		    return false;
		  }
		  catch(SQLException e)
		  {	  e.printStackTrace();	 return false; }
		  catch(Exception e)
		  {	  e.printStackTrace();	 return false; }  
		  
	  }
	  public static Boolean forgotpassword2(String email_id,String s_ans)
	  {  
		  try
		  {
		  getConnection();
		  int nor=0;
	      stmt=con.prepareStatement("select * from user_details where email_id=? and s_ans=? "); 
	      stmt.setString(1, email_id);
	      stmt.setString(2, s_ans);

		  ResultSet rs=stmt.executeQuery();  
		  while(rs.next())
			  {  
			    	nor=1;		
			  }  
		     closeConnection();	 
		    if(nor>0)
		    {
		    	return true;
		    }
		    return false;
		  }
		  catch(SQLException e)
		  {	  e.printStackTrace();	 return false; }
		  catch(Exception e)
		  {	  e.printStackTrace();	 return false; }  
		  
	  }


}
