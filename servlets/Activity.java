package servlets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Activity implements ActionListener, MouseListener, KeyListener {
	public static Activity activity;
	static highScore HIscore;
	public ArrayList<Rectangle> jet;
	public final int WIDTH = 800, HEIGHT = 800;
	public Render render;
	public Rectangle bird;
	public Random random;
	public int ticks, yMotion, score;
	public boolean gameOver, started;
	FrameClass jframe;
	static int highScore1 =0;

	public void ActivityMethod() {
		jframe = new FrameClass();
		Timer timer = new Timer(20, this);
		bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		render = new Render();
		random = new Random();
		jframe.add(render);
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
		jframe.setVisible(true);
		jet = new ArrayList<Rectangle>();
		jframe.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F2) {
					// close frame one.
				}
			}
		});
		addjet(true);
		addjet(true);
		addjet(true);
		addjet(true);
		timer.start();

	}

	public void addjet(boolean start) {
		int space = 300;
		int width = 30;
		int height = 20; // random.nextInt(300);

		if (start) {
			// position of jets
			jet.add(new Rectangle(WIDTH + random.nextInt(100) + width + jet.size() * 300, 200 + random.nextInt(300),
					width, height));
			jet.add(new Rectangle(WIDTH + width + (jet.size() - 1) * 300, 200 + random.nextInt(500), width, height));
		} else {
			jet.add(new Rectangle(jet.get(jet.size() - 1).x + 600, HEIGHT - height - 120, width, height));
			jet.add(new Rectangle(jet.get(jet.size() - 1).x, 0, width, HEIGHT - height - space));

		}
	}

	public void Jet(Graphics g, Rectangle column) {
		g.setColor(Color.black);
		g.fillRect(column.x, column.y, column.width, column.height);

	}

	public void Fly() {
		if (gameOver) {
			bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
			yMotion = 0;
			score = 0;
			addjet(true);
			addjet(true);
			gameOver = false;
		}
		if (!started) {
			started = true;

		} else if (!gameOver) {
			score = 1 + score;
			if (yMotion > 0) {
				yMotion = 0;
			}
			yMotion -= 7;
		}
		if (highScore1 < score) {
			highScore1 = score;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int speed = 5;
		ticks++;
		String hs ="";
		try {
			hs = highScore.updateHiScore(score).toString();
			highScore1 = Integer.valueOf(hs);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (started) {

			for (int i = 0; i < jet.size(); i++) {
				Rectangle column = jet.get(i);
				column.x -= speed;
			}
			if (ticks % 2 == 0 && yMotion < 15) {
				yMotion += 2;
			}
		}

		bird.y += yMotion;

		// condition for game over
		if (bird.y > HEIGHT - 120 || bird.y < 120) {
			gameOver = true;
		}
		for (Rectangle column : jet) {
			if (bird.intersects(column)) {
				gameOver = true;
			}
		}

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
		for (Rectangle column : jet) {
			Jet(g, column);
		}
		g.setColor(Color.white); // text color
		g.setFont(new Font("Arial", 1, 100)); // text property for first page

		// Image image = null;
		// File image2 = new File("vogel.jpg");
		// try {
		// image = ImageIO.read(image2);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		if (!started) {
			g.drawString("Tap to Start", 75, HEIGHT / 2 - 50);
		}
		if (gameOver) {
			// jframe.setVisible(false);
			// CloseFrame();

			g.drawString("Game Over", WIDTH / 2 - 200, HEIGHT / 2 - 100);
			g.setFont(new Font("Arial", 1, 50));
			g.drawString("High Score: " + String.valueOf(highScore1), WIDTH / 2 - 150, HEIGHT / 2 + 100); // high
																											// score
			g.drawString("Score:  " + String.valueOf(score), WIDTH / 2 - 155, HEIGHT / 2 + 200); // your

		}
		if (!gameOver && started) {
			addjet(true);
			g.setFont(new Font("Arial", 1, 25)); // text property
			g.drawString("High Score: " + String.valueOf(highScore1), 25, 100); // high
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
			if (gameOver) {
				jframe.setVisible(false);
				LastPage lp = new LastPage();
				lp.ConnectLastpage();
			}
		}

	}

	public static void main(String arg[]) {
		activity = new Activity();
		activity.ConnectActivity();

	}

	public void ConnectActivity() {
		activity = new Activity();
		activity.ActivityMethod();
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

	public FrameClass getJframe() {
		return jframe;
	}

	public void setJframe(FrameClass jframe) {
		this.jframe = jframe;
	}

}
