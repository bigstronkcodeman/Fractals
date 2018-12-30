import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Robot;

class Controller implements ActionListener, MouseListener, KeyListener
{
	Model model;
	View view;
	boolean keyLeft, keyRight, keyUp, keyDown;

	Controller(Model m)
	{
		model = m;
	}

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = true; break;
			case KeyEvent.VK_LEFT: keyLeft = true; break;
			case KeyEvent.VK_UP: keyUp = true; break;
			case KeyEvent.VK_DOWN: keyDown = true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = false; break;
			case KeyEvent.VK_LEFT: keyLeft = false; break;
			case KeyEvent.VK_UP: keyUp = false; break;
			case KeyEvent.VK_DOWN: keyDown = false; break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
	}

	void update()
	{
		if (keyRight)
		{
			model.fractalTree.offsetAngle(-1);
		}
		else if (keyLeft)
		{
			model.fractalTree.offsetAngle(1);
		}
		
		if (keyUp)
		{
			//if (model.numGrows <= 3)
			{
				// model.turtle.strideLength /= 3;
				model.numGrows++;
			}
		}
		else if (keyDown)
		{
			// if (model.numGrows >= 1)
			{
				// model.turtle.strideLength *= 3;
				model.numGrows--;
			}
		}
	}

	public void mousePressed(MouseEvent e)
	{
	}

	public void mouseReleased(MouseEvent e) 
	{  

	}

	public void mouseEntered(MouseEvent e) {    }

	public void mouseExited(MouseEvent e) {    }

	public void mouseClicked(MouseEvent e) 
	{
	}

	void setView(View v)
	{
		view = v;
	}

	public void actionPerformed(ActionEvent e)
	{
	}
}
