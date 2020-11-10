// Given a set of closed intervals, find the smallest set of numbers that covers all the intervals.
// If there are multiple smallest sets, return any of them.
// For example, given the intervals [0, 3], [2, 6], [3, 4], [6, 9],
// one set of numbers that covers all these intervals is {3, 6}.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// custom data type
class Interval {

	int start,end;

	Interval(int arr[])
	{
		start= arr[0];
		end= arr[1];
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
		// then put the one with higher start interval first
		// ex- a = [2,3] b = [1,3]
		// after comparing = [ [1,3],[2,3] ]

		if (a.end==b.end)
			return a.start-b.start;
		
		// when end interval are not same,
		// then put the one with lower end interval first
		// ex- a= [1,2] b = [2,5]
		// after comparing = [ [1,2],[2,5] ]
		return a.end-b.end;
	}
}

public class Day24 
{
	public boolean isIntersecting(Interval first, Interval second)
	{
		if(first.end >= second.start )
			return true;
		
		return false;
	}
	
	public Interval findShortestInterval(ArrayList<Interval> intersectingIntervals)
	{
		Interval shortestInterval = intersectingIntervals.get(0);
		
		// traverse to find shortest interval
		for(int i=0; i< intersectingIntervals.size();i++)
		{
			shortestInterval.start = Math.max(shortestInterval.start, intersectingIntervals.get(i).start);
			shortestInterval.end = Math.min(shortestInterval.end, intersectingIntervals.get(i).end);
		}
		
		// swapping
		if (shortestInterval.start > shortestInterval.end)
		{
			int t = shortestInterval.start;
			shortestInterval.start= shortestInterval.end;
			shortestInterval.end= t;
		}
		
		return shortestInterval;
	}

	public ArrayList<Interval> findShortestIntervals(Interval intervals[]){

		// Sorting according to preference
        Arrays.sort(intervals, new IntervalComparator());

        ArrayList<Interval> shortestIntervals= new ArrayList<>();
		ArrayList<Interval> intersectingIntervals= new ArrayList<>();

		// handling special case: when array has single element
		if(intervals.length==1) {
			shortestIntervals.add(intervals[0]);
			return shortestIntervals;
		}

		for(int i= 0; i< intervals.length-1;i++)
		{
			// if two consecutive intervals are intersecting/overlapping
			// add them to array that contains all intersecting intervals
			if(isIntersecting(intervals[i],intervals[i+1]))
			{				
				if(!intersectingIntervals.contains(intervals[i]))
					intersectingIntervals.add(intervals[i]);

				intersectingIntervals.add(intervals[i+1]);
			}
			
			// if intervals aren't intersecting,
			// find smallest interval that covers all those intersecting intervals.
			// and clear the intersectingIntervals array for next intersecting intervals
			else
			{
				if(!intersectingIntervals.isEmpty())
					{
					Interval shortestInterval= findShortestInterval(intersectingIntervals);
					shortestIntervals.add(shortestInterval);
					}
				intersectingIntervals.clear();

				// Handling corner case
				if(i==0)
				  {
					shortestIntervals.add(intervals[i]);
					continue;
				  }
				// add non intersecting interval
				shortestIntervals.add(intervals[i+1]);
			}
		}

		// if every interval was intersecting,
		// then else block in iteration must have not executed
		// therefore, we need to find shortest interval then.
		if(shortestIntervals.isEmpty())
			shortestIntervals.add(findShortestInterval(intersectingIntervals));

		return shortestIntervals;
	}
	
	// Driver code
    public static void main(String args[]) 
	{
		int arr [][]= {{0,3},{2,6},{6,9},{3,4},{10,11},{12,14},{13,15}};
		Interval intervals[] = {
				new Interval(arr[0]),
				new Interval(arr[1]),
				new Interval(arr[2]),
				new Interval(arr[3]),
				new Interval(arr[4]),
				new Interval(arr[5]),
				new Interval(arr[6])
				};
		Day24 ob = new Day24();
		ArrayList<Interval> shortestIntervals = ob.findShortestIntervals(intervals);
		System.out.println(shortestIntervals);

	}
}