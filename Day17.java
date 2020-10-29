// This problem was asked by Amazon.
// Given n numbers, find the greatest common denominator between them.
// For example, given the numbers [42, 56, 14], return 14.

public class Day17 {

	// function that finds GCD using Euclidean algorithm by division
	public static int gcd(int a, int b)
	{
		// base case
		if(a%b==0)
			return b;

		// recursive case
		else
			return gcd(b,a%b);
	}
	
	// function that return GCD of n numbers
	public static int findGCD(int numbers[])
	{
		int gcd= numbers[0];

		for(int i= 0; i < numbers.length; i++)
		{
			gcd= gcd(gcd,numbers[i]);

			// smallest GCD is 1 and 1 is multiple of every number,
			// so no further calculations are needed
			// this is for optimization (can be skipped)
			if(gcd==1)
				return 1;
		}

		return gcd;
	}

	// Driver code
	public static void main(String args[])
	{
		int numbers[] = {42, 56, 14};
		System.out.println(findGCD(numbers));
	}
}
