import javax.swing.*;
import java.awt.*;

public	class render extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		main.x.render((Graphics2D)g);
	}
}