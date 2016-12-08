package game1;

import java.awt.*;

import javax.swing.*;

public class page1 {
	private JFrame f;
	private JLabel p;
	private JButton b;
	
	
	public page1()
	{
		Action ();
	}

	private void Action() {
		f =  new JFrame ( " DYNAMIC Action");
		f.setVisible(true);
		f.setSize(800, 800);
		// for panel
		b = new JButton( "PLAY" );
		b.setSize( 40,40);
		b.addActionListener(null);
	

		
		
		
	
	}
	
	private void setLayout(BorderLayout borderLayout) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String []args){
		page1 a = new page1();
	}
}

