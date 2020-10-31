// Given a binary tree, return the level of the tree with minimum sum.

import java.util.Queue;
import java.util.LinkedList;

// class that defines structure of every Node of tree
class TreeNode
{
	TreeNode left,right;
	int data;

	public TreeNode(int data)
	{
		this.data=data;
		left=right=null;
	}
}

public class Day19 {

	public static int findMaxLevelSum(TreeNode root)
	{
		// if tree doesn't exists
		if (root == null)
	        return -1;

		int minLevelSum= root.data;

		// this will store the tree nodes that aren't used for calculating sum
		Queue<TreeNode> nodesToBeVisited= new LinkedList<>();
		nodesToBeVisited.add(root);

		while(nodesToBeVisited.size()!=0)
		{
			int levelSum= 0; // stores sum of each level

			// stores number of elements of current level are present inside queue
			int currentLevelNodes=nodesToBeVisited.size();

			while(currentLevelNodes-- != 0)
			{
				TreeNode temp= nodesToBeVisited.poll();
				levelSum= levelSum+ temp.data;

				// storing nodes of next level inside queue
				if(temp.left!=null)
					nodesToBeVisited.add(temp.left);
				if(temp.right!=null)
					nodesToBeVisited.add(temp.right);
			}

			if(minLevelSum > levelSum)
				minLevelSum= levelSum;
		}

		return minLevelSum;
	}

	// Driver code
	public static void main(String args[])
	{
		 TreeNode root = new TreeNode(1);
		 root.left = new TreeNode(2);
         root.right = new TreeNode(3);
   	     root.left.left = new TreeNode(4);
	     root.left.right = new TreeNode(5);
	     root.right.right = new TreeNode(6);
	     root.right.right.left = new TreeNode(7);
	     root.right.right.right = new TreeNode(8);
	     /*   Constructed Binary tree is:
				         1
				       /   \
				     2      3
				   /  \      \
				  4    5      6
				            /   \
				           7     8    */

	     System.out.println(findMaxLevelSum(root));
	}
}
