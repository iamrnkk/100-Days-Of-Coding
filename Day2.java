// This problem was asked by Google.

// A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
// Given the root to a binary tree, count the number of unival subtrees.


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
public class Day2 
{
	
	public static boolean isUnival(Node node,int[] count)
	{
		// base case
		if(node == null)
			return true;
		
		// see whether subtrees on the left and right subtrees are unival or not 
		boolean leftUnival= isUnival(node.left, count);
		boolean rightUnival= isUnival(node.right, count);
		
		// conditions for tree to not be unival-
		
		// condition 1: if either left or right subtree is not unival 
		if(!leftUnival || !rightUnival)
			return false;
		
		// condition 2: if left child is not equal to parent node (if child exists)
		else if(node.left != null && node.left.data != node.data)
			return false;
		
		// condition 3: if right child is not equal to parent node (if child exists)
		else if(node.left != null && node.left.data != node.data)
			return false;
		
		// if all those conditions are false that means the tree/subtree is unival
		count[0]++;
		return true;
	}
	
	static int countUnival(Node node)
	{
		int count[]= {0};
		isUnival(node, count);
		
		return count[0];
	}
	
	public static void main(String args[])
	{
		Node root= new Node(0);
		root.left= new Node(1);
		root.right= new Node(0);
		root.right.left= new Node(1);
		root.right.right= new Node(0);
		root.right.left.left= new Node(1);
		root.right.left.right= new Node(1);
		
		System.out.println(countUnival(root));
	}
}