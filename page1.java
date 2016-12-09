
package game1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import servlets.activity1;


public class frame {
	
	

	

	public static void main(String[] args) {
		
		//add frame and properties
		JFrame jframe = new JFrame();
		jframe.setBackground(null);
		jframe.setVisible(true);
		jframe.setSize(800,800);
		jframe.setDefaultCloseOperation(jframe.DISPOSE_ON_CLOSE);
		
		//add jpanel 
		JPanel jpanel = new JPanel( );
		
		
		jpanel.setSize(800, 800);
		jpanel.setVisible(true);
		jpanel.setLayout(null);
		//Color color = RED;
		//jpanel.setBackground(color);
		jframe.add(jpanel);
		
		
		//I WILL WORK HERE
		//VOGEL LOGO 
		Image image = null;
		File image2 = new File("VOGEL.jpg");
		try {
			image = ImageIO.read(image2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 JLabel label = new JLabel(new ImageIcon(image));
		 label.setBounds(100,100, 120, 100);
		jpanel.add(label);
		
	
		
		
	 // JButton
		JButton jbutton = new JButton("play");
		jpanel.add( jbutton);
		jbutton.setToolTipText("click here and start game");
		jbutton.setBounds(300,400, 120, 50);
		
		jbutton.addActionListener(new Action());
		
		//addtext field
		
		JTextField tf = new JTextField(" here is your hight score");
		jpanel.add(tf);
		tf.setBounds(200, 650, 300, 50);
		
		
		
	
		
		
	}
	
	
	static class Action implements ActionListener {
		public void actionPerformed1(ActionEvent e){
			//put your out put.
			
			System.out.println("hello");
		
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("hello");
			Activity n = new  Activity();
		}

		
	}
		
	
	
		
}
		
	
	



