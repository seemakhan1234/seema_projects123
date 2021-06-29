import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class returnbook {

	private JFrame frame;
	private JTextField txtsid;
	private JTextField txtelp;
	private JTextField txtfine;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnbook window = new returnbook();
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
	public returnbook() {
		initialize();
		connect();
		returnbook_load();
	}
	Connection con;
	PreparedStatement pst;
	private JTextField txtissueid;
	private JTextField txtrefund;
	private JTextField txtselection;
	public void connect() {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/slibrary","root","root");
			//JOptionPane.showMessageDialog(table, "connection created"); //for testing purpose only (can uncomment to know what is going under the hood)

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 	}
	public void returnbook_load() {
		try {
			 
			 Statement stmt=con.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from returnbook ");
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 
			 						// con.close();
			
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
		frame.setBounds(100, 100, 1012, 644);
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
		menuBar.setBounds(0, 0, 1018, 27);
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
		cselection.setModel(new DefaultComboBoxModel(new String[] {"StudentId", "StudentName", "BookName"}));
		cselection.setBounds(516, 81, 115, 36);
		frame.getContentPane().add(cselection);
		
		
		txtselection = new JTextField();
		txtselection.setForeground(new Color(153, 0, 0));
		txtselection.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				try {
					String selection=(String)cselection.getSelectedItem();
					String query="select * from returnbook where "+selection+" like ? ";
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
		
		txtselection.setBounds(641, 80, 147, 39);
		frame.getContentPane().add(txtselection);
		txtselection.setColumns(10);
		JButton txttable = new JButton("Refresh");
		txttable.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\Refresh-icon.png"));
		txttable.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		txttable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnbook_load() ;
				
			}
		});
		txttable.setBounds(578, 539, 126, 36);
		frame.getContentPane().add(txttable);
		


		
		
		JLabel lblNewLabel = new JLabel("Return Book");
		lblNewLabel.setForeground(new Color(107, 142, 35));
		lblNewLabel.setFont(new Font("Elephant", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(27, 62, 231, 40);
		frame.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_4 = new JLabel("  Issue ID");
		lblNewLabel_4.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel_4.setBounds(0, 125, 91, 28);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtissueid = new JTextField();
		txtissueid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER)
				{
					String issueid=txtissueid.getText();
					try {
						pst=con.prepareStatement("select * from issuebook where Id = ?");
						pst.setString(1, issueid);
						ResultSet rs=pst.executeQuery();
						if(rs.next()== false) {
							JOptionPane.showMessageDialog(null, " Issue Id not found");
						}
						else {
							txtsid.requestFocus();

							
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
			}
			}
		});
		txtissueid.setBounds(126, 131, 148, 20);
		frame.getContentPane().add(txtissueid);
		txtissueid.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("StudentID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 19));
		lblNewLabel_1.setBounds(0, 192, 112, 28);
		frame.getContentPane().add(lblNewLabel_1);
		JLabel txtsname = new JLabel("studentname");
		txtsname.setBackground(new Color(255, 255, 255));
		txtsname.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		txtsname.setEnabled(false);
		txtsname.setHorizontalAlignment(SwingConstants.CENTER);
		txtsname.setBounds(143, 251, 120, 19);
		frame.getContentPane().add(txtsname);
		
		JLabel txtbook = new JLabel("bookname");
		txtbook.setEnabled(false);
		txtbook.setHorizontalAlignment(SwingConstants.CENTER);
		txtbook.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		txtbook.setBounds(143, 308, 120, 20);
		frame.getContentPane().add(txtbook);
		JLabel txtrdate = new JLabel("Returndate");
		txtrdate.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		txtrdate.setEnabled(false);
		txtrdate.setHorizontalAlignment(SwingConstants.CENTER);
		txtrdate.setBounds(143, 361, 120, 19);
		frame.getContentPane().add(txtrdate);
		JLabel lblNewLabel_5 = new JLabel("Refund");
		lblNewLabel_5.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel_5.setBounds(10, 504, 112, 17);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtrefund = new JTextField();
		txtrefund.setBounds(154, 501, 104, 20);
		frame.getContentPane().add(txtrefund);
		txtrefund.setColumns(10);
		
		
		
		txtsid = new JTextField();
		txtsid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER)
				{
					String issueid=txtissueid.getText();
				String id=txtsid.getText();
				int fine;
				try {
					pst=con.prepareStatement("select s.StudentName , b.BookName,i.Returndate,DATEDIFF(now(),i.Returndate) as elap , i.Deposit_Amt from issuebook i JOIN student s ON i.StudentId = s.StudentId JOIN book b ON i.Book = b.Id and i.StudentId = ? and i.Id = ? ");
					pst.setString(1, id);
					pst.setString(2, issueid);
					ResultSet rs=pst.executeQuery();
					if(rs.next()== false) {
						JOptionPane.showMessageDialog(lblNewLabel_1, "StudentId not found");
					}
					else {
						String sname=rs.getString("s.StudentName");
						String bname=rs.getString("b.BookName");
						String date=rs.getString("i.Returndate");
						
						txtsname.setText(sname.trim());
						txtbook.setText(bname.trim());
						txtrdate.setText(date);
						String elp=rs.getString("elap");
						int elaped=Integer.parseInt(elp);
						String refund=rs.getString("i.Deposit_Amt");
						if(elaped>0) {
							txtelp.setText(elp);
							 fine=elaped*10;
							txtfine.setText(String.valueOf(fine));
							int amt=Integer.parseInt(refund)-fine;//to calculate refund after deducting fine
							txtrefund.setText(String.valueOf(amt));//setting refund to txt box
							
							
						}
						else {
							txtelp.setText("0");
							txtfine.setText("0");
							txtrefund.setText(refund);//if no fine is there actual deposit amt will be refunded---------
						}
						
						
					}
				} 
				 catch(Exception e3){
					 System.out.print(e3);
			 }
}
		
			}});
						txtsid.setBounds(126, 199, 148, 19);
		frame.getContentPane().add(txtsid);
		txtsid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name");
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 250, 147, 19);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Book");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 19));
		lblNewLabel_3.setBounds(10, 308, 60, 19);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_6 = new JLabel("Return Date");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Bookman Old Style", Font.BOLD, 19));
		lblNewLabel_6.setBounds(0, 360, 133, 19);
		frame.getContentPane().add(lblNewLabel_6);
		
		
		JLabel lblNewLabel_8 = new JLabel("Days Elapsed");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Bookman Old Style", Font.BOLD, 19));
		lblNewLabel_8.setBounds(0, 410, 147, 19);
		frame.getContentPane().add(lblNewLabel_8);
		
		txtelp = new JTextField();
		txtelp.setBounds(154, 412, 104, 19);
		frame.getContentPane().add(txtelp);
		txtelp.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Fine");
		lblNewLabel_9.setFont(new Font("Bookman Old Style", Font.BOLD, 19));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(0, 461, 60, 19);
		frame.getContentPane().add(lblNewLabel_9);
		
		txtfine = new JTextField();
		txtfine.setBounds(154, 463, 104, 19);
		frame.getContentPane().add(txtfine);
		txtfine.setColumns(10);
		
		JButton button_add = new JButton("Return\r\n");
		button_add.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\returnbook-icon.png"));
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=txtsid.getText();
				String issueid=txtissueid.getText();

				String sname=txtsname.getText();
				String bookname=txtbook.getText();
				String rdate=txtrdate.getText();
				String elpdays=txtelp.getText();
				String fine=txtfine.getText();
				String refundamt=txtrefund.getText();
				
				try {
					//add refund amt to database
					pst=con.prepareStatement("insert into returnbook(StudentId ,StudentName ,BookName,ReturnDate ,ElapseDays,Fine,Refund_Amt ) values(?,?,?,?,?,?,?)");
					pst.setString(1, sid);
					pst.setString(2, sname);
					
					pst.setString(3, bookname);
					pst.setString(4, rdate);
					pst.setString(5, elpdays);
					pst.setString(6, fine);
					pst.setString(7, refundamt);

					
					int k=pst.executeUpdate();
					pst=con.prepareStatement("delete from issuebook where StudentId = ? and  Id = ?");//to delete returned book record from issuebook table----
					pst.setString(1, sid);
					pst.setString(2, issueid);
					pst.executeUpdate();

					if(k==1)
					{
						JOptionPane.showMessageDialog(null, "Book Returned successfullyy---");
						txtsid.setText("");
						txtsname.setText("");
						txtissueid.setText("");
						txtbook.setText("");
						txtrdate.setText("");
						txtelp.setText("");
						txtfine.setText("");
						txtrefund.setText("");
						txtissueid.requestFocus();
						
						returnbook_load();
						
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
		button_add.setFont(new Font("Constantia", Font.BOLD, 18));
		button_add.setBounds(11, 532, 123, 54);
		frame.getContentPane().add(button_add);
		
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
		button_cancel.setFont(new Font("Constantia", Font.BOLD, 18));
		button_cancel.setBounds(144, 532, 131, 54);
		frame.getContentPane().add(button_cancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 138, 714, 390);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//to show selected row content------
				DefaultTableModel d1=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				int id=Integer.parseInt(d1.getValueAt(selectedIndex,0).toString());
				
				txtsid.setText(d1.getValueAt(selectedIndex,1).toString());
				txtsname.setText(d1.getValueAt(selectedIndex,2).toString());
				txtbook.setText(d1.getValueAt(selectedIndex,3).toString());
				txtrdate.setText(d1.getValueAt(selectedIndex,4).toString());
				txtelp.setText(d1.getValueAt(selectedIndex,5).toString());
				txtfine.setText(d1.getValueAt(selectedIndex,6).toString());
				txtrefund.setText(d1.getValueAt(selectedIndex,7).toString());
								button_add.setEnabled(false);

			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JTableHeader tableHeader = table.getTableHeader();
		 Font headerFont = new Font("Calibri", Font.BOLD, 15);
		 tableHeader.setFont(headerFont);
		table.setFont(new Font("Monospaced", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, "", null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Member ID", "Member Name", "Book", "Return Date", "Days Elapsed", "Fine", "Refund"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(79);
		table.getColumnModel().getColumn(2).setPreferredWidth(132);
		table.getColumnModel().getColumn(3).setPreferredWidth(135);
		table.getColumnModel().getColumn(4).setPreferredWidth(126);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.setBounds(315, 37, 626, 554);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\bg3.PNG"));
		lblNewLabel_10.setBounds(0, 0, 998, 609);
		frame.getContentPane().add(lblNewLabel_10);
		
		
		
		
	}
}
