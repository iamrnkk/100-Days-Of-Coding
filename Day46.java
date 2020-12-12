// Given an array of numbers and an index i, return the index of the nearest larger number of the number at index i,
// where distance is measured in array indices.

// For example, given [4, 1, 3, 5, 6] and index 0, you should return 3.

// If two distances to larger numbers are the equal, then return any one of them.
// If the array at i doesn't have a nearest larger integer, then return null.

// Follow-up: If you can preprocess the array, can you do this in constant time?

public class Day46 
{
	public static Integer getNearestLargest(int[] numbers, int index)
	{
		// traversing
		for(int i=0; i< numbers.length; i++)
		{
			// for storing relative distance for both left and right side
			int left= index-i;
			int right= index+i;
			
			if(left>=0 && numbers[left]> numbers[index])
				return left;
			
			else if(right<numbers.length && numbers[right]>numbers[index])
				return right;
		}
		
		// if nothing is returned yet, then queried index number is largest 
		return null;
	}
	
	// Driver code
	public static void main(String args[])
	{
		int numbers[]= {4, 1, 3, 5, 6};
		
		System.out.println(getNearestLargest(numbers,0));
	}
}