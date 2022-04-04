import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Finance {
	 ResultSet rs = null;
	    String q;
	    Connection connection = new dbConnection().getConnection();//open connection to mySql database
	private double payment;
	private PreparedStatement statement;
	private double salePrice;
	private double quantity;
	private double wholesale;
	private double InvenQuantity;
	
	public double payment(String productId, double quantity) {
		
		try {
			q = "select * FROM productInfo WHERE ProductID = '"+productId+"'";
   		 statement = connection.prepareStatement (q);    //connection to database
   		//statement.setString( 1, productId);//calling to first column to search 
       	rs = statement.executeQuery(q);
   

       	while(rs.next()) {//gets data from database	
		 salePrice = rs.getDouble("salePrice");
		 wholesale = rs.getDouble("wholesale");
		 InvenQuantity = rs.getDouble("quantity");
		
       	}
       	if (quantity <=5) {
       	payment = salePrice * quantity;
       	}
       	else {
       		payment = wholesale * quantity;
       		
       	
       	}
       	
       	InvenQuantity = InvenQuantity - quantity; 
       	checkout(productId, InvenQuantity );
		}
		catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     }
		return payment; 
	}

	
	public void checkout(String productId, double quantity) {
		
		try {
			q = "Update productInfo set Quantity = '"+quantity+"' WHERE ProductID = '"+productId+"'";
   		 statement = connection.prepareStatement (q);    //connection to database
   		//statement.setString( 1, productId);//calling to first column to search 
       statement.executeQuery(q);	
	}
		catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	
		}
}

}
