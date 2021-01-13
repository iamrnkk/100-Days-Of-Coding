// This problem was asked by Pinterest.

// Given an integer list where each number represents the number of hops you can make,
// determine whether you can reach to the last index starting at index 0.

// For example, [2, 0, 1, 0] returns True while [1, 1, 0, 1] returns False.


public class Day81
{
	public static boolean isEndReachable(int nums[])
	{
		// currMaxJumps will store max Jumps 
		// it can Jump to get to next index with respect to current index
		// i.e- for {1, 3, 1, 2, 0, 1}
		// at index i=0, currMaxJumps=1 (index) {1,3}
		// at index i=1, currMaxJumps=4 (index) {1,3,1,2,0}
		// at index i=2, currMaxJumps=4 (index) {1,3,1,2,0}
		// at index i=3, currMaxJumps=5 (index) {1,3,1,2,0,1}
		int currMaxJumps= nums[0];
		
		// traversing to find currMaxJumps and if it can reach till end
		for(int i=0; i< nums.length;i++)
		{
			// if can't jump farther 
			if(currMaxJumps< i) return false;
			
			// since we are finding maximum Jumps from the current index
			// we need to update it every time we go to next index
			currMaxJumps= Math.max(currMaxJumps, i + nums[i]);
		}
		
		return true;
	}
	
	public static void main(String args[])
	{
		int nums[]= {2, 0, 1, 0};
		
		System.out.println(isEndReachable(nums));
	}
}
