// This problem was asked by Bloomberg.
// Determine whether there exists a one-to-one character mapping from one string s1 to another s2.
// For example, given s1 = abc and s2 = bcd, return true since we can map a to b, b to c, and c to d.
// Given s1 = foo and s2 = bar, return false since the o cannot map to two characters.


import java.util.HashMap;

public class Day12 {

	// Data structure that stores key value pair
	static HashMap<Character, Character> map = new HashMap<>();

	//function that checks one to one mapping
	static boolean checkMapping(String s1,String s2)
	{
		// if size of strings do not match
		// that means mapping is not one to one
		if(s1.length()!=s2.length())
			return false;

		// loop for accessing each character of both strings
		for(int i= 0; i < s1.length(); i++)
		{
			// putIfAbsent(key,value) method stores key-value pair
			// only if key is not present in HashMap
			// it returns null if there is no similar key present in HashMap
			// and if similar key is present in HashMap,
			// it returns the previously stored value(character)
			Character c = map.putIfAbsent(s1.charAt(i),s2.charAt(i));
			Character c1= map.putIfAbsent(s2.charAt(i),s1.charAt(i));
				
				// when previously mapped character s1 to s2 is not equal to
				// currently mapped characters of s1 and s2
				// then mapping is one to many
				if(c != null && c != s2.charAt(i) && c1 != null && c1 != s1.charAt(i))
					return false;
		}

		// if nothing is returned till now that means mapping is one to one
		return true;
	}

	public static void main(String args[])
	{
		String s1= "foo";
		String s2= "loe";
		System.out.println(checkMapping(s1,s2));
	}

}
