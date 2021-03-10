// This problem was asked by Palantir.

// The ancient Egyptians used to express fractions as a sum of several terms where each numerator is one. For example, 4 / 13 can be represented as 1 / 4 + 1 / 18 + 1 / 468.

// Create an algorithm to turn an ordinary fraction a / b, where a < b, into an Egyptian fraction.

import java.util.ArrayList;

// custom data type
class Fraction
{
	int n, d;
	public Fraction(int n, int d)
	{
		this.n= n;
		this.d= d;
	}
	
	@Override
	public String toString() {
		if(d==1)
			return n+"";
	    return n+ "/"+ d ;
	}
}

public class Day89
{
	static ArrayList<Fraction> egyptionFrac= new ArrayList<>();
	public static ArrayList<Fraction> getEgyptionFrac(int n, int d)
	{
		
		
		if(d==0 || n==0)
			return egyptionFrac;

        else if(d % n == 0)
		{
			egyptionFrac.add(new Fraction(1, d/n));
			return egyptionFrac;
		}

		else if(n > d)
		{
			egyptionFrac.add(new Fraction(n/d,1));
			egyptionFrac.add(new Fraction(n%d,d));
			return egyptionFrac;
		}

		 int x= d/n +1;
			egyptionFrac.add(new Fraction(1, x));
			
			
		return getEgyptionFrac(n*x-d, d*x);
		
	}
	
	public static void main(String args[])
	{
		ArrayList<Fraction> egyptFrac = getEgyptionFrac(6,14);
		
		System.out.println(egyptFrac);
	}
}