// This problem was asked by Snapchat.

// Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.

// The input list is not necessarily ordered in any way.

// For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Interval
{
	int start, end;

	public Interval(int start,int end)
	{
		this.start= start;
		this.end= end;
	}

	@Override
	public String toString() {
	    return "(" + this.start + ", " + this.end + ")";
	}
}

class IntervalComparator implements Comparator <Interval>
{
	@Override
	public int compare(Interval a , Interval b)
	{
		// when end interval of two intervals are same,
		// then put the one with smaller start interval first
		// ex- a = [2,3] b = [1,3]
		// after comparing = [ [1,3],[2,3] ]
		return a.start-b.start;
	}
}

public class Day56 
{

	public static ArrayList<Interval> mergeIntervals(Interval[] intervals)
	{
		Arrays.sort(intervals, new IntervalComparator());

		Interval currentInterval= intervals[0];
		Interval nextInterval= intervals[1];

		ArrayList<Interval> mergedIntervals= new ArrayList<>();
		mergedIntervals.add(intervals[0]);

		for(int i = 1; i< intervals.length; i++)
		{
			// when encountered overlapping Intervals
			// ex-[(4,10) (5,8)]
			// currentInterval.end= 10 , nextInterval.start= 5
			if(nextInterval.start <= currentInterval.end)
			{
				// merging intervals and and updating list
				mergedIntervals.get(mergedIntervals.size()-1).start= Math.min(currentInterval.start, nextInterval.start);
				mergedIntervals.get(mergedIntervals.size()-1).end= Math.max(currentInterval.end, nextInterval.end);
			}
			
			// when non overlapping intervals
			else
				mergedIntervals.add(nextInterval);

			// updating for next iteration
			currentInterval= mergedIntervals.get(mergedIntervals.size()-1);
			if(i+1!= intervals.length)
				nextInterval= intervals[i+1];
		}
		
		return mergedIntervals;
	}
	
	// Driver code
	public static void main(String args[])
	{
		Interval[] intervals= { 
								new Interval(1,3),
								new Interval(5,8),
								new Interval(4,10),
								new Interval(20,25),
								};
		
		System.out.println(mergeIntervals(intervals));
	}
}