import java.util.ArrayList;
import java.util.Stack;
import java.awt.Color;

class Memory
{
	Point location;
	double dirAngle;

	Memory(Point currLoc, double direction)
	{
		location = new Point(currLoc);
		dirAngle = direction;
	}
}

class Turtle
{
	//Rules: F -> move forward strideLength units
	//		 + -> rotate 60 deg
	//		 - -> rotate -60 deg
	double dirAngle, angleOffset, scaleFactor;
	double strideLength;
	Point location;
	Stack<Memory> memories;
	ArrayList<Line> path;
	Color penColor;

	Turtle()
	{
		scaleFactor = 1.36;
		angleOffset = 60;
		strideLength = 950;
		dirAngle = 0;
		location = new Point(700, 205);
		memories = new Stack<Memory>();
		path = new ArrayList<Line>();
		penColor = Color.white;
	}

	void instruct(String instructions)
	{
		for (int i = 0; i < instructions.length(); i++)
		{
			switch (instructions.charAt(i))
			{
				case 'F':
					double newX = location.x + Math.cos(dirAngle * (Math.PI / 180)) * strideLength;
					double newY = location.y + Math.sin(dirAngle * (Math.PI / 180)) * strideLength;
					path.add(new Line(new Point(location.x, location.y), new Point(newX, newY)));
					location.x = newX;
					location.y = newY;
					break;
				case '+':
					dirAngle += angleOffset;
					break;
				case '-':
					dirAngle -= angleOffset;
					break;
				case '[':
					memorize();
					break;
				case ']':
					recall();
					break;
				case '>':
					strideLength *= scaleFactor;
					break;
				case '<':
					strideLength /= scaleFactor;
					break;
			}
		}
	}

	void memorize()
	{
		memories.push(new Memory(location, dirAngle));
	}

	void recall()
	{
		Memory memory = memories.pop();
		this.location.x = memory.location.x;
		this.location.y = memory.location.y;
		this.dirAngle = memory.dirAngle;
	}

	void forget()
	{
		int size = path.size();
		for (int i = 0; i < size; i++)
		{
			path.remove(path.size() - 1);
		}
	}

	void reset()
	{
		location.x = 700;
		location.y = 975;
		dirAngle = 270;
		forget();
	}
}