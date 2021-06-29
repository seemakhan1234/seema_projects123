import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class category {

	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("Category");
	private JTextField textField;
	static private JTable table;
	private  JComboBox comboBox;
	//private JButton btnNewButton;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					category window = new category();
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
	public category() {
		initialize();
		connect();
		load();
	}
	Connection con;
	PreparedStatement pst;
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
	
	public void load() {
		try {
			
			 Statement stmt=con.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from category");
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 
			//con.close();
			
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
		frame.setBounds(100, 100, 1038, 672);
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
		lblNewLabel.setFont(new Font("Elephant", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 78, 126, 36);
		frame.getContentPane().add(lblNewLabel);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBackground(new Color(255, 255, 204));
		menuBar.setBounds(0, 0, 1024, 27);
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
		cselection.setModel(new DefaultComboBoxModel(new String[] {"id", "catname"}));
		cselection.setBounds(516, 81, 115, 36);
		frame.getContentPane().add(cselection);
		
		
		txtselection = new JTextField();
		txtselection.setForeground(new Color(153, 0, 0));
		txtselection.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				try {
					String selection=(String)cselection.getSelectedItem();
					String query="select * from category where "+selection+" like ? ";
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
				load() ;
				
			}
		});
		txttable.setBounds(587, 549, 126, 36);
		frame.getContentPane().add(txttable);
		

		

		
		JLabel lblNewLabel_1 = new JLabel("Category Name");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 174, 145, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Status");
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 234, 104, 24);
		frame.getContentPane().add(lblNewLabel_2);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"active", "deactive"}));
		comboBox.setBounds(165, 237, 131, 22);
		frame.getContentPane().add(comboBox);
		textField = new JTextField();
		textField.setBounds(165, 176, 131, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\Add-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to insert record---
				String category=textField.getText();
				String status=comboBox.getSelectedItem().toString();
				if(category.equals("")||status.compareToIgnoreCase("")==1){
					JOptionPane.showMessageDialog(btnNewButton, "SOME FIELDS ARE EMPTY","error",1);
					textField.setText("");
					comboBox.setSelectedIndex(-1);
					
				}
				else if(!Pattern.matches("[a-zA-Z][a-zA-Z]*", textField.getText()))
				{
			       JOptionPane.showMessageDialog(null, "invalid name");
			    
			       textField.setText("");
					
				}
				else {
				try {
					pst=con.prepareStatement("insert into category(catname,status) values(?,?)");
					pst.setString(1, category);
					pst.setString(2, status);
					int k=pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(btnNewButton, "Record Added");
						textField.setText("");
						comboBox.setSelectedIndex(-1);
						textField.requestFocus();
						load();
						
					}
					else {
						JOptionPane.showMessageDialog(btnNewButton, "Error..");

					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
//					try {
//						JOptionPane.showMessageDialog(frame, "gonna close connection");
//						con.close();
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
				}
				
			}
		}
		});
		btnNewButton.setFont(new Font("Constantia", Font.BOLD, 18));
		btnNewButton.setBounds(21, 316, 134, 49);
		frame.getContentPane().add(btnNewButton);

		


				
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//to show selected row content------
				DefaultTableModel d1=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				int id=Integer.parseInt(d1.getValueAt(selectedIndex,0).toString());
				textField.setText(d1.getValueAt(selectedIndex,1).toString());
				comboBox.setSelectedItem(d1.getValueAt(selectedIndex,1).toString());
				btnNewButton.setEnabled(false);
				
				
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JTableHeader tableHeader = table.getTableHeader();
		Font headerFont = new Font("Calibri", Font.BOLD, 15);
		tableHeader.setFont(headerFont);
		table.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, ""},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Category Name", "Status"
			}
		) 
		);
		table.getColumnModel().getColumn(0).setPreferredWidth(94);
		table.getColumnModel().getColumn(1).setPreferredWidth(255);
		table.getColumnModel().getColumn(2).setPreferredWidth(172);
		table.setBounds(335, 52, 663, 549);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(306, 133, 652, 405);
		frame.getContentPane().add(scrollPane);

		scrollPane.setViewportView(table);

		
	
		
		
				
				
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\Button-Delete-icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to delete selected row record----
				if(table.getSelectedRowCount()==1) {
				try {
					int result =JOptionPane.showConfirmDialog(frame, "Do you really want to delete the record?","Record Delete",JOptionPane.YES_NO_OPTION);
					 if(result == JOptionPane.YES_OPTION) {
					
					int row=table.getSelectedRow();
					String value=table.getModel().getValueAt(row,0).toString();
					String query="delete from category where id="+value;
					 PreparedStatement stmt=con.prepareStatement(query);
					 stmt.executeUpdate();
					 DefaultTableModel tbmodel=(DefaultTableModel)table.getModel();
					 tbmodel.setRowCount(0);
					 load();
					 JOptionPane.showMessageDialog(btnNewButton_1, "Record deleted");
					 btnNewButton.setEnabled(true);
					 
					 }
					 else {
						 btnNewButton.setEnabled(true);
						 textField.setText("");
							comboBox.setSelectedIndex(-1);
							textField.requestFocus();
					 }
					 		
					 
				 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				else {
					 JOptionPane.showMessageDialog(btnNewButton_1, "Please select row to delete");

				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Constantia", Font.BOLD, 18));
		btnNewButton_1.setBounds(21, 376, 134, 49);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\updateicon.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to update selected row record---
				if(table.getSelectedRowCount()==1) //to check whether row is selected or not--------
				{

				DefaultTableModel d1=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				int id=Integer.parseInt(d1.getValueAt(selectedIndex,0).toString());

				String category=textField.getText();
				String status=comboBox.getSelectedItem().toString();
				if(category.equals("")||status.compareToIgnoreCase("")==1){
					JOptionPane.showMessageDialog(btnNewButton, "SOME FIELDS ARE EMPTY","error",1);
					textField.setText("");
					comboBox.setSelectedIndex(-1);
					
				}
				else if(!Pattern.matches("[a-zA-Z][a-zA-Z]*", textField.getText()))
				{
			       JOptionPane.showMessageDialog(null, "invalid name");
			    
			       textField.setText("");
					
				}


				else {
					try {
				
					pst=con.prepareStatement("update category set catname = ?,status = ? where id= ?");
					pst.setString(1, category);
					pst.setString(2, status);
					pst.setInt(3, id);
					int k=pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(btnNewButton, "Record Updated");
						textField.setText("");
						comboBox.setSelectedIndex(-1);
						textField.requestFocus();
						load();
						btnNewButton.setEnabled(true);
						
					}
					else {
						JOptionPane.showMessageDialog(btnNewButton, "Error..");

					}
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					} }
					else {
						 JOptionPane.showMessageDialog(btnNewButton_1, "Please select row to update");

					}


			
			}});
		btnNewButton_2.setFont(new Font("Constantia", Font.BOLD, 18));
		btnNewButton_2.setBounds(160, 316, 136, 49);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cancel");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\Close-2-icon.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int result =JOptionPane.showConfirmDialog(frame, "Do you want to close connection?","connection close",JOptionPane.YES_NO_OPTION);
					 if(result == JOptionPane.YES_OPTION) {
		        	con.close();
		        	addbooks object= new addbooks();
					object.main(null);
					
					frame.setVisible(false);
               }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Constantia", Font.BOLD, 18));
		btnNewButton_3.setBounds(163, 376, 133, 49);
		frame.getContentPane().add(btnNewButton_3);
		
				
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\bg8.PNG"));
		lblNewLabel_3.setBounds(0, 0, 1024, 635);
		frame.getContentPane().add(lblNewLabel_3);
		
	}
}
