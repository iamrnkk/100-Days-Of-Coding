// This problem was asked by Microsoft.

// A number is considered perfect if its digits sum up to exactly 10.

// Given a positive integer n, return the n-th perfect number.

// For example, given 1, you should return 19. Given 2, you should return 28.

public class Day52 
{
	public static int digitSum(int num)
	{
		int sum=0;
		
		//extracting and adding digits
		while(num!=0)
		{
			sum+= num%10;
			num/=10;
		}
		
		return sum;
	}
	
	public static int findNthPerfect(int n)
	{
		int nthPerfect=18, counter=0;
		
		while(counter<n)
		{
			// increase cointer when encounter a perfect number
			if(digitSum(++nthPerfect) == 10)
				counter++;
		}
		
		return nthPerfect;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int n = 2;
		
		System.out.println(findNthPerfect(n));
	}
}