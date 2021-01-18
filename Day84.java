// This problem was asked by Facebook.

// Given a positive integer n, find the smallest number of squared integers which sum to n.

// For example, given n = 13, return 2 since 13 = 32 + 22 = 9 + 4.

// Given n = 27, return 3 since 27 = 32 + 32 + 32 = 9 + 9 + 9.


public class Day84 
{
	public static int minPerfectSquares(int n)
	{
		if(n<0)
            return 0;
        // optional
		if(n<=3)
			return n;
		
		// will store min perfect squares needed to sum up to respective index
		// at index 0= 0 (min perfect squares needed to sum upto 0)
		// at index 1= 1 (min perfect squares needed to sum upto 1)
		// at index 2= 2 (min perfect squares needed to sum upto 2)
		// at index 3= 3 (min perfect squares needed to sum upto 3)
		// at index 4= 1 (min perfect squares needed to sum upto 4)
		// and so on..
		int dp[] = new int[n+1];
		
		for(int i= 0; i <= n; i++)
		{
			// initially filling with max possibility
			dp[i]=i;
			
			// subtract the square of j from i and then check min perfect squares needed 
			// to reach the number we got after subtracting
			// if that is minimum than the current then store it. ex-
			// for i=4
			//    at j=1
			//       dp[4-1*1] => dp[3]= 3
			//       therefore dp[4]= min(4,3+1) => dp[4]= 4
			//    at j=2
			//       dp[4-2*2] => dp[0]= 0
			//       therefore dp[4]= min(4, 0+1) => dp[4]= 1 
			for(int j=1; j*j <= i; j++)
				dp[i]= Math.min(dp[i], dp[i-j*j]+1);
		}
		
		return dp[n];
	}
	
	public static void main(String args[])
	{
		System.out.println(minPerfectSquares(27));
	}
}