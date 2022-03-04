import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class CreateAccountGUI extends JFrame {

	Connection connect = null;
	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtPassword;
//	private UserInfo userInfo;

	String authorization; 

	/**
	 * Launch the application.
	 */
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountGUI frame = new CreateAccountGUI();
					frame.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	
	
	public CreateAccountGUI() {
		
		try {
		//	userInfo = new UserInfo();
		
		}
		catch (Exception exc) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	      //  JOptionPane.showMessageDialog(this, "Error:" + exc, "Error", JOptionPane.ERROR_MESSAGE);
	     }
		
		//Authorization permission = new Authorization();
		 String url = "jdbc:mysql://localhost:3306/Sprint1";
	     String username = "root";
	     String password = "password123";
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel firstNamelbl = new JLabel("First Name");
		firstNamelbl.setBounds(22, 28, 71, 14);
		contentPane.add(firstNamelbl);
		
		JLabel lastNamelbl = new JLabel("Last Name");
		lastNamelbl.setBounds(22, 72, 68, 22);
		contentPane.add(lastNamelbl);
		
		JLabel emailLbl = new JLabel("Email");
		emailLbl.setBounds(22, 123, 47, 14);
		contentPane.add(emailLbl);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setBounds(22, 171, 47, 14);
		contentPane.add(passwordLbl);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(125, 25, 96, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(125, 73, 96, 20);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(125, 120, 96, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(125, 168, 96, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton enterBtn = new JButton("Enter");
		enterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FirstName = txtFirstName.getText();
				String LastName = txtLastName.getText();
			    String email = txtEmail.getText();
			    String pass = txtPassword.getText();
				
				
				try {
					
		//	userInfo.addProduct(FirstName, LastName, email, pass);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		enterBtn.setBounds(90, 216, 89, 23);
		contentPane.add(enterBtn);
	}
}
