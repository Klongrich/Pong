import java.awt.*;
import javax.swing.*;

public class paddle
{
	static int pwidth = 30;
	static int plength = 150;
	int x;
	int y;
	int score;

	paddle(int x, int y, int score)
	{
		this.x = x;
		this.y = y;
		this.score = score;
	}

	public void		render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(x, y, pwidth, plength);
	}

	public void		update()
	{
		if (y >= main.LENGTH - plength - 20)
		{
			y = main.LENGTH - plength - 20;
		}
		else if (this.y <= 0)
		{
			this.y = 0;
		}	
	}

	public void		move(boolean x)
	{
		int speed = 8;
		if (x)
			y -= speed;
		else
			y += speed;
	}	
}