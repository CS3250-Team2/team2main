
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ProjectMain implements ActionListener{

	// public GUI(){
	// 	JFrame frame = new JFrame();
	// 	JPanel panel = new JPanel();
	// 	panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	// 	panel.setLayout(new GridLayout(0, 1));

	// 	frame.add(panel, BorderLayout.CENTER);
	// 	frame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
	// }
	    public static void main(String[] args) throws ClassNotFoundException {
			
	        String url = "jdbc:mysql://localhost:3306/Sprint1";
	        String username = "root";
	        String password = "Liltwan10$";
			String query = "SELECT productId, quantity, wholesale, saleprice, supplierId, FROM";
	        int number;
	        Scanner in = new Scanner(System.in);

	        //new GUI();

			JPanel panel = new JPanel();
			JFrame frame = new JFrame();
			frame.setSize(350,200);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//frame.setVisible(true);
			frame.add(panel);

			panel.setLayout(null);
			JLabel userLabel = new JLabel("Username");
			userLabel.setBounds(10, 20, 80, 25);
			panel.add(userLabel);

			JTextField userText = new JTextField(20);
			userText.setBounds(100, 20, 165, 25);
			panel.add(userText);

			panel.setLayout(null);
			JLabel passwordLabel = new JLabel("Password");
			passwordLabel.setBounds(10, 50, 80, 25);
			panel.add(passwordLabel);

			JPasswordField passwordText = new JPasswordField();
			passwordText.setBounds(100, 50, 165, 25);
			panel.add(passwordText);

			JButton button = new JButton("Login");
			button.setBounds(10, 80, 80, 25);
			button.addActionListener(new ProjectMain());
			panel.add(button);

			JLabel success = new JLabel("");
			success.setBounds(10, 110, 300, 25);
			panel.add(success);
			

			frame.setVisible(true);


	        try {
	        	
	            Connection connection = DriverManager.getConnection(url, username, password);
	            
	            
	            do {
	            	do {
	            		String menu = "\n Welcome to Team 2 Inventory Program!"
                                		+ "\n1.) Choose 1 to create a username and password."
                                		+ "\n2.) Choose 2 to check inventory information."
                                		+ "\n3.) Choose 3 to EXIT. ";
                        System.out.println(menu);
                        number = in.nextInt();
                        		
	            	} while (number < 0 || number > 3);
	            	
	            	switch(number) {
	            		case 1:
	            			String sql = "INSERT INTO userInfo (userName, pass) VALUES (?,?)";
	        	            PreparedStatement statement = connection.prepareStatement(sql); //reading database?
	        	            String userName; //declaring strings
	        	            String pass;
	        	            System.out.println("Enter your username: ");
	        	            userName = in.next();	        	       //scanner input for username 
	        	            System.out.println("Enter your password: ");
	        	            pass = in.next();						   //scanner input for pass
	        	            
	        	            
	        	            statement.setString(1, userName); //row position 1 and userName column
	        	            statement.setString(2, pass);     //row position 2 and pass column
	        	            
	        	            int rows = statement.executeUpdate(); //checking if a row was inserted 
	        	            if (rows > 0) {
	        	            	System.out.println("A row has been inserted.");
	        	            	statement.close();}
	        	            break;
	        	          
	        	       case 2:
	        	    	   System.out.println("not ready yet :)");
						   
	        	    	   break;
	        	    	   
	        	       default:
	        	    	   System.out.println("Goodbye.");
	        	    	   break;
	            	}
	            }while (number != 3);
				in.close();
	        }
	            	
	        catch (SQLException e) {       //to check if the db connection was successful or not
	            System.out.println("Oops, error!");
	            e.printStackTrace();
	        }
	    
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}

