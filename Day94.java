// This problem was asked by Stripe.

// Given an integer n, return the length of the longest consecutive run of 1s in its binary representation.

// For example, given 156, you should return 3.

public class Day94 {
	public static int findConsecutiveOnes(int n)
	{
		int consecutiveOnes=0;
		while (n!=0)
		{
			n= n & n<<1;
			consecutiveOnes++;
		}
		return consecutiveOnes;
	}
	
	public static void main(String args[])
	{
		int n=156;
		System.out.println(findConsecutiveOnes(n));
	}

}