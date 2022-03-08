import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import com.mysql.cj.xdevapi.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class OrderTable {

	PreparedStatement statement = null; 
	//java.sql.Statement state = null; 
    ResultSet rs = null;
    String q;
    Connection connection = new dbConnection().getConnection();//open connection to mySql database


	
    public List<OrderInfo> getAllOrderInfo()throws Exception{
    	List<OrderInfo> list = new ArrayList<>();  
    	
    	PreparedStatement statement = null; 
    	ResultSet rs = null;
    	
    	try {	
        	q = ("select * from orders");
    		 statement = connection.prepareStatement (q);    
        	rs = statement.executeQuery(q);
    

        	while(rs.next()) {//gets data from database
				OrderInfo tempOrderInfo = convertRowToProduct(rs);
				list.add(tempOrderInfo);
				
			}
						
			statement.close();
    	}
    	catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     } 
    	return list; 
		
		
    
}
    
    public List<OrderInfo> searchAllOrderInfo(String cust_email)throws Exception{
    	List<OrderInfo> list = new ArrayList<>();
    	
    	try {
    		cust_email +="%";
        	q = ("select * from orders where cust_email like ?");
        	
    		statement = connection.prepareStatement (q);  
    		statement.setString( 1, cust_email);//calling to first column to search 
        	rs = statement.executeQuery();
    

        	while(rs.next()) {//gets data from database
				OrderInfo tempOrderInfo = convertRowToProduct(rs);
				list.add(tempOrderInfo);
				
			}
						
			statement.close();
			rs.close();
			
		}
    	catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     } 
    	return list;
    }
    
   
	
private OrderInfo convertRowToProduct(ResultSet rs) throws SQLException {

 	    
		Date date = rs.getDate("date");
		String cust_email = rs.getString("cust_email");
		double cust_location =  rs.getDouble("cust_location");;
		String orderproductId = rs.getString("ProductID");
		double orderquantity =  rs.getDouble("Quantity");;

		OrderInfo tempOrderInfo = new OrderInfo( date,  cust_email, 
				cust_location,  orderproductId,orderquantity);
	 		
	
	 return tempOrderInfo;
	}

public void addOrder(LocalDate date, String cust_email, double cust_Location , String ProductID , double Quantity) {
	


	try {
		
		 String sql5 = "INSERT INTO orders (Date, cust_email, cust_location, ProductID, Quantity )" //state to call to table and columns in mySql
				+ "VALUES ('"+ date +"' , '"+cust_email+"','"+cust_Location+"','"+ProductID+"','"+Quantity+"')";//values from data obtain from user input
		 	PreparedStatement statement=connection.prepareStatement(sql5);
		 	
		
		 	statement.executeUpdate(sql5);//to update information in database with new entry
		 
		 	statement.close();
	}
	catch (SQLException e) {       //to check if the db connection was successful or not
        System.out.println("Oops, error!");
        e.printStackTrace();
     }
}
}
