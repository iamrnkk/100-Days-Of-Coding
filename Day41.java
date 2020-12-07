import java.util.LinkedList;

public class Day41 
{
	public static boolean isMinimallyConnected( LinkedList<Character>[] adjacencyList)
	{
		//counter to count edges
		int countEdges=0;
		
		// traversing adjencylist for counting edges
		for(int i=0;i <adjacencyList.length;i++)
		{
			for(int j=1;j< adjacencyList[i].size();j++)
			{
				countEdges++;
			}
		}
		
		// since, it is undirected graph 
		// therefore, every edge is counted twice
		// so, dividing it to get correct count
		countEdges/=2;
		
		// for minimallly connected graph, edges= vertices -1
		return countEdges == (adjacencyList.length-1);
	}
	
	// Driver code
	public static void main(String args[])
	{
		LinkedList<Character>[] adjacencyList = new LinkedList[4];
		
		for (int i = 0; i < adjacencyList.length; i++) 
			adjacencyList[i] = new LinkedList<Character>();
		
		adjacencyList[0].add('a');
		adjacencyList[0].add('b');
		adjacencyList[0].add('c');
		
		adjacencyList[1].add('b');
		adjacencyList[1].add('a');
		adjacencyList[1].add('d');
		
		adjacencyList[2].add('c');
		adjacencyList[2].add('a');
		
		adjacencyList[3].add('d');
		adjacencyList[3].add('a');
		
		// graph-         AdjacencyList-
		//    b -- d      | a |-> b-> c
		//   /            | b |-> a-> d
		//  a             | c |-> a
		//   \            | d |-> a
		//    c
		
		System.out.println(isMinimallyConnected(adjacencyList));
	}
}