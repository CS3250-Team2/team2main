import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI {

	private JFrame frame;
	private JTextField usernameText;
	private JPasswordField passwordText;

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
		
		JLabel lblUsernameLabel = new JLabel("Username");
		lblUsernameLabel.setBounds(40, 55, 107, 16);
		panel.add(lblUsernameLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(40, 105, 107, 16);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			private int authorization;

			public void actionPerformed(ActionEvent e) {
			String userName = usernameText.getText();
				
				UserLogin check = new UserLogin();
				
				try {
					 authorization = check.searcAuthroization(userName);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if( authorization == 0) {
				dbPage nw = new dbPage();//calls to GUI for employee
				nw.NewScreen();}
				
				else {
				CustomerGUI nw2 = new CustomerGUI();//calls to GUI for customers
				nw2.NewScreen();}
				
			}
			
		});
		btnNewButton.setBounds(40, 171, 117, 29);
		panel.add(btnNewButton);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.setBounds(226, 171, 149, 29);
		panel.add(createAccount);
	}
}
