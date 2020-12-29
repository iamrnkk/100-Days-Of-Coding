// This problem was asked by Google.

// Determine whether a doubly linked list is a palindrome. What if it’s singly linked?

// For example, 1 -> 4 -> 3 -> 4 -> 1 returns True while 1 -> 4 returns False.

import java.util.Stack;

class Node
{
	int data; Node next;
	
	public Node(int data)
	{
		this.data= data;
		next=null;
	}
}

public class Day66 
{
	public static boolean isPalindrome(Node head)
	{
		Node temp= head;
		
		// Last In First Out (LIFO)
		Stack<Integer> reverse = new Stack<>();
		
		while(temp !=null)
		{
			reverse.push(temp.data);
			temp=temp.next;
		}
		
		temp=head;
		
		while(temp!=null)
		{
			if(temp.data != reverse.pop())
				return false;
			temp= temp.next;
		}
		
		return true;
	}
	
	public static void main(String args[])
	{
		Node head= new Node(1);
		head.next= new Node(2);
		head.next.next= new Node(2);
		head.next.next.next= new Node(1);
		
		System.out.println(isPalindrome(head));
	}
}