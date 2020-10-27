// This problem was asked by Amazon.
//
// Implement a stack API using only a heap. A stack implements the following methods:
//
// -push(item), which adds an element to the stack
// -pop(), which removes and returns the most recently added element (or throws an error if there is nothing on the stack)
//
// Recall that a heap has the following operations:
//
// -push(item), which adds a new key to the heap
// -pop(), which removes and returns the max value of the heap

import java.util.PriorityQueue;
import java.util.Comparator;

// class that defines the structure of each element in stack
class StackElement
{
	int key, data;
	// constructor
	public StackElement(int key, int data)
	{
		this.key= key;
		this.data= data;
	}
}

// class that implements stack using heap
class StackHeap
{
	// In Java, priority queue is based on priority heap, now using comparator to use it as stack
	PriorityQueue<StackElement> heap = new PriorityQueue<>(new Comparator<StackElement>()
	{
		// overriding
		public int compare(StackElement e1,StackElement e2) {
			return e2.key - e1.key;
		}
	});

	int top = -1;

	// function that adds element in stack
	public void push(int data) {
		heap.add(new StackElement(++top,data));
	}

	// function that removes element from stack
	public Integer pop() {

		// if stack underflow
		if(top==-1)
		 return null;

		top--;
		return heap.poll().data;
	}
}

// Driver code
public class Day14 {

	public static void main(String[] args){

        StackHeap stack = new StackHeap();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
    }

}
