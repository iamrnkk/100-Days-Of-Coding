// Given a string, determine whether any permutation of it is a palindrome.
// For example, carrace should return true, since it can be rearranged to form racecar, which is a palindrome.
// daily should return false, since there's no rearrangement that can form a palindrome.

import java.util.ArrayList;

public class Day23
{
	public static boolean hasPallindromePermutation(String word)
	{
		ArrayList<Character> palindromeChecker = new ArrayList<>();
		
		// traversing string
		for(int i=0; i< word.length();i++)
		{
			// if there is a pair(duplicate) of character in array
			if(palindromeChecker.contains(word.charAt(i)))
				palindromeChecker.remove((Character)word.charAt(i));
			else
				palindromeChecker.add(word.charAt(i));
		}
		
		// if length is even then there will be a pair(duplicate) for each character,
		// if length is odd one character will not have a character
		if( (word.length()%2==0 && palindromeChecker.isEmpty()) || (word.length()%2!=0 && palindromeChecker.size()==1) )
			return true;
		else
			return false;
	}
	
    // Driver code
	public static void main(String args[])
	{
		String word= "carace";
		System.out.println(hasPallindromePermutation(word));
	}
}