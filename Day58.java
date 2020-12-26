// This problem was asked by Google.

// Given k sorted singly linked lists, write a function to merge all the lists into one sorted singly linked list.

import java.util.PriorityQueue;

class Node
{
	int data; Node next;
	
	public Node(int data)
	{
		this.data= data;
		next= null;
	}
	
	@Override
	public String toString() {
	    return data+"";
	}
}

public class Day58 
{
	public static Node mergeKLists(Node[] heads)
	{ 
		PriorityQueue<Node> minHeap =new PriorityQueue<>(heads.length, (a,b)-> a.data-b.data);
		
		// will store head and tail of of merged list
		Node headMerged=null, tailMerged=null ;
		
		// filling up heap with all the heads of lists
		for(Node head: heads)
		{
			if (head !=null)
				minHeap.add(head);
		}

		
		while(!minHeap.isEmpty())
		{
			// getting and removing current minimum element in heap
			Node currNode= minHeap.poll();
			
			// now adding the next Node inside heap
			if(currNode.next != null)
				minHeap.add(currNode.next);
			
			// intializong head of merged list
			if(headMerged== null)
				headMerged=tailMerged=currNode;
			
			// updating tail of the merged list
			else
			{
				tailMerged.next= currNode;
				tailMerged= currNode;
			}
		}

		return headMerged;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		Node a, b, c;
		a= new Node(1);
		a.next= new Node(4);
		a.next.next= new Node(5);
		
		b=new Node(1);
		b.next= new Node(3);
		b.next.next= new Node(4);
		
		c= new Node(2);
		c.next= new Node(6);
		
		Node[] heads= {a, b, c};
		Node headMerged= mergeKLists(heads);
		
		while(headMerged!=null)
		{
			if(headMerged.next != null)
				System.out.print(headMerged + "-> ");
			else
				System.out.println(headMerged);
			
			headMerged= headMerged.next;
		}
	}
}