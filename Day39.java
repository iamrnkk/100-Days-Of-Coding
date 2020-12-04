// This question was asked by Apple.

// Given a binary tree, find a minimum path sum from root to a leaf.

// For example, the minimum path in this tree is [10, 5, 1, -1], which has sum 15.

//       10
//      /  \
//     5    5
//      \    \
//       2    1
//           /
//          -1

import java.util.ArrayList;

class Node
{
	Node left,right;
	int data;
	
	public Node(int data)
	{
		this.data= data;
		left=right= null;
	}
}

class Min
{
	int sum= Integer.MAX_VALUE;
	Node leaf=null;
	ArrayList<Integer> nodes= new ArrayList<>();
}

class BinaryTree
{

	Node root;
	
	Min min= new Min();
	
	public void findMinSum(Node root, int currSum)
	{
		// base case 
		if (root== null)
			return ;

		currSum= currSum+ root.data;
		
		// when the current path sum is minimum path sum
		// store sum and the leaf
		if((currSum <= min.sum) && root.left==null && root.left==null)
			{
			min.sum= currSum;
			min.leaf=root;
			}
		
		
		findMinSum(root.left,currSum);
		findMinSum(root.right,currSum);
	}
	
	public  boolean getMinPath(Node root, int minSum)
	{
		// base case
		if(root==null)
			return false;
		 
		// if found min path leaf or  node's descendent have min sum leaf
		if(root== min.leaf || getMinPath(root.right,minSum-root.data) || getMinPath(root.left,minSum-root.data))
		{
			min.nodes.add(root.data);
			return true;
		}
		
		return false;		
	}
	
	public void getMinSum(Node root)
	{
		findMinSum(root,0);
		getMinPath(root,min.sum);
		System.out.println(min.nodes);
	}
}

public class Day39 
{
	public static void main(String args[])
	{
		BinaryTree tree= new BinaryTree();
		tree.root= new Node(10);
		tree.root.left= new Node(5);
		tree.root.right= new Node(5);
		tree.root.left.left= new Node(2);
		tree.root.right.right= new Node(1);
		tree.root.right.right.left= new Node(-1);
        // tree constructed-
        //       10
        //      /  \
        //     5    5
        //      \    \
        //       2    1
        //           /
        //          -1

		tree.getMinSum(tree.root);
	}
}