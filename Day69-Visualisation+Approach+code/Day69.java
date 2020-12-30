// This problem was asked by Snapchat.

// Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
// find the minimum number of rooms required.

// For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

import java.util.Arrays;
import java.util.PriorityQueue;

// custom data type
class Interval
{
	int startTime, endTime;
	
	public Interval(int start, int end)
	{
		startTime=start;
		endTime= end;
	}
	
	@Override
	public String toString()
	{
		return "("+startTime+", "+endTime+")";
	}
}
public class Day69 
{
	public static int getMinRooms(Interval[] intervals)
	{
		// handling edge cases
		if(intervals.length==0 || intervals==null)
			return 0;
		
		if(intervals.length==1)
			return 1;
		
		// ascending order: according to starting time of lecture
		Arrays.sort(intervals,(a,b)->(a.startTime-b.startTime));
		
		// MinHeap that will store earliest freeable room at the top/root
		PriorityQueue<Interval> ReservedRooms = new PriorityQueue<>((a,b)->(a.startTime-b.startTime));
		ReservedRooms.add(intervals[0]);
		
		for(int i=1; i< intervals.length; i++)
		{
			Interval earliestFreeableRoom= ReservedRooms.peek();
			Interval currentLecture= intervals[i];
			
			// when room can be freed and used for next lecture
			// extend the reservation for the room as new lecture
			// will take place in the same room
			if(earliestFreeableRoom.endTime<= currentLecture.startTime)
				earliestFreeableRoom.endTime=currentLecture.endTime;
			
			// if no room is free for new lecture
			// simply create a new room
			else
				ReservedRooms.add(currentLecture);
		}
		
		return ReservedRooms.size();
	}
	
	// Driver Code
	public static void main(String args[])
	{
		Interval intervals[]= { 
								new Interval(30,75),
								new Interval(0,50),
								new Interval(60,150)
							};
		
		System.out.println(getMinRooms(intervals));
	}
}