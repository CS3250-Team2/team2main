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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LoginGUI {
	private JFrame frmWelcome;
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
					window.frmWelcome.setVisible(true);
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
		frmWelcome = new JFrame();
		frmWelcome.setType(Type.UTILITY);
		frmWelcome.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\david\\Documents\\Team2\\Picture1.png"));
		frmWelcome.setTitle("Login Page");
		frmWelcome.getContentPane().setBackground(Color.BLACK);
		frmWelcome.setBounds(100, 100, 549, 434);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, null, null, null));
		panel.setBounds(0, 0, 537, 400);
		frmWelcome.getContentPane().add(panel);
		panel.setLayout(null);
		
		usernameText = new JTextField();
		usernameText.setBounds(161, 165, 149, 29);
		panel.add(usernameText);
		usernameText.setColumns(10);
		
		passwordText = new JPasswordField();
		passwordText.addKeyListener(new KeyAdapter() {
			private int authorization;
			//@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			

					
//							
						String userName = usernameText.getText();
						String pass = passwordText.getText();
						
						
						UserLogin check = new UserLogin();
						
						//method to verify if username and password entered match account in database
						
						int checkLogin = check.checkAccount(check.checkUserName(userName), check.checkPassword(pass));
						
							//method to check if employee or customer login
							if (checkLogin == 1) {
								LoginGUI window = new LoginGUI();
								try {
									authorization = check.searcAuthroization(userName);
									
									//employee login
									if( authorization == 0) {
											
									
											dbPage nw = new dbPage();//calls to GUI for employee
											
											nw.NewScreen();
											window.frmWelcome.setVisible(false);
											//window.dispose();
											
									}
									
									//customer login
									else if (authorization == 1) {
											
											CustomerGUI nw2 = new CustomerGUI();//calls to GUI for customers
											
												nw2.NewScreen();}
									frmWelcome.setVisible(false);
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
					
				}
			
		});
		passwordText.setBounds(161, 205, 149, 29);
		panel.add(passwordText);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(40, 171, 74, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(40, 211, 74, 16);
		panel.add(lblNewLabel_1);
		
	//	JButton btnNewButton = new JButton("Login");

			
	//	btnNewButton.setBounds(40, 171, 117, 29);
	//	panel.add(btnNewButton);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.setBounds(151, 269, 149, 29);
		
		createAccount.addActionListener(new ActionListener() { // connecting method to mysql database with GU to show inventory
			public void actionPerformed(ActionEvent e) {
				CreateAccountGUI create = new CreateAccountGUI ();
				create.NewScreen();
			}
		});
		panel.add(createAccount);
		
		JButton guest = new JButton("Guest Login");
		
		guest.setBounds(151, 322, 149, 29);
		
		guest.addActionListener(new ActionListener() { // connecting method to mysql database with GU to show inventory
			public void actionPerformed(ActionEvent e) {
					
				CustomerGUI nw2 = new CustomerGUI();//calls to GUI for customers
				nw2.NewScreen();
				frmWelcome.setVisible(false); 
			}
		});
		//frmClass.getContentPane().add(guest);
		
		panel.add(guest);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome Fantastic4 Team");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(115, 34, 267, 109);
		panel.add(lblNewLabel_2);
	}
}