// This problem was asked by Google.
//
// Given a word W and a string S, find all starting indices in S which are anagrams of W.
// For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.

import java.util.ArrayList;
public class Day16 {

	// function that the current substring(window) of s is anagram or not
	public static boolean checkAnagram(int sAlphabetsCount[], int wAlphabetsCount[] )
	{
		boolean isAnagram = true;

		for(int i= 0; i < 26; i++)
		{
			if(sAlphabetsCount[i] != wAlphabetsCount[i])
				isAnagram = false;
		}

		return isAnagram;
	}

	// function that finds and returns all the starting indexes of substrings that are anagram of string w
	public static ArrayList<Integer> findAnagramIndexes(String s, String w){

		ArrayList<Integer> anagramIndexes = new ArrayList<>();

		// stores frequency of each alphabets in strings s & w respectively
		int sAlphabetsCount[] = new int[26];
		int wAlphabetsCount[] = new int[26];
		int window= w.length(); // length of substring to consider for

		// handling special case: when length of s is less than w
		if(s.length() < window)
			return null;

		// looping to initialize frequencies of alphabets for the first substring of s
		// also initializing and fixing frequencies of alphabets in w
		for(int i= 0; i < window; i++)
		{
			(sAlphabetsCount[s.charAt(i)-'a'])++;
			(wAlphabetsCount[w.charAt(i)-'a'])++;
		}

		boolean isAnagram= true;

		// looping to finds anagram substring indexes
		for(int i= window; i<s.length(); i++)
		{

			isAnagram= checkAnagram(sAlphabetsCount,wAlphabetsCount);

			if(isAnagram)
				anagramIndexes.add(i-window);

			// updating frequencies for next substring(window)
			(sAlphabetsCount[s.charAt(i-window)-'a'])--;
			(sAlphabetsCount[s.charAt(i)-'a'])++;
		}

		// for checking anagram in last substring
		isAnagram= checkAnagram(sAlphabetsCount,wAlphabetsCount);
		if(isAnagram)
			anagramIndexes.add(s.length()-window);

		return anagramIndexes;
	}

	// Driver code
	public static void main(String args[])
	{

		String s = "abxaba";
		String w = "ab";

		ArrayList<Integer> anagramIndexes= findAnagramIndexes(s,w);

		System.out.println(anagramIndexes);
	}

}
