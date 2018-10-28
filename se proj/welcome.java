package dbs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class welcome extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome window = new welcome();
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
	public welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 422, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome ! \r\nPlease select one of the following");
		lblWelcome.setBounds(89, 11, 218, 59);
		frame.getContentPane().add(lblWelcome);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login fr=new login();
				fr.setVisible(true);
				frame.dispose();
			}
		}); 
		btnNewButton.setBounds(218, 130, 112, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGISTER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new newreg().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(218, 200, 112, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblIfYoureA = new JLabel("If you're a registered user  :");
		lblIfYoureA.setBounds(34, 134, 157, 14);
		frame.getContentPane().add(lblIfYoureA);
		
		JLabel lblIfNotPlease = new JLabel("If not, Please register  :");
		lblIfNotPlease.setBounds(34, 204, 139, 14);
		frame.getContentPane().add(lblIfNotPlease);
	}
}
