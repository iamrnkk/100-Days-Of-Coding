// You have n fair coins and you flip them all at the same time. Any that come up tails you set aside.
// The ones that come up heads you flip again. How many rounds do you expect to play before only one coin remains?

// Write a function that, given n, returns the number of rounds you'd expect to play until one coin remains.


public class Day43 
{
	public static int getRounds(int n)
	{
		// According to probability,
		// 2^N=n or we can say
		// log(base 2) n = N
		// 2= total possible outcomes for each event/coin (heads, tails)
		// n= no. of possible events (number of coins)
		// N= no.of possible outcomes ( total no. of rounds)
		
		return (int)(Math.log(n)/Math.log(2));
	}
	
	// Driver Code
	public static void main(String args[])
	{
		System.out.println(getRounds(4));
	}
}
