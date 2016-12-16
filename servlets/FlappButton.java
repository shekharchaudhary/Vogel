package servlets;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FlappButton {
	static ImageIcon image;
	static ImageIcon image2;

	 public static void main(String[] args) {
	 // add frame and properties
	 FlappButton a = new FlappButton();
	 // a.AddBird();
	 FrameClass jframe = new FrameClass();
	 jframe.add(a.AddBird());
	 jframe.repaint();
	 jframe.setVisible(true);
	 }

	public JLabel AddBird() {

		JLabel label = new JLabel();
		image = new ImageIcon("bird1_sm.png");
		image2 = new ImageIcon("bird2_sm.png");
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				label.setIcon(image);
				try {
					Thread.sleep(80);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Clicked!");
				// image.getImage().flush();
			}
		});
		label.addMouseListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				label.setIcon(image2);
				//System.out.println("Released!");
			}
		});
		label.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				label.setIcon(image2);
				//System.out.println("Released!");
			}
		});

		return label;
	}
}
