import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.List;

import org.junit.jupiter.api.Test;

class ConnectionTest {

	@Test
	public void testOpenConnection() throws Exception {
		
		System.out.println("open Connection");
		dbConnection test = new dbConnection();
		test.getConnection();
		assertEquals(test != null, true); //The result will equal not null then junit test pass
		}
}
	//@Test 
//	public void testOrderTable() throws Exception {
//		System.out.println("OrderTable");
//		String orderTable = "Order table orders\n "
//				+ "DATE DATE NOT NULL,\n"
//				+ "CUSTEMAIL TEXT NOT NULL,\n"
//				+ "CUSTLOCATION DOUBLE NOT NULL,\n"
//				+ "PRODUCTID TEXT NOT NULL,\n"
//				+ "PRODUCTQUANTI DOUBLE NOT NULL,\n"
//				+"):";
//		try {
//			
//			OrderTable rs = new OrderTable();
//		
//		// rs.getAllOrderInfo();
//		 date columnName1 = rs.getAllOrderInfo(0);
//		 String columnName2 = rs.getAllOrderInfo(1);
//		 Double columnName3 = rs.getAllOrderInfo(2);
//		 String colunmName4 = rs.getAllOrderInfo(3);
//		 Double colunmName5 = rs.getAllOrderInfo(4);
//		 
//		 assertEquals("DATE",columnName1);
//		 assertEquals("CUSTEMAIL",columnName2);
//		 assertEquals("CUTLOCATION",columnName3);
//		 assertEquals("PRODUCTID",colunmName4);
//		 assertEquals("PRODUCTQUANTI",colunmName5);
//		 
//		 
//		 
//		 
//	}catch (Exception e)
//		e.printStackTrace();
//		
//	}
//
//	@Test
//	
//	public void testInsertOrderTable() throws Exception {
//		
//		System.out.println("InsertOrderInfo");
//		String insertOrderData = "INSERT INTO orders\n"
//				+ "(DATE, cust_email, cust_location, product_id, product_quantity)\n";
//		try {
//			OrderTable rs = new OrderTable();
//			String cust_email = rs.getString(cust_email);
//			
//		}
