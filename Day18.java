// This problem was asked by MongoDB.
//
// Given a list of elements, find the majority element, which appears more than half the time (> floor(len(lst) / 2.0)).
// You can assume that such element exists.
// For example, given [1, 2, 1, 1, 3, 4, 0], return 1.

import java.util.HashMap;
public class Day18 {

	public static Integer findMajorityElement(int numbers[])
	{
		// for storing frequency of each integer of numbers[]
		HashMap<Integer,Integer> frequencyMap = new HashMap<>();
		int majorityElement = numbers[0]; // to store integer with max frequency

		for(int i=0; i < numbers.length; i++)
		{
			// putIfAbsent(key,value) method stores key-value pair
		    // only when key is not present in HashMap.
			// it returns null if there is no similar key present in HashMap
			// and if similar key is present in HashMap,
			// it returns the previously stored value of accessed key
			Integer currentFreq= frequencyMap.putIfAbsent(numbers[i],1);

			// if key already existed, then increase the frequency
			if(currentFreq!= null)
				{
				frequencyMap.put(numbers[i],++currentFreq);

				// if current key has max frequency then store it in majorityFreq
				if(frequencyMap.get(majorityElement) < frequencyMap.get(numbers[i]) )
					majorityElement= numbers[i];
				}
			System.out.println(majorityElement);
		}
		System.out.println(frequencyMap);

		// this is optional for the given question as question says
		// "You can assume that such element exists."
		if( frequencyMap.get(majorityElement) > ((numbers.length)/2) )
			return majorityElement;
		else
			return null;
	}

	// Driver code
	public static void main(String args[])
	{
		int numbers[]= {5, 2, 1, 1, 1, 4, 1};
		System.out.println(findMajorityElement(numbers));
	}
}
