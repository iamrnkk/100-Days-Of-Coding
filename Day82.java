// This problem was asked by Palantir.

// Write a program that checks whether an integer is a palindrome.
// For example, 121 is a palindrome, as well as 888. 678 is not a palindrome. Do not convert the integer into a string.


public class Day82 
{
	public static boolean isPalindrome(int num)
	{
		int revNum=0;
		
		while(revNum < num)
		{
			revNum= revNum*10 + num/10;
			num/=10;
		}
		
		return revNum == num;
	}
	
	public static void main(String args[])
	{
		int num= 121;
		System.out.println(isPalindrome(num));
	}
}