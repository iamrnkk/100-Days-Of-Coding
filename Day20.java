// Given a set of distinct positive integers, find the largest subset such that every pair of elements in the subset (i, j) satisfies either i % j = 0 or j % i = 0.
// For example, given the set [3, 5, 10, 20, 21], you should return [5, 10, 20]. Given [1, 3, 6, 24], return [1, 3, 6, 24].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Day20 {
	
	
	public static ArrayList<Integer> findLargestSubset(int a[])
	{
		// handling special case: when array is empty
		if(a.length == 0)
			return null;
		
		// tempSubArr stores assumed Largest subset
		// MaxSubArr stores actual Largest subset
		ArrayList<Integer> tempSubArr= new ArrayList<>();
		ArrayList<Integer> maxSubArr= new ArrayList<>();
		
		// handling special case : when array has only one element
		if(a.length == 1)
			{ 
			maxSubArr.add(a[0]);
			return maxSubArr;
			}
		
		Arrays.sort(a);
		
		// max will store maximum sum that a subarray of array can have
		// tempMax will store sum of subarray that is assumed to be maximum but not confirmed
		int max=0, tempMax=0;
		
		// checking end corner
		if(a[a.length-1] % a[a.length-2] == 0)
			{
			tempMax= a[a.length-1];
			tempSubArr.add(a[a.length-1]); 
			}

		// loop for traversing a[]
		for(int i=a.length-2; i > 0; i--)
		{
			// if assumed maximum doesn't contain all divisible numbers
			// we can reset the tempMax to 0 and tempSubArr to null and start storing sum and next subarray.
			if(a[i] % a[i-1] !=0 && a[i+1]% a[i] !=0)
			{
				tempMax=0;
				tempSubArr.clear();
			}
			
			else
				{
				// add elements in tempSubArr and sum in tempMax
				tempMax= tempMax + a[i];
				tempSubArr.add(a[i]);
				}

			// if assumed max sum is greater than actual max sum
			if(max < tempMax)
				{
				maxSubArr.clear();
				maxSubArr.addAll(tempSubArr);
				}
		}
		
		// checking start corner
		if(a[1] % a[0] == 0)
			{
			tempMax= tempMax + a[0];
			tempSubArr.add(a[0]);
			}
		
		if(max < tempMax)
		{
			maxSubArr.clear();
			maxSubArr.addAll(tempSubArr);
		}
		
		Collections.reverse(maxSubArr);

		return maxSubArr;
	}
	
	public static void main(String args[])
	{
		int a[]= {1, 3, 6, 24};
		System.out.println(findLargestSubset(a));
	}
}