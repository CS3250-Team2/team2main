
import java.sql.*;

public class dbConnection{

	 public Connection getConnection()
	 {
		 String url = "jdbc:mysql://localhost:3306/sprint1";
	     String username = "root";
	     String password = "David3341";
	     
	     Connection connection = null;
	     
	     try 
	     {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	     } 
	     catch (ClassNotFoundException e1) 
	     {
	        
	        e1.printStackTrace();
	    }

	     try 
	     {
	             connection = DriverManager.getConnection(url, username, password);
	     } 
	     catch (Exception e) 
	     {
	       
	         e.printStackTrace();
	     }
	    return connection;
	    }
	}