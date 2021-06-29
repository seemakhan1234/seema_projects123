


import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class homepage {

	private JFrame frmWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage window = new homepage();
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
	public homepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame("");
		frmWelcome.setTitle("\r\n");
		frmWelcome.getContentPane().setBackground(new Color(255, 255, 255));
		frmWelcome.setBounds(100, 100, 854, 456);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to Library Management System");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(10, 31, 763, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(240, 230, 140));
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 33));
		frmWelcome.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		
		lblNewLabel_1.setBounds(104, 136, 169, 167);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\adminlogin.jpg"));


		frmWelcome.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(556, 136, 169, 167);
		lblNewLabel_2.setLabelFor(frmWelcome);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\librarianlogin.jpg"));
		frmWelcome.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Admin Login");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login obj1= new login();
				obj1.setVisible(true);
				frmWelcome.setVisible(false);
			}
			
		});
		lblNewLabel_3.setBounds(99, 324, 188, 28);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Georgia", Font.BOLD, 26));
		frmWelcome.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Librarian Login");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				librarianlogin obj2= new librarianlogin();
				obj2.setVisible(true);
				frmWelcome.setVisible(false);
				
				
			}
		});
		lblNewLabel_4.setBounds(531, 324, 242, 28);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Georgia", Font.BOLD, 26));
		frmWelcome.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\log.png"));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 0, 840, 419);
		frmWelcome.getContentPane().add(lblNewLabel_5);
	}
}