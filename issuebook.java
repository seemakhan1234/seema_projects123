import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.SwingConstants;
import java.awt.Color;


import javax.swing.JTable;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

//import books.author_item;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class issuebook {

	private JFrame frame;
	private JTextField txtname;
	private JTable table;
	private JTextField txtid;
	JComboBox txtbook = new JComboBox();
	ResultSet rs=null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issuebook window = new issuebook();
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
	public issuebook() {
		initialize();
		connect();
		book();
		issuebook_load();

	}
	Connection con;
	PreparedStatement pst;
	private JTextField txtdeposit;
	private JTextField txtselection;
		public void connect() {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/slibrary","root","root");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 	}
		
		public class book_item{
			int id;
			String name;
			public book_item(int id,String name)
			{
				this.id=id;
				this.name=name;
			}
			public String toString()
			{
				return name;
			}
		}
		
		public void book()
		{
			try {
				pst =con.prepareStatement("select * from book");
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {
					txtbook.addItem(new book_item (rs.getInt(1),rs.getString(2)));
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error occur");
			}
			
			
			
		}
		public void issuebook_load() {
			try {
				 
				 Statement stmt=con.createStatement();
				 ResultSet rs=stmt.executeQuery("select i.Id ,m.StudentId,m.StudentName,b.BookName,i.Issuedate date,i.Returndate,i.Deposit_Amt from issuebook i JOIN student m ON i.StudentId=m.StudentId JOIN book b ON i.book=b.Id   ");
				 table.setModel(DbUtils.resultSetToTableModel(rs));
				 
				 						 				
			 }
			 catch(Exception e3){
				 System.out.print(e3);
		 }

		}

		
		

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 979, 637);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter()
		{
		    @Override
		    public void windowClosing(WindowEvent e)
		    {
		    	super.windowClosing(e);
		        try {
					JOptionPane.showMessageDialog(frame, "gonna close connection");
		        	con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});

		frame.getContentPane().setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBackground(new Color(255, 255, 204));
		menuBar.setBounds(0, 0, 965, 27);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Home");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\home-icon.png"));
		mnNewMenu.setBackground(new Color(255, 255, 0));
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				librarianfunc lb=new librarianfunc() ;
				lb.main(null);
				frame.setVisible(false);
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_4 = new JMenu("AddBooks");
		mnNewMenu_4.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\addbooks-icon.png"));
		mnNewMenu_4.setBackground(new Color(255, 255, 0));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Category");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category ct=new category() ;
				ct.main(null);
				frame.setVisible(false);
				
			}
		});
		
		mntmNewMenuItem_1.setBackground(new Color(255, 255, 153));
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Author");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				author obj=new author() ;
				obj.main(null);
				frame.setVisible(false);

			}
		});
				mntmNewMenuItem.setBackground(new Color(255, 255, 153));
		mntmNewMenuItem.setForeground(new Color(0, 0, 0));
		mnNewMenu_4.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("publisher");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				publisher obj=new publisher() ;
				obj.main(null);
				frame.setVisible(false);

				
			}
		});
				mntmNewMenuItem_2.setBackground(new Color(255, 255, 153));
		mnNewMenu_4.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Books");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				books obj=new books() ;
				obj.main(null);
				frame.setVisible(false);
			}
		});
		
		mntmNewMenuItem_3.setBackground(new Color(255, 255, 153));
		mnNewMenu_4.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_5 = new JMenu("Student");
		mnNewMenu_5.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\Student-id-icon.png"));
		mnNewMenu_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				student obj=new student() ;
				obj.main(null);
				frame.setVisible(false);
			}
		});
		mnNewMenu_5.setBackground(new Color(255, 255, 0));
		menuBar.add(mnNewMenu_5);
		
		JMenu mnNewMenu_6 = new JMenu("IssueBook");
		mnNewMenu_6.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\issuebook-icon.png"));
		mnNewMenu_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				issuebook obj=new issuebook() ;
				obj.main(null);
				frame.setVisible(false);
			}
		});
		mnNewMenu_6.setBackground(new Color(255, 255, 0));
		menuBar.add(mnNewMenu_6);
		
		JMenu mnNewMenu_7 = new JMenu("ReturnBook");
		mnNewMenu_7.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\returnbook-icon.png"));
		mnNewMenu_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				returnbook obj=new returnbook() ;
				obj.main(null);
				frame.setVisible(false);
			}
		});
		mnNewMenu_7.setBackground(new Color(255, 255, 0));
		menuBar.add(mnNewMenu_7);
		
		JMenu mnNewMenu_1 = new JMenu("Email");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				email obj=new email() ;
				obj.main(null);
				frame.setVisible(false);
			}
		});
		mnNewMenu_1.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\email-icon.png"));
		menuBar.add(mnNewMenu_1);
		JLabel searchlbl = new JLabel("Search By");
		searchlbl.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\search-icon.png"));
		searchlbl.setForeground(new Color(153, 0, 102));
		searchlbl.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		searchlbl.setBounds(378, 81, 137, 32);
		frame.getContentPane().add(searchlbl);


		JComboBox cselection = new JComboBox();
		cselection.setForeground(new Color(153, 0, 0));
		cselection.setModel(new DefaultComboBoxModel(new String[] {"StudentId", "Book"}));
		cselection.setBounds(508, 77, 115, 36);
		frame.getContentPane().add(cselection);
		
		
		txtselection = new JTextField();
		txtselection.setForeground(new Color(0, 102, 153));
		txtselection.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				try {
					String selection=(String)cselection.getSelectedItem();
					String query="  select i.Id ,m.StudentId,m.StudentName,b.BookName,i.Issuedate date,i.Returndate,i.Deposit_Amt from issuebook i JOIN student m ON i.StudentId=m.StudentId JOIN book b ON i.book=b.Id   where i. "+selection+" like ? ";
					pst=con.prepareStatement(query);
					pst.setString(1, txtselection.getText() + "%");
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		txtselection.setBounds(633, 76, 147, 39);
		frame.getContentPane().add(txtselection);
		txtselection.setColumns(10);
		JButton txttable = new JButton("Refresh");
		txttable.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\Refresh-icon.png"));
		txttable.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		txttable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				issuebook_load() ;
				
			}
		});
		txttable.setBounds(593, 515, 126, 36);
		frame.getContentPane().add(txttable);
		
		

		
		JLabel lblNewLabel = new JLabel("ISSUE BOOK");
		lblNewLabel.setBounds(55, 38, 234, 33);
		lblNewLabel.setForeground(new Color(128, 128, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Elephant", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);
		JLabel label = new JLabel("Student Id");
		label.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		label.setBounds(30, 103, 137, 14);
		frame.getContentPane().add(label);
		
		txtid = new JTextField();
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					String mid=txtid.getText();
					try {
						pst = con.prepareStatement("select * from student where StudentId= ?");
						pst.setString(1, mid);
						 rs=pst.executeQuery();
						 if(rs.next() == false) {
							 JOptionPane.showMessageDialog(null, "Student ID no found");
						 }
						 else {
							 String studentname = rs.getString("StudentName");
							 txtname.setText(studentname.trim());
						 }
					} 
					 catch(Exception e3){
						 System.out.print(e3);
				 }
}
			}
		});
		txtid.setBounds(177, 102, 168, 20);
		frame.getContentPane().add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name");
		lblNewLabel_2.setBounds(26, 148, 137, 23);
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtname = new JTextField();
		txtname.setBounds(177, 148, 168, 23);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Book Title");
		lblNewLabel_3.setBounds(13, 196, 130, 23);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_3);
		
		txtbook.setBounds(176, 198, 169, 22);
		frame.getContentPane().add(txtbook);
		
		JDateChooser txtbdate = new JDateChooser();
		txtbdate.setBounds(177, 246, 168, 23);
		frame.getContentPane().add(txtbdate);
		
		JLabel lblNewLabel_4 = new JLabel("Borrow Date");
		lblNewLabel_4.setBounds(26, 246, 128, 23);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_4);
		
		JDateChooser txtrdate = new JDateChooser();
		txtrdate.setBounds(177, 292, 168, 23);
		frame.getContentPane().add(txtrdate);
		
		JLabel lblNewLabel_5 = new JLabel("Return Date");
		lblNewLabel_5.setBounds(26, 292, 130, 23);
		lblNewLabel_5.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel_5);
		JLabel lblNewLabel_1 = new JLabel("Deposit Amt");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel_1.setBounds(30, 326, 135, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtdeposit = new JTextField();
		txtdeposit.setBounds(177, 326, 86, 26);
		frame.getContentPane().add(txtdeposit);
		txtdeposit.setColumns(10);

		
		JButton btnBookissue = new JButton("ISSUE");
		btnBookissue.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\issuebook-icon.png"));
		btnBookissue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mid = txtid.getText();
				book_item bitem =(book_item) txtbook.getSelectedItem();
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				String issuedate =date.format(txtbdate.getDate());
				SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
				String returndate =date1.format(txtrdate.getDate());
				String damt = txtdeposit.getText();
				
				try {
					pst=con.prepareStatement("insert into issuebook(StudentId,Book ,Issuedate,Returndate,Deposit_Amt) values(?,?,?,?,?)");
					pst.setString(1, mid);
					pst.setInt(2, bitem.id);
					pst.setString(3, issuedate);
					pst.setString(4, returndate);
					pst.setString(5, damt);

					

					
					int k=pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(null, "Book Issued!!!!!!!!!!");
						txtname.setText("");
						txtid.setText("");
						txtbook.setSelectedIndex(-1);
						
						issuebook_load();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Error..");

					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}

				
			
		});
		btnBookissue.setBounds(30, 383, 122, 55);
		btnBookissue.setFont(new Font("Constantia", Font.BOLD, 18));
		frame.getContentPane().add(btnBookissue);
		
		JButton button_update = new JButton("Update");
		button_update.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\updateicon.png"));
		button_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount()==1) //to check whether row is selected or not--------
				{
				DefaultTableModel d1=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				int id=Integer.parseInt(d1.getValueAt(selectedIndex,0).toString());

				String mid = txtid.getText();
				book_item bitem =(book_item) txtbook.getSelectedItem();
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				String issuedate =date.format(txtbdate.getDate());
				SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
				String returndate =date1.format(txtrdate.getDate());
				String damt = txtdeposit.getText();
				try {
					pst=con.prepareStatement("update issuebook set StudentId = ?,Book = ? ,Issuedate = ?,Returndate =? ,Deposit_Amt = ? where Id=?");
					pst.setString(1, mid);
					pst.setInt(2, bitem.id);
					pst.setString(3, issuedate);
					pst.setString(4, returndate);
					pst.setString(5, damt);

					
					pst.setInt(6, id);

					
					int k=pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(null, "Issued Book Updated!");
						txtname.setText("");
						txtid.setText("");
						txtbook.setSelectedIndex(-1);
						txtdeposit.setText("");
						
						issuebook_load();
						btnBookissue.setEnabled(true);
						txtid.setEditable(true);
						
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Error..");

					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				else {
					 JOptionPane.showMessageDialog(null, "Please select row to update");

				}

				

				
			}
		});
		button_update.setBounds(208, 383, 117, 55);
		button_update.setFont(new Font("Constantia", Font.BOLD, 18));
		frame.getContentPane().add(button_update);
		
		JButton button_cancel = new JButton("Cancel");
		button_cancel.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\Close-2-icon.png"));
		button_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int result =JOptionPane.showConfirmDialog(frame, "Do you want to close connection?","connection close",JOptionPane.YES_NO_OPTION);
					 if(result == JOptionPane.YES_OPTION) {
						 con.close();
						 librarianfunc object= new librarianfunc();
							object.main(null);
							
							frame.setVisible(false);

					 }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		button_cancel.setBounds(117, 449, 117, 55);
		button_cancel.setFont(new Font("Constantia", Font.BOLD, 18));
		frame.getContentPane().add(button_cancel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(355, 123, 600, 380);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//to show selected row content------
				DefaultTableModel d1=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				int id=Integer.parseInt(d1.getValueAt(selectedIndex,0).toString());
				txtid.setText(d1.getValueAt(selectedIndex,1).toString());
				txtid.setEditable(false);

				txtname.setText(d1.getValueAt(selectedIndex,2).toString());
				//txtname.setEditable(false);

				txtbook.setSelectedItem(d1.getValueAt(selectedIndex,3).toString());
				txtdeposit.setText(d1.getValueAt(selectedIndex,6).toString());

				
				btnBookissue.setEnabled(false);
				

			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		 JTableHeader tableHeader = table.getTableHeader();
		 Font headerFont = new Font("Calibri", Font.BOLD, 15);
		 tableHeader.setFont(headerFont);
		table.setFont(new Font("Monospaced", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Student ID", "Student Name", "Book", "Borrow Date", "Return Date", "DepositAmount"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(102);
		table.getColumnModel().getColumn(2).setPreferredWidth(133);
		table.getColumnModel().getColumn(3).setPreferredWidth(118);
		table.getColumnModel().getColumn(4).setPreferredWidth(132);
		table.getColumnModel().getColumn(5).setPreferredWidth(130);
		table.getColumnModel().getColumn(6).setPreferredWidth(81);
		table.setBounds(383, 24, 538, 542);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\bg2.PNG"));
		lblNewLabel_6.setBounds(0, 0, 965, 600);
		frame.getContentPane().add(lblNewLabel_6);
		
				
		
		
		
		
		
	}
}