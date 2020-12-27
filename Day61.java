// This problem was asked by Microsoft.

// Given an array of numbers, find the length of the longest increasing subsequence in the array.
// The subsequence does not necessarily have to be contiguous.

// For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], 
// the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.


public class Day61 
{
	public static int getLIS(int nums[])
	{
		// corner case
		if (nums.length==0) return 0;
		
		// will store length of increasing subsequences
		int dp[]= new int[nums.length];
		
		// will store length of LIS
		int lenLIS= 1;
		
		// at index 0 the subsequence can only be 1 
		// as there are no preceeding elements
		dp[0]=1;
		
		// looping for finding longest subsequence till nums[i]
		// if we choose nums[i] as last number in subsequence
		for(int i=1; i < nums.length; i++)
		{ 
			for(int j=0; j < i; j++)
			{
				// if previous number is smaller than current number 
				// and current number already does not store a subsequence 
				// that has higher length than the current subsequence
				if(nums[i] > nums[j] && dp[i] < dp[j]+1)
					dp[i]= dp[j]+1;
			}
			
			// updating length of longest increasing subsequence
			lenLIS= Math.max(lenLIS, dp[i]);
		}
		
		return lenLIS;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int nums[]= {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		
		System.out.println(getLIS(nums));
	}
}