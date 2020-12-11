// Given a number represented by a list of digits, find the next greater permutation of a number, in terms of lexicographic ordering.
// If there is not greater permutation possible, return the permutation with the lowest value/ordering.

// For example, the list [1,2,3] should return [1,3,2]. The list [1,3,2] should return [2,1,3]. The list [3,2,1] should return [1,2,3].

// Can you perform the operation without allocating extra memory (disregarding the input memory)?


public class Day44 
{
	public static void getNextPermutation(int numbers[])
	{
		// trigger will store the index after which the numbers are to be reversed 
		int trigger= numbers.length-1;
		
		// traversing to find the trigger
		for(int i=numbers.length-2; i>=0;i--)
		{
			if(numbers[i+1]>=numbers[i])
				{
				trigger=i;
				break;
				}
		}
		
		if(trigger >=0)
		{
			int j = numbers.length - 1;
			
	        // finding the next number just larger than numbers[trigger]
			// and then swap them
			while (j >= 0 && numbers[j] <= numbers[trigger]) 
	            j--;
	        swap(numbers,trigger,j);
		}
		
		// now reversing  all the numbers after trigger index
		reverse(numbers,trigger+1,numbers.length-1);
	}
	
	public static void swap(int[] numbers, int a, int b)
	{
		int t= numbers[a];
		numbers[a]= numbers[b];
		numbers[b]=t;
	}
	
	public static void reverse(int[] numbers,int a, int b)
	{
		while(a<b)
			swap(numbers,a++,b--);
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int numbers[]= {1,2,3};
		getNextPermutation(numbers);
		System.out.println(numbers[0]+" "+numbers[1]+" "+numbers[2]);
	}
}