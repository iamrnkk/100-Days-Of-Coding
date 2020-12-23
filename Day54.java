// This problem was asked by LinkedIn.

// Given a linked list of numbers and a pivot k,
// partition the linked list so that all nodes less than k come before nodes greater than or equal to k.

// For example, given the linked list 5 -> 1 -> 8 -> 0 -> 3 and k = 3, the solution could be 1 -> 0 -> 5 -> 8 -> 3.



// class that defines structure of 
// each node in linked list
class Node
{
	int data;
	Node next;
	
	public Node(int data)
	{
		this.data= data;
		next=null;
	}
}

public class Day54
{
	public static void printNodes(Node head)
	{
		while(head != null)
		{
			if(head.next!=null)
				System.out.print(head.data+"-> ");
			else
				System.out.print(head.data);
			
			head= head.next;
		}
		
		System.out.println();
	}
	
	public static Node partition(Node head, int k)
	{
		// linked list that will store element < k 
		Node lessThanPivot= null;
		Node headLessThanPivot= null;
		
		// linked list that will store element >= k
		Node greaterThanPivot =null;
		Node headGreaterThanPivot=null;
		
		Node temp= head;
		
		// traversing original list to do partition
		while(temp !=null)
		{
			// if lessThanPivot is empty, initialize it
			// and store the address of head
			if(lessThanPivot == null && temp.data < k)
			{
				lessThanPivot= temp;
				headLessThanPivot= temp;
			}
			
			// if greaterThanPivot is empty, initialize it
			// and store the address of head
			else if(greaterThanPivot == null && temp.data >= k)
			{
				greaterThanPivot= temp;
				headGreaterThanPivot= temp;
			}
			
			// add elements > k in lessThanPivot
			else if(lessThanPivot!=null && temp.data < k)
			{
				lessThanPivot.next= temp;
				lessThanPivot=lessThanPivot.next;
			}
				
			// add elements >= k in greaterThanPivot
			else
			{
				greaterThanPivot.next= temp;
				greaterThanPivot= greaterThanPivot.next;
			}
			
			temp= temp.next;
		}
		
		lessThanPivot.next= headGreaterThanPivot;
		
		return headLessThanPivot;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		Node head= new Node(5);
		head.next= new Node(1);
		head.next.next= new Node(8);
		head.next.next.next= new Node(0);
		head.next.next.next.next= new Node(3);
		
		printNodes(head);
		
		Node newHead= partition(head,3);
		
		printNodes(newHead);
	}
}