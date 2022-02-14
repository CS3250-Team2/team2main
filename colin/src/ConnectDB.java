package sprint1Project;

	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;
	import java.sql.ResultSet;

public class ConnectDB {
	    public static void main(String[] args) throws ClassNotFoundException {
	        String url = "jdbc:mysql://localhost:3306/sprint1";
	        String username = "root";
	        String password = "ZHk37_fTdZZ4bnkp";
	        	        int number;
	      
	        Scanner in = new Scanner(System.in);
	        
	        

	        try {
	        	
	            Connection connection = DriverManager.getConnection(url, username, password);
	            
	            
	            do {
	            	do {
	            		String menu = "\n Welcome to Team 2 Inventory Program!"
                                		+ "\n1.) Choose 1 to create a username and password."
                                		+ "\n2.) Choose 2 to check inventory information."
                                		+ "\n3.) Choose 3 to print out full inventory."
                                		+ "\n4.) Choose 4 to EXIT. ";
                        System.out.println(menu);
                        number = in.nextInt();
                        		
	            	} while (number < 0 || number > 4);
	            	
	            	switch(number) {
	            		case 1:
	            			String sql = "INSERT INTO userInfo (userName, pass) VALUES (?,?)";
	        	            PreparedStatement statement = connection.prepareStatement(sql); //reading database?
	        	            String userName; //declaring strings
	        	            String pass;
	        	            System.out.println("Enter your username: ");
	        	            userName = in.next();	        	       //scanner input for username 
	        	            System.out.println("Enter your password: ");
	        	            pass = in.next();						   //scanner input for pass
	        	            
	        	            
	        	            statement.setString(1, userName); //row position 1 and userName column
	        	            statement.setString(2, pass);     //row position 2 and pass column
	        	            
	        	            int rows = statement.executeUpdate(); //checking if a row was inserted 
	        	            if (rows > 0) {
	        	            	System.out.println("A row has been inserted.");
	        	            	statement.close();}
	        	            break;
	        	          
	            		case 2:
	            			  String sql2 = "select ProductID, Quantity, Wholesale, Saleprice, SupplierID from productInfo where ProductID = ?";
	            			  PreparedStatement stmt = connection.prepareStatement (sql2);
	            			  System.out.println("Enter a productId: ");
	            			  String productId = in.next ();
	            			  stmt.setString(1, productId);
	            			  ResultSet rs = stmt.executeQuery();
	            			  while (rs.next()) {
	            			      String productID =   rs.getString("ProductID");
	            			      double Quantity = rs.getDouble("Quantity");
	            			      double Wholesale = rs.getDouble("Wholesale");
	            			      double Saleprice = rs.getDouble("Saleprice");
	            			      String SupplierID = rs.getString("SupplierId");
	            			      System.out.println("ProductID: " + productID + ", Quantity: " + Quantity + ", Wholesale: " + Wholesale + ", Saleprice: " + Saleprice + ", SupplierID: " + SupplierID);
	            			  }
	            			  break;

        	    			   
	      	    		   
	            		case 3: 
	            			String sql3 = "select * from productInfo"; // print the entire table on database
	            			PreparedStatement stmt2 = connection.prepareStatement (sql3);
	            	        	ResultSet rs2 = stmt2.executeQuery(sql3);
	            	        	while(rs2.next()) {
	            	        	    String productID =   rs2.getString("ProductID");
	            			    double Quantity = rs2.getDouble("Quantity");
	            			    double Wholesale = rs2.getDouble("Wholesale");
	            			    double Saleprice = rs2.getDouble("Saleprice");
	            			    String SupplierID = rs2.getString("SupplierId");
	            			    System.out.println("ProductID: " + productID + ", Quantity: " + Quantity + ", Wholesale: " + Wholesale + ", Saleprice: " + Saleprice + ", SupplierID: " + SupplierID);
	            	        	}
	            			break;
	        	    	   
	        	    	  
	        	    	   
	        	       default:
	        	    	   System.out.println("Goodbye.");
	        	    	   break;
	            	
	            	}
	            
	        
	        
	            }while (number != 4); 
	        }
	            
	        
	            	
	        catch (SQLException e) {       //to check if the db connection was successful or not
	            System.out.println("Oops, error!");
	            e.printStackTrace();
	        }
	    }
}




	  

	        
	    
	    


