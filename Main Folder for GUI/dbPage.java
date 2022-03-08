import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	private ProductTable productTable;
	private OrderTable orderTable;
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
	private JButton searchBtn;
	private JButton showBtn;
	private JButton addBtn;
	private JButton deleteBtn;
	private JButton editBtn;
	private JTextField supplierIDtextField;
	private JLabel prodIdLabel;
	private JTextField productIDtextField ;
	private JTextField quantitytextField;
	private JLabel quantitiyLabel;
	private JLabel wholesaleLabel;
	private JTextField wholesaletextField;
	private JLabel salepriceLabel;
	private JTextField 	salepricetextField;
	private JLabel suplierIdLabel;
	private JButton exitDbBtn;
	private JTextField orderIDtextField;
	private JButton orderBtn;
	String authorization; 
	
	/**
	 * Create the application.
	 */
	public dbPage() {
		try {
			productTable = new ProductTable();
			orderTable = new OrderTable();
		}
		catch (Exception exc) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	      //  JOptionPane.showMessageDialog(this, "Error:" + exc, "Error", JOptionPane.ERROR_MESSAGE);
	     }
		
		//Authorization permission = new Authorization();
		 String url = "jdbc:mysql://localhost:3306/Sprint1";
	     String username = "root";
	     String password = "ZHk37_fTdZZ4bnkp";
		
		//authorization = permission.getPermission();
	     initialize();
	
		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
		//JPanel panel = new JPanel();
		frmClass = new JFrame();
		frmClass.setBounds(100, 100, 662, 504);
		frmClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClass.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 82, 472, 388);
		frmClass.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
				
		prodIdLabel = new JLabel("Product ID");
		prodIdLabel.setBounds(6, 12, 95, 16);
		frmClass.getContentPane().add(prodIdLabel);
	
	
		quantitytextField = new JTextField();
		quantitytextField.setBounds(148, 40, 95, 26);
		frmClass.getContentPane().add(quantitytextField );
		quantitytextField.setColumns(10);
		
		wholesaletextField = new JTextField();
		wholesaletextField.setBounds(255, 40, 95, 26);
		frmClass.getContentPane().add(wholesaletextField);
		wholesaletextField.setColumns(10);
		
		quantitiyLabel = new JLabel("Quantity ");
		quantitiyLabel.setBounds(148, 12, 61, 16);
		frmClass.getContentPane().add(quantitiyLabel);
		
		wholesaleLabel = new JLabel("Wholesale");
		wholesaleLabel.setBounds(255, 12, 84, 16);
		frmClass.getContentPane().add(wholesaleLabel);
		
		salepricetextField = new JTextField();
		salepricetextField.setBounds(362, 40, 95, 26);
		frmClass.getContentPane().add(salepricetextField);
		salepricetextField.setColumns(10);
		
		salepriceLabel = new JLabel("Saleprice");
		salepriceLabel.setBounds(362, 12, 61, 16);
		frmClass.getContentPane().add(salepriceLabel);
		
		supplierIDtextField = new JTextField();
		supplierIDtextField.setBounds(469, 40, 130, 26);
		frmClass.getContentPane().add(supplierIDtextField);
		supplierIDtextField.setColumns(10);
		
		suplierIdLabel = new JLabel("Supplier ID");
		suplierIdLabel.setBounds(469, 12, 95, 16);
		frmClass.getContentPane().add(suplierIdLabel);
		
		
		searchBtn = new JButton("Search Inventory");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get productId from text field
				
				try {
					String userinput = productIDtextField.getText();//get productId from textfield with userinput
					
					List<ProductInfo> productInfo = null;
					
					if(userinput != null && userinput.trim().length() > 0) {
						productInfo = productTable.searchAllProudctInfo(userinput);//call the productinfo
						
					}
					else {
						productInfo = productTable.getAllProudctInfo();//if productId empty, get all productinfo
					}
					//prints the data onto the GUI table
				ProductTableModel model = new ProductTableModel(productInfo);
					table.setModel(model);
				}
				
				catch(Exception exc){
					
				}
			}
		});
		searchBtn.setBounds(6, 78, 134, 29);
		frmClass.getContentPane().add(searchBtn);
	
		showBtn = new JButton("Show Inventory");
		showBtn.addActionListener(new ActionListener() { // connecting method to mysql database with GU to show inventory
			public void actionPerformed(ActionEvent e) {
				List<ProductInfo> productInfo = null;
				try {
					productInfo = productTable.getAllProudctInfo();
					ProductTableModel model = new ProductTableModel(productInfo);
					table.setModel(model);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		showBtn.setBounds(6, 119, 134, 29);
		frmClass.getContentPane().add(showBtn);
		
		addBtn = new JButton("Add Product");
		
		addBtn.addActionListener(new ActionListener() { // connecting method to mysql database with GU to show inventory
			public void actionPerformed(ActionEvent e) {
				
				double quantity = Double.valueOf(quantitytextField.getText());
				double wholesale = Double.valueOf(wholesaletextField.getText());
				double salePrce = Double.valueOf(salepricetextField.getText());
				String supplierID = supplierIDtextField.getText();
				String productID = productIDtextField.getText();
				
				
				try {
					
				productTable.addProduct(productID, quantity, wholesale, salePrce, supplierID);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		addBtn.setBounds(6, 160, 134, 29);
		frmClass.getContentPane().add(addBtn);
		
		deleteBtn = new JButton("Delete Product");
		deleteBtn.addActionListener(new ActionListener() { // connecting method to mysql database with GU to show inventory
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String productID = productIDtextField.getText();
					productTable.Delete(productID);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		deleteBtn.setBounds(6, 201, 134, 29);
		frmClass.getContentPane().add(deleteBtn);
		
		editBtn = new JButton("Edit Data");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//double quantity = Double.valueOf(quantitytextField.getText());
				//double wholesale = Double.valueOf(wholesaletextField.getText());
				//double salePrce = Double.valueOf(salepricetextField.getText());
				String supplierID = supplierIDtextField.getText();
				String productID = productIDtextField.getText();
			
				//if(supplierID != null) {
						//productTable.EditInventoryString(productID, "supplierID", supplierID);
					//}
			
			
			}
			
		});
		editBtn.setBounds(6, 242, 134, 29);
		frmClass.getContentPane().add(editBtn);
		
		
		orderBtn = new JButton("Customer Orders");
		orderBtn.setBounds(6, 283, 134, 29);
		//when button press action to show all orders from customers.
		orderBtn.addActionListener(new ActionListener() { // connecting method to mysql database with GU to show inventory
			public void actionPerformed(ActionEvent e) {
				List<OrderInfo> orderInfo = null;
				try {
					orderInfo = orderTable.getAllOrderInfo();
					OrderTableModel model = new OrderTableModel(orderInfo);
					table.setModel(model);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frmClass.getContentPane().add(orderBtn);
		
		
		exitDbBtn = new JButton("Exit Database");
		exitDbBtn.setBounds(6, 323, 134, 29);
		frmClass.getContentPane().add(exitDbBtn);
		
		
		productIDtextField = new JTextField();
		productIDtextField.setBounds(6, 40, 130, 26);
		frmClass.getContentPane().add(productIDtextField);
		productIDtextField.setColumns(10);
		
		
	}
	
}
