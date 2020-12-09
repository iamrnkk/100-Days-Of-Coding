// You are given an array of nonnegative integers.
// Let's say you start at the beginning of the array and are trying to advance to the end.
// You can advance at most, the number of steps that you're currently on.
// Determine whether you can get to the end of the array.

// For example, given the array [1, 3, 1, 2, 0, 1], we can go from indices 0 -> 1 -> 3 -> 5, so return true.

// Given the array [1, 2, 1, 0, 0], we can't reach the end, so return false.

public class Day42 
{
	public static boolean isEndReachable(int[] numbers)
	{
		// currMaxReach will store max steps 
		// it can take to move to next index with respect to current index
		// i.e- for {1, 3, 1, 2, 0, 1}
		// at index i=0, currMaxReach=1 (index) {1,3}
		// at index i=1, currMaxReach=4 (index) {1,3,1,2,0}
		// at index i=2, currMaxReach=4 (index) {1,3,1,2,0}
		// at index i=3, currMaxReach=5 (index) {1,3,1,2,0,1}
		int currMaxReach= numbers[0];
		
		// traversing to find currMaxReach and if it can reach till end
		for(int i=0; i< numbers.length; i++)
		{
			// if the steps stops before reaching end/current index 
			if(currMaxReach<i)
				return false;
			
			// since we are finding maximum reach from the current index
			// we need to update it every time we go to next index
			currMaxReach= Math.max(currMaxReach, i+numbers[i]);
		}
		
		return true;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int numbers[]= {1, 3, 1, 2, 0, 1};
		
		System.out.println(isEndReachable(numbers));
	}
}