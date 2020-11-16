// This problem was asked by Google.

// The edit distance between two strings refers to the minimum number of 
// character insertions, deletions, and substitutions required to change one string to the other.
// For example, the edit distance between “kitten” and “sitting” is three:
// substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.

// Given two strings, compute the edit distance between them.


public class Day30 
{
	// function that finds minimum of three operations
	public static int min (int insert, int delete, int replace)
	{
		if(insert <= delete && insert <= replace)
			return insert;
		if(delete <= insert && delete <= replace)
			return delete;
		else
			return replace;
	}
	
	public static int findEditDistance(String s1, String s2)
	{
		int l1= s1.length(), l2= s2.length();
		
		// matrix that will store minimum no. of operations needed 
		// to convert each substring s1[i] to s2[j]
		// Note: length is taken l1+1 & l2+1 , since
		// we are considering possibility of empty string
		// i.e at [0][j], s1[0] ="" and at [i][0], s2[0]=""
		int operationsMatrix [][] = new int [l1+1][l2+1];
		
		// i loop is for string s1
		for(int i= 0; i<=l1; i++)
		{
			// j loop is for string s2
			for(int j=0; j<=l2; j++)
			{
				// when s1[i] is empty,
				// min operations will be inserting all characters till s2[j]
				if(i==0)
					operationsMatrix[i][j]= j;
				
				// when s2 is empty,
				// min operations will be removing all characters till s1[i]
				else if(j==0)
					operationsMatrix[i][j]= i;
				
				// if characters are equal then no new operations are needed
				// therefore just copy the count of previous operations
				else if(s1.charAt(i-1)== s2.charAt(j-1))
					operationsMatrix[i][j]= operationsMatrix[i-1][j-1];
				
				else
				{
					// at s1[i+1] we are inserting a character that equals character at s2[j]
					// this means length of string is updated by 1 after insertion and 
					// s1[i] is already at index i-1 since new character is added after it.
					int insert = operationsMatrix[i][j-1];
					
					// we are removing character at position i therefore s1[i-1]
					int delete = operationsMatrix[i-1][j];
					
					// we have replaced s1[i] with s2[j] therefore moving to next indexes of both s1 and s2 
					int replace = operationsMatrix[i-1][j-1];
					
					// since new operation is done therefore 1 is added and 
					// minimum no. of operations of the three is taken in account
					operationsMatrix[i][j]= 1+ min(insert, delete, replace);
				}
				
			}
		}
		
		return operationsMatrix[l1][l2];
	}
	
	// Driver Code
	public static void main(String args[])
	{
		String s1= "kitten", s2="sitting";
		System.out.println(findEditDistance(s1,s2));
	}
}