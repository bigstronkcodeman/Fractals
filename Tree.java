import java.util.ArrayList;
import java.lang.Math;
import java.util.Iterator;
import java.util.Random;

class Tree
{
	Line root;
	int numBranches, angle, angleOffset;
	double shrinkcrement;
	ArrayList<Line> tree;

	Tree()
	{
		shrinkcrement = 2.0/3.0;
		angleOffset = 0;
		angle = 20;
		root = new Line(new Point(960, 0), new Point(960, 300));
		tree = new ArrayList<Line>();
		tree.add(root);
		numBranches = 1;
	}

	void grow(int n)
	{
		growHelper(n, root);
		System.out.printf("number of branches: %d%n", numBranches);
	}

	void growHelper(int n, Line branch)
	{
		if (n > 0 && branch.length >= 1)
		{
			Random rand = new Random();
			Line newBranch1 = new Line(new Point(0, 0), new Point((branch.b.x - branch.a.x), (branch.b.y - branch.a.y)));
			newBranch1 = newBranch1.rotateAbout(newBranch1.a, angle + angleOffset);
			newBranch1.shrink(shrinkcrement /** (9.0 / 10.0)*/);
			newBranch1.shift(branch.b.x, branch.b.y);
			
			Line newBranch2 = new Line(new Point(0, 0), new Point((branch.b.x - branch.a.x), (branch.b.y - branch.a.y)));
			newBranch2 = newBranch2.rotateAbout(newBranch2.a, -0.5 * (angle + angleOffset));
			newBranch2.shrink(shrinkcrement/** (8.0 / 9.0)*/);
			newBranch2.shift(branch.b.x, branch.b.y);
			
			tree.add(newBranch1);
			tree.add(newBranch2);
			numBranches += 2;
			n--;
			
			growHelper(n, newBranch1);
			growHelper(n, newBranch2);
		}
	}
	
	void offsetAngle(int n)
	{
		angleOffset += n;
	}
	
	void die()
	{
		for (int i = tree.size(); i > 1; i--)
		{
			tree.remove(tree.size() - 1);
		}
		numBranches = 1;
	}
}