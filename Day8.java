// This problem was asked by Yahoo.
// Write an algorithm that computes the reversal of a directed graph.
// For example, if a graph consists of A -> B -> C, it should become A <- B <- C.

import java.util.*;

public class Day8 {

	 // adjency List for directed graph
	 LinkedList<Character> adj[];
	 // adjency list that stores transpose of directed graph
	 LinkedList<Character> rev[];

	//default constructor that initializes adjency lists
	public Day8(int v)
	{
		adj = new LinkedList[v];
		rev = new LinkedList[v];

		for(int i= 0; i < v; i++)
		{
			adj[i] = new LinkedList<Character>();
			rev[i] = new LinkedList<Character>();
		}
	}

	// function for adding edges(paths) of each node
	public void addEdge(char source,char destination, boolean isRev)
	{
		// checks whether to add edge in adj or rev
		// since source and destinations are character type
		// we type cast the the source to integer type get index
		if(!isRev)
			adj[(int)source-65].add(destination);
		else
			rev[(int)source-65].add(destination);
	}

	//function that makes transpose of directed graph
	public void findReverse(int v)
	{
		//traversing adjency list adj
		for(int i = 0; i < v; i++)
            {
				//traversing each edge of nodes to make reverse directed graph
				for(int j = 0; j < adj[i].size(); j++)
					//adding edges to rev
					addEdge(adj[i].get(j), (char)(i+65), true);
            }

	}


	public  void display(int v,boolean isRev)
	{
		//checks whether to print adj or rev
		if(!isRev) {

			//traverses each node of adjency list
			for(int i = 0; i < v; i++)
	        {
	            System.out.print((char)(i+65) + " --> ");

	            //traverses each edge of adjency list
	            for(int j = 0; j < adj[i].size(); j++)
	                System.out.print(adj[i].get(j) + ", ");
	        }
			System.out.println("-");
		}
		else {

			//traverses each node of adjency list
			for(int i = v-1; i >=0; i--)
	        {
	            System.out.print((char)(i+65) + " --> ");

	            //traverses each edge of adjency list
	            for(int j = 0; j < rev[i].size(); j++)
	                System.out.print(rev[i].get(j) + ", ");

	        }
			System.out.println("-");
		}

	}

	//Driver code
	public static void main(String args[])
	{
		Day8 graph = new Day8(3);
		graph.addEdge('A', 'B', false);
		graph.addEdge('B', 'C', false);

		graph.display(3,false);

		graph.findReverse(3);

		graph.display(3,true);


	}
}
