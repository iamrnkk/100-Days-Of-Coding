// Given an array and a number k that's smaller than the length of the array, rotate the array to the right k elements in-place.


public class Day87
{
	public static void reverse(int nums[] , int start, int end)
	{
		while(start < end)
		{
			int temp= nums[start];
			nums[start]= nums[end];
			nums[end]= temp;
			
			start++;
			end--;
		}
	}
	
	public static void rotate(int nums[], int k)
	{
		// rotate from x to 3 steps right [if k= 3]
		// [x--o~~] -> [o~~x--] 
		        
		reverse(nums,0,nums.length-1); // [~~o--x]  
		reverse(nums,0, k-1); // [o~~--x]
		reverse(nums,k,nums.length-1); // [o~~x--]
	}
	
	public static void main(String args[])
	{
		int nums[]= {0,1,2,3,4,5};
		
		rotate(nums,3);
		
		for(int num: nums)
			System.out.print(num+" ");
	}
}