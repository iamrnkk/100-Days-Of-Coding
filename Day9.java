// This problem was asked by Google.
// Given an array of elements, return the length of the longest subarray where all its elements are distinct.
// For example, given the array [5, 1, 3, 5, 2, 3, 4, 1], return 5 as the longest subarray of distinct elements is [5, 2, 3, 4, 1].

import java.util.ArrayList;

public class Day9 {

	//Array that stores non repeating largest sub array
	ArrayList<Integer> subArray = new ArrayList<>();

	//function that adds element in subArray from arr
	public int makeLargestSubArray(int arr[])
	{
		//traversing arr
		for(int i=0; i < arr.length; i++)
		{
			//if subArray does not contain element from arr
			//then only push element to the list
			if(!subArray.contains(arr[i]))
				subArray.add(arr[i]);

		}
		//return length of largest sub array
		return subArray.size();
	}

	//Driver code
	public static void main(String args[])
	{

		int arr[] = {5,5,4,5,2,1,3,4,5};
		Day9 ob = new Day9();
		System.out.println(ob.makeLargestSubArray(arr));

	}
}
