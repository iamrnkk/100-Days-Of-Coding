// This problem was asked by Amazon.

// An sorted array of integers was rotated an unknown number of times.

// Given such an array, find the index of the element in the array in faster than linear time.
// If the element doesn't exist in the array, return null.

// For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).

// You can assume all the integers in the array are unique.


public class Day79 
{
	public static Integer binarySearch(int[] nums, int targetNum)
	{
		int start= 0 , end= nums.length-1;
		
		while(start<=end)
		{
			int mid= (start + end)/2;
			
			if(nums[mid]==targetNum) return mid;
			
			// check if all the nums in range are sorted
            // note- you can remove '=' from else if cond,
            //       since arr contains unique nums according to ques
			else if( nums[start] <= nums[mid]) 
			{
				// check if target num lies in the range
				if(nums[start] <= targetNum && nums[mid] > targetNum)
					end= mid-1;

                // else switch to other side
				else
					start= mid+1;
			}
			
			// if first side was unsorted then this side is obviously sorted
			else
			{
				if(nums[mid] < targetNum && nums[end]>= targetNum)
					start= mid+1;
				else
					end= mid-1;
			}
		}
		
		return null;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int nums[]= {13, 18, 25, 2, 8, 10};
		
		System.out.println(binarySearch(nums,8));
	}
}