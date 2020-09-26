package com.obrs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.model.*;

public class RegistrationDAO {
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
		  { e.printStackTrace();	 }
	  }
	  
	  public static boolean register(RegistrationModel reg)
	  {
		  int nor=0;
		  try{
			  getConnection();
			   stmt=con.prepareStatement("insert into user_details values(?,?,?,?,?,?,?,?,?,?)");
			  stmt.setString(1, reg.getEmail_id());
			  stmt.setString(2, reg.getName());
			  stmt.setString(3, reg.getDl_no());
			  stmt.setString(4, reg.getPh_no());
			  stmt.setString(5, reg.getPassword() );
			  stmt.setString(6, reg.getLocation());
			  stmt.setString(7, reg.getUtype());
			  stmt.setString(8, reg.getS_quest());
			  stmt.setString(9, reg.getS_ans());
			 stmt.setString(10, reg.getU_id());
			    nor= stmt.executeUpdate();
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
