// This problem was asked by Microsoft.

// Given a 2D matrix of characters and a target word, 
// write a function that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.

// For example, given the following matrix:

// [['F', 'A', 'C', 'I'],
//  ['O', 'B', 'Q', 'P'],
//  ['A', 'N', 'O', 'B'],
//  ['M', 'A', 'S', 'S']]

// and the target word 'FOAM', you should return true, since it's the leftmost column.
// Similarly, given the target word 'MASS', you should return true, since it's the last row.

public class Day50 
{
	public static boolean isFound(char[][] matrix,String query)
	{
		
		char[] word= query.toCharArray();
		
		int rowLen= matrix.length;
		int colLen= matrix[0].length;
		int wordLen= word.length;
		
		boolean found=true;
		
		// traversing matrix
		for(int i= 0; i< rowLen; i++)
		{
			for(int j= 0; j< colLen; j++)
			{
				// when found the first letter of the word
				// checking horizontally if the word matches
				if(word[0] == matrix[i][j] && colLen-j>=wordLen)
				{
					found=true;
					
					for(int k=j,l=0; k< colLen && l<wordLen; k++, l++)
					{
						// if word does not match
						if(matrix[i][k]!= word[l])
							{
							found=false;
							break;
							}
					}
					
					if(found)
						return true;
				}
				
				// when found the first letter of word
				// checking vertically if the word matches
				if(word[0] == matrix[i][j] && rowLen-i>=wordLen)
				{
					found= true;
					for(int k=i,l=0; k< colLen && l< wordLen; k++, l++)
					{
						// if word does not match
						if(matrix[k][j]!=word[l])
							{
							found=false;
							break;
							}
					}
					
					if(found)
						return true;
				}
			}
		}
		
		return false;
	}
	
	
	// Driver Code
	public static void main(String args[])
	{
		char[][] matrix= {
				{'F', 'A', 'C', 'I'},
				{'O', 'B', 'Q', 'P'},
				{'A', 'N', 'O', 'B'},
				{'M', 'A', 'S', 'S'} };
		String query= "FOAM";
		System.out.println(isFound(matrix,query));
	}
}