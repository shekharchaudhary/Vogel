package servlets;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InitialPage {

	//private static JFrame frame;
	private JTextField txtYourHighScore;
	static FrameClass frame;
	static highScore hiScore;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		InitialPage ip = new InitialPage();
		ip.initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new FrameClass();
		frame.getContentPane().setForeground(new Color(0, 0, 205));
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.BOLD, 50));
		frame.getContentPane().setBackground(Color.RED);
		//frame.setBackground(Color.RED);
		frame.getContentPane().setLayout(null);
		// LABLE
		JLabel lblNewLabel = new JLabel("VOGEL");
		lblNewLabel.setBounds(310, 148, 190, 55);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 54));
		frame.getContentPane().add(lblNewLabel);
		// BUTTON
		JButton btnNewButton = new JButton("START");
		btnNewButton.setBounds(345, 400, 117, 61);
		btnNewButton.setForeground(new Color(0, 0, 139));
		btnNewButton.setBackground(new Color(105, 105, 105));
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new Action());

		// TEXT FIELD
		 txtYourHighScore = new JTextField();
		String HIscore ="";
		try {
			HIscore = highScore.updateHiScore(0).toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtYourHighScore.setColumns(30);
		txtYourHighScore.setForeground(new Color(90, 80, 139));
		txtYourHighScore.setText("YOUR HIGH SCORE: "+HIscore);
		txtYourHighScore.setBounds(310, 677, 300, 45);
		txtYourHighScore.setVisible(true);
		frame.getContentPane().add(txtYourHighScore);
		
	}

	static class Action implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("hello");
			frame.setVisible(false);
			Activity a = new Activity();
			a.ConnectActivity();
		}

	}

}