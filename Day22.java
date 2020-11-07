// Find an efficient algorithm to find the smallest distance (measured in number of words) between any two given words in a string.
// For example, given words "hello", and "world" and a text content of "dog cat hello cat dog dog hello cat world",
// return 1 because there's only one word "cat" in between the two words

public class Day22 {

	public static Integer findShortestDistance(String sentence, String word1, String word2)
	{
		// if any of the strings are empty
		if(sentence == null || word1 == null || word2 == null || sentence.isEmpty() || word1.isEmpty() || word2.isEmpty())
			return null;
		
		String words[]= sentence.split(" ");
		
		Integer fromWord1= null;
		Integer toWord2= null;
		Integer shortestDistance= words.length+1;
		
		// traversing words[]
		for(int i=0; i< words.length; i++)
		{
			if(words[i].equalsIgnoreCase(word1))
				fromWord1 = i;
			else if(words[i].equalsIgnoreCase(word2))
				toWord2 = i;
			
			// when both the words are finally found in words[]
			if(fromWord1 != null && toWord2 != null)
				shortestDistance =Math.min(shortestDistance, Math.abs(fromWord1-toWord2));
		}
		
		// if either or both words aren't found in words[]
		if(shortestDistance == words.length+1)
			return null;
		
		return shortestDistance-1;
	}
	
	// Driver Code
	public static void main (String args[])
	{
		String sentence = "dog cat hello cat dog dog hello cat world";
		System.out.println(findShortestDistance(sentence,"hello", "world"));
	}
	
}