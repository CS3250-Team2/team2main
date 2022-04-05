import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.luv2code.jdbc.employeesearch.core.Employee;
import com.luv2code.jdbc.employeesearch.dao.EmployeeDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class EditInventory extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField productIDTextField;
	private JTextField QuantityTextField;
	private JTextField WholesaleTextField;
	private JTextField SalepriceTextField;
	private JTextField SupplierIdTextField;
	
	private dbPage employee; // the  Employee gui
	private ProductTable productTable;
	
	private ProductInfo previousProductInfo = null;
	private boolean updateProductTable =  false; 
	/**
	 * Launch the application.
	 */
	/*public AddProductGUI(dbPage theEmployee, ProductTable theProductTable) {
		this();
		employee = theEmployee;
		productTable = theProductTable;
	}*/
	public EditInventory(boolean theUpdateMode, ProductInfo thepreviousProductInfo) {
	try {
		
		employee = new dbPage();
		productTable = new ProductTable();
		//orderTable = new OrderTable();
		//updateProductTable = theUpdateMode;
		
		previousProductInfo = thepreviousProductInfo;
		//initalize();
		if (updateProductTable){
			setTitle("Update Product");
			
			populateGUI(previousProductInfo);
		}
	}
	
	
	catch (Exception exc) {       //to check if the db connection was successful or not
        System.out.println("Oops, error!");
      //  JOptionPane.showMessageDialog(this, "Error:" + exc, "Error", JOptionPane.ERROR_MESSAGE);
     }

	}

	private void populateGUI(ProductInfo theProduct) {
		QuantityTextField.setText(String.valueOf((theProduct.getQuantity())));
		WholesaleTextField.setText(String.valueOf((theProduct.getWholesale())));
		SalepriceTextField.setText(String.valueOf((theProduct.getSalePrice())));
		SupplierIdTextField.setText(theProduct.getSupplierId());
		productIDTextField.setText(theProduct.getProductId());
		
	}
	/**
	 * Create the dialog.
	 * @return 
	 */
	public EditInventory() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblNewLabel = new JLabel("Product Id");
			contentPanel.add(lblNewLabel, "2, 2, right, default");
		}
		{
			productIDTextField = new JTextField();
			contentPanel.add(productIDTextField, "4, 2, fill, default");
			productIDTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Quantity");
			contentPanel.add(lblNewLabel_1, "1, 4, 2, 1, right, default");
		}
		{
			QuantityTextField = new JTextField();
			contentPanel.add(QuantityTextField, "4, 4, fill, default");
			QuantityTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Wholesale");
			contentPanel.add(lblNewLabel_2, "2, 6, right, default");
		}
		{
			WholesaleTextField = new JTextField();
			contentPanel.add(WholesaleTextField, "4, 6, fill, default");
			WholesaleTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Saleprice");
			contentPanel.add(lblNewLabel_3, "2, 8, right, default");
		}
		{
			SalepriceTextField = new JTextField();
			contentPanel.add(SalepriceTextField, "4, 8, fill, default");
			SalepriceTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Supplier Id");
			contentPanel.add(lblNewLabel_4, "2, 10, right, default");
		}
		{
			SupplierIdTextField = new JTextField();
			contentPanel.add(SupplierIdTextField, "4, 10, fill, default");
			SupplierIdTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						saveProduct();
					}

			
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}
	private void saveProduct() {
		// get product info from gui
		//save to database
		//refresh gui
		//show message sucess
		
		double quantity = Double.valueOf(QuantityTextField.getText());
		double wholesale = Double.valueOf(WholesaleTextField.getText());
		double salePrce = Double.valueOf(SalepriceTextField.getText());
		String supplierID = SupplierIdTextField.getText();
		String productID = productIDTextField.getText();
		
		
			
		//ProductInfo tempProductInfo = new ProductInfo(productID, quantity, wholesale, salePrce, supplierID);
		try {
				//save to mysql database
			productTable.addProduct(productID, quantity, wholesale, salePrce, supplierID);
			
			//close add product window
			setVisible(false);
			dispose();
			
			//refresh inventory list?
			employee.refreshEmployeeWindow();
			
			//show message for sucess of adding product
			JOptionPane.showMessageDialog(null, "Product added to inventory sucessfully."); 		
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error when adding product to inventory." );
				e1.printStackTrace();
			}
		/*try {
			
			productTable.addProduct(tempProductInfo);
			
		
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
	}

}
