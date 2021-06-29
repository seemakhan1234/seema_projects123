

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.SwingConstants;
import java.sql.* ;
import java.awt.SystemColor;
public class librarianlogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ResultSet rs=null;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static librarianlogin frame = new librarianlogin();
	public static void main(String ars[]) {
		frame.setVisible(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public librarianlogin() {
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 469);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER USERNAME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(90, 137, 209, 17);
		contentPane.add(lblNewLabel);
		
		JTextField txtuname = new JTextField();
		txtuname.setBackground(Color.WHITE);
		txtuname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtuname.setBounds(320, 134, 136, 20);
		contentPane.add(txtuname);
		txtuname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\r\nENTER PASSWORD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(99, 184, 200, 22);
		contentPane.add(lblNewLabel_1);
		JPasswordField txtpwd = new JPasswordField();
		txtpwd.setBackground(Color.WHITE);
		txtpwd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpwd.setEchoChar('*');
		txtpwd.setBounds(320, 185, 136, 20);
		contentPane.add(txtpwd);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(new Color(153, 0, 51));
		btnNewButton.setBackground(new Color(250, 240, 230));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\preferences-system-login-icon.png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=txtuname.getText();
				@SuppressWarnings("deprecation")
				String pswd=txtpwd.getText();
				
				if(uname.equals("")||pswd.equals(""))
				{
					JOptionPane.showMessageDialog(btnNewButton, "Some fields are empty","error",1);
				}else {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/slibrary","root","root");
						PreparedStatement stmt=con.prepareStatement("select * from librarian where user_id=? and password=?");
						stmt.setString(1, uname);
						stmt.setString(2, pswd);
						
						
						rs=stmt.executeQuery();
						if(rs.next())
						{
							@SuppressWarnings("unused")
							String s1=rs.getString("user_id");
							@SuppressWarnings("unused")
							String s2=rs.getString("password");
							JOptionPane.showMessageDialog(btnNewButton, "Logged in Successfully");
							librarianfunc object= new librarianfunc();
							object.main(null);
							
							frame.setVisible(false);

							txtuname.setText("");
							txtpwd.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(btnNewButton, " User_id or Password are not matched");
							txtuname.setText("");
							txtpwd.setText("");

						}	
						
						}catch(Exception e1){
					
					}
				}
				
				
				
				
				 
			
			}
		});
		btnNewButton.setBounds(158, 304, 115, 42);
		contentPane.add(btnNewButton);
		
		
		
		JCheckBox ckbox = new JCheckBox("show password\r\n");
		ckbox.setForeground(new Color(153, 0, 51));
		ckbox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ckbox.setBackground(SystemColor.info);
		ckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ckbox.isSelected())
				{
					txtpwd.setEchoChar((char)0);	
				
				}
				else
				{
					txtpwd.setEchoChar('*');
				}
			}
		});
		ckbox.setBounds(383, 230, 151, 29);
		contentPane.add(ckbox);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setForeground(new Color(153, 0, 51));
		btnNewButton_1.setBackground(new Color(250, 240, 230));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\Close-2-icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				homepage hp=new homepage();
				hp.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(385, 304, 115, 42);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("LIBRARIAN LOGIN");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(204, 0, 51));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_4.setBounds(148, 35, 374, 51);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(102, 0, 0));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\bg1.PNG"));
		lblNewLabel_2.setBackground(new Color(204, 102, 204));
		lblNewLabel_2.setBounds(0, 0, 690, 434);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
