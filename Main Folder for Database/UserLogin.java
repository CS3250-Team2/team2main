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
	    
	    
	}
