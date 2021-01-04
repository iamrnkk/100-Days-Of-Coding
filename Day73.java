// This problem was asked by Microsoft.

// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

// For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.

// Your algorithm should run in O(n) complexity.

import java.util.HashSet;

public class Day73 
{
	public static int getLongestConsecutiveSequence(int numbers[])
	{
		HashSet<Integer> numberSet= new HashSet<>();
		
		// adding all elements to set
		for(int number: numbers)
			numberSet.add(number);
		
		// will keep count of longest consecutive seq
		int longestSeq=0;
		
		for(int i= 0; i<numbers.length; i++)
		{
			// pre-check if the current number is the starting number of sequence
			// i.e if seq= 1 2 3 4
			// then if block will only execute when the numbers[i]=1
			if(!numberSet.contains(numbers[i]-1))
			{
				int currNum= numbers[i];
				int countSeq= 1;
				
				// counting the seq
				while(numberSet.contains(currNum+1))
				{
					countSeq++;
					currNum++;
				}
				
				longestSeq= Math.max(longestSeq, countSeq);
			}
		}
		
		return longestSeq;
	}
	
	public static void main(String args[])
	{
		
		int numbers[]= {100, 4, 200, 1, 3, 2};
		
		System.out.print(getLongestConsecutiveSequence(numbers));
	}
}
