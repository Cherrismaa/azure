package marks;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class result {

	private JFrame frame;
	private JTextField t1;
	private JLabel lblNewLabel_1;
	private JLabel lb1;
	private JLabel lb2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					result window = new result();
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
	public result() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1023, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Serial.No");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(95, 150, 111, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=t1.getText();
				int email=Integer.parseInt(s);
						try {
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/serial","root","mrec");
							String q="select name,marks from registration  where email=?";
						    PreparedStatement ps=con.prepareStatement(q);
						    ps.setInt(1, email);
						    ResultSet rs=ps.executeQuery();
						    rs.next();
						    lb1.setText("name:"+ rs.getString(1));
						    lb2.setText("marks:"+ rs.getInt(2));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(315, 246, 203, 57);
		frame.getContentPane().add(btnNewButton);
		
		t1 = new JTextField();
		t1.setBounds(315, 140, 157, 57);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Data Retrieval");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_1.setBounds(277, 30, 284, 57);
		frame.getContentPane().add(lblNewLabel_1);
		
		lb1 = new JLabel("Name");
		lb1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lb1.setBounds(95, 347, 336, 47);
		frame.getContentPane().add(lb1);
		
		lb2 = new JLabel("Marks");
		lb2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lb2.setBounds(95, 450, 466, 47);
		frame.getContentPane().add(lb2);
	}

}
