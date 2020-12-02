// Given a number in the form of a list of digits, return all possible permutations.

// For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]].

import java.util.ArrayList;

public class Day38 {

	public static ArrayList<ArrayList<Integer>> getPermutations(int numbers[])
	{
		// this will store all the possible permutations
		ArrayList<ArrayList<Integer>> permutations= new ArrayList<>();
		
		boolean visited[]= new boolean[numbers.length];
		
		backtrack(permutations, numbers, new ArrayList<Integer>(), visited);
		
		return permutations;
	}
	
	public static void backtrack(ArrayList<ArrayList<Integer>> permutations,int[] numbers, ArrayList<Integer> currentPermutation, boolean[] visited)
	{
		//base case
		if(currentPermutation.size()== numbers.length)
		{
			permutations.add(new ArrayList<>(currentPermutation));
			return;
		}
		
		
		for(int i=0; i<numbers.length; i++)
		{
			// if the current number from numbers is visited already
			// then move to next iteration
			if(visited[i]== true)
				continue;
			
			currentPermutation.add(numbers[i]);
			visited[i]=true;
			
			// recursive case
			backtrack(permutations, numbers, currentPermutation, visited);
			
			// when currentPermutation has been stored in permutations,
			// then we update it for storing next Permutation
			currentPermutation.remove(currentPermutation.size()-1);
			visited[i]= false;
		}
	}
	
	// Driver code
	public static void main(String args[])
	{
		int[] numbers= {1,2,3};
		System.out.println(getPermutations(numbers));
	}
}