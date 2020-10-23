// This problem was asked by Google.
// Given the head of a singly linked list, swap every two nodes and return its head.
// For example, given 1 -> 2 -> 3 -> 4, return 2 -> 1 -> 4 -> 3


// custom data type that defines structure of each node in linked list
class Node{

	int data;
	Node next;

	// constructor
	public Node(int data)
	{
		this.data=data;
		this.next= null;
	}
}

public class Day11 {

	// function that swaps pair of nodes
	public Node swapNodes(Node head) {

		// making a temporary node for traversing
		Node temp= new Node(-1);
		temp.next=head;

		// since after traversing second node will be swapped with first
		// ex- 1(head)->2->3->4
		// after swapping- 2(head)->1->4->3
		// so, making second element as head
		head=head.next;

		// traversing linked list
		while(temp!= null && temp.next!=null) {

			// initially,
			// temp= -1(head)->1->2->3->4

			// first= 1(first)->2->3->4
			Node first= temp.next;
			// second= 2(second)->3->4
			Node second= temp.next.next;

			// first= 1(first)->3->4
			first.next= first.next.next;
			// second= 2(second)->1(first)->3->4
			second.next= first;
			// temp= -1(head)->2(second)->1(first)->3->4
			temp.next= second;

			// temp= 1(head)->3->4
			temp= temp.next.next;

		}
		return head;
	}

	// function to print nodes from linked list
	public void display(Node head)
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data);
			if(temp.next!=null)
				System.out.print("-> ");
			temp=temp.next;
		}
		System.out.println();
	}

	// Driver code
	public static void main (String args[]){

		Node start = new Node(1);
		start.next = new Node(2);
		start.next.next= new Node(3);
		start.next.next.next= new Node(4);

		Day11 ob= new Day11();
		ob.display(start);

		Node swap = ob.swapNodes(start);
		ob.display(swap);


	}

}
