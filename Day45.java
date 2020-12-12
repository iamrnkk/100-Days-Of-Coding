// Print the nodes in a binary tree level-wise.

import java.util.LinkedList;
import java.util.Queue;

// class that defines structure of each Node
class Node
{
	 int data;
	 Node left,right;
	 
	 public Node(int data)
	 {
		 this.data=data;
		 left=right=null;
	 }
}

public class Day45
{
	public static void levelOrderTraversal(Node root)
	{
		// stores Nodes that are not visited(yet to be printed)
		Queue<Node> unvisitedNodes= new LinkedList<>();
		unvisitedNodes.add(root);
		
		// traversing
		while(!unvisitedNodes.isEmpty())
		{
			Node currentNode= unvisitedNodes.poll();
			
			System.out.print(currentNode.data+" ");
			
			if(currentNode.left!=null)
				unvisitedNodes.add(currentNode.left);
			
			if(currentNode.right!=null)
				unvisitedNodes.add(currentNode.right);
		}
		
		System.out.println();
	}
	
	// Driver Code
	public static void main(String args[])
	{
		Node root= new Node(1);
		root.left= new Node(2);
	    root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		root.right.right= new Node(6);
		// tree constructed-
		//      1
		//     / \
		//    2   3
		//   / \   \
		//  4   5   6
		
		levelOrderTraversal(root);
	}
}