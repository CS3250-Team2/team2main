package sprintProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
public class QueDB {
	public static void main(String[] args) {  
	
		/// 
        
	}
        
        
     public Supplier getSupplier(){
    	 Supplier supplier = null;
         try {
        	 String url       = "url";
             String user      = "user";
             String password  = "pw";
             
             String productinfo = "SELECT product_id, quanity, wholesale, sale_price,supplier_id " +
                        "FROM productinfo";
        
             Connection conn = DriverManager.getConnection(url, user, password); 
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(productinfo);
              
             //this while loop added to test if able to read from database and printout   
            while (rs.next()) {
            	
                System.out.println(rs.getString("product_id") + "\t" + 
                                   rs.getDouble("quanity")  + "\t" +
                                   rs.getDouble("wholesale") + "\t" +
                                   rs.getDouble("sale_price")  + "\t" +
                                   rs.getInt("supplier_id"));}
                
             if (rs.next()) {
            	supplier = new Supplier();
            	
                supplier.setProductId(rs.getString("product_id"));
                supplier.setQuantity(rs.getDouble("quanity"));
                supplier.setWholesale(rs.getDouble("wholesale"));
                supplier.setSalePrice(rs.getDouble("sale_price"));
                supplier.setSupplierId(rs.getInt("supplier_id"));
            }
         } 
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
        return supplier;
	}
	

}
