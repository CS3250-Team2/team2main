import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Color;

//Adding on GitHub again 
//Adding on GitHub again 
//Adding on GitHub again 


public class FinancialGUI {
	private JFrame frmClass;
	private Finance finance;
	private JTextField DateTextField;
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinancialGUI window = new FinancialGUI();
					window.frmClass.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FinancialGUI() {
		try {
			
			finance = new Finance();
			
		}
		catch (Exception exc) {       //to check if the db connection was successful or not
	        System.out.println("Oops, error!");
	      //  JOptionPane.showMessageDialog(this, "Error:" + exc, "Error", JOptionPane.ERROR_MESSAGE);
	     }
		
	     initialize();
	}
	private void initialize() {
		//JPanel panel = new JPanel();
		frmClass = new JFrame();
		frmClass.setTitle("Finance Report");
		frmClass.getContentPane().setForeground(Color.BLUE);
		frmClass.setBounds(100, 100, 816, 575);
		frmClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClass.getContentPane().setLayout(null);
		
		JButton btnDailyOrders = new JButton("Report Daily Orders");
		btnDailyOrders.setHorizontalAlignment(SwingConstants.LEFT);
		btnDailyOrders.setBounds(33, 156, 148, 23);
		frmClass.getContentPane().add(btnDailyOrders);
		
		JButton btnMonthlyOrders = new JButton("Report Monthly Orders");
		btnMonthlyOrders.setHorizontalAlignment(SwingConstants.LEFT);
		btnMonthlyOrders.setBounds(33, 266, 148, 23);
		frmClass.getContentPane().add(btnMonthlyOrders);
		
		JButton btnYearlyOrders = new JButton("Report Yearly Orders");
		btnYearlyOrders.setHorizontalAlignment(SwingConstants.LEFT);
		btnYearlyOrders.setBounds(33, 361, 148, 23);
		frmClass.getContentPane().add(btnYearlyOrders);
		
		DateTextField = new JTextField();
		DateTextField.setBounds(206, 74, 123, 22);
		frmClass.getContentPane().add(DateTextField);
		DateTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(258, 107, 307, 277);
		frmClass.getContentPane().add(scrollPane);
	}
}
