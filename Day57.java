// This problem was asked by Facebook.

// Given a array of numbers representing the stock prices of a company in chronological order,
// write a function that calculates the maximum profit you could have made from buying and selling that stock once.
// You must buy before you can sell it.

// For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.

public class Day57 
{
	public static int getMaxProfit(int[] sharePrices)
	{
		int maxProfit=0;
		int minPrice= sharePrices[0];
		
		for(int i=0; i<sharePrices.length-1; i++)
		{
			minPrice= Math.min(minPrice,sharePrices[i]);
			maxProfit=Math.max(maxProfit, sharePrices[i+1]-minPrice);
		}
		
		return maxProfit;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int[] sharePrices= {9, 11, 8, 5, 7, 10};
		
		System.out.println(getMaxProfit(sharePrices));
	}
}