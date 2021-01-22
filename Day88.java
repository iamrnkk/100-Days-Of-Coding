// This problem was asked by Dropbox.

// Spreadsheets often use this alphabetical encoding for its columns: "A", "B", "C", ..., "AA", "AB", ..., "ZZ", "AAA", "AAB", ....

// Given a column number, return its alphabetical column id. For example, given 1, return "A". Given 27, return "AA".

public class Day88 
{
	public static String encode(int n)
	{
		String encoded= "";
		
		while(n > 0)
		{
			 int r = n % 26;
			 encoded= (char)(64+ r) + encoded; // converted using ASCII and then added to string
			 n= n/26;
		}
		
		return encoded;
	}
	
	public static void main(String args[])
	{
		System.out.println(encode(1000));
	}
}