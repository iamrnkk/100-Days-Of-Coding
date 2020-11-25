// Given a linked list and a positive integer k, rotate the list to the right by k places.

// For example, given the linked list 7 -> 7 -> 3 -> 5 and k = 2, it should become 3 -> 5 -> 7 -> 7.
// Given the linked list 1 -> 2 -> 3 -> 4 -> 5 and k = 3, it should become 3 -> 4 -> 5 -> 1 -> 2.

class Node
{

	int data;
	Node next;
	
	public Node(int data)
	{
		this.data= data;
		next= null;
	}
}

public class Day34
{
	public static Node rotate(Node start, int k)
	{
		if(start==null || start.next==null)
			return null;
		
		Node head = start.next;
		Node slow= head;
		Node fast= head;
		// linked list = 1[head]-> 2[fast,slow]-> 3-> 4 -> 5
 
		for(int i=1; i<=k ; i++)
			fast= fast.next;
		/*after looping k=4 times
		 * fast=4
		 * linked list: 1[head]-> 2[slow]-> 3-> 4[fast]-> 5
		 */

		if(fast==null) // k > length of linkedlist
			return null;

		while(fast.next!=null)
		{
			fast=fast.next;
			slow=slow.next;
		}
		/*after looping 
		 * fast=5, slow=3
		 * linked list: 1[head]-> 2-> 3[slow]-> 4-> 5[fast]
		 */
		
		fast.next= head;
		/* linked list: 1[head]-> 2-> 3[slow]-> 4-> 5[fast]
		 * 				^                           :
		 * 				|                           |
		 * 				- - - - - - - - - - - - - - -
		 */
		
		start.next= slow;
		/* linked list: 1-> 2-> 3[slow]-> 4[head]-> 5[fast]
		 * 				^                           :
		 * 				|                           |
		 * 				- - - - - - - - - - - - - - -
		 */
		
		slow.next=null;
		// linked list: 4[head]-> 5[fast]-> 1-> 2-> 3[slow]
		
		return start;
	}
	
	public static void print(Node start)
	{
		Node temp= start.next;
		while(temp!= null)
		{
			System.out.print(temp.data);
			if(temp.next!=null)
				System.out.print("-> ");
			temp= temp.next;
		}
		
		System.out.println();
	}
	
    // Driver node
	public static void main(String args[])
	{
		Node start = new Node(-1);
		start.next = new Node(1);
		start.next.next = new Node(2);
		start.next.next.next = new Node(3);
		start.next.next.next.next = new Node(4);
		start.next.next.next.next.next = new Node(5);
		
		print(start);
		start=rotate(start,4);
		print(start);
	}

}