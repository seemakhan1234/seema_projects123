

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;



public class login extends JFrame {

	/**
	 * 
	 */
	ResultSet rs=null;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static login frame = new login();
	public static void main(String[] args) {
		
		frame.setVisible(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sarim\\Pictures\\Saved Pictures\\62863-books-icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 449);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER USERNAME");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(81, 84, 187, 17);
		contentPane.add(lblNewLabel);
		
		JTextField txtuname = new JTextField();
		txtuname.setBackground(new Color(255, 255, 255));
		txtuname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtuname.setBounds(278, 81, 187, 20);
		contentPane.add(txtuname);
		txtuname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER PASSWORD");
		lblNewLabel_1.setForeground(new Color(153, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(81, 140, 187, 22);
		contentPane.add(lblNewLabel_1);
		JPasswordField txtpwd = new JPasswordField();
		txtpwd.setBackground(new Color(255, 255, 255));
		txtpwd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpwd.setEchoChar('*');
		txtpwd.setBounds(278, 140, 187, 20);
		contentPane.add(txtpwd);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(new Color(51, 0, 102));
		btnNewButton.setBackground(new Color(255, 250, 240));
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
				}
				else {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/slibrary","root","root");
						PreparedStatement stmt=con.prepareStatement("select * from admin where user_id=? and password=?");
						stmt.setString(1, uname);
						stmt.setString(2, pswd);
						
						
						 rs=stmt.executeQuery();
						if(rs.next())
						{
							
							JOptionPane.showMessageDialog(btnNewButton, "Logged in Successfully");
							addlibrarian object= new addlibrarian();
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
		btnNewButton.setBounds(129, 226, 139, 55);
		contentPane.add(btnNewButton);
		
		
		
		JCheckBox ckbox = new JCheckBox("show password\r\n");
		ckbox.setForeground(new Color(153, 0, 0));
		ckbox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ckbox.setBackground(new Color(255, 250, 240));
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
		ckbox.setBounds(377, 167, 146, 21);
		contentPane.add(ckbox);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setForeground(new Color(51, 0, 102));
		btnNewButton_1.setBackground(new Color(255, 250, 240));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\Close-2-icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				homepage hp=new homepage();
				hp.main(null);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(304, 226, 139, 55);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("ADMIN LOGIN");
		lblNewLabel_3.setForeground(new Color(102, 0, 0));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 18, 681, 55);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\admins.png"));
		lblNewLabel_2.setForeground(new Color(204, 0, 0));
		lblNewLabel_2.setBackground(new Color(255, 102, 153));
		lblNewLabel_2.setBounds(0, 0, 693, 410);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
