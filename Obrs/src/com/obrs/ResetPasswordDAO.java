package com.obrs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.RegistrationModel;
import com.model.*;

public class ResetPasswordDAO {
	private static Connection con; 
	private static PreparedStatement stmt;
	public static void getConnection()
	  {
		  try {
		  Class.forName("com.mysql.jdbc.Driver");   // Driver should be registered
		  con=DriverManager.getConnection( "jdbc:mysql://localhost:3307/bikedatabase","root",""); 
		  }
		  catch(SQLException e)
		  {	  e.printStackTrace();	  }
		  catch(Exception e)
		  {	  e.printStackTrace();	  }  	  
		  
	  
	  }
	  public static void closeConnection()
	  {
		  try{
			  if(con.isClosed()==false)
		          con.close();   // closing the connection
		  }
		  catch(Exception e)
		  { 
			  e.printStackTrace();
			  }
	  }
	  public static boolean resetPassword(ResetPasswordModel rp)
	  {
		  int nor=0;
		  String qn=null;
		  try
		  {
		  getConnection();
	      stmt=con.prepareStatement("update user_details set password=? where email_id=?");  
	      stmt.setString(2,rp.getEmail_id());
	      stmt.setString(1,rp.getPassword());
		  nor=stmt.executeUpdate();
		     closeConnection();	
			   if (nor>0)
			   {
				   return true;
			   }
			   else
				   return false;
			    }
			  catch(SQLException e)
			  {
			  e.printStackTrace();
			  return false;
			  }
			  catch(Exception e)
			  {
			  e.printStackTrace();
			  return false;
			  }  	  	  
			  
		  }
	

}
