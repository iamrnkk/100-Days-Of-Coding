// This problem was asked by Google.

// Given a binary tree of integers, find the maximum path sum between two nodes.
// The path must go through at least one node, and does not need to go through the root.

import java.util.ArrayList;

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


public class Day75 
{
	static int maxSum;
	
	public static int getMaxPathSum(Node root)
	{
		maxSum= Integer.MIN_VALUE;
		maxSubPathSum(root);
		return maxSum;
	}
	
	public static int maxSubPathSum( Node node)
	{
		// base case
		if(node == null) return 0;
		
		// DFS to get sums (we don't need negative sums, so make sums 0 then)
		int leftSum= Math.max(0, maxSubPathSum(node.left));
		int rightSum= Math.max(0, maxSubPathSum(node.right));
		
		// the root for current subtree may or may not be the root for maxPathSum
		// so store the maxSum in maxSum by comparing
		maxSum= Math.max(maxSum, leftSum+ node.data+ rightSum);
		
		// root of current subtree may not be the root for maxSumPath
		// so in that case return the best possible path to above nodes
		return Math.max(leftSum, rightSum)+ node.data;
	}
	
	public static void main (String[] args)
	{
		Node root = new Node(-10);
		root.left = new Node(9);
		root.right= new Node(20);
		root.left.left = new Node(1);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		// tree constructed:
		//          -10
		//          /  \
		//         9   20
		//        /   /  \
		//       1   15   7
		
		System.out.println(getMaxPathSum(root));
	}
}