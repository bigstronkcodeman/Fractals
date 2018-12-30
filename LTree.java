import java.util.ArrayList;

class LTree
{
	//Rules: F -> F+F-F-FF+F+F-F
	String axiom, string;
	int generations;
	ArrayList<Line> tree;

	LTree()
	{
		axiom = "F++F++F";
		string = "";
		generations = 0;
	}

	void generateString(int numIterations)
	{
		stringHelper(numIterations, axiom, 0);
	}

	void stringHelper(int numIterations, String currentGeneration, int generation)
	{
		if (generation < numIterations)
		{
			String nextGeneration = "";
			for (int i = 0; i < currentGeneration.length(); i++)
			{
				switch (currentGeneration.charAt(i))
				{
					case 'F':
						nextGeneration += "F-F++F-F";
						break;
					case 'x':
						nextGeneration += "a";
						break;
					case 'y':
						nextGeneration += "b";
						break;
					case 'a':
						nextGeneration += "F[+x]Fb";
						break;
					case 'b':
						nextGeneration += "F[-y]Fa";
					default:
						nextGeneration += currentGeneration.charAt(i);
				}
			}
			generations++;
			stringHelper(numIterations, nextGeneration, generation + 1);
		}
		else
		{
			string = currentGeneration;
		}
	}

	void generateTree()
	{
		
	}
}