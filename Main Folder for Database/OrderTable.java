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
    ResultSet rs = null;//reads from the database
    String q;//string for the statement to enter into database
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
		String orderproductId = rs.getString("product_id");
		double orderquantity =  rs.getDouble("product_quantity");;
		double orderId = rs.getDouble("OrderID");
		OrderInfo tempOrderInfo = new OrderInfo( date,  cust_email, 
				cust_location,  orderproductId,orderquantity, orderId);
	 		
	
	 return tempOrderInfo;
	}

public void addOrder(LocalDate date, String cust_email, double cust_Location , String ProductID , double Quantity, double orderId) {

    try {

         String sql5 = "INSERT INTO orders (DATE, cust_email, cust_location, product_id, product_quantity, OrderId )" //state to call to table and columns in mySql
                + "VALUES ('"+ date +"' , '"+cust_email+"','"+cust_Location+"','"+ProductID+"','"+Quantity+"','"+orderId+"')";//values from data obtain from user input
             PreparedStatement statement=connection.prepareStatement(sql5);


             statement.executeUpdate(sql5);//to update information in database with new entry

             statement.close();
    }
    catch (SQLException e) {       //to check if the db connection was successful or not
        System.out.println("Oops, error!");
        e.printStackTrace();
     }
}

public double checkOrderId(double input ) {
	//String queryCheck = String.format("SELECT * from orders WHERE OrderId = %f", input);
	
		try {
			
			//input +="%";
        	q = ("select * from orders where OrderId like ?");///need to query to mysql with c
        	
    		statement = connection.prepareStatement (q);  
    		statement.setDouble( 1, input);//calling to first column to search 
        	rs = statement.executeQuery();
	
	// if this ID already exists, we increase orderID by 1 
    
	if(rs.next()) {
		input = input +1;
		
	    // connection.close();
	 
	}
	else {
		
		input = 0;
	}

    statement.close();
	}
	
	catch (SQLException e) {       //to check if the db connection was successful or not
		System.out.println("Oops, error!");
		e.printStackTrace();
   
		}
	return input;
}

	public void addOrderId(double input) {
		String a = null;
		try {
			//String q =  String.format("Update productInfo set Quantity = %f, Wholesale = %f, Saleprice = %f, SupplierID = %s WHERE ProductID = %s",Quantity,Wholesale, Saleprice,SupplierID, productID); //state to call to table and columns in mySql
		//String q =  String.format("Update orders SET OrderId = %f WHERE OrderId = is Null",input); //state to call to table and columns in mySql
			 /*String sql5 = "INSERT INTO orders (OrderId )" //state to call to table and columns in mySql
		                + "VALUES ('"+input+"')";*/
			String q =  String.format("Update orders SET OrderId = '"+input+"' WHERE OrderId = '"+a+"'"); //state to call to table and columns in mySql

		System.out.println("this is editString = "+ q);
			
			statement= connection.prepareStatement (q);


			statement.executeUpdate(q);//to update information in database with new entry
			
			statement.close();
		}
	catch (SQLException e) {       //to check if the db connection was successful or not
			System.out.println("Oops, error!");
			e.printStackTrace();
		}
	}

	public void editOrderId() {
		double input = 0;
		
		//double orderId = rs.getDouble("OrderID");
		
		//double orderId; 
		PreparedStatement statement = null; 
    	ResultSet rs = null;
    	
    	try {	
        	q = ("select * from orders");
    		statement = connection.prepareStatement (q);    
        	rs = statement.executeQuery(q);
        	
        	
        	while(rs.next()) {//gets data from database
				
        		rs.getDouble("OrderId");
        		 if (rs.wasNull()) {
        			 input = checkOrderId(input);
        			 addOrderId(input);
        			
        		 }
        
			}
						
			statement.close();
    	}
    	catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     } 
		
	}
	
	public double getOrderId() {
		double orderId = 0;
		try {	
        	q = ("select * from orders");
    		 statement = connection.prepareStatement (q);    
        	rs = statement.executeQuery(q);
    

        	while(rs.next()) {//gets data from database
				orderId = rs.getDouble(5);
				
			}
						
			statement.close();
    	}
    	catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     }
		return orderId; 
	}
	
public void Delete(String input) {//deletes entire row containing all information on product

	String q = "DELETE FROM orders WHERE OrderId = '"+input+"'";
		try {
			statement= connection.prepareStatement (q);
			statement.executeUpdate(q);
	
			statement.close();
		}
  
		catch (SQLException e) {       //to check if the db connection was successful or not
			System.out.println("Oops, error!");
			e.printStackTrace();
       
			}
}

public List<OrderInfo> shoppingCart(Object tempOrderInfo) {
	
	List<OrderInfo> list = new ArrayList<>();  
	list.add((OrderInfo) tempOrderInfo);
	
	
	return list;
	
		
}

public OrderInfo cart(String date, String cust_email, double cust_location, String orderproductId,double orderquantity, double orderId )throws Exception{
	
	
	OrderInfo tempOrderInfo = new OrderInfo( date,  cust_email, 
			cust_location,  orderproductId,orderquantity, orderId);
	
	
	return tempOrderInfo;  
}

public int Yes()
{
	return 0;	
}

public int No() {
	
	return 1;
}


public void editOrder(String firsname, String lastname, String email) {
	
}

}
