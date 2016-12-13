package servlets;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlappButton {

	public static void main(String[] args) {

		// add frame and properties
		JFrame jframe = new JFrame();
		jframe.setBackground(null);

		jframe.setSize(800, 800);
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(jframe.DISPOSE_ON_CLOSE);

		// jframe.add(new JLabel(new ImageIcon("bird.")));
		// jframe.add(new JLabel(new ImageIcon("bird2.gif")));
		// jframe.addMouseListener((MouseListener) new Action());
		JLabel label = new JLabel("");

		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// jframe.add(new JLabel(new ImageIcon("b1_3.jpg")));
				// jframe.add(label);
				System.out.println("Clicked!");
			
			}
		});
		 label.addMouseListener(new MouseAdapter() {
		 public void mouseReleased(MouseEvent e) {
		 // TODO Auto-generated method stub
			// jframe.add(new JLabel(new ImageIcon("bird.png")));
		 System.out.println("Released!");
		
		 }
		 });
		 jframe.add(label);
		// jframe.add(new JLabel(new ImageIcon("bird.png")));
		
		jframe.setVisible(true);
	}

}
