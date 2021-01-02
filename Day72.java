// This problem was asked by Google.

// Given two strings A and B, return whether or not A can be shifted some number of times to get B.

// For example, if A is abcde and B is cdeab, return true. If A is abc and B is acb, return false.

public class Day72
{
	public static boolean canBeShifted(String s1, String s2)
	{
		// if either string doesn't exist or strings are unequal,
		// they can't be shifted
		if(s1.length()==0 || s2.length()==0 || s1== null || s2==null || s1.length()!= s2.length())
			return false;
		
		// if string 2 is there when we make the string 1 circular
		// i.e when index 0 starts after last index of string 
		return (s1+s1).contains(s2);
	}
	
	// Driver Code
	public static void main(String args[])
	{
		String s1= "aaabbbccc", s2= "cccaaabbb";
		
		System.out.print(canBeShifted(s1,s2));
	}
}