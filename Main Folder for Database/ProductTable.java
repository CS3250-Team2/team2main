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
    		 statement = connection.prepareStatement (q);    //connection to database
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
 //method to search for product in inventory database using product id   
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
  
    //method to add new entry for new product into inventory database
    
    public void addProduct(String productID, double Quantity, double Wholesale ,
			double Saleprice , String SupplierID) {
    		PreparedStatement statement = null; 
    	
    				try {
    						String q = "INSERT INTO productInfo (ProductID, Quantity, Wholesale, Saleprice, SupplierID )" //state to call to table and columns in mySql
    						+ "VALUES ('"+ productID +"', '"+Quantity+"',  '"+Wholesale+"', '"+Saleprice+"', '"+SupplierID+"')";//values from data obtain from user input
    		
    						statement= connection.prepareStatement (q);
   		 
    	
    						statement.executeUpdate(q);//to update information in database with new entry
   		 
    						statement.close();
    					}
    				catch (SQLException e) {       //to check if the db connection was successful or not
    						System.out.println("Oops, error!");
    						e.printStackTrace();
    					} 
    }
  
  //to delete from table the entire row containing information on product using product ID
    public void Delete(String input) {//deletes entire row containing all information on product

		String q = "DELETE FROM productInfo WHERE ProductID = '"+input+"'";
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

    public List<ProductInfo>  getFromMysql() {
    	List<ProductInfo> list = new ArrayList<>();
    	try {
        	q = ("select * from productInfo");
    		 statement = connection.prepareStatement (q);    //connection to database
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
    
    
	public void EditInventory(String productID, double Quantity, double Wholesale ,
			double Saleprice , String SupplierID) {
		PreparedStatement statement = null; 
	
				try {
					String q1 =  String.format("select * from productInfo  WHERE ProductID = %s", productID); //state to call to table and columns in mySql
					String q =  String.format("Update productInfo set Quantity = %f WHERE SupplierID = %s",Quantity,SupplierID ); //state to call to table and columns in mySql
					
					
					System.out.println("this is editString = "+ q);
						statement = connection.prepareStatement (q1);    //connection to database
						rs = statement.executeQuery(q1);
						while(rs.next()) {
						statement= connection.prepareStatement (q);
		 
	
						statement.executeUpdate(q);//to update information in database with new entry
						}
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
