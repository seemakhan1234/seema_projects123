import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class student {

	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("Student");
	private JTextField txtname;
	private JTextField txtcontact;
	private JTable table;
	private JTextField txtemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student window = new student();
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
	public student() {
		initialize();
		connect();
		student_load();
			}
	Connection con;
	PreparedStatement pst;
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
	
	public void student_load() {
		try {
			 
			 Statement stmt=con.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from student");
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
		frame.setBounds(100, 100, 976, 626);
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
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Elephant", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(38, 51, 265, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel searchlbl = new JLabel("Search By");
		searchlbl.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\search-icon.png"));
		searchlbl.setForeground(new Color(153, 0, 102));
		searchlbl.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		searchlbl.setBounds(460, 54, 137, 32);
		frame.getContentPane().add(searchlbl);
		// to add menubar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBackground(new Color(255, 255, 204));
		menuBar.setBounds(0, 0, 960, 27);
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
		

		JComboBox cselection = new JComboBox();
		cselection.setForeground(new Color(153, 0, 0));
		cselection.setModel(new DefaultComboBoxModel(new String[] {"StudentId", "StudentName"}));
		cselection.setBounds(598, 54, 115, 36);
		frame.getContentPane().add(cselection);
		
		
		txtselection = new JTextField();
		txtselection.setForeground(new Color(0, 102, 153));
		txtselection.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				try {
					String selection=(String)cselection.getSelectedItem();
					String query="select * from student where "+selection+" like ? ";
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
		
		txtselection.setBounds(723, 51, 147, 39);
		frame.getContentPane().add(txtselection);
		txtselection.setColumns(10);
		JButton txttable = new JButton("Refresh");
		txttable.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\Refresh-icon.png"));
		txttable.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		txttable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student_load() ;
				
			}
		});
		txttable.setBounds(584, 522, 126, 36);
		frame.getContentPane().add(txttable);
		
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel_1.setBounds(0, 108, 94, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 180, 94, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contact No");
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 267, 115, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtname = new JTextField();
		txtname.setBounds(132, 110, 136, 22);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtcontact = new JTextField();
		txtcontact.setBounds(135, 269, 133, 22);
		frame.getContentPane().add(txtcontact);
		txtcontact.setColumns(10);
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel_5.setBounds(20, 326, 115, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtemail = new JTextField();
		txtemail.setBounds(132, 329, 136, 20);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		JTextArea txtaddress = new JTextArea();
		txtaddress.setBounds(132, 157, 136, 80);
		frame.getContentPane().add(txtaddress);
		
		JButton button_add = new JButton("Add");
		button_add.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\Add-icon.png"));
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to insert record---
				String name=txtname.getText();
				String address=txtaddress.getText();
				String phoneno=txtcontact.getText();
				String email=txtemail.getText();
								if(name.equals("")||address.equals("")||phoneno.equals("")||email.equals("")){
					JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY","error",1);
					
					
				}
								else if(!Pattern.matches("[a-zA-Z][a-zA-Z]*", txtname.getText()))
								{
							       JOptionPane.showMessageDialog(null, "invalid name");
							    
								  txtname.setText("");
									
								}
								else if(!Pattern.matches("^(.+)@(.+)$", txtemail.getText()))
								{
							       JOptionPane.showMessageDialog(null, "invalid email address");
							    
								  txtemail.setText("");
									
								}

								else if(!Pattern.matches("^[0-9]+$", txtcontact.getText()))
								{
							       JOptionPane.showMessageDialog(null, "CONTACT SHOULD BE A NUMBER");
							    
								  txtcontact.setText("");
									
								}

				else {
				try {
					pst=con.prepareStatement("insert into student(StudentName,Address,phoneno,Email) values(?,?,?,?)");
					pst.setString(1, name);
					pst.setString(2, address);
					pst.setString(3, phoneno);
					pst.setString(4, email);

					
					int k=pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(null, "Record Added");
						txtname.setText("");
						txtaddress.setText("");
						txtcontact.setText("");
						txtemail.setText("");
						
						txtname.requestFocus();
						student_load();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Error..");

					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
				
			}
		});
		button_add.setFont(new Font("Constantia", Font.BOLD, 18));
		button_add.setBounds(23, 378, 126, 48);
		frame.getContentPane().add(button_add);
		
		JButton button_update = new JButton("Update");
		button_update.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\updateicon.png"));
		button_update.setFont(new Font("Constantia", Font.BOLD, 18));
		button_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount()==1) //to check whether row is selected or not--------
				{

				DefaultTableModel d1=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				int id=Integer.parseInt(d1.getValueAt(selectedIndex,0).toString());
				String name=txtname.getText();
				String address=txtaddress.getText();
				String phoneno=txtcontact.getText();
				String email=txtemail.getText();
				
				if(name.equals("")||address.equals("")||phoneno.equals("")||email.equals("")){
					     JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY","error",1);
					}
				else if(!Pattern.matches("^[0-9]+$", txtcontact.getText()))
				{
			       JOptionPane.showMessageDialog(null, "CONTACT SHOULD BE A NUMBER");
			    
				  txtcontact.setText("");
					
				}
				else if(!Pattern.matches("[a-zA-Z][a-zA-Z]*", txtname.getText()))
				{
			       JOptionPane.showMessageDialog(null, "invalid name");
			    
				  txtname.setText("");
					
				}
				else if(!Pattern.matches("^(.+)@(.+)$", txtemail.getText()))
				{
			       JOptionPane.showMessageDialog(null, "invalid email address");
			    
				  txtemail.setText("");
					
				}

				else {
				try {
					pst=con.prepareStatement("update student set StudentName =? , Address = ? , phoneno = ? , Email = ?  where StudentId = ?");
					pst.setString(1, name);
					pst.setString(2, address);
					pst.setString(3, phoneno);
					pst.setString(4, email);
					pst.setInt(5, id);
					int k=pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(null, "Record Updated");
						txtname.setText("");
						txtaddress.setText("");
						txtcontact.setText("");
						txtemail.setText("");
						
						txtname.requestFocus();
						student_load();

						
						button_add.setEnabled(true);
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Error..");

					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
				}
				else {
					 JOptionPane.showMessageDialog(null, "Please select row to update");

				}

				
				
				
				
			}
		});
		button_update.setBounds(176, 378, 127, 48);
		frame.getContentPane().add(button_update);
		
		JButton button_delete = new JButton("Delete");
		button_delete.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\Button-Delete-icon.png"));
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to delete selected row record----
				if(table.getSelectedRowCount()==1) {
				try {
					int result =JOptionPane.showConfirmDialog(frame, "Do you really want to delete the record ?","record delete",JOptionPane.YES_NO_OPTION);
					 if(result == JOptionPane.YES_OPTION) {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/slibrary","root","root");
					int row=table.getSelectedRow();
					String value=table.getModel().getValueAt(row,0).toString();
					String query="delete from student where Id="+value;
					 PreparedStatement stmt=con.prepareStatement(query);
					 stmt.executeUpdate();
					 DefaultTableModel tbmodel=(DefaultTableModel)table.getModel();
					 tbmodel.setRowCount(0);
					 student_load();
					 JOptionPane.showMessageDialog(null, "Record deleted");
					 txtname.setText("");
						txtaddress.setText("");
						txtcontact.setText("");
						txtemail.setText("");
						
						txtname.requestFocus();

					 button_add.setEnabled(true);
					 }
					 else {
						 txtname.setText("");
							txtaddress.setText("");
							txtcontact.setText("");
							txtemail.setText("");

							
							txtname.requestFocus();
							 button_add.setEnabled(true);


						
					 }

					 
						
					 
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				else {
					 JOptionPane.showMessageDialog(null, "Please select row to delete");

				}
				
				
				
			}
		});
		button_delete.setFont(new Font("Constantia", Font.BOLD, 18));
		button_delete.setBounds(20, 437, 126, 48);
		frame.getContentPane().add(button_delete);
		
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
		button_cancel.setBounds(177, 439, 126, 45);
		frame.getContentPane().add(button_cancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(345, 95, 593, 424);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//to show selected row content------
				DefaultTableModel d1=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				int id=Integer.parseInt(d1.getValueAt(selectedIndex,0).toString());
				txtname.setText(d1.getValueAt(selectedIndex,1).toString());
				txtaddress.setText(d1.getValueAt(selectedIndex,2).toString());
				txtcontact.setText(d1.getValueAt(selectedIndex,3).toString());
				txtemail.setText(d1.getValueAt(selectedIndex,4).toString());
								button_add.setEnabled(false);
				
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JTableHeader tableHeader = table.getTableHeader();
		Font headerFont = new Font("Calibri", Font.BOLD, 15);
		tableHeader.setFont(headerFont);
		table.setFont(new Font("Monospaced", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Address", "Contact No"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(82);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(151);
		table.getColumnModel().getColumn(3).setPreferredWidth(134);
		table.setBounds(333, 23, 595, 537);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\bg9.png"));
		lblNewLabel_4.setBounds(0, 0, 982, 589);
		frame.getContentPane().add(lblNewLabel_4);
		
		
						
		
		
		
		
		
		
	}
}
