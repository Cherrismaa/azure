package marks;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class registrationS_no {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrationS_no window = new registrationS_no();
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
	public registrationS_no() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1028, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Serial.No");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(75, 178, 130, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblEmail.setBounds(75, 331, 130, 35);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMarks.setBounds(75, 410, 130, 35);
		frame.getContentPane().add(lblMarks);
		
		JLabel lblNmae = new JLabel("Name\r\n");
		lblNmae.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNmae.setBounds(75, 255, 130, 35);
		frame.getContentPane().add(lblNmae);
		
		t1 = new JTextField();
		t1.setBounds(297, 178, 149, 35);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(297, 255, 149, 35);
		frame.getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(297, 331, 149, 35);
		frame.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(297, 415, 149, 35);
		frame.getContentPane().add(t4);
		
		JLabel lblNewLabel_1 = new JLabel("Registration");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_1.setBounds(319, 32, 316, 66);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SUBMIT!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serial=t1.getText();
				int s=Integer.parseInt(serial);
				String name=t2.getText();
				String email=t3.getText();
				String marks=t4.getText();	
				float f=Float.parseFloat(marks);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/serial","root","mrec");
					String q="Insert into registration values('"+name+"','"+email+"','"+serial+"','"+marks+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "Done");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(504, 460, 224, 53);
		frame.getContentPane().add(btnNewButton);
	}
}
