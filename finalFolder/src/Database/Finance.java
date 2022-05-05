import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private double profits;
	private String month;
	private FinanceInfo tempFinanceInfo;
	
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
       	System.out.println("inventory quantity before order = "+ InvenQuantity);
       	
       	InvenQuantity = InvenQuantity - quantity; 
       	
       	System.out.println("inventory quantity after order = "+ InvenQuantity);
       	
       	
       	checkout(productId, InvenQuantity );
		}
		catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     }
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.format(payment);
		
		return payment; 
	}

	public double profit(String productId, double quantity) {
		
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
       	
   
		}
		catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     }
		DecimalFormat df = new DecimalFormat("#.##");
		df.format(payment);
		
		return payment;
	}
	
	public void checkout(String productId, double quantity) {
		System.out.println("inventory quantity= "+ quantity);
		try {
			q = "Update productInfo set Quantity = ? WHERE ProductID = '"+productId+"'";
   		 statement = connection.prepareStatement (q);    //connection to database
   		statement.setDouble( 1, quantity);//calling to first column to search 
       statement.executeUpdate();	
	}
		catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	
		}
}

	public double YearProfits(LocalDate date)
	{
		int year = date.getYear();
		double singleProfit =0;
		try {
			q = "select SUM(profits) FROM orders where YEAR(date) ='"+year+"'";
   		 statement = connection.prepareStatement (q);    //connection to database
   		//statement.setString( 1, productId);//calling to first column to search 
       	rs = statement.executeQuery(q);
   

       	while(rs.next()) {//gets data from database	
       		
       		
		 singleProfit = rs.getDouble(1);
		 profits = profits+ singleProfit;
		
       	}
      
	
		}
		catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     }
		DecimalFormat df = new DecimalFormat("#.##");
		df.format(profits);
		
		return profits;
		
		
	}

	public double MonthlyProfits(LocalDate date, int month)
	{
		 profits =0;
		double singleProfit =0;
		int year = date.getYear(); 
		//int month = date.getMonthValue();
		try {
			q = "select SUM(profits) FROM orders  WHERE Month (date) = '"+month+"' AND YEAR(date) = '"+year+"'";
   		 statement = connection.prepareStatement (q);    //connection to database
   		//statement.setString( 1, productId);//calling to first column to search 
       	rs = statement.executeQuery(q);
   

       	while(rs.next()) {//gets data from database	
		  singleProfit = rs.getDouble(1);
		 profits = profits+ singleProfit;
		
       	}
      
	
		}
		catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     }
		DecimalFormat df = new DecimalFormat("#.##");
		df.format(profits);
		return profits;
		
		
	}
	
	public double DailyProfits(LocalDate date)
	{
	
		double singleProfit =0;
		try {
			q = "select SUM(profits) FROM orders where date = '"+date+"'";
   		 statement = connection.prepareStatement (q);    //connection to database
   		//statement.setString( 1, productId);//calling to first column to search 
       	rs = statement.executeQuery(q);
   

       	while(rs.next()) {//gets data from database	
		  singleProfit = rs.getDouble(1);
		 profits = profits+ singleProfit;
		
       	}
      
	
		}
		catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     }
		DecimalFormat df = new DecimalFormat("#.##");
		df.format(profits);
		return profits;
		
		
	}
	
	public String getPopular(LocalDate date, int i)
	{
		double tempProfit;
		double profit=0;
		String tempProduct;
		String product = null;
		int year = date.getYear(); 
		int month = date.getMonthValue();
		
		switch (i) {
		
		case 1:
			q = " select *, SUM(profit) from DailyProfits  group by product_id ";
			
			
			break;
		case 2:
			q = " select *, SUM(profit) from MonthlyProfits  group by product_id ";
			break;
		
		case 3:
		
			q = " select *, SUM(profit) from YearProfits  group by product_id ";
		break;
		}
		
		
		try {
			statement = connection.prepareStatement (q);    //connection to database
	   		//statement.setString( 1, productId);//calling to first column to search 
	       	rs = statement.executeQuery(q);
	   

			while(rs.next()) {//gets data from database	
				
				 tempProduct = rs.getString("product_id");
				 tempProfit = rs.getDouble("profit");
				 
				 if (profit < tempProfit)
				 {
					 product = tempProduct;
					 
					 System.out.println("daily popular product" + product );
									 
			}
			}
				 
				 switch (i) {
					
					case 1:
						q = "Delete from DailyProfits";
						
						
						break;
					case 2:
						q = "Delete from MonthlyProfits";
						break;
					
					case 3:
					
						q = "Delete from YearProfits";
					break;
					}		 
			
			statement = connection.prepareStatement (q);    //connection to database
	   
			statement.executeUpdate(q); 
			   	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
		
		
	}
	
	public String MonPop(LocalDate date, int i) {
		double tempProfit;
		double profit=0;
		String tempProduct = "no product sold";
		String product = null;
		int year = date.getYear(); 
		//int month = date.getMonthValue();
		q = " select *, SUM(profit) from MonthlyProfits  group by product_id ";
		
		
		try {
			statement = connection.prepareStatement (q);    //connection to database
	   		//statement.setString( 1, productId);//calling to first column to search 
	       	rs = statement.executeQuery(q);
	   

			while(rs.next()) {//gets data from database	
				
				 tempProduct = rs.getString("product_id");
				 tempProfit = rs.getDouble("profit");
				 System.out.println("month popular product" + tempProduct );
				 if (profit < tempProfit)
				 {
					 product = tempProduct;
					 
					 System.out.println("daily popular product" + product );
									 
			}
			}
				 
			
					
					//	q = "Delete from YearProfits";
				
			//statement = connection.prepareStatement (q);    //connection to database
	   
			//statement.executeUpdate(q); 
			   	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
		
		
	}
	public String getMonth(int i) {
		switch(i) {
		case 1:
			month = "January";
			break;
		
		case 2:
			month = "Febuary";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "May " ;
			break;
		case 6:
			month = "June";
			break;
		case 7:
			month = "July";
			break;
		case 8:
			month = "August";
			break;	
		case 9:
			month = "September";
			break;
		case 10:
			month = "October";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "December";
			break;
		default:
			break;
		
		}
		return month;
		
		
	}
	
	public void addProfitsTable(LocalDate date, String productId, double profit,int i) {
		
		try {
			
			 switch (i) {
				
				case 1:
					q = "INSERT INTO DailyProfits (DATE,  product_id, profit)" //state to call to table and columns in mySql
			                + "VALUES ('"+ date +"' , '"+productId+"','"+profit+"')";//values from data obtain from user input
					
					
					break;
				case 2:
					q = "INSERT INTO MonthlyProfits (DATE,  product_id, profit)" //state to call to table and columns in mySql
			                + "VALUES ('"+ date +"' , '"+productId+"','"+profit+"')";//values from data obtain from user input
				
				case 3:
				
					q = "INSERT INTO YearProfits (DATE,  product_id, profit)" //state to call to table and columns in mySql
			                + "VALUES ('"+ date +"' , '"+productId+"','"+profit+"')";//values from data obtain from user input
				break;
				}		

	         
	             PreparedStatement statement=connection.prepareStatement(q);


	             statement.executeUpdate(q);//to update information in database with new entry

	             statement.close();
	    }
	    catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     }
	}

public void addMonProfitsTable(LocalDate date, String productId, double profit,int i) {
		
		try {
			
			 
			
					q = "INSERT INTO MonthlyProfits (DATE,  product_id, profit)" //state to call to table and columns in mySql
			                + "VALUES ('"+ date +"' , '"+productId+"','"+profit+"')";//values from data obtain from user input
				
			
					
	         
	             PreparedStatement statement=connection.prepareStatement(q);


	             statement.executeUpdate(q);//to update information in database with new entry

	             statement.close();
	    }
	    catch (SQLException e) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	        e.printStackTrace();
	     }
	}


public void addYearProfitsTable(LocalDate date, String productId, double profit,int i) {
	
	try {
		
		 
			
				q = "INSERT INTO YearProfits (DATE,  product_id, profit)" //state to call to table and columns in mySql
		                + "VALUES ('"+ date +"' , '"+productId+"','"+profit+"')";//values from data obtain from user input
			
         
             PreparedStatement statement=connection.prepareStatement(q);


             statement.executeUpdate(q);//to update information in database with new entry

             statement.close();
    }
    catch (SQLException e) {       //to check if the db connection was successful or not
        System.out.println("Oops, error!");
        e.printStackTrace();
     }
}
public List<FinanceInfo> searchYearInfo(LocalDate date)throws Exception{
	List<FinanceInfo> list = new ArrayList<>();
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	String orderproductId;
	String profit;
	String Year = formatter.format(date.getYear());
	String PopularItemM = " ";
	try {
	
		q = " select *, SUM(profits) from orders where  YEAR(date) = '"+date+"' group by product_id ";
    	
		statement = connection.prepareStatement (q);  
		
    	rs = statement.executeQuery();
    	

    	while(rs.next()) {//gets data from database
    		
    		orderproductId = rs.getString("product_id");
    		profit = formatter.format( rs.getDouble("profits"));
    		FinanceInfo tempFinanceInfo = new FinanceInfo(month,Year,profit,PopularItemM,orderproductId );
			list.add(tempFinanceInfo);
			
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

public List<FinanceInfo> searchDayInfo(LocalDate date)throws Exception{
	List<FinanceInfo> list = new ArrayList<>();
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	String orderproductId;
	String profit;
	String Year = formatter.format(date.getYear());
	String PopularItemM = " ";
	try {
	
		q = " select *, SUM(profits) from orders where  date = '"+date+"' group by product_id ";
    	
		statement = connection.prepareStatement (q);  
		
    	rs = statement.executeQuery();
    	

    	while(rs.next()) {//gets data from database
    		
    		orderproductId = rs.getString("product_id");
    		profit = formatter.format( rs.getDouble("profits"));
    		FinanceInfo tempFinanceInfo = new FinanceInfo(month,Year,profit,PopularItemM,orderproductId );
			list.add(tempFinanceInfo);
			
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

public String YearPopularFast(LocalDate date) {
	
	
		

		String tempProduct = null;
	
		
		q = " select product_id, MAX(product_quantity) from orders where YEAR(date) = '"+date+"' group by product_id ";
		try {
			statement = connection.prepareStatement (q);    //connection to database
	   		//statement.setString( 1, productId);//calling to first column to search 
	       	rs = statement.executeQuery(q);   

			while(rs.next()) {//gets data from database	
				
				 tempProduct = rs.getString("product_id");		
				 
			}
	
			   	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempProduct;
}

public String DayPopularFast(LocalDate date) {
	

String tempProduct = null;


q = " select product_id, MAX(product_quantity) from orders where date = '"+date+"' group by product_id ";
try {
	statement = connection.prepareStatement (q);    //connection to database
	//statement.setString( 1, productId);//calling to first column to search 
	rs = statement.executeQuery(q);   

	while(rs.next()) {//gets data from database	
		
		 tempProduct = rs.getString("product_id");		
		 
	}

	   	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return tempProduct;
	
}

public String MonthPopularFast(LocalDate date,int i) {
	String tempProduct = null;
	
	

q = " select product_id, MAX(product_quantity) from orders where Month (date) = '"+i+"' AND YEAR(date) = '"+date+"' group by product_id ";
try {
	statement = connection.prepareStatement (q);    //connection to database
	//statement.setString( 1, productId);//calling to first column to search 
	rs = statement.executeQuery(q);   

	while(rs.next()) {//gets data from database	
		
		 tempProduct = rs.getString("product_id");		
		 
	}

	   	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return tempProduct;
	
}


}
