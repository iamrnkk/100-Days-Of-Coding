// This problem was asked by Google.

// Find the minimum number of coins required to make n cents.

// You can use standard American denominations, that is, 1¢, 5¢, 10¢, and 25¢.

// For example, given n = 16, return 3 since we can make it with a 10¢, a 5¢, and a 1¢.

import java.util.Arrays;

public class Day74
{
	public static int getMinimumCoins(int coins[],int targetSum)
	{
		// will store minmum coins needed to get the desired sum till targetSum 
		int[] sums= new int[targetSum+1];
		Arrays.fill(sums, Integer.MAX_VALUE); //initializing
		
		// to get sum 0 we need 0 coins
		sums[0]=0;
		
		// traversing to get minimum coins for each sum
		for(int i= 1; i< sums.length; i++)
		{
			// for current sum, check the possible coins needed
			// lets say coins[]= {1,2,5,10}
			// i.e if current sum=2,
			// then first check for coins[0], then coins[1], then coins[2] in sums[]
			// by decrementing coins[j] from sums[i]
			// ex- 5-1 = 4 now check in sums[4] 
			// if minimum coins needed in sums [4]+1 is less than current, replace it 
            // (+1 ,since we have spent 1 coin to reach sums[4])
			for(int j=0; j< coins.length && coins[j]<=i; j++)
				sums[i]= Math.min(sums[i], 1+sums[i- coins[j]]);
		}
		
		// cant find coins? then return -1 else return minimum coins
		return (sums[targetSum]==Integer.MAX_VALUE)? -1: sums[targetSum];
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int coins[]= {1,5,10,25};
		int n=16;
		
		System.out.println(getMinimumCoins(coins,n));
	}
}