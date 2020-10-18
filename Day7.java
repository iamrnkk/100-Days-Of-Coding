//This problem was asked by Facebook.
//Suppose you are given two lists of n points, one list p1, p2, ..., 
//pn on the line y = 0 and the other list q1, q2, ..., qn on the line y = 1.
//Imagine a set of n line segments connecting each point pi to qi.
//Write an algorithm to determine how many pairs of the line segments intersect.

public class Day7 {
	
	//function for counting pairs of lines that intersect
	public static int countIntersections(int x0[],int x1[])
	{
		//counter variable that stores no. of intersecting pairs
		int intersectingPairs= 0; 
		
		//i loop traverses coordinates of x (x0,x1) at y=0 and y=1
		for(int i= 0 ; i < x0.length; i++)
		{
			//j loop traverses both x0 and x1 again to compare every element in x0 &x1
			for(int j= 0 ; j < x0.length; j++)
			{
				// when point (x0[i],0) of line 1 is before point (x0[j],0) of line 2 and 
				// point (x1[i],1) of line 1 is after point (x1[j],1) of line 2 or vice-versa , 
				// they will intersect.
				// ex- point (1,0) of line 1 is before point (4,0) of line 2 and
				//     point (5,1) of line 1 is after point (2,1) of line 2,
				//     they will surely intersect.
				// 
				//      2     5
				//   (x0[i]) (x0[j])
				//    - - - - - - - y=1
				//       \    /
				//        \  /
				//         \/
				//         /\
				//        /  \
				//       /    \
				//    - - - - - - - y=0
				//	    1      4
				//    (x1[j]) (x1[i])
				
				if( ( x0[i] < x0[j] && x1[i] > x1[j] ) || ( x0[i] > x0[j] && x1[i] < x1[j] ) )
					intersectingPairs++;
			}
		}
		
		// return no. of intersecting pairs
		return intersectingPairs;
	}
	
	//Driver code
	public static void main(String args[]) {
		
		int x0[]= {1,2,3,4,5}; // coordinates of x at y=0
		int x1[]= {5,4,3,2,1}; // coordinates of x at y=1
		
		System.out.println(countIntersections(x0,x1));
	}
}
