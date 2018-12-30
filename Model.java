
class Model
{
	Tree fractalTree;
	LTree ltree;
	Turtle turtle;
	int numGrows;

	Model() 
	{
		numGrows = 0;
		fractalTree = new Tree();
		ltree = new LTree();
		turtle = new Turtle();
	}

	void update() 
	{
		fractalTree.die();
		fractalTree.grow(numGrows);
		// turtle.reset();
		// ltree.generateString(numGrows);
		// turtle.instruct(ltree.string);
		System.out.println("string length: " + ltree.string.length());
	}

	void setDestination(int x, int y) 
	{
	}

	void setInitClickLocation(int x, int y) 
	{
	}
}