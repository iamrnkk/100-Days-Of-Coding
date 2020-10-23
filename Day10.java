// This problem was asked by Uber.
// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// Find the minimum element in O(log N) time. You may assume the array does not contain duplicates.
// For example, given [5, 7, 10, 3, 4], return 3.

public class Day10 {

	// function that searches minimum element in an array
	public int searchMin(int arr[])
	{
		int start=0 , end= arr.length - 1, mid,min;

		// if arr is not rotated then
		// return the zeroth index element(minimum)
		if(arr[start] < arr[end])
		{
			min= arr[start];
			return min;
		}

		// stop the loop when lower limit exceeds upper limit
		while(start<end)
		{
			mid = (start+end)/2;

			// checks if middle index element of current array is minimum
			// ex- [4,5,1,2,3]
			// here mid= (0+4)/2= 2nd element
			// arr[mid-1]= 5 > arr[mid]=1
			if(arr[mid-1] > arr[mid])
				{
				min= arr[mid];
				return min;
				}

			// checks if mid+1 index element of current array is minimum
			// ex-[3,4,5,1,2]
			// here mid= 2nd element
			// arr[mid]= 3 > arr[mid+1]= 1
			else if(arr[mid]> arr[mid+1])
				{
				min= arr[mid+1];
				return min;
				}

			// when mid element is greater then start
			// ex- [3,4,5,6,1,2]
			// arr[mid]= 5 > arr[start]
			// then make the lower limit of current array as mid+1
			// now array will become= [6,1,2]
			// where arr[start]= 6, arr[end]=2
			else if(arr[mid]>arr[start])
				start= mid+1;

			//when start is less thsan middle
			// ex- [7,1,2,3,4,5,6]
			// here mid= 3rd element
			// arr[mid] < arr[start]
			// then make upper limit of current array as mid-1
			// now array will become= [7,1,2]
			// where arr[start]= 7, arr[end]=2
			else
				end=mid-1;
		}
		return -1;
	}

	// Driver code
	public static void main(String args[])
	{
		int arr[] = {4,5,6,7,3};
		Day10 ob= new Day10();
		System.out.println(ob.searchMin(arr));
		}

}
