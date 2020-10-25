// Given a circular array, compute its maximum subarray sum in O(n) time. A subarray can be empty, and in this case the sum is 0.
// For example, given [8, -1, 3, 4], return 15 as we choose the numbers 3, 4, and 8 where the 8 is obtained from wrapping around.
// Given [-4, 5, 1, 0], return 6 as we choose the numbers 5 and 1.


import java.util.ArrayList;

public class Day13
{
	int a[] , totalSum=0;

	public Day13 (int a[])
	{
		this.a = a;
	}

	// function that finds max sum of subarray elements
	// of straight(no wrapping) array using kadane's algorithm
	public int kadane()
	{
		// max will store maximum sum that a subarray of array can have
		// tempMax will store sum of subarray that is assumed to be maximum but not confirmed
		int max=0, tempMax=0;

		// loop for traversing a[]
		for(int i=0; i < a.length; i++)
		{

			tempMax= tempMax + a[i];

			// stores sum of all elements in a[]
			totalSum= totalSum + a[i];

			// if assumed maximum sum of subarray goes lower than 0,
			// then we can safely say that this assumed maximum sum is not maximum sum
			// so, we can reset the tempMax to 0 and start storing sum for next subarray in it.
			if(tempMax<0)
				tempMax=0;

			// if assumed max sum is greater than actual max sum
			if(max < tempMax)
				max=tempMax;

			// inverting the elements of array for the next time
			// as second time, this function will be called for
			// finding sum of subarray of minimum elements
			a[i]=-a[i];
		}

		return max;
	}

	// function that finds max sum of subarray elements of circular array
	public int findMax()
	{
		//when array is empty
		if (a==null)
			return 0;

		// case 1 : if maximum elements subarray does not involve wrapping,
		// then Simply find the max subarray using kadane's algorithm

		// maxStraight will store sum of max elements when there is no wrapping
		int maxStraight = kadane();

		// case 2 : when maximum elements subarray  of circular array involve wrapping
		// Instead of finding max elements subarray , we can find minimum elements subarray
		// and add it to total sum of original array elements.
		//    Total sum of array = sum of maximum elements subarray + sum of minimum elements subarray
		// => sum of maximum elements subarray = Total sum of array - sum of minimum elements subarray
		int arraySum= totalSum;
		int minStraight = kadane();
		int maxCircular = arraySum + minStraight; //since minStraight contains sum of inverted elements - changes to +


		// handling special case: when every element is -ve number in the array
		if(minStraight == arraySum )
			return maxStraight;

		// return the largest sum between wrapping and non wrapping case
		return Math.max(maxStraight, maxCircular);

	}

	// Driver code
	public static void main(String args[])
	{
		int arr[] = {5,6,-1,2,3,-2,4,4};
		Day13 ob = new Day13(arr);

		System.out.println(ob.findMax());
	}
}
