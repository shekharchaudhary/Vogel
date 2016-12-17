package servlets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class rough extends FlappButton {
	static ImageIcon image;

	public static void main(String[] args) {
		// FlappButton a = new FlappButton();
		FrameClass frame = new FrameClass();
	//	FlappButton fb = new FlappButton();
		//JLabel jl = new JLabel();
		//jl = fb.AddBird();
		//jl.setBounds(293, 501, 234, 139);
		//frame.add(jl);
		JLabel jl2 = new JLabel("sdkjf");
		jl2.setBounds(100, 331, 234, 139);
		frame.add(jl2);
	//	frame.pack();
		// frame.getContentPane().add(jl2);
		// frame.add(jl2);
		// frame.repaint();
		frame.setVisible(true);
	}
}