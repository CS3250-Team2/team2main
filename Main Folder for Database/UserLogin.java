import java.sql.SQLException;
	

	//import com.mysql.cj.xdevapi.Statement;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;


public class UserLogin {

	
		PreparedStatement statement = null; 
		//java.sql.Statement state = null; 
	    ResultSet rs = null;
	    String q;
	    Connection connection = new dbConnection().getConnection();//open connection to mySql database
		private int authorization;
		private String username;
		private String password;
		//private String email;
		private boolean exist = false;

		
	  
	    
	    public int searcAuthroization(String userName)throws Exception{
	    	//List<ProductInfo> list = new ArrayList<>();
	    	
	    	try {
	    		//userName +="%";
	        	q = ("select authorization from userInfo where userName = ?");
	        	
	    		statement = connection.prepareStatement (q);  
	    		statement.setString( 1, userName);//calling to first column to search 
	        	rs = statement.executeQuery();
	    

				while(rs.next()) {//gets data from database
					 authorization = rs.getInt("authorization");
				}
							
				statement.close();
				rs.close();
				
			}
	    	catch (SQLException e) {       //to check if the db connection was successful or not
		        System.out.println("Oops, error!");
		        e.printStackTrace();
		     } 
	    System.out.println("this authoriation is :" + authorization);
	    
			return authorization;
	    }
	    
	   public int checkAccount(boolean username, boolean password) {
		   
		   if (username == true && password == true) {
			  authorization =  1;
		   }
		   else {
			   authorization = 0;
		   }
		
		   return authorization;
	   }
	    
	   public boolean checkUserName(String input) {
		
		 
		q = ("select * from userInfo where userName = ?");
       	try {
   		statement = connection.prepareStatement (q);  
   		statement.setString( 1, input);//calling to first column to search 
       	rs = statement.executeQuery();
       	
       		if(rs.next()) {
       			exist  = true; 
       		}
       		
       	}
       	catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     } 
		return exist;
		   
	   } 
	   
	   public boolean checkPassword(String input) {
			
			 
			q = ("select * from userInfo where pass = ?");
	       	try {
	   		statement = connection.prepareStatement (q);  
	   		statement.setString( 1, input);//calling to first column to search 
	       	rs = statement.executeQuery();
	       	
	       		if(rs.next()) {
	       			exist  = true; 
	       		}
	       		
	       	}
	       	catch (SQLException e) {       //to check if the db connection was successful or not
		        System.out.println("Oops, error!");
		        e.printStackTrace();
		     } 
			return exist;
			   
		   } 
		    
	    public void guest(String email) {
	    	PreparedStatement statement = null; 
	    	
			try {
					String q = "INSERT INTO userInfo (userName, pass, authorization, firstName, lastName,email )" //state to call to table and columns in mySql
					+ "VALUES (guest, guest , '"+ 1 +"',guest,guest,'"+ email +"')";//values from data obtain from user input
	
					statement= connection.prepareStatement (q);
	 

					statement.executeUpdate(q);//to update information in database with new entry
	 
					statement.close();
				}
			catch (SQLException e) {       //to check if the db connection was successful or not
					System.out.println("Oops, error!");
					e.printStackTrace();
				} 
	    	
	    }
	    
	   
	}