// This problem was asked by Google.

// Given a linked list, sort it in O(n log n) time and constant space.

// For example, the linked list 4 -> 1 -> -3 -> 99 should become -3 -> 1 -> 4 -> 99.

class Node{
	int data;
	Node next;
	public Node(int data)
	{
		this.data=data;
		next=null;
	}
}

public class Day90 
{
	public static Node findMid(Node head)
	{
		Node slow,fast;
		slow=fast=head;
		
		while(fast.next!=null && fast.next.next!=null)
		{
			slow=slow.next;
			fast= fast.next.next;
		}
		
		return slow;
	}
	
	public static Node merge(Node h1, Node h2)
	{
		if(h1==null) return h2;
		if(h2==null) return h1;
		Node i1=h1, i2=h2;
		Node mergedHead= new Node(-1);
		Node merged= mergedHead;
		
		while(i1!=null && i2!=null)
		{
			if(i1.data < i2.data)
			{
				merged.next= i1;
				i1=i1.next;
			}
			
			else
			{
				merged.next= i2;
				i2=i2.next;
			}
			
			merged=merged.next;
		}
		
		merged.next= i1!=null?i1:i2;
		
		return mergedHead.next;
		
	}
	
	public static Node mergeSort(Node head)
	{
		if(head==null || head.next==null) return head;
		Node mid= findMid(head);
		Node newHead= mid.next;
		mid.next=null;
		Node h1=mergeSort(head);
		Node h2= mergeSort(newHead);
		
		return merge(h1,h2);
	}
	
	public static void printList(Node head)
	{
		Node temp= head;
		
		while(temp !=null)
		{
			if(temp.next!=null)
				System.out.print(temp.data+"-> ");
			else
				System.out.print(temp.data+"\n");
			
			temp=temp.next;
		}
	}
	
	public static void main(String args[])
	{
		
		Node head= new Node(4);
		head.next= new Node(1);
		head.next.next= new Node(-3);
		head.next.next.next= new Node(99);
		
		printList(head);
		Node newH= mergeSort(head);
		printList(newH);
		
	}
}
