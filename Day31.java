// This question was asked by Snapchat.

// Given the head to a singly linked list, where each node also has a “random” pointer that points to anywhere in the linked list,
// deep clone the list.

import java.util.HashMap;

// class that defines structure of each node
class Node
{
	int data;
	Node next, random;
	
	public Node(int data)
	{
		this.data = data;
		next= random=null;
	}
}

public class Day31
{	
	public static Node clone(Node head)
	{
		Node originalNode= head, clonedNode= null;
		
		// map that wil store originalNode to clonedNode mapping
		HashMap<Node,Node> nodeMap= new HashMap<Node,Node>();
		
		// traversing original for cloning and mapping
		while(originalNode!=null)
		{
			clonedNode= new Node(originalNode.data);
			nodeMap.put(originalNode,clonedNode);
			originalNode= originalNode.next;
		}
		
		// re-refrencing to head
		originalNode= head;
		
		// linking each nodes
		while(originalNode !=null)
		{
			clonedNode= nodeMap.get(originalNode);
			clonedNode.next = nodeMap.get(originalNode.next);
			clonedNode.random = nodeMap.get(originalNode.random);
			originalNode= originalNode.next;
		}
		
		clonedNode= nodeMap.get(head);
		return clonedNode;
	}
	
	public static void print(Node head)
	{
		while(head !=null)
		{
			System.out.print(head.data+":"+ head.random.data+ "(random)");
			if(head.next!=null)
				System.out.print(" -> ");
			head= head.next;
		}
		System.out.println();
	}
	
	// Driver code
	public static void main(String args[])
	{
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next= new Node(3);
		head.next.next.next= new Node(4);
		head.next.next.next.next = new Node(5);
		
		head.random= head.next.next.next;
		head.next.random= head.next.next;
		head.next.next.random= head.next;
		head.next.next.next.random= head;
		head.next.next.next.next.random= head.next.next.next.next;
		
		Node clonedHead= clone(head);
		
		print(head);
		print(clonedHead);
	}
}