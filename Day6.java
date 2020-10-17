// This problem was asked by Stripe.
// Given a collection of intervals,
// find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
// Intervals can "touch", such as [0, 1] and [1, 2], but they won't be considered overlapping.
// For example, given the intervals (7, 9), (2, 4), (5, 8),
// return 1 as the last interval can be removed and the first two won't overlap.
// The intervals are not necessarily sorted in any order.

import java.util.Comparator;
import java.util.Arrays;

class IntervalComparator implements Comparator <Interval>
{
	//overriding method to sort the intervals in array
	public int compare(Interval a , Interval b)
	{
		// when end interval of two intervals are same,
		// then put the one with higher start interval first
		// ex- a = [1,3] b = [2,3]
		// after comparing = [ [2,3],[1,3] ]
		//(this part is optional)
		if (a.end==b.end)
			return b.start-a.start;

		// when end intervals are not same,
		// then put the one with lower end interval first
		// ex- a= [1,2] b = [2,5]
		// after comparing = [ [1,2],[2,5] ]
		return a.end-b.end;
	}
}

// custom data type
class Interval {

	int start,end;

	Interval(int arr[])
	{
		start= arr[0];
		end= arr[1];
	}

}

public class Day6 {

	public static int countOverlaps(Interval intervals[]) {

		// sorting according to preference
		Arrays.sort(intervals, new IntervalComparator());

		int currentEndInterval= intervals[0].end;
		int nextStartInterval= intervals[1].start;
		int overlaps= 0; // acts as a counter

		// loop for traversing Intervals
		for(int i= 1; i < intervals.length-1; i++)
		{
			// when intervals are overlapping
			// ex- [[1,3],[2,3]]
			// here currentEndInterval= 3 & nextStartInterval= 2
			// this is condition for overlap so,
			// add 1 to counter variable overlap
			if(nextStartInterval < currentEndInterval)
				overlaps++;

			// update values for next Iteration
			currentEndInterval= intervals[i].end;
			nextStartInterval= intervals[i+1].start;
		}

		//returns no. of overlaps encountered
		return overlaps;
	}

	//Driver code
	public static void main(String args[])
	{
		int arr [][]= {{1,2},{2,3},{3,4},{1,3}};

		Interval intervals[] = {
				new Interval(arr[0]),
				new Interval(arr[1]),
				new Interval(arr[2]),
				new Interval(arr[3])
				};

		System.out.println(countOverlaps(intervals));
	}

}
