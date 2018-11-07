package dbs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class startloc extends JFrame {
	
	double xcord,ycord,mcord,ncord,x,y;
	String s;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startloc frame = new startloc("");
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
	public startloc(String ola) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 634, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\BIN\\dbs\\src\\map\\india.jpg"));
		lblNewLabel.setBounds(10, 11, 328, 354);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelectTheStarting = new JLabel("Select the starting city  :");
		lblSelectTheStarting.setBounds(348, 81, 145, 14);
		contentPane.add(lblSelectTheStarting);
		
		JButton btnContinue = new JButton("Confirm");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xcord=x;
				ycord=y;
				
			}
		});
		btnContinue.setBounds(503, 77, 89, 23);
		contentPane.add(btnContinue);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mcord=x;
				ncord=y;
			}
		});
		btnNewButton.setBounds(503, 145, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblSelectTheDestinatoin = new JLabel("select the destinatoin city  :");
		lblSelectTheDestinatoin.setBounds(346, 149, 157, 14);
		contentPane.add(lblSelectTheDestinatoin);
		
		JButton btnContinue_1 = new JButton("Continue");
		btnContinue_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new bikeselection(xcord,ycord,mcord,ncord,ola).setVisible(true);
				contentPane.disable();
				dispose();
			}
		});
		btnContinue_1.setBounds(427, 252, 89, 23);
		contentPane.add(btnContinue_1);
		
		lblNewLabel.addMouseListener( new MouseListener() {
		    public void mouseClicked(MouseEvent e) {
		         x = e.getX();
		         y = e.getY();
		         
		         
                 if(((x>=55)&&(x<=61)&&((y>=205)&&(y<=213)))){
                     x=58;
                     y=209;
                     s="mumbai";
                 }else if(((x>=85)&&(x<=94))&&((y>=312)&&(y<=319))){
                     x=89;
                     y=316;
                     s="kochi";
                 }else if(((x>=223)&&(x<=233))&&((y>=163)&&(y<=174))){
                     x=228;
                     y=169;
                     s="kolkata";
                 }else if(((x>=113)&&(x<=126))&&((y>=222)&&(y<=237))){
                     x=119;
                     y=230;
                     s="hyderabad";
                 }else if(((x>=101)&&(x<=113))&&((y>=274)&&(y<=282))){
                     x=107;
                     y=280;
                     s="bangalore";
                 }else if(((x>=134)&&(x<=146))&&((y>=274)&&(y<=286))){
                     x=139;
                     y=280;
                     s="chennai";
                 }else if(((x>=102)&&(x<=115))&&((y>=93)&&(y<=105))){
                     x=107;
                     y=99;
                     s="delhi";
                 }else if(((x>=52)&&(x<=62))&&((y>=156)&&(y<=165))){
                     x=57;
                     y=161;
                     s="ahmadabad";
                 }else if(((x>=122)&&(x<=132))&&((y>=180)&&(y<=191))){
                     x=127;
                     y=186;
                     s="nagpur";
                 }else if(((x>=169)&&(x<=177))&&((y>=220)&&(y<=230))){
                     x=173;
                     y=225;
                     s="vishakhapatnam";
                 }
                 else
                	 s="none selected";
		         
		         JOptionPane.showMessageDialog(null, "Your selected city is "+s+"\nPlease press confirm to proceed", "Start", JOptionPane.INFORMATION_MESSAGE); 
		    }

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
	}
}
