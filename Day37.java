// You have a large array with most of the elements as zero.

// Use a more space-efficient data structure, SparseArray, that implements the same interface:

// init(arr, size): initialize with the original large array and size.
// set(i, val): updates index at i with val.
// get(i): gets the value at index i.

import java.util.HashMap;

class SparseArray
{
	int[] arr;
	int size;
	
	// key- indexes that have non zero values 
	// value- respective non zero value of that index
	// ex- for arr= {0,0,10,16,0,0}
	// Map = {2=10,3=16}
	HashMap<Integer,Integer> nonZeroIndexes = new HashMap<>();
	
	public SparseArray(int[] arr, int size)
	{
		this.arr= new int[size];
		this.arr= arr;
		this.size=size;
	}
	
	public void set(int i,int val)
	{
		// handling edge cases
		if(i<0 || i>size)
			return;
		
		// if encountered a non zero value
		// then store it in the map along with the index
		else if(arr[i]!=0)
			nonZeroIndexes.put(i, val);
	}
	
	public Integer get(int i)
	{
		// handling edge cases
		if(i<0 || i>size)
			return null;
		
		// return value from dictionary for the queried index i
		// if not found in map then return default value 0
		return nonZeroIndexes.getOrDefault(i, 0);
	}
}

// Driver code
public class Day37 
{
	public static void main(String args[])
	{
		int[] arr= {0,0,1,2,0,0};
		
		SparseArray spArr= new SparseArray(arr,7);
		
		for(int i=0; i<6; i++)
			spArr.set(i, arr[i]);
		
		System.out.println(spArr.get(0));
		System.out.println(spArr.get(1));
		System.out.println(spArr.get(2));
		System.out.println(spArr.get(3));
		System.out.println(spArr.get(4));
		System.out.println(spArr.get(5));
	
	}
}