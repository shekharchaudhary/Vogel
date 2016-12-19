package servlets;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FrameClass extends JFrame {

	public FrameClass() {
		setTitle("VOGEL");
		setSize(800, 800);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

//	public static void main(String[] args) {
//		FrameClass f = new FrameClass();
//
//	}
}
