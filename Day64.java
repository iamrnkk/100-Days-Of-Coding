// This problem was asked by Google.

// Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

// For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

// In this example, assume nodes with the same value are the exact same node objects.

// Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

class Node
{
	int data; Node next;
	
	public Node(int data)
	{
		this.data= data;
		next= null;
	}
}

public class Day64 
{
	public static int length(Node head)
	{
		if(head == null)
			return 0;
		
		else
			return 1+length(head.next);
	}
	
	public static Node getIntersectingNode(Node a, Node b)
	{
		// thing to be noted in singly linked list,
		// two nodes can point to one Node,
		// but one Node can't point to more than one nodes.
		// ex-
		// 2 -> 3 -> 7  
		//		      \
		//	           --> 8 -> 10  here 8 = intersecting Node
		//            /
		//      9 -> 1
		int lenA= length(a), lenB= length(b);
		
		// finding bigger & smaller length linkedlist
		Node headBigList = (lenA>=lenB)?a:b;
		Node headSmallList = (lenA<lenB)?a:b;
		
		// skipping out extra nodes of bigger list
		for(int i=1; i <= Math.abs(lenA-lenB) ; i++)
			headBigList=headBigList.next;
		
		// iterate till encountered an intersecting node
		while(headBigList.data != headSmallList.data)
		{
			headBigList=headBigList.next;
			headSmallList= headSmallList.next;
		}
		
		return headBigList;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		
		Node a= new Node(3);
		a.next= new Node(7);
		a.next.next= new Node(8);
		a.next.next.next= new Node(10);
		
		Node b= new Node(9);
		b.next= new Node(1);
		b.next.next= new Node(8);
		b.next.next.next= new Node(10);
		
		System.out.println(getIntersectingNode(a,b).data);
	}
}