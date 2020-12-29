// This problem was asked by Google.

// Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.

// Do this faster than the naive method of repeated multiplication.

// For example, pow(2, 10) should return 1024.


public class Day68 
{
	public static long pow(int x, int y)
	{
		if(y==0) return x;
		
		int base=x;
		
		// if -ve power
		if(y<0)
		{
			base= 1/x;
			y=-y;
		}
		
		for(int i=1; i<y/2 ;i++)
			base=base*x*x;
			
		base=base*x;
		
		if(y%2!=0)
			base=base*x;
		
		return base;
	}
	
	public static void main(String args[])
	{
		int x=2,y=10;
		
		System.out.println(pow(x,y));
	}
}