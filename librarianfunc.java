import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class librarianfunc {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					librarianfunc window = new librarianfunc();
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
	public librarianfunc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(51, 204, 255));
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 714, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Library Operations");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setForeground(new Color(165, 42, 42));
		lblNewLabel_10.setFont(new Font("Algerian", Font.BOLD, 28));
		lblNewLabel_10.setBackground(new Color(176, 224, 230));
		lblNewLabel_10.setBounds(208, 10, 307, 26);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addbooks object= new addbooks();
				object.main(null);
				
				frame.setVisible(false);

			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\addbooks.png"));
		lblNewLabel.setBounds(296, 47, 121, 115);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				student object= new student();
				object.main(null);
				
				frame.setVisible(false);

			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\student.jpg"));
		lblNewLabel_1.setBounds(65, 325, 121, 115);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				issuebook object= new issuebook();
				object.main(null);
				
				frame.setVisible(false);

			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\issuebooks.png"));
		lblNewLabel_2.setBounds(20, 133, 121, 115);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homepage object= new homepage();
				object.main(null);
				
				frame.setVisible(false);

			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\logout.png"));
		lblNewLabel_3.setBounds(546, 325, 121, 115);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				returnbook object= new returnbook();
				object.main(null);
				
				frame.setVisible(false);

			}
		});
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\returnbooks.png"));
		lblNewLabel_4.setBounds(567, 117, 121, 115);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Add Books");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblNewLabel_5.setBounds(296, 160, 121, 26);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Issue Books");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblNewLabel_6.setBounds(20, 248, 121, 26);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Return Books");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblNewLabel_7.setBounds(557, 228, 131, 32);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Students");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblNewLabel_8.setBounds(65, 438, 121, 26);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Logout");
		lblNewLabel_9.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(567, 435, 121, 33);
		frame.getContentPane().add(lblNewLabel_9);
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				email object= new email();
				object.main(null);
				
				frame.setVisible(false);
				
			}
		});
		lblNewLabel_11.setBackground(new Color(230, 230, 250));
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\mail.png"));
		lblNewLabel_11.setBounds(296, 309, 121, 115);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_13 = new JLabel("Email");
		lblNewLabel_13.setFont(new Font("Bookman Old Style", Font.BOLD, 19));
		lblNewLabel_13.setBounds(325, 414, 75, 26);
		frame.getContentPane().add(lblNewLabel_13);

		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBackground(new Color(51, 204, 255));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\librarian2.PNG"));
		lblNewLabel_12.setBounds(0, 0, 696, 503);
		frame.getContentPane().add(lblNewLabel_12);
	
		
			}
}
