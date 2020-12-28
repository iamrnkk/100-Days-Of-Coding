// This problem was asked by Amazon.

// Run-length encoding is a fast and simple method of encoding strings.
// The basic idea is to represent repeated successive characters as a single count and character.
// For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

// Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
// You can assume the string to be decoded is valid.


public class Day62
{

	public static String encode(String str)
	{
		int currFreq=1;
		String encodedStr="";
		
		for(int i=0; i< str.length(); i++)
		{
			
			// when same characters aren't encountered
			// then add the current current character with its frequency in the encodedStr
			if(i == str.length()-1 || str.charAt(i) != str.charAt(i+1))
			{
				
				encodedStr= encodedStr +currFreq + str.charAt(i);
				currFreq=1;
			}
			
			//if same characters are encountered, then increase frequency 
			else
			{
				currFreq++;
			}
		}
		
		return encodedStr;
	}
	
	public static String decode(String str)
	{
		String decodedStr="";
		
		// since encoded string has the format-
		// [frequency followed by character] 
		// ex "1A"
		// str[i]= 1= freq & str[i+1] = 'A'= character  
		// therefore updating i=i+2
		for(int i=0; i< str.length(); i=i+2)
		{
			
			int currFreq= Integer.parseInt(str.charAt(i)+"");
			decodedStr= decodedStr+ (str.charAt(i+1)+"").repeat(currFreq);
		}
		
		return decodedStr;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		String str= "AAAABBBCCDAA";
		
		String encodedstr= encode(str);
		System.out.println(encodedstr);
		System.out.println(decode(encodedstr));
	}
}