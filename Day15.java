// It was asked by Square.
//
// Given a list of words, return the shortest unique prefix of each word.
//
// For example, given the list:
// [dog, cat, apple, apricot, fish]
// Return the list:
// [d, c, app, apr, f]

// class defines structure of each node in trie
class TrieNode{

	// each node stores adresses of 26 child nodes, as there are 26 alphabets
	TrieNode child[]= new TrieNode[26];
	// a counter that tells how many times the node is visited while inserting new nodes
	int unique;

	// constructor to initialize addresses of each child node as null
	public TrieNode() {
		unique= 1;
		for(int i= 0; i<26; i++ )
			child[i]= null;
	}
}

// class to make trie and prefixes
class Trie{

	TrieNode root;

	// function that inserts new node in trie
	public void insert (String word) {
		TrieNode temp = root;

		// looping to access each alphabet of word
		for(int i=0; i < word.length(); i++ )
		{
			char c= word.charAt(i);
			// if the alphabet is not in trie, then insert it in trie
			if(temp.child[c-'a'] == null)
				temp.child[c-'a']= new TrieNode();

			// if the alphabet is already in trie, increase its frequency
			else
				(temp.child[c-'a'].unique)++;

			// move to next child node
			temp= temp.child[c-'a'];
		}
	}

	// function that makes shortest unique prefix of word
	public String makePrefix(String word)
	{

		TrieNode temp= root;
		// variable that stores prefix
		String prefix="";

		// looping to access each alphabet of word
		for(int i=0; i < word.length(); i++ )
		{
			char c= word.charAt(i);
			prefix= prefix+ c;

			// the lower the frequency, the higher the uniqueness
			// when frequency is 1 that means
			// the alphabets till this node will make unique prefix
			if(temp.child[c-'a'].unique == 1)
				return prefix;

			// move to next child node
			temp= temp.child[c-'a'];
		}

		return prefix;
	}

	// function that finds prefixes of each word in array words
	public String[] findPrefix(String words[])
	{
		// arr that stores prefixes of all the words in arr words
		String prefixes[] = new String[words.length];
		root= new TrieNode();

		// making a trie by inserting alphabets of each word from arr words
		for(int i= 0; i<words.length; i++)
			insert(words[i]);

		// making shortest unique prefixes of each word in arr words
		for(int i= 0; i<words.length; i++)
			prefixes[i]= makePrefix(words[i]);

		return prefixes;
	}
}


public class Day15 {

	// Driver code
	public static void main(String args[]) {

		String words[]= {"dog", "cat", "apple", "apricot", "fish"};

		Trie ob = new Trie();
		String prefixes[] =ob.findPrefix(words);

		for(int i= 0; i<words.length; i++)
		System.out.println(prefixes[i]);
	}
}
