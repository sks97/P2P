package dbs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tripconf extends JFrame {
	int a,b,c,d,dist;
	String reg;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tripconf frame = new tripconf(0,0,0,0,"","","","");
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
	public tripconf(double x,double y,double m,double n,String dep,String rate,String ola,String cyname) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 511, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("client details  :");
		lblNewLabel.setBounds(27, 29, 74, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("pick-up  :");
		lblNewLabel_1.setBounds(27, 73, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("destination  :");
		lblNewLabel_2.setBounds(27, 123, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("bike model  :");
		lblNewLabel_3.setBounds(27, 171, 74, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm  ?  ");
		lblNewLabel_4.setBounds(69, 333, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("total cost  :");
		lblNewLabel_5.setBounds(27, 225, 74, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(192, 33, 150, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(192, 73, 150, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(192, 123, 150, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(192, 171, 150, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(192, 225, 150, 14);
		contentPane.add(lblNewLabel_10);
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int cnt=0;
					//step1 load the driver class  
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","rajdadia","rajroopa");  
					  
//					//step3 create the statement object  
//					Statement stmt=con.createStatement();  
//					  
//					//step4 execute query  
//					ResultSet rs=stmt.executeQuery("select * from route");
//					while(rs.next())
//					{
//						cnt++;
//					}
//					cnt=cnt+1;
					Random random = new Random();
					cnt=random.nextInt(1000)+5;

					
					//step3 create the statement object  
					Statement stmt1=con.createStatement();  
					String query = "INSERT INTO route VALUES(?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1,cnt);
					ps.setString(2,lblNewLabel_7.getText());
					ps.setString(3,lblNewLabel_8.getText());
					ps.setInt(4,Integer.parseInt(ola));
					ps.setInt(5,Integer.parseInt(reg));
					ps.execute();
					ps.close();
					
				
					new bbhmm(ola).setVisible(true);
					dispose();
					
				}catch(Exception f){ System.out.println(f);}
				
				}
		});
		btnNewButton.setBounds(161, 329, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new startloc(ola).setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(371, 329, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblDistance = new JLabel("Distance  :");
		lblDistance.setBounds(27, 275, 61, 14);
		contentPane.add(lblDistance);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(192, 275, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		dist=(int) Math.sqrt((Math.pow(x-m, 2)+Math.pow(y-n, 2)));
		
		String city1;
		try
		{
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","rajdadia","rajroopa");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			  
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("select cname from city where x="+x+" and y="+y); 
			
			while(rs.next())
			{
				//System.out.println(rs.getString(1));
				lblNewLabel_7.setText(rs.getString(1));
			}
			
			//step3 create the statement object  
			Statement stmt1=con.createStatement(); 
			  
			//step4 execute query  
			ResultSet rs1=stmt1.executeQuery("select cname from city where x="+m+" and y="+n); 
			
			while(rs1.next())
			{
				lblNewLabel_8.setText(rs1.getString(1));
			}
			
			//step3 create the statement object  
			Statement stmt2=con.createStatement();  
			  
			//step4 execute query  
			ResultSet rs2=stmt2.executeQuery("select fname,lname from clientdetails where clientid="+ola); 
			
			while(rs2.next())
			{
				lblNewLabel_6.setText("Mr/Ms. "+rs2.getString(1)+" "+rs2.getString(2));
			}
			
			//step3 create the statement object  
			Statement stmt3=con.createStatement();  
			 
			//step4 execute query  
			ResultSet rs3=stmt3.executeQuery("select model,brand,regno from vehicleinfo where model='"+cyname+"'"); 
			
			while(rs3.next())
			{
				lblNewLabel_9.setText(rs3.getString(1)+" of "+rs3.getString(2));
				reg=rs3.getString(3);
			}
			
			//step3 create the statement object  
			Statement stmt4=con.createStatement();  
			  
			//step4 execute query  
			ResultSet rs4=stmt4.executeQuery("select fname,lname from clientdetails where clientid="+ola); 
			
			while(rs4.next())
			{
				lblNewLabel_10.setText(""+(dist*Integer.parseInt(rate)+Integer.parseInt(dep)));
			}
			lblNewLabel_11.setText(String.valueOf(dist));
			
		}catch(Exception f){ System.out.println(f);}
	}
}
