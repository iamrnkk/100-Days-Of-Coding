// Let X be a set of n intervals on the real line. We say that a set of points P "stabs" X
// if every interval in X contains at least one point in P. Compute the smallest set of points that stabs X.

// For example, given the intervals [(1, 4), (4, 5), (7, 9), (9, 12)], you should return [4, 9].

import java.util.ArrayList;
import java.util.Arrays;


class Interval{
	int start,end;
	
	public Interval(int start, int end)
	{
		this.start= start;
		this.end= end;
	}
}

public class Day83 {
	
	public static ArrayList<Integer> getMinStabs(Interval[] intervals )
	{
		if(intervals==null || intervals.length==0 )
			return null;
		
		// sort in ascending order according to end interval
		Arrays.sort(intervals, (a,b)-> a.end-b.end);
		
		int currEnd= intervals[0].end;
		
		ArrayList<Integer> stabPoints= new ArrayList<>();
		stabPoints.add(currEnd);
		
		if(intervals.length==1)
			return stabPoints;
		
		for(int i=1; i < intervals.length; i++)
		{
			// if encountered a non-overlapping interval w.r.t to previous interval
			if(intervals[i].start > currEnd)
			{
				currEnd=intervals[i].end;
				stabPoints.add(currEnd);
			}
		}
		
		return stabPoints;
	}
	
	public static void main(String args[])
	{
		Interval[] intervals= {
								new Interval(1,4),
								new Interval(4,5),
								new Interval(7,9),
								new Interval(9,12),
							  };
		
		System.out.println(getMinStabs(intervals));
	}
}