// This problem was asked by Facebook.

// Given an array of integers in which two elements appear exactly once and all other elements appear exactly twice,
// find the two elements that appear only once.

// For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.

// Follow-up: Can you do this in linear time and constant space?

import java.util.ArrayList;
import java.util.HashMap;

public class Day40
{
	public static int[] getUniques(int[] numbers)
	{
		int xorUniques=0;
		int[] uniques= new int[2];
		
		// traversing to find xor of two unique integers
		// ex- arr= {2, 4, 6, 8, 10, 2, 6, 10}
		//     after traversing, xorUniques will have 
		//     xor of 4 and 8 (uniques) i.e 12 (1100)
		for(int i= 0; i<numbers.length; i++)
	    	xorUniques= xorUniques ^ numbers[i];
		
		// ANDing xorUniques and it's 2's compliment to get set(1) bit
		// we are finding set(1) bits because xoring of two different bits gives set(1)
		// and since, xorUniques contained xor of uniques, there must be different bits
		// ex - 1100 ^ 0100 = 1000 (8)
		xorUniques= xorUniques & -xorUniques;

		// traversing again, but this time we can store two different uniques seperately
		for(int i= 0; i<numbers.length; i++)
		{
			// 0100(4) & 1000 = 0000 ==0 (true)
			if((numbers[i] & xorUniques)==0)
				uniques[0]= uniques[0]^numbers[i];
			
			// 1000(8) & 1000 = 1000 !=0 (false) 
			else
				uniques[1]= uniques[1]^numbers[i];	
		}
		return uniques;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int numbers[]= {2, 4, 6, 8, 10, 2, 6, 10};
		
		int[] uniques= getUniques(numbers);
		System.out.println(uniques[0]);
		System.out.println(uniques[1]);
	}
}