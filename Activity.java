package servlets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Activity implements ActionListener, MouseListener, KeyListener {
	public static Activity activity;

	public final int WIDTH = 800, HEIGHT = 800;
	public Render render;
	public Rectangle bird;

	public Random random;
	public int ticks, yMotion, score, highScore;
	public boolean gameOver, started;
	// public ImageGraphicAttribute bird2;

	public Activity() {
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);
		render = new Render();
		random = new Random();

		jframe.setTitle("VOGEL");
		jframe.add(render);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.setVisible(true);
		// intial position and size of object
		bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		// bird2 = new ImageGraphicAttribute(image, 2, 25 , 25);
		timer.start();

	}

	public void Plane(Graphics g, Rectangle column) {
		g.setColor(Color.black);
		g.fillRect(column.x, column.y, column.width, column.height);

	}

	public void Fly() {
		if (gameOver) {
			bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
			yMotion = 0;
			score = 0;;

			gameOver = false;
		}
		if (!started) {
			started = true;
		} else if (!gameOver) {
			if (yMotion > 0) {
				yMotion = 0;
			}
			yMotion -= 7;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int speed = 6;
		ticks++;
		if (started) {
			if (ticks % 2 == 0 && yMotion < 15) {
				yMotion += 2;
			}
		}

		bird.y += yMotion;

		
		// condition for game over
		if (bird.y > HEIGHT - 120) {
			gameOver = true;
		}
		if (bird.y < 120) {
			gameOver = true;
		}
		// if (bird.y + yMotion >= HEIGHT - 120) {
		// //bird.y = HEIGHT - 120 - bird.height;
		// gameOver = true;
		// }

		render.repaint();
	}

	public void Repaint(Graphics g) {
		g.setColor(new Color(6, 220, 250)); // background color
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(new Color(87, 247, 242)); // sky color
		g.fillRect(0, 0, WIDTH, 140);
		g.setColor(new Color(3, 20, 141)); // water color
		g.fillRect(0, HEIGHT - 120, WIDTH, 120);
		g.setColor(new Color(5, 23, 75)); // wave color
		g.fillRect(0, HEIGHT - 120, WIDTH, 20);
		g.setColor(Color.red); // bird color
		g.fillRect(bird.x, bird.y, bird.width, bird.height);
		g.setColor(Color.white); // text color
		g.setFont(new Font("Arial", 1, 100)); // text property for first page

		if (!started) {
			g.drawString("Tap to Start", 75, HEIGHT / 2 - 50);
		}
		if (gameOver) {
			g.drawString("Game Over", WIDTH / 2 - 200, HEIGHT / 2 - 100);
			g.setFont(new Font("Arial", 1, 50));
			g.drawString("High Score: " + String.valueOf(highScore), WIDTH / 2 - 150, HEIGHT / 2 + 100); // high
																											// score
			g.drawString("Score:  " + String.valueOf(score), WIDTH / 2 - 155, HEIGHT / 2 + 200); // your
																									// score
		}
		if (!gameOver && started) {
			g.setFont(new Font("Arial", 1, 25)); // text property
			g.drawString("High Score: " + String.valueOf(highScore), 25, 100); // high
																				// score
			g.drawString("Score:  " + String.valueOf(score), WIDTH - 150, 100); // your
																				// score
		}
	}

	public class Render extends JPanel {
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Activity.activity.Repaint(g);

		}

	}

	public static void main(String arg[]) {
		activity = new Activity();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Fly();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Fly();
		}

	}

}
