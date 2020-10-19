// The Sieve of Eratosthenes is an algorithm used to generate all prime numbers smaller than N.
//The method is to take increasingly larger prime numbers, and mark their multiples as composite.
// For example, to find all primes less than 100, we would first mark [4, 6, 8, ...] (multiples of two),
// then [6, 9, 12, ...] (multiples of three), and so on. Once we have done this for all primes less than N,
// the unmarked numbers that remain will be prime.
// Implement this algorithm.

import java.io.*;
import java.util.ArrayList;
public class Day3
{
	static ArrayList<Integer> primes = new ArrayList<>();

	// constructor to initialize every element in an arrayList as 1 (true) except 0th and 1st element
	public Day3(int n)
	{
		for(int i= 0; i < n; i++)
			primes.add(1);
        primes.set(0,0);
		primes.set(1,0);
	}

  // function to check actual prime numbers
	public void checkPrime(int n)
	{
    // looping to acces each element in array
		for (int i=2; i < n; i++)
		{
						// now checking if the current element is a prime number
            if(primes.get(i) == 1)
			{
								// giving prime number its actual value (currently it stores 1)
                primes.set(i,i);

        // looping to find multiples of each prime numbers and make them 0(false)
				for (int j=2; (i*j) < n/2; j++)
					    primes.set((i*j),0);
			}
		}
	}

  //Driver code
	public static void main (String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter limit: ");
		int n = Integer.parseInt(br.readLine());

        Day3 ob = new Day3(n);
        ob.checkPrime(n);

		System.out.println("Prime no's:");
		for (int i=2; i < n; i++)
		{
			if(primes.get(i) != 0)
            {
             System.out.println(primes.get(i));
            }
        }

    }
}
