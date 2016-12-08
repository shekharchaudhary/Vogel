


package game1;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class menu extends JFrame {

    // JPanel
    JPanel pnlButton = new JPanel();
    // Buttons
   
   
    public menu() {
        // FlightInfo setbounds
       
        JButton btnAdd = new JButton();
        File file = new File("play.png");
        Image image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JLabel label = new JLabel(new ImageIcon(image));
        btnAdd.setBounds(60, 400, 220, 30);
        pnlButton.add(label);
        // JPanel bounds
        pnlButton.setBounds(400, 400, 200, 100);

        // Adding to JFrame
        pnlButton.add(btnAdd);
        add(pnlButton);
        //adding label to frame
        JLabel jlabel = new JLabel( " high score");
        
        

        // JFrame properties
        setSize(800, 800);
        setBackground(Color.BLACK);
        setTitle("1st page of the game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    

    public static void main(String[] args) {
        new menu();
    }
}


  



   