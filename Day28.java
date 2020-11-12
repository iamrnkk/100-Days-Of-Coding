//Given a real number n, find the square root of n. For example, given n = 9, return 3.

public class Day28 {
	
	// according to babylonian method,
	//  N = (N)^1/2 * (N)^1/2 is same as 
	//  N = X * N/X
	//  ex- 16 = 4 * 16/4 = (16)^1/2 * (16)^1/2
	//  for better understanding- https://www.youtube.com/watch?v=CnMBo5nG_zk
	public static Double babylonSquareRoot(double num)
	{
		// square root of negative number is imaginary
        if (num<0)
			return null;
		if (num==0)
			return 0.0;
		
		double guessedNum= num, accuracy= 0.000001;
		
		while(Math.abs(guessedNum-num/guessedNum) > accuracy)
			guessedNum= (guessedNum + num/guessedNum)/2;
		
		return guessedNum;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int num= 18;
		System.out.println(babylonSquareRoot(num));
	}

}