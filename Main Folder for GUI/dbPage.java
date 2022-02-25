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
	String authorization; 
	
	/**
	 * Create the application.
	 */
	public dbPage() {
		try {
			productTable = new ProductTable();
		}
		catch (Exception exc) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	      //  JOptionPane.showMessageDialog(this, "Error:" + exc, "Error", JOptionPane.ERROR_MESSAGE);
	     }
		
		//Authorization permission = new Authorization();
		 String url = "jdbc:mysql://localhost:3306/Sprint1";
	     String username = "root";
	     String password = "password123";
		
		//authorization = permission.getPermission();
	     initialize();	
		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
		JPanel panel = new JPanel();
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
		
		exitDbBtn = new JButton("Exit Database");
		exitDbBtn.setBounds(6, 283, 134, 29);
		frmClass.getContentPane().add(exitDbBtn);
		
		searchBtn = new JButton("Search Inventory");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get productId from text field
				
				//call the productinfo
				
				//if productId empty, get all productinfo
				
				//printout productinfo
				
				try {
					String userinput = productIDtextField.getText();
					
					List<ProductInfo> productInfo = null;
					
					if(userinput != null && userinput.trim().length() > 0) {
						productInfo = productTable.searchAllProudctInfo(userinput);
					}
					else {
						productInfo = productTable.getAllProudctInfo();
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
		showBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		
		productIDtextField = new JTextField();
		productIDtextField.setBounds(6, 40, 130, 26);
		frmClass.getContentPane().add(productIDtextField);
		productIDtextField.setColumns(10);
		
		
	}
	
}
