// Determine whether a tree is a valid binary search tree.

// A binary search tree is a tree with two children, left and right,
// and satisfies the constraint that the key in the left child must be less than or equal to the root and 
// the key in the right child must be greater than or equal to the root.

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

public class Day32 
{
	public static boolean isBST(Node root, Node min, Node max)
	{
		// base case 
		if(root==null)
			return true;

		// if data of current node is not between min and max value
		else if((min!=null && root.data <= min.data) || (max!=null && root.data >= max.data))
			return false;

		else
		{
			// left node should not be lower than current min node value of entire tree (min= min) 
			// and also does not exceed the value of immediate parent node (max= root)
			boolean left = isBST(root.left,min,root);
			
			// right node should not be lower than immediate parent node (min= root)
			// and also should not exceed current max node value of entire tree (max= max) 
			boolean right = isBST(root.right,root,max);
			
			return left && right;
		}
	}

	// Driver code
	public static void main(String args[])
	{
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		/* Tree constructed is-
		 * 			4
		 * 		   / \
		 * 		  2   5
		 * 		 / \
		 * 		1   3
		 */
		
		System.out.println(isBST(root,null,null));
	}
}