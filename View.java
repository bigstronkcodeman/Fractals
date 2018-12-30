import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class View extends JPanel
{
	Controller controller;
	Model model;
	int num;

	View(Controller c, Model m)
	{
		controller = c;
		model = m;
		num = 0;
	}

	public void paintComponent(Graphics g)
	{
		Random rand = new Random();
		g.setColor(Color.black);
		g.fillRect(0, 0, 10000, 10000);
		g.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
		for (int i = 0; i < model.fractalTree.tree.size(); i++)
		{
			g.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
			Line currentBranch = model.fractalTree.tree.get(i);
			g.drawLine((int)currentBranch.a.x, (int)currentBranch.a.y, (int)currentBranch.b.x, (int)currentBranch.b.y);
		}
		// g.setColor(Color.white);
		// for (int i = 0; i < model.turtle.path.size(); i++)
		// {
		// 	g.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
		// 	Line currentLine = model.turtle.path.get(i);
		// 	g.drawLine((int)currentLine.a.x, (int)currentLine.a.y, (int)currentLine.b.x, (int)currentLine.b.y);
		// }
	}
}