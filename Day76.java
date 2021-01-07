// This problem was asked by Apple.

// Implement the function fib(n), which returns the nth number in the Fibonacci sequence, using only O(1) space.

public class Day76 
{
	public static int fibonacci(int n)
	{
		int first=0, second= 1, nth=0;
		
		if(n==1) return 0;
		if(n==2) return 1;
		
		for(int i=2; i<=n; i++)
		{
			nth= first+second;
			
			// updating for next iteration
			first=second;
			second=nth;
		}
		
		return nth;
	}
	
	public static void main(String args[])
	{
		System.out.print(fibonacci(5));
	}
}
