import java.lang.Math;

class Point
{
	double x, y;

	Point(double inpX, double inpY)
	{
		x = inpX;
		y = inpY;
	}
	
	Point(Point copyPoint)
	{
		this.x = copyPoint.x;
		this.y = copyPoint.y;
	}
	
	void scale(double scalar)
	{
		x *= scalar;
		y *= scalar;
	}

	void shift(double offsetX, double offsetY)
	{
		x += offsetX;
		y += offsetY;
	}
}

class Line
{
	Point a, b;
	double length;

	Line(Point inpA, Point inpB)
	{
		a = inpA;
		b = inpB;
		length = Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
	}
	
	void shrink(double scalar)
	{
		a.scale(scalar);
		b.scale(scalar);
	}

	void shift(double offsetX, double offsetY)
	{
		a.shift(offsetX, offsetY);
		b.shift(offsetX, offsetY);
	}

	Line rotateAbout(Point origin, double degrees)
	{
		double radians = (Math.PI / 180) * degrees;
		double new_aX, new_aY, new_bX, new_bY;
		if (origin.equals(a))
		{
			new_bX = (b.x * Math.cos(radians)) + (b.y * (-Math.sin(radians)));
			new_bY = (b.x * Math.sin(radians)) + (b.y * Math.cos(radians));
			return new Line(this.a, new Point(new_bX, new_bY)); 
		}
		else
		{
			new_aX = (a.x * Math.cos(radians)) + (a.y * (-Math.sin(radians)));
			new_aY = (a.x * Math.sin(radians)) + (a.y * Math.cos(radians));
			return new Line(new Point(new_aX, new_aY), this.b);
		}
	}
}