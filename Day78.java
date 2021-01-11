// This question was asked by Google.

// Given an integer n and a list of integers l,
// write a function that randomly generates a number from 0 to n-1 that isn't in l (uniform).

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day78
{
	public static List<Integer> exclude(int n, List<Integer> l)
	{
		List<Integer> nums = IntStream.rangeClosed(0,n-1).boxed().collect(Collectors.toList());
		nums.removeAll(l);
		
		return nums;
	}
	
	public static int getRandom(int n, List<Integer> l)
	{
		List<Integer> nums= exclude(n,l);
		
		Random r= new Random();
		int randIdx= r.nextInt(nums.size());
		
		return  nums.get(randIdx);
	}
	
	public static void main(String args[])
	{
		List<Integer> l = List.of(3,5,8);
		
		System.out.println(getRandom(11,l));
	}
}