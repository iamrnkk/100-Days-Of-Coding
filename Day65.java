// This problem was asked by Airbnb.

// Given a list of words, find all pairs of unique indices such that the concatenation of the two words is a palindrome.

// For example, given the list ["code", "edoc", "da", "d"], return [(0, 1), (1, 0), (2, 3)].

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day65 
{
	private static String reverse(String s)
	{
		return new StringBuffer(s).reverse().toString();
	}
	
	public static boolean isPalindrome(String str)
	{
		return str.equalsIgnoreCase(reverse(str));
	}
	
	public static ArrayList<List<Integer>> getPalindromePairs(String[] words)
	{
		// mapping: reversed word of each index to the index
		// ex- ["abc", "cba", "top"]
		// indexMap- ["cba"=0, "abc"=1, "pot"=2]
		HashMap<String, Integer> indexMap= new HashMap<>();
		
		// list will store lists of index of string and index of palindrome string
		ArrayList<List<Integer>> palindromePairs= new ArrayList<>();
		
		// mapping
		for(int i=0; i< words.length; i++)
			indexMap.put(reverse(words[i]), i);
		
		
		for(int i=0; i< words.length; i++)
		{
			String word= words[i];
			
			for(int j=0; j< word.length();j++)
			{
				String prefix= word.substring(0,j);
				String suffix= word.substring(j);
				
				// if prefix is a pallindrome and suffix is the map 
				// ex- word= "aabc", prefix= "aa" (palindrome) suffix= bc
				//     if suffix "bc" is in the map then, pallindrome can be formed 
				//     i.e "cb aa bc"
				if(isPalindrome(prefix) && indexMap.containsKey(suffix))
				{
					int pairIdx= indexMap.get(suffix);
					
					// check for single characters
					if(pairIdx != i)
						palindromePairs.add(List.of(i,pairIdx));
				}
				
				// same applied for prefix
				else if(isPalindrome(suffix) && indexMap.containsKey(prefix))
				{
					int pairIdx= indexMap.get(prefix);
					
					// check for single characters
					if(pairIdx != i)
						palindromePairs.add(List.of(i,pairIdx));
				}
			}
		}
		
		return palindromePairs;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		String words[]= {"code", "edoc", "da", "d"};
		
		System.out.print(getPalindromePairs(words));
	}
}