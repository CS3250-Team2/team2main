package sprint1Project;

	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;

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
                                		+ "\n3.) Choose 3 to EXIT. ";
                        System.out.println(menu);
                        number = in.nextInt();
                        		
	            	} while (number < 0 || number > 3);
	            	
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
	        	    	   System.out.println("not ready yet :)");
	        	    	   break;
	        	    	   
	        	       default:
	        	    	   System.out.println("Goodbye.");
	        	    	   break;
	            	}
	            }while (number != 3);
	        }
	            	
	        catch (SQLException e) {       //to check if the db connection was successful or not
	            System.out.println("Oops, error!");
	            e.printStackTrace();
	        }
	    
	    }}

	  

	        
	    
	    


