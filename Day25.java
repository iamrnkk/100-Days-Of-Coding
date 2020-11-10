// You are given an array of length n + 1 whose elements belong to the set {1, 2, ..., n}.
// By the pigeonhole principle, there must be a duplicate. Find it in linear time and space.

import java.util.ArrayList;

public class Day25 
{
	public static Integer findDuplicate(int numbers[])
	{
		ArrayList<Integer> uniqueList= new ArrayList<>();
		Integer duplicate= null;
		
		// traverse to find duplicate
		for (int i= 0; i< numbers.length; i++)
		{
			// if duplicate found
			if(uniqueList.contains(numbers[i]))
				{
					duplicate= numbers[i];
					break;
				}

			uniqueList.add(numbers[i]);
		}
		
		return duplicate;
	}
	
	public static void main(String args[])
	{
		int num[] = {1,2,3,4,5,1};
		System.out.println(findDuplicate(num));
	}
}