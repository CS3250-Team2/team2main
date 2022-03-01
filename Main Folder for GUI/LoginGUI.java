import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class LoginGUI {
	private JFrame frame;
	private JTextField usernameText;
	//private JPasswordField passwordText;
	private JTextField passwordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 260);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		usernameText = new JTextField();
		usernameText.setBounds(195, 50, 180, 26);
		panel.add(usernameText);
		usernameText.setColumns(10);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(195, 100, 180, 26);
		panel.add(passwordText);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(40, 55, 107, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(40, 105, 107, 16);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			
			private int authorization;

			public void actionPerformed(ActionEvent e) {
//					
				String userName = usernameText.getText();
				String pass = passwordText.getText();
				
				
				UserLogin check = new UserLogin();
				
				//method to verify if username and password entered match account in database
				
				int checkLogin = check.checkAccount(check.checkUserName(userName), check.checkPassword(pass));
				
					//method to check if employee or customer login
					if (checkLogin == 1) {
						
						try {
							authorization = check.searcAuthroization(userName);
							
							//employee login
							if( authorization == 0) {
							
									dbPage nw = new dbPage();//calls to GUI for employee
									
									nw.NewScreen();}
							
							//customer login
							else if (authorization == 1) {
									
									CustomerGUI nw2 = new CustomerGUI();//calls to GUI for customers
									
									nw2.NewScreen();}
						}
						
					
						
						catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					
					}
				
					else {
						
					
					JOptionPane.showMessageDialog(null, "No account found." );//"Error Message", JOptionPane.ERROR);
						
					
					
							//JOptionPane.showMessageDialog(null, "No account found.", "Error Message", JOptionPane.ERROR)			}
				
					}	
					
				}
					
	
			
		});
		
		
		btnNewButton.setBounds(40, 171, 117, 29);
		panel.add(btnNewButton);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.setBounds(226, 171, 149, 29);
		panel.add(createAccount);
		
		JButton guest = new JButton("Guest Login");
		guest.setBounds(126, 210, 149, 29);
		guest.addActionListener(new ActionListener() { // connecting method to mysql database with GU to show inventory
			public void actionPerformed(ActionEvent e) {
				
				
				CustomerGUI nw2 = new CustomerGUI();//calls to GUI for customers
				nw2.NewScreen();
			}
		});
		//frmClass.getContentPane().add(guest);
		
		panel.add(guest);
	}
	
	
}
