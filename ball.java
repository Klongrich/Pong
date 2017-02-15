import java.awt.*;
import java.util.*;

public class ball{

	static int count;
	private int x;
	private int y;
	private int yspeed = 10;
	private int xspeed = 10;
	private paddle p1;
	private paddle p2;

	ball(paddle p1, paddle p2, int x, int y)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.x = x;
		this.y = y;
	}

	public void		render(Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval(x, y, 35, 35);
	}

	private int		hit()
	{	
		int n;
		Random rand = new Random();
		
		 n = rand.nextInt(2) + 1;
		count++;
		if (n == 1)
		{
			return (-1);
		}
		if (n == 2)
		{
			return (1);
		}
		return (0);
	}

	private void	reset()
	{
		 if (x  < paddle.pwidth)
		 {
			p1.score++;
		 }
		 else 
		 {
			p2.score++;
		 }
		 x = (main.WIDTH / 2) - 17;
		 y = (main.LENGTH / 2) - 16;
	}

	public void		update()
	{
		if (y >= main.LENGTH - 60 || y <= 10)
		{
			yspeed *= -1;
		}
		if (x < paddle.pwidth || x > main.WIDTH - paddle.pwidth)
		{
			reset();
			xspeed *= hit();
		}
		if (x < 45 && y > p1.y && y < p1.y + paddle.plength)
		{
			xspeed *= -1;
			yspeed *= hit();
		}
		if (x > 530 && y > p2.y && y < p2.y + paddle.plength)
		{
			xspeed *= -1;
			yspeed *= hit();
		}
		x += xspeed;
		y += yspeed;
	}

}