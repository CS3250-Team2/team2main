import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;



public class FinancialGUI {

	private JFrame frmClass;
	private Finance finance;
	private JTextField DateTextField;
	private OrderTable orderTable;
	private OrderInfo orderInfo;
	private OrderInfo tempOrderInfo;
	private JTable table;
	private JLabel DateTextFieldLabel;
	private FinanceInfo financeInfo;
	private String popular;
	
	private String ProfitDay;
	private String ProfitMonth;
	private String ProfitYear;
	private String PopularItemD;
	private String PopularItemM;
	private String PopularItemY;
	protected String Jan;
	protected String Feb;
	protected String Mar;
	protected String Apr;
	protected String May;
	protected String Jun;
	protected String Jul;
	protected String Aug;
	protected String Sep;
	protected String Oct;
	protected String Nov;
	protected String Dec;
	protected String month;
	protected String year;
	
	
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
			orderTable = new OrderTable();
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

		
		
		DateTextField = new JTextField();
		DateTextField.setBounds(206, 74, 123, 22);
		frmClass.getContentPane().add(DateTextField);
		DateTextField.setColumns(10);
///biggerScrollPanel

		DateTextFieldLabel= new JLabel("Date to Search YYYY-MM-DD");
		DateTextFieldLabel.setBounds(206, 10, 180, 100);
		frmClass.getContentPane().add(DateTextFieldLabel);
		table = new JTable();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(258, 107, 510, 410);

		frmClass.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnDailyOrders = new JButton("Report Daily Orders");
		btnDailyOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get ProductID from text field
				
				String date = DateTextField.getText();
				
				DateTimeFormatter dateFormatter = 
				        new DateTimeFormatterBuilder()
				            .parseCaseInsensitive()
				            .appendPattern("yyyy-MM-dd")
				            .toFormatter(Locale.ENGLISH);
				
				
				LocalDate date2 = LocalDate.parse(date, dateFormatter);
				
					List<FinanceInfo> daylist  = null;
					try {
						
						daylist = finance.searchDayInfo(date2);
						DetailFinanceTableModel model = new DetailFinanceTableModel(daylist);
						table.setModel(model);
					double profit = finance.DailyProfits(date2);
					
					PopularItemD = finance.DayPopularFast(date2);
					//financeInfo.setPopularItemD(popular);
					
					NumberFormat formatter = NumberFormat.getCurrencyInstance();
					ProfitDay = formatter.format(profit);
					
				
					JOptionPane.showMessageDialog(null, "Daily profits = " + ProfitDay);
					JOptionPane.showMessageDialog(null, "Daily Popular Item  = " + PopularItemD);
			
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		
		
		
		
		btnDailyOrders.setHorizontalAlignment(SwingConstants.LEFT);
		btnDailyOrders.setBounds(33, 156, 148, 23);
		frmClass.getContentPane().add(btnDailyOrders);

		JButton btnMonthlyOrders = new JButton("Report Monthly Orders");
		btnMonthlyOrders.addActionListener(new ActionListener() {
		
			
		

			public void actionPerformed(ActionEvent e) {
				//get ProductID from text field
				int i = 1;
				
				String date = DateTextField.getText();
				
				 double profit;
				 
				
				DateTimeFormatter dateFormatter = 
				        new DateTimeFormatterBuilder()
				            .parseCaseInsensitive()
				            .appendPattern("yyyy-MM-dd")
				            .toFormatter(Locale.ENGLISH);
				
				
				LocalDate date2 = LocalDate.parse(date, dateFormatter);
				
				
				List<FinanceInfo> list  = new ArrayList<>();
				try {
				
	
				NumberFormat formatter = NumberFormat.getCurrencyInstance();
					
					while( i<13){
						
						//List<OrderInfo> orderInfo = null;
					
			//	orderTable.getMonthlyPop(date2, i);
				//orderTable.getMonthyReport(date2);
				//PopularItemM  = finance.MonPop(date2,3);
					profit = finance.MonthlyProfits(date2,i);
					
					System.out.println("month profit= " + profit );
					String month = finance.getMonth(i);
					if (profit == 0) {
						
					ProfitMonth = "0";
					PopularItemM = " no items sold";
						
					}
					else if (profit >0){
						ProfitMonth =  formatter.format(profit);
						
						PopularItemM = finance.MonthPopularFast(date2, i);
						System.out.println("month popular= " + PopularItemM );
					}
					FinanceInfo tempFinanceInfo = new FinanceInfo(month,date,ProfitMonth,PopularItemM,month );
					list.add(tempFinanceInfo);
					
					i ++;
					
					}
				

					FinanceTableModel model = new FinanceTableModel(list);
					table.setModel(model);
						
					  
					  System.out.println("All done monthly!= "  );
				} catch (Exception e1) {
					// TODO Auto-generated catch bloc
					e1.printStackTrace();
				}
				
			}
		});


		
		
		
		btnMonthlyOrders.setHorizontalAlignment(SwingConstants.LEFT);
		btnMonthlyOrders.setBounds(33, 190, 148, 23);
		frmClass.getContentPane().add(btnMonthlyOrders);

		JButton btnYearlyOrders = new JButton("Report Yearly Orders");
		btnYearlyOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get ProductID from text field
				
				String date = DateTextField.getText();
				
				DateTimeFormatter dateFormatter = 
				        new DateTimeFormatterBuilder()
				            .parseCaseInsensitive()
				            .appendPattern("yyyy-MM-dd")
				            .toFormatter(Locale.ENGLISH);
				
				
				LocalDate date2 = LocalDate.parse(date, dateFormatter);
				
				List<FinanceInfo> yearlist  = null;
				try {
					
					 yearlist = finance.searchYearInfo(date2);
						DetailFinanceTableModel model = new DetailFinanceTableModel(yearlist);
						table.setModel(model);
					
					
					NumberFormat formatter = NumberFormat.getCurrencyInstance();
				ProfitYear = formatter.format(finance.YearProfits(date2));
					
					PopularItemY = finance.YearPopularFast(date2);
					
					  JOptionPane.showMessageDialog(null, "Yearly profits = " + ProfitYear);
					  JOptionPane.showMessageDialog(null, "Yearly popular item = " + PopularItemY);
					  
					 
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		btnYearlyOrders.setHorizontalAlignment(SwingConstants.LEFT);
		btnYearlyOrders.setBounds(33, 229, 148, 23);
		frmClass.getContentPane().add(btnYearlyOrders);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerOrderGUI back = new CustomerOrderGUI();
				back.NewScreen();
				frmClass.dispose();
			}
		});
		backButton.setBounds(31, 421, 89, 23);
		frmClass.getContentPane().add(backButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				DateTextField.setText("");
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
			}
		});
		btnClear.setBounds(31, 263, 150, 23);
		frmClass.getContentPane().add(btnClear);
		
		JButton btnProfts = new JButton("Profits");
		btnProfts.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				List<OrderInfo> orderInfo = null;
				try {
					orderInfo = orderTable.getAllOrderInfo();
					orderTable.getProfit(orderInfo);
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnProfts.setBounds(31, 290, 150, 23);
		frmClass.getContentPane().add(btnProfts);


	}
}