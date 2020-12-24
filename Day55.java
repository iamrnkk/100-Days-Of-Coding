// This problem was asked by Google.

// Given a sorted list of integers, square the elements and give the output in sorted order.

// For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].


import java.util.ArrayList;
import java.util.stream.IntStream;

public class Day55 
{
	// function that merges two arrays in ascending order
	public static ArrayList<Integer> merge(int[] left, int [] right)
	{
		ArrayList<Integer> sortedNums= new ArrayList<>();
		
		int lCounter=0, rCounter=0;
		
		// traversing both arrays to get sorted array,
		// till one of it has no elements left to add in sorted array
		while(lCounter< left.length && rCounter < right.length)
		{
			// if left has smaller number
			if(left[lCounter] < right[rCounter])
				sortedNums.add(left[lCounter++]);
			
			// if right has smaller number
			else if(left[lCounter] > right[rCounter])
				sortedNums.add(right[rCounter++]);
			
			// if numbers in left and right are equal
			else
			{
				sortedNums.add(left[lCounter++]);
				sortedNums.add(right[rCounter++]);
			}
		}
		
		// adding remaining elements to sorted array if left
		if(lCounter<left.length)
		{
			for(int i= lCounter; i< left.length; i++)
				sortedNums.add(left[i]);
		}
		if(rCounter<right.length)
		{
			for(int i= rCounter; i< right.length; i++)
				sortedNums.add(left[i]);
		}
		
		return sortedNums;
				
	}
	
	public static ArrayList<Integer> squareAndSort(int[] numbers)
	{
		// finding the index from where positive values start
		int triggerIndex = IntStream.range(0, numbers.length).filter(i -> numbers[i] >= 0).findFirst().getAsInt();
		
		int[] negativeNums= new int[triggerIndex];
		int[] positiveNums= new int[numbers.length-triggerIndex];
		
		// squaring negative nums and adding them in ascending order
		for(int i=0,j=triggerIndex-1; i< triggerIndex; i++,j--)
			negativeNums[i]= numbers[j]*numbers[j];
		
		// squaring positive nums and adding them in ascending order
		for(int i= triggerIndex,j=0; i< numbers.length; i++,j++)
			positiveNums[j]= numbers[i]* numbers[i];
 
		return merge(negativeNums, positiveNums);
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int numbers[]= {-9, -2, 0, 2, 3};
		
		System.out.println(squareAndSort(numbers));
	}
}