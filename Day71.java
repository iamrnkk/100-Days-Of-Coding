// This problem was asked by Amazon.

// Implement a bit array.

// A bit array is a space efficient array that holds a value of 1 or 0 at each index.

//     init(size): initialize the array with size
//     set(i, val): updates index at i with val where val is either 1 or 0.
//     get(i): gets the value at index i.


class BitArray
{
	// since boolean takes 1 bit
	// it is more space efficient than int
	//true=1, false=0
	boolean arr[];
	int n;
	
	public BitArray(int n)
	{
		// by default every index is initialized false 
		arr= new boolean[n];
		this.n=n;
	}
	
	void set(int i, int val)
	{
		if(i>=n || i<0)
		{
			System.out.println("Invalid index");
			return;
		}
		
		arr[i]= val>0;	
	}
	
	int get(int i)
	{
		if(i>=n || i<0)
			return -1;
		
		return (arr[i])?1:0;
	}
}

// Driver Code
public class Day71 
{
	public static void main(String args[])
	{
		BitArray ba= new BitArray(5);
		
		ba.set(0, 0);
		ba.set(1, 1);
		ba.set(2, 1);
		ba.set(3, 0);
		ba.set(4, 1);
		
		System.out.println(ba.get(0));
		System.out.println(ba.get(1));
		System.out.println(ba.get(2));
		System.out.println(ba.get(3));
		System.out.println(ba.get(4));
	}
}