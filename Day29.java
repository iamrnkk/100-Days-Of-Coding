// Gray code is a binary code where each successive value differs in only one bit, as well as when wrapping around.
// Gray code is common in hardware so that we don't see temporary spurious values during transitions.
// Given a number of bits n, generate a possible gray code for it.
// For example, for n = 2, one gray code would be [00, 01, 11, 10].

import java.util.ArrayList;

public class Day29
{

	// function that XORs two bits(characters)
	public static char xorCharacters(char a, char b)
		{
		return (a==b)? '0': '1';
		}
	
	// function that converts binary number to gray code
	public static String toGray(String binary)
	{
		if(binary.length() ==1)
			return binary;
		
		String gray ="" +binary.charAt(0);
		
		for(int i= 1; i< binary.length(); i++)
		{
			char a= binary.charAt(i-1);
			char b= binary.charAt(i);
			gray += xorCharacters(a,b);
		}
		
		return gray;
	}
	
	public static ArrayList<String> findGrayCodes(int bits)
	{
		ArrayList<String> grayCodes= new ArrayList<>();
		
		// looping from 0 to total no. total combinations
		for(int i= 0 ; i< Math.pow(bits,bits); i++)
		{
			// convert number to binary
			String binary= Integer.toUnsignedString(i, 2);
			// convert binary to gray code
			String gray= toGray(binary);
			// now add it to arraylist
			grayCodes.add(gray);
		}
		
		return grayCodes;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int bits= 3;
		System.out.println(findGrayCodes(bits));
	}
}