package dbs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

public class bikeselection extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox_1;
	String re,te;
	String cyname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bikeselection frame = new bikeselection(0,0,0,0,"");
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
	public bikeselection(double x,double y,double m,double n,String ola) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 569, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Deposit according to the type is  :");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel.setBounds(44, 272, 288, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rate of the selected bike is  :");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(43, 332, 218, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(313, 272, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(313, 332, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		try {
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","rajdadia","rajroopa");  
		  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
		  
		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select distinct(type) from vehicleinfo");
		
		
		int i=0;
		String[] mstr=new String[3];
		while(rs.next())
		{
			mstr[i]=rs.getString(1);
			i++;
		}
		
		comboBox_1 = new JComboBox();
		
		JComboBox comboBox = new JComboBox(mstr);
		comboBox.addActionListener(new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        try {
		        	comboBox_1.removeAllItems();
		        //step3 create the statement object  
				Statement stmt1=con.createStatement();  
				//step4 execute query  
				ResultSet rs1=stmt1.executeQuery("select brand,model from vehicleinfo where type='"+comboBox.getSelectedItem().toString()+"'");
				
		        String[] msgs=new String[3];
		        int j=0;
		        while(rs1.next())
		        {
		        	msgs[j]=rs1.getString(1)+"--"+rs1.getString(2);
		        	comboBox_1.addItem(msgs[j]);
		        	j++;
		        }
		        
		        comboBox_1.addActionListener(new ActionListener () {
				    public void actionPerformed(ActionEvent e) {
				        try 
				        {
				        	
				        	cyname= comboBox_1.getSelectedItem().toString().substring(comboBox_1.getSelectedItem().toString().lastIndexOf("-") + 1);
				        	//step3 create the statement object  
							Statement stmt2=con.createStatement();  
							//step4 execute query  
							ResultSet rs2=stmt2.executeQuery("select rate,deposit from vehicleinfo where model='"+cyname+"'");
							while(rs2.next())
							{
								lblNewLabel_2.setText(rs2.getString(2));
								lblNewLabel_3.setText(rs2.getString(1));
								re=rs2.getString(2); te=rs2.getString(1);
							}
				        }
				        catch(Exception f){ System.out.println(f);}
				    }
		        });
		        comboBox_1.setBounds(281, 112, 186, 20);
				contentPane.add(comboBox_1);
				
		        }
		        catch(Exception f){ System.out.println(f);}
		    }
		});
		comboBox.setBounds(43, 112, 180, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Proceed");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new tripconf(x,y,m,n,re,te,ola,cyname).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(223, 378, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblPleaseSelectThe = new JLabel("Please select the bike.");
		lblPleaseSelectThe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseSelectThe.setBounds(142, 34, 217, 32);
		contentPane.add(lblPleaseSelectThe);
			
		}catch(Exception f){ System.out.println(f);}
	}
}
