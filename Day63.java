// Given three 32-bit integers x, y, and b, return x if b is 1 and y if b is 0, using only mathematical or bit operations.
// You can assume b can only be 1 or 0.

public class Day63 
{
	public static double getXOrY(int x, int y,int b)
	{
		return x*b + y*(1-b);
	}
	
	public static void main(String args[])
	{
		int x= 4,y=5, b=0;
		
		System.out.println(getXOrY(x,y,b));
	}
}
