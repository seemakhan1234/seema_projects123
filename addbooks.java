import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class addbooks {

	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("Add Details of a Book");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addbooks window = new addbooks();
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
	public addbooks() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblNewLabel.setForeground(new Color(153, 51, 102));
		lblNewLabel.setFont(new Font("Elephant", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(112, 10, 309, 36);
		frame.getContentPane().add(lblNewLabel);
		JLabel label_back = new JLabel("");
		label_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				librarianfunc object= new librarianfunc();
				object.main(null);
				
				frame.setVisible(false);

				
			}
		});
		label_back.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\back1.png"));
		label_back.setBounds(10, 0, 71, 36);
		frame.getContentPane().add(label_back);

		
		JLabel txtcategory = new JLabel("");
		txtcategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				category object= new category();
				object.main(null);
				
				frame.setVisible(false);

			}
		});
		txtcategory.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\category.jpg"));
		txtcategory.setBounds(27, 68, 156, 155);
		frame.getContentPane().add(txtcategory);
		
		JLabel txtauthor = new JLabel("");
		txtauthor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				author object= new author();
				object.main(null);
				
				frame.setVisible(false);

			}
		});
		txtauthor.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\author.png"));
		txtauthor.setBounds(311, 68, 156, 155);
		frame.getContentPane().add(txtauthor);
		
		JLabel txtpublisher = new JLabel("");
		txtpublisher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				publisher object= new publisher();
				object.main(null);
				
				frame.setVisible(false);

			}
		});
		txtpublisher.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\publisher.jpg"));
		txtpublisher.setBounds(39, 317, 156, 155);
		frame.getContentPane().add(txtpublisher);
		
		JLabel txtbooks = new JLabel("");
		txtbooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				books object= new books();
				object.main(null);
				
				frame.setVisible(false);

			}
		});
		txtbooks.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\books.png"));
		txtbooks.setBounds(311, 317, 156, 155);
		frame.getContentPane().add(txtbooks);
		
		JLabel lblNewLabel_5 = new JLabel("Category");
		lblNewLabel_5.setFont(new Font("Constantia", Font.BOLD, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(27, 243, 156, 36);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("BOOKS");
		lblNewLabel_6.setFont(new Font("Constantia", Font.BOLD, 25));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(277, 494, 237, 31);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Author");
		lblNewLabel_7.setFont(new Font("Constantia", Font.BOLD, 25));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(311, 244, 156, 36);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Publisher");
		lblNewLabel_8.setFont(new Font("Constantia", Font.BOLD, 25));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(39, 493, 156, 32);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\ARWA\\TYBCA\\SEM-VI\\Project\\bg11.PNG"));
		lblNewLabel_9.setBounds(0, 0, 567, 569);
		frame.getContentPane().add(lblNewLabel_9);
		
			}
}
