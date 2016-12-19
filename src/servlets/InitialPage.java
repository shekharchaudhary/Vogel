package servlets;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InitialPage {

	private static JFrame frame;
	private JTextField txtYourHighScore;
	static highScore hiScore;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialPage window = new InitialPage();
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
	public InitialPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 205));
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.BOLD, 50));
		frame.getContentPane().setBackground(Color.RED);
		frame.setBackground(Color.RED);
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
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
		// TEXT FIELD
		 txtYourHighScore = new JTextField();
		String HIscore ="";
		try {
			HIscore = highScore.updateHiScore(0).toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtYourHighScore = new JTextField();
		txtYourHighScore.setForeground(new Color(0, 0, 139));
		txtYourHighScore.setText("YOUR HIGH SCORE" + HIscore);
		txtYourHighScore.setBounds(310, 677, 235, 45);
		frame.getContentPane().add(txtYourHighScore);
		txtYourHighScore.setColumns(10);
	}

	static class Action implements ActionListener {
		public void actionPerformed1(ActionEvent e) {
			// put your out put.

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// System.out.println("hello");
			System.out.println("hello");
			frame.setVisible(false);
			Activity a = new Activity();
			a.ConnectActivity();
		}

	}

}
