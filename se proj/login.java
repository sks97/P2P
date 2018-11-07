package dbs;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.*;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{  
					//step1 load the driver class  
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","rajdadia","rajroopa");  
					  
					//step3 create the statement object  
					Statement stmt=con.createStatement();  
					  
					//step4 execute query  
					ResultSet rs=stmt.executeQuery("select * from clientlogin");  
					boolean flag=false;
					while(rs.next())  
					{
						if(rs.getString(2).equals(textField.getText()) && rs.getString(3).equals(passwordField.getText()))
						{
							Statement stmt1=con.createStatement();
							ResultSet rs1=stmt1.executeQuery("select lname from clientdetails where uname= '"+rs.getString(2)+"'");
							rs1.next();
							
							JOptionPane.showMessageDialog(null, "Welcome Mr/Ms "+rs1.getString(1), "Succesful", JOptionPane.INFORMATION_MESSAGE); 
							
							Statement stmt2=con.createStatement();
							ResultSet rs2=stmt2.executeQuery("select clientid from clientdetails where uname= '"+rs.getString(2)+"'");
							rs2.next();
							
							new startloc(rs2.getString(1)).setVisible(true);
							dispose();
							
							flag=true;
							break;
						}
					}
					if(flag==false)
						JOptionPane.showMessageDialog(null, "Wrong Login/Password", "Sorry ", JOptionPane.INFORMATION_MESSAGE); 
					  
					//step5 close the connection object  
					con.close();  
					  
					}catch(Exception f){ System.out.println(f);}
			}
		});
		btnNewButton.setBounds(136, 152, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(234, 59, 121, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username  :");
		lblNewLabel.setBounds(58, 58, 115, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password  :");
		lblNewLabel_1.setBounds(58, 115, 115, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your details");
		lblPleaseEnterYour.setBounds(136, 11, 150, 14);
		contentPane.add(lblPleaseEnterYour);
		
		JLabel lblAdminemployeeLogin = new JLabel("Admin/Employee login  :");
		lblAdminemployeeLogin.setBounds(25, 223, 163, 14);
		contentPane.add(lblAdminemployeeLogin);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new adminlogin().setVisible(true);
				dispose();
			}
		});
		btnContinue.setBounds(241, 219, 89, 23);
		contentPane.add(btnContinue);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(234, 112, 121, 20);
		contentPane.add(passwordField);
	}
}
