package dbs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class insveh extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insveh frame = new insveh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public insveh() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(233, 23, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 69, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(233, 118, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(233, 168, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(233, 219, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(233, 274, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(233, 321, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Class.forName("oracle.jdbc.driver.OracleDriver");

		            //step2 create  the connection object  
		            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle", "rajdadia", "rajroopa");


		            String query = "INSERT INTO vehicleinfo VALUES(?,?,?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					
					ps.setInt(1,Integer.parseInt(textField.getText()));
					ps.setString(2,textField_1.getText());
					ps.setString(3,textField_2.getText());
					ps.setInt(4,Integer.parseInt(textField_3.getText()));
					ps.setString(5,textField_4.getText());
					ps.setInt(6,Integer.parseInt(textField_5.getText()));
					ps.setInt(7,Integer.parseInt(textField_6.getText()));
					
					ps.execute();
					ps.close();
		            
		            JOptionPane.showMessageDialog(null, "Succesfully Inserted ", "Inserted", JOptionPane.INFORMATION_MESSAGE);
		            new empwork().setVisible(true);
		            dispose();

		        } catch (Exception f) {
		            System.out.println(f);
		        }
			}
		});
		btnNewButton.setBounds(71, 367, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Registration No.");
		lblNewLabel.setBounds(59, 26, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Model");
		lblNewLabel_1.setBounds(59, 72, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Brand");
		lblNewLabel_2.setBounds(59, 124, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Seater Info");
		lblNewLabel_3.setBounds(59, 171, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Type");
		lblNewLabel_4.setBounds(59, 225, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Deposit");
		lblNewLabel_5.setBounds(59, 277, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Rate per k.m.");
		lblNewLabel_6.setBounds(59, 324, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new empwork().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(269, 367, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
