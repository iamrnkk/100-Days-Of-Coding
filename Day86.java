// This problem was asked by Twitter.

// A permutation can be specified by an array P, where P[i] represents the location of the element at i in the permutation.
// For example, [2, 1, 0] represents the permutation where elements at the index 0 and 2 are swapped.

// Given an array and a permutation, apply the permutation to the array. For example, given the array ["a", "b", "c"] and 
// the permutation [2, 1, 0], return ["c", "b", "a"].

import java.util.HashMap;

public class Day86 
{
	public static void permute(String arr[], int p[])
	{
		HashMap<Integer,String> idxToNum = new HashMap<>();
		
		for(int i=0; i< p.length; i++)
			idxToNum.put(i , arr[i]);
		
		for(int i=0; i < p.length;i++)
		{
			arr[i]= idxToNum.get(p[i]);
		}
	}
	
	public static void main(String args[])
	{
		String arr[]= {"a", "b", "c"};
		int p[]= {2,1,0};
		
		permute(arr, p);
		
		for(int i=0; i < p.length;i++)
			System.out.print(arr[i]+", ");
	}
}