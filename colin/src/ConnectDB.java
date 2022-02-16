package sprint1Project;

	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;
	import java.sql.ResultSet;

public class ConnectDB {
	    static Scanner in = new Scanner(System.in);
	
	
	    public static void main(String[] args) throws ClassNotFoundException {
	    	PreparedStatement statement = null; 
            ResultSet rs = null;
	        int number;
	      
	        
	        
	        

	        try {
	        	
	        	Connection connection =new dbConnection().getConnection();	              
	            
	            do {
	            	do {
	            		String menu = "\n Welcome to Team 2 Inventory Program!"
                                		+ "\n1.) Choose 1 to create a username and password."
                                		+ "\n2.) Choose 2 to check inventory information."
                                		+ "\n3.) Choose 3 to print out full inventory."
                                		+ "\n4.) Choose 4 to print out select inventory."
                                		+ "\n5.) Choose 5 to EXIT. ";
                        System.out.println(menu);
                        number = in.nextInt();
                        		
	            	} while (number < 0 || number > 6);
	            	
	            	switch(number) {
	            		case 1:
	            			String sql = "INSERT INTO userInfo (userName, pass) VALUES (?,?)";
	        	            statement = connection.prepareStatement(sql); //reading database?
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
	            			  statement = connection.prepareStatement (sql2);
	            			  System.out.println("Enter a productId: ");
	            			  String productId = in.next ();
	            			  statement.setString(1, productId);
	            			  rs = statement.executeQuery();
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
	            			
	            			String sql3 = "select * from productInfo"; // read the entire table's data on database
	            			statement = connection.prepareStatement (sql3);
	            	        rs = statement.executeQuery(sql3);
	            	        
            			    System.out.println("ProductID\t\tQuantity\tWholesale\tSaleprice\tSupplierId");//add row for name of each column

	            	        while(rs.next()) {//gets data from database
	            	        	String productID =   rs.getString("ProductID");
	            			    double Quantity = rs.getDouble("Quantity");
	            			    double Wholesale = rs.getDouble("Wholesale");
	            			    double Saleprice = rs.getDouble("Saleprice");
	            			    String SupplierID = rs.getString("SupplierId");

	            			    System.out.println( productID + "\t\t" + Quantity + "\t\t" + Wholesale + "\t\t" + Saleprice + "\t\t" + SupplierID);//write one row of data from database
	            	        	}
            			    System.out.println("ProductID\t\tQuantity\tWholesale\tSaleprice\tSupplierId");

	            	        break;
	            			
	        	    	   
	            		case 4:
	            			int choice;
	            			ConnectDB select = new ConnectDB();
	            			String sql4 = "select * from productInfo";
	            			statement= connection.prepareStatement (sql4);
		          			rs = statement.executeQuery();
		          			choice = select.selectChocie();
		          			  
		          			  		switch(choice) {
		          			  			case 1:
		          			  				System.out.println("ProductID\t\tQuantity");
		          			  				while(rs.next()) {
		          			  					String productID =   rs.getString("ProductID");
		          			  					double Quantity = rs.getDouble("Quantity");
		          			  					System.out.println( productID+ "\t\t" + Quantity);
		          			  				System.out.println("ProductID\t\tQuantity");
		          			  				}
		          			  				break;
		          			  				
		          			  			case 2 :
		          			  				System.out.println("ProductID\t\tWholesale");
		          			  				while(rs.next()) {
		          			  					String productID =   rs.getString("ProductID");
		          			  					double Wholesale = rs.getDouble("Wholesale");
		          			  					System.out.println( productID + "\t\t" + Wholesale);
		          			  				}
		          			  				break;
		          			  			
		          			  			case 3:
		          			  				System.out.println("ProductID\t\tSaleprice");
		          			  				while(rs.next()) {
		          			  					String productID =   rs.getString("ProductID");
		          			  					double Saleprice = rs.getDouble("Saleprice");
		          			  					System.out.println( productID + "\t\t" + Saleprice);
		          			  				}
		          			  				break;
		          			  				
		          			  				
		          			  			case 4:
		          			  				System.out.println("ProductID\t\tSupplierId");
		          			  				while(rs.next()) {
		          			  					String productID =   rs.getString("ProductID");
		          			  					String SupplierID = rs.getString("SupplierId");
		          			  					System.out.println( productID + "\t\t" + SupplierID);
		          			  				}
		          			  				break;
		          			  			default:
		          			  				break;
		   
		          			  
		          			  		}
		          			
		          			  break;
		          			 
	            		case 5: //this case add into the inventory
	            			System.out.println("Enter product ID.");
	            			String productID =  in.next();
	            			
	            			System.out.println("Enter product quantity.");
            			    double Quantity = in.nextInt();
            			    
            			    System.out.println("Enter wholesale.");
            			    double Wholesale =in.nextInt();
            			     			   
            			    System.out.println("Enter sale price ID.");           			    
            			    double Saleprice = in.nextInt();
            			    
            			    System.out.println("Enter supplier ID.");
            			    String SupplierID = in.next();
            			    
	            			String sql5 = "INSERT INTO productInfo (ProductID, Quantity, Wholesale, Saleprice, SupplierID )" //state to call to table and columns in mySql
	            			+ "VALUES ('"+ productID +"', '"+Quantity+"',  '"+Wholesale+"', '"+Saleprice+"', '"+SupplierID+"')";//values from data obtain from user input
	            			statement= connection.prepareStatement (sql5);
	            			
	            			statement.executeUpdate();//to update information in database with new entry
	            			
	            		
	            			
	        	       default:
	        	    	   System.out.println("Goodbye.");
	        	    	   break;
	            	
	            	}
	            
	        
	        
	            }while (number != 6); 
	        }
	            
	        
	            	
	        catch (SQLException e) {       //to check if the db connection was successful or not
	            System.out.println("Oops, error!");
	            e.printStackTrace();
	         }
	    
	        	
	    
	    }
		   public int selectChocie() {
		    	
		    	//Scanner in = new Scanner(System.in);
		    	
		    	String menu = 
		    		 "\n1.) Choose 1 to  add/delete/print  id of product."	
	           		+"\n2.) Choose 2 to add/delete/print quantity of product."
	           		+ "\n3.) Choose 3 to  add/delete/print  wholesale of product."
	           		+ "\n4.) Choose 4 to  add/delete/print  saleprice of product."
	           		+ "\n5.) Choose 5 to  add/delete/print  supplier ID of product."
	           		+ "\n6.) Choose 6 to EXIT. ";
		    	System.out.println(menu);
		    	int choice = in.nextInt();
		    	
		    	return choice;
		    }
		   
		   public void UpdateInventory() {
			   
		   }
		    
		   public void PrintInventory(){
			   
		   }
		   
		 
		   public String Delete(int DeleteChoice) {
			 
			  return null;
		   }
		  
	     
}
