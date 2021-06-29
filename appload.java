import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.ImageIcon;

public class appload extends JFrame {
	
	private JPanel contentPane;
	JProgressBar pbar = new JProgressBar();
	JLabel txtpin = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		appload p= new appload();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
										p.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		homepage hp = new homepage();
	
		
			try {
				for(int i= 0; i<=100;i++)
				{
				Thread.sleep(100);
				p.pbar.setValue(i);
				p.txtpin.setText((i)+"%");
				if(i==100)
				{
					p.setVisible(false);
					p.dispose();
				}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hp.main(null);
			p.dispose();
		}
		
		
	

	/**
	 * Create the frame.
	 */
	public appload() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(10, 11, 707, 420);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Loading................................................");
		lblNewLabel.setForeground(new Color(0, 0, 204));
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 24));
		lblNewLabel.setBounds(252, 246, 215, 34);
		panel.add(lblNewLabel);
		pbar.setForeground(new Color(255, 204, 0));
		
		
		pbar.setBounds(74, 291, 587, 29);
		panel.add(pbar);
		
		
		txtpin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpin.setForeground(new Color(153, 0, 0));
		txtpin.setBounds(322, 329, 81, 29);
		panel.add(txtpin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Sarim\\eclipse-workspace\\Library-Management-Project\\images\\lmslogo.gif"));
		lblNewLabel_1.setBounds(242, 11, 221, 224);
		panel.add(lblNewLabel_1);
	}
}
