// This problem was asked by Snapchat.

// Given a string of digits, generate all possible valid IP address combinations.

// IP addresses must follow the format A.B.C.D, where A, B, C, and D are numbers between 0 and 255.
// Zero-prefixed numbers, such as 01 and 065, are not allowed, except for 0 itself.

// For example, given "2542540123", you should return ['254.25.40.123', '254.254.0.123'].

import java.util.ArrayList;

public class Day59
{
	public static void restoreIpAddresses(String s, int[] segmentsOfIp, int currIndex, int segmentOfIpNo, ArrayList<String> ipAddresses)
	{
		// Base case
		// if we reached last segment no. Of ip address  or last index of String s
		if(segmentOfIpNo== 4 || currIndex >= s.length())
			{
				// if both, segment no. and current index of string, are last
				// then ip adress must be valid. So, add it 
				if(segmentOfIpNo==4 && currIndex == s.length())
					ipAddresses.add(segmentsOfIp[0]+"."+segmentsOfIp[1]+"."+segmentsOfIp[2]+"."+segmentsOfIp[3]);
				return;
			}
			
		// looping to choose a segment from string and explore further to choose next segments 
		for(int len=1; len<4 && currIndex+len <= s.length(); len++)
		{
			
			// fetched a segment and stored it
			int segmentOfIp= Integer.parseInt(s.substring(currIndex,currIndex+len));
			
			// checking constraints
			if(segmentOfIp > 255 || len==2 && s.charAt(currIndex)=='0')
				break;
			
			// Choose
			segmentsOfIp[segmentOfIpNo]= segmentOfIp;
			
			// Explore 
			restoreIpAddresses(s,segmentsOfIp, currIndex+len, segmentOfIpNo+1, ipAddresses);
			
			// Unchoose
			segmentsOfIp[segmentOfIpNo]= -1;
		}
			
	}
	
	public static ArrayList<String> getIpAddresses(String s)
	{
		ArrayList<String> ipAddresses= new ArrayList<>();
		
		int[] segmentsOfIp= new int[4];
		
		restoreIpAddresses(s, segmentsOfIp, 0, 0, ipAddresses);
		
		return ipAddresses;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		String s= "2542540123";
		
		System.out.println(getIpAddresses(s));
	}
}