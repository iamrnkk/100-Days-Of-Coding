// This question was asked by ContextLogic.

// Implement division of two positive integers without using the division, multiplication, or modulus operators.
// Return the quotient as an integer, ignoring the remainder.


public class Day67 
{
	public static int divide(int a, int b)
	{
		if(b==0)
			{
			System.out.print("Infinity / Not Defined ");
			return Integer.MAX_VALUE;
			}
		
		if(b>a)
			return 0;
		
		int sign= ((a<0)^(b<0))? -1:1;
		
		int quotient=0;
		
		while(a>=b)
		{
			a-=b;
			quotient++;
		}
		
		return sign*quotient;
	}
	
	public static void main(String args[])
	{
		int a= 10,b=5;
		
		System.out.print(divide(a,b));
	}
}