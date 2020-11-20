// Given the root of a binary search tree, and a target K, return two nodes in the tree whose sum equals K.
// For example, given the following tree and K of 20
//   10
//  /  \
// 5    15
//     /  \
//    11   15
// Return the nodes 5 and 15.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// class that defines structure of each node in tree
class Node
{
	int data;
	Node left,right;
	
	public Node(int data)
	{
		this.data= data;
		left=right=null;
	}
}

public class Day33 
{

	public static ArrayList<Integer> findPair(Node root, int target)
	{
		HashSet<Integer> visited = new HashSet<>();
		Queue<Node> toBeVisited = new LinkedList<Node>();
		ArrayList<Integer> pair = new ArrayList<>();
		
		toBeVisited.add(root);
		
		// will apply BFS to store unvisited nodes in Queue
		// data of visited nodes will be stored in HashSet
		while(!toBeVisited.isEmpty())
		{
			if(toBeVisited.peek()!= null)
			{
				Node currNode = toBeVisited.remove();
				
				// when pair is found 
				if(visited.contains(target-currNode.data))
				{
					pair.add(currNode.data);
					pair.add(target-currNode.data);
					return pair;
				}
				
				visited.add(currNode.data);
				toBeVisited.add(currNode.right);
				toBeVisited.add(currNode.left);
			}
		}
		
		return null;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.right.left = new Node(11);
		root.right.right = new Node(16);
		/* the constructed tree is -
		 *  	  10
 		 *		 /  \
		 *		5    15
    	 *			/  \
   		 *		   11   15
		 */
		
		System.out.println(findPair(root, 20));
		
	}
}