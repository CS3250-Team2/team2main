import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//public static void NewScreen() {
//	
//	EventQueue.invokeLater(new runnable()) {
//		public void run() {
//			try {
//				dbPage = window = new dbPage();
//				window.frmClass.setVisible(true);
//			} catch (Exception e ) {
//				e.printStackTrace();
//		}
//	}
//}

public class dbPage {

	private JFrame frmClass;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) 
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbPage window = new dbPage();
					window.frmClass.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connect = null;
	PreparedStatement statement = null; 
	private JButton searchBtn;
	private JButton showBtn;
	private JButton addBtn;
	private JButton deleteBtn;
	private JButton editBtn;
	private JTextField textField;
	private JLabel prodIdLabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel quantitiyLabel;
	private JLabel wholesaleLabel;
	private JTextField textField_3;
	private JLabel salepriceLabel;
	private JTextField textField_4;
	private JLabel suplierIdLabel;
	private JButton exitDbBtn;
	
	
	/**
	 * Create the application.
	 */
	public dbPage() {
		Connection connect = new dbConnection().getConnection();	

		
		 String url = "jdbc:mysql://localhost:3306/Sprint1";
	     String username = "root";
	     String password = "Liltwan10$";
		 initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClass = new JFrame();
		frmClass.setBounds(100, 100, 662, 504);
		frmClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClass.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 82, 472, 388);
		frmClass.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		searchBtn = new JButton("Search Inventory");
		searchBtn.setBounds(6, 78, 134, 29);
		frmClass.getContentPane().add(searchBtn);
		
		showBtn = new JButton("Show Inventory");
		showBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//String query = "select * from productInfo"; 
				//PreparedStatement pst = connect.prepareStatement(query);
			//ResultSet rs = pst.executeQuery();
					String sql3 = "select * from productInfo"; // read the entire table's data on database
        			statement = connect.prepareStatement (sql3);
        	        ResultSet rs = statement.executeQuery(sql3);
        	        table.setModel((TableModel) rs);
        	        
//    			    System.out.println("ProductID\t\tQuantity\tWholesale\tSaleprice\tSupplierId");//add row for name of each column
//
//        	        while(rs.next()) {//gets data from database
//        	        	String productID =   rs.getString("ProductID");
//        			    double Quantity = rs.getDouble("Quantity");
//        			    double Wholesale = rs.getDouble("Wholesale");
//        			    double Saleprice = rs.getDouble("Saleprice");
//        			    String SupplierID = rs.getString("SupplierId");
//
//        			    System.out.println( productID + "\t\t" + Quantity + "\t\t" + Wholesale + "\t\t" + Saleprice + "\t\t" + SupplierID);//write one row of data from database
//        	        	}
//    			    System.out.println("ProductID\t\tQuantity\tWholesale\tSaleprice\tSupplierId");
			
				
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		showBtn.setBounds(6, 119, 134, 29);
		frmClass.getContentPane().add(showBtn);
		
		addBtn = new JButton("Add Product");
		addBtn.setBounds(6, 160, 134, 29);
		frmClass.getContentPane().add(addBtn);
		
		deleteBtn = new JButton("Delete Product");
		deleteBtn.setBounds(6, 201, 134, 29);
		frmClass.getContentPane().add(deleteBtn);
		
		editBtn = new JButton("Edit Data");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editBtn.setBounds(6, 242, 134, 29);
		frmClass.getContentPane().add(editBtn);
		
		textField = new JTextField();
		textField.setBounds(6, 40, 130, 26);
		frmClass.getContentPane().add(textField);
		textField.setColumns(10);
		
		prodIdLabel = new JLabel("Product ID");
		prodIdLabel.setBounds(6, 12, 95, 16);
		frmClass.getContentPane().add(prodIdLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 40, 95, 26);
		frmClass.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(255, 40, 95, 26);
		frmClass.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		quantitiyLabel = new JLabel("Quantity ");
		quantitiyLabel.setBounds(148, 12, 61, 16);
		frmClass.getContentPane().add(quantitiyLabel);
		
		wholesaleLabel = new JLabel("Wholesale");
		wholesaleLabel.setBounds(255, 12, 84, 16);
		frmClass.getContentPane().add(wholesaleLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(362, 40, 95, 26);
		frmClass.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		salepriceLabel = new JLabel("Saleprice");
		salepriceLabel.setBounds(362, 12, 61, 16);
		frmClass.getContentPane().add(salepriceLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(469, 40, 130, 26);
		frmClass.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		suplierIdLabel = new JLabel("Supplier ID");
		suplierIdLabel.setBounds(469, 12, 95, 16);
		frmClass.getContentPane().add(suplierIdLabel);
		
		exitDbBtn = new JButton("Exit Database");
		exitDbBtn.setBounds(6, 283, 134, 29);
		frmClass.getContentPane().add(exitDbBtn);
	}
}
