// Given an array of integers, write a function to determine whether the array could become non-decreasing by modifying at most 1 element.

// For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.

// Given the array [10, 5, 1], you should return false, since we can't modify any one element to get a non-decreasing array.

public class Day77 
{
	public static boolean checkPossibility(int[] nums) 
    {
      int count=0;
        
        for(int i= 1; i<nums.length; i++)
        {
            if(nums[i-1] > nums[i]) 
            {   
                count++;
                
                if(count>1) return false;
                
                // if sequence is like [2,6,4] (nums[0]< nums[2])
                // then simply change the number at current index-1 [2,4,4]
                if(i==1 || nums[i-2] <= nums[i] )
                    nums[i-1]= nums[i];
                
                // if sequence is like [4,6,2] (nums[0]> nums[2])
                // then simply change the number at current index [4,6,6]
                else
                    nums[i]=nums[i-1];
            }
        }
        
        return true;
    }
	
	// Driver Code
	public static void main (String args[])
	{
		int nums[] = {10, 5, 7};
		
		System.out.println(checkPossibility(nums));
	}
}