// This problem was asked by Square.

// Assume you have access to a function toss_biased() which returns 0 or 1 with a probability that's not 50-50 (but also not 0-100 or 100-0). You do not know the bias of the coin.

// Write a function to simulate an unbiased coin toss

public class Day80 
{
	public static int biased()
	{
		int probability= (int)(Math.random()*100);
		
		if(probability>=70)
			return 0;
		else
			return 1;
	}
	
	public static int unbiased()
	{
		int difference= biased() - biased();
		
		// base case 1: 
		// if 50-50 condition i.e 1, 0
		if(difference > 0)
			return 1;
		
		// base case 2:
		// if another 50-50 condition i.e 0, 1
		else if(difference < 0)
			return 0;
		
		// recursive case:
		// unbiased condition i.e 1,1 or 0,0
		return unbiased();
	}
	
    // Driver Code
	public static void main(String args[])
	{
		for(int i=0; i< 10; i++)
			System.out.print(unbiased() + " ");
	
	}
}