// This problem was asked by Facebook.

// Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.

// For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.

// Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets that add up to the same sum.

public class Day49 
{
	public static boolean hasSubsetSum(int numbers[], int targetSum)
	{
		// matrix that stores boolean, whether the number should be included or not to get sum
		// no of rows = element present at current index
		// no. of coloumns = sums till target sum i.e 0,1,2,3.... target sum
		boolean hasSum[][]= new boolean [numbers.length+1][targetSum+1];
		
		// filling first row (if no. of elements=0) with false since 
		// we can't find sum if we include 0 elements
		for (int i = 0; i < hasSum[0].length; i++)
            hasSum[0][i] = false;
		
		// filling first column (if sum=0) with true since,
		// 0 as a sum can be found if we have any number of elements
		for (int i = 0; i < hasSum.length; i++)
            hasSum[i][0] = true;
		
		// traversing and assigning booleans
		for(int i=1; i<hasSum.length;i++)
		{
			for(int j=1; j< hasSum[0].length;j++)
			{	
				// copying above index's value in the matrix 
				// initially taking as not including the current number to get sum
				hasSum[i][j]= hasSum [i-1][j];
				
				// if number is less than the sum 
				if(j>= numbers[i-1])
				{
					boolean NumIncluded= hasSum[i-1][j- numbers[i-1]];
					boolean NumNotIncluded= hasSum[i][j];
					
					// checking if number should be included or not
					hasSum[i][j]= NumIncluded || NumNotIncluded;
				}
			}
		}
		
		return hasSum[numbers.length][targetSum];
	}
	
	public static boolean canBePartitioned(int numbers[])
	{
		int sum=0;
		
		for(int i= 0; i<numbers.length; i++)
			sum= sum+ numbers[i];
		
		// if sum isn't even then,
		// there wont be two unique subsets that will give equal sum
		if(sum%2==1) return false;
		
		if(sum==0) return true;
		
		// by pigeon hole principle,
		// if there's a half of sum array
		// other half of sum will also be there
		// i.e- sum= sum/2 + sum/2
		return hasSubsetSum(numbers, sum/2);
	}
	
	// Driver COde
	public static void main(String args[])
	{
		int numbers[] = {15, 5, 20, 10, 35, 15, 10};
		
		System.out.println(canBePartitioned(numbers));
	}
}