
package servlets;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InitialPage {

	private JLabel lable;
	static FrameClass frame;
	static highScore hiScore;
	static int Height;
	static int Width;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
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
		frame = new FrameClass();
		Height = frame.getHeight();
		Width = frame.getWidth();
		frame.getContentPane().setBackground(Color.RED);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("VOGEL");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, Height / 6));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(Width / 3, Height / 6, Width / 3, Height / 6);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("FLY");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new Action());
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, Height / 20));
		btnNewButton.setBounds(Width / 2 - (Width / 26), Height / 2, Width / 13, Height / 10);
		frame.getContentPane().add(btnNewButton);
		// High Score
		String HIscore = "";
		try {
			HIscore = highScore.updateHiScore(0).toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lable = new JLabel();
		lable.setFont(new Font("Comic Sans MS", Font.BOLD, Height / 18));
		lable.setText(" High Score : " + HIscore);
		lable.setForeground(Color.YELLOW);
		lable.setBounds(Width / 2 - (Width / 7), Height / 2+(Height / 14), Width / 2, Height / 2);
		frame.getContentPane().add(lable);
		
	}

	static class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// System.out.println("hello");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.setVisible(false);
			Activity a = new Activity();
			a.ConnectActivity();
		}

	}
}
