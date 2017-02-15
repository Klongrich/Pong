import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main implements KeyListener, ActionListener
{
	static int WIDTH = 600;
	static int LENGTH = 600;
	static int gamestat = 0;
	static main x;
	render r;
	paddle p1;
	paddle p2;
	ball b;
	Timer time;

	main()
	{
		time = new Timer(50, this);
		r = new render();
		JFrame frame = new JFrame("Pong");

		frame.setVisible(true);
		frame.setSize(WIDTH, LENGTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.addKeyListener(this);
		frame.add(r);
	}

	public void	render(Graphics2D g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, LENGTH);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (gamestat == 0)
		{
			g.setColor(Color.white);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 70)); 
			g.drawString("PONG", 200, 100);
		}

		if (gamestat == 1)
		{
			g.setColor(Color.white);
			g.fillRect((WIDTH / 2) - 2, 0, 4, LENGTH);
			g.drawOval(176, 170, 250, 250);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
			g.drawString(String.valueOf(p1.score), 80, 60);
			g.drawString(String.valueOf(p2.score), 490, 60);

			p1.render(g);
			p2.render(g);
			b.render(g);
		}
	}

	public static void main(String [] args)
	{
		x = new main();
	}

	public void update()
	{
		p1.update();
		p2.update();
		b.update();
	}

	public void start()
	{
		p1 = new paddle(0, (LENGTH / 2) - (paddle.plength / 2), 0);
		p2 = new paddle(WIDTH - paddle.pwidth, (LENGTH / 2) - (paddle.plength / 2), 0);
		b = new ball(p1, p2, (WIDTH / 2) - 17, (LENGTH / 2) - 16);
	}

	public void actionPerformed(ActionEvent e)
	{
		update();
		r.repaint();
	}

	public void keyPressed(KeyEvent e)
	{
		int id = e.getKeyCode();
		if (id == KeyEvent.VK_UP)
		{
			p1.move(true);
		}
		else if (id == KeyEvent.VK_DOWN)
		{
			p1.move(false);
		}
		if (id == KeyEvent.VK_8)
		{
			p2.move(true);
		}
		else if (id == KeyEvent.VK_5)
		{
			p2.move(false);
		}

		if (id == KeyEvent.VK_SPACE)
		{
			if (gamestat == 0)
			{
				start();
				time.start();
				gamestat = 1;
			}
			else if (gamestat == 1)
			{
				time.stop();
				gamestat = 0;
			}
		}
	}

	public void keyReleased(KeyEvent e)
	{

	}

	public void keyTyped(KeyEvent e)
	{

	}
}