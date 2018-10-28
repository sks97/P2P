package dbs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class remveh extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					remveh frame = new remveh();
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
	public remveh() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		try 
        {
        	//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","rajdadia","rajroopa");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			  
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("select model from vehicleinfo");     
			
        	while(rs.next())
        	{
        		comboBox.addItem(rs.getString(1).toString());
        	}
			
        } catch(Exception f){ System.out.println(f);}
		
		
		
		comboBox.addActionListener(new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	s=comboBox.getSelectedItem().toString();
		        
		    }
        });
		comboBox.setBounds(127, 66, 140, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try 
			        {
					//step1 load the driver class  
						Class.forName("oracle.jdbc.driver.OracleDriver");  
						  
						//step2 create  the connection object  
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","rajdadia","rajroopa");  
						  
						//step3 create the statement object  
						Statement stmt1=con.createStatement();  
						  
						//step4 execute query  
						ResultSet rs1=stmt1.executeQuery("delete from vehicleinfo where model='"+s+"'");  
						JOptionPane.showMessageDialog(null, "Succesfully Deleted", "Succesful", JOptionPane.INFORMATION_MESSAGE);
						
						new empwork().setVisible(true);
			        	dispose();
						
			        }
			        catch(Exception f){ System.out.println(f);}
			}
		});
		btnNewButton.setBounds(91, 180, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new empwork().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(238, 180, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
