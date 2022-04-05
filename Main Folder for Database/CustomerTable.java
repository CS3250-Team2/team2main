import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.cj.xdevapi.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerTable {
	//java.sql.Statement state = null; 
    ResultSet rs = null;
    String q;
    Connection connection = new dbConnection().getConnection();//open connection to mySql database

    public List<ProductInfo> getAllOrders()throws Exception{
    	List<ProductInfo> list = new ArrayList<>();  
    	
    	PreparedStatement statement = null; 
    	ResultSet rs = null;
    	
    	try {	
        	q = ("select * from orders");
    		 statement = connection.prepareStatement (q);    
        	rs = statement.executeQuery(q);
    

        	while(rs.next()) {//gets data from database
				ProductInfo tempProduct = convertRowToProduct(rs);
				list.add(tempProduct);
				
			}
						
			statement.close();
    	}
    	catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     } 
    	return list; 
		
		
    
}
    
    private OrderInfo convertRowToProduct(ResultSet rs) throws SQLException {

 	    
    	
    	String userName = rs.getString("userName");
    	String email = rs.getString("cust_email");
    	double location= rs.getDouble("location");
    	String productId = rs.getString("product_id");
    	String ProductQuantity = rs.getString("product_quantity");
    	 	
    		ProductInfo tempProduct = new ProductInfo( userName,  email, 
    				location,  productId,ProductQuantity);
    	 		
    	
    	 return tempProduct;
    	}
}
