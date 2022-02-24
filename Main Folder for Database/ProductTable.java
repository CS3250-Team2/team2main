import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.cj.xdevapi.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ProductTable {
	PreparedStatement statement = null; 
	//java.sql.Statement state = null; 
    ResultSet rs = null;
    String q;
    Connection connection = new dbConnection().getConnection();//open connection to mySql database


	
    public List<ProductInfo> getAllProudctInfo()throws Exception{
    	List<ProductInfo> list = new ArrayList<>();  
    	
    	PreparedStatement statement = null; 
    	ResultSet rs = null;
    	
    	try {	
        	q = ("select * from productInfo");
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
    
    public List<ProductInfo> searchAllProudctInfo(String productID)throws Exception{
    	List<ProductInfo> list = new ArrayList<>();
    	
    	try {
    		productID +="%";
        	q = ("select * from productInfo where productID like ?");
        	
    		statement = connection.prepareStatement (q);  
    		statement.setString( 1, productID);//calling to first column to search 
        	rs = statement.executeQuery();
    

			while(rs.next()) {//gets data from database
				ProductInfo tempProduct = convertRowToProduct(rs);
				list.add(tempProduct);
				
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
    
    public void addProduct(ProductInfo theproduct) {
    	PreparedStatement statement = null; 
    	ResultSet rs = null;
    	try {

    		 String q = "INSERT INTO productInfo (ProductID, Quantity, Wholesale, Saleprice, SupplierID )" //state to call to table and columns in mySql
    					+ "VALUES (?,?,?,?,?)";//values from data obtain from user input*/
    		 statement= connection.prepareStatement (q);
   		 
    		 	statement.setString(1, theproduct.getProductId());
    		 	statement.setDouble(2, theproduct.getQuantity());
    		 	statement.setDouble(3, theproduct.getWholesale());
    		 	statement.setDouble(4, theproduct.getSalePrice());
    		 	statement.setString(5, theproduct.getSupplierId());
   		 
    		 	statement.executeUpdate();//to update information in database with new entry
   		 
   		 
    		 	statement.close();
    	}
    	catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     } 
    }
	public void UpdateInventory(ProductInfo product) {
		  
    	 try {
    	    
    		 String q = ("Update productInfo" + "set productid = ?, quantity = ?, wholesale =?, saleprice = ?, supllier=?" + "where productid=");
    		 statement= connection.prepareStatement (q);
    		 
    		 statement.setString(1, product.getProductId());
    		 statement.setDouble(2, product.getQuantity());
    		 statement.setDouble(3, product.getWholesale());
    		 statement.setDouble(4, product.getSalePrice());
    		 statement.setString(5, product.getSupplierId());
    		 
    		 statement.executeUpdate();//to update information in database with new entry
    		 
    		 
    		 statement.close();
    	 }
    	 catch (SQLException e) {       //to check if the db connection was successful or not
    	        System.out.println("Oops, error!");
    	        e.printStackTrace();
    	     } 
	}
	
private ProductInfo convertRowToProduct(ResultSet rs) throws SQLException {

 	    
	
	String productId = rs.getString("productId");
	double quantity= rs.getDouble("quantity");
	double salePrice = rs.getDouble("salePrice");
	double wholesale = rs.getDouble("wholesale");
	String supplierId = rs.getString("supplierId");
	 	
		ProductInfo tempProduct = new ProductInfo( productId,  quantity, 
				 wholesale,  salePrice,supplierId);
	 		
	
	 return tempProduct;
	}

public static void main(String[] args) throws Exception {
	ProductTable check = new ProductTable();
 System.out.println(check.searchAllProudctInfo("test"));
 System.out.println(check.getAllProudctInfo());


}
}
