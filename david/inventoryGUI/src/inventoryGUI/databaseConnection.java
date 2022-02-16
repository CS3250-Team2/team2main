package inventoryGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class databaseConnection extends JFrame {

	private JPanel contentPane;
	private JTextField searchBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					databaseConnection frame = new databaseConnection();
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
	public databaseConnection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton createButton = new JButton("Create");
		createButton.setBounds(10, 318, 89, 23);
		contentPane.add(createButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(109, 318, 89, 23);
		contentPane.add(deleteButton);
		
		JButton readButton = new JButton("Read");
		readButton.setBounds(208, 318, 89, 23);
		contentPane.add(readButton);
		
		searchBox = new JTextField();
		searchBox.setBounds(399, 319, 96, 20);
		contentPane.add(searchBox);
		searchBox.setColumns(10);
		
		JLabel searchBoxLabel = new JLabel("Seach");
		searchBoxLabel.setBounds(334, 322, 47, 14);
		contentPane.add(searchBoxLabel);
	}

}
