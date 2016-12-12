package game1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class lastpage {

	public class Action {

	}

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lastpage window = new lastpage();
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
	public lastpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
			frame = new JFrame();
			frame.getContentPane().setBackground(Color.RED);
			frame.setBounds(100, 100, 800, 800);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			
			JTextField txtHighScore = new JTextField();
			txtHighScore.setText("HIGH SCORE");
			txtHighScore.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			txtHighScore.setBounds(293, 201, 234, 39);
			frame.getContentPane().add(txtHighScore);
			txtHighScore.setColumns(10);
			
			JTextField txtYourScore = new JTextField();
			txtYourScore.setFont(new Font("Lucida Grande", Font.BOLD, 13));
			txtYourScore.setText("YOUR SCORE");
			txtYourScore.setForeground(new Color(0, 0, 128));
			txtYourScore.setBounds(293, 275, 234, 39);
			frame.getContentPane().add(txtYourScore);
			txtYourScore.setColumns(10);
			
			JButton btnNewButton = new JButton("START");
			btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			btnNewButton.setBounds(354, 410, 117, 61);
			frame.getContentPane().add(btnNewButton);
			
			
			
			JButton btnNewButton_1 = new JButton("EXIT");
			btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			btnNewButton_1.setBounds(354, 563, 117, 61);
			frame.getContentPane().add(btnNewButton_1);
			frame.setResizable(false);
		}
	
	}


