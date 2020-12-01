// You are given a starting state start, a list of transition probabilities for a Markov chain, and a number of steps num_steps.
// Run the Markov chain starting from start for num_steps and compute the number of times we visited each state.

// For example, given the starting state a, number of steps 5000, and the following transition probabilities:

// [
//   ('a', 'a', 0.9),
//   ('a', 'b', 0.075),
//   ('a', 'c', 0.025),
//   ('b', 'a', 0.15),
//   ('b', 'b', 0.8),
//   ('b', 'c', 0.05),
//   ('c', 'a', 0.25),
//   ('c', 'b', 0.25),
//   ('c', 'c', 0.5)
// ]
// One instance of running this Markov chain might produce { 'a': 3012, 'b': 1656, 'c': 332 }.

import java.util.HashMap;
import java.util.Map.Entry;

// non-primitive datatype for storing all the transitions
class Transition
{
	char from, to;
	double probability;
	
	public Transition(char from, char to, double probability)
	{
		this.from= from;
		this.to= to;
		this.probability= probability;
	}
}

public class Day36 
{
	// method to count frequency of characters in randomly generated string
	public static HashMap<Character, Integer> countCharacters(char start, Transition[] transitions, int steps)
	{
		// map that will store current state as key & all the possible next state 
		// along with all prob of going to next state in form of key-value pair as value
		// ex- {a={a=0.9, b=0.075, c=0.025},
		//		b={a=0.15, b=0.8, c=0.05},
		//		c={a=0.25, b=0.25}}
		HashMap<Character, HashMap<Character, Double>> possibleTransitions= new HashMap<Character, HashMap<Character, Double>>();

		// traversing transitions to initialize map possibleTransitions
		for(int i=0;i<transitions.length-1;)
		{
			HashMap<Character, Double> currentTransitions= new HashMap<Character, Double>();

			for(int j=i; j< transitions.length; j++)
			{
				if(transitions[j].from != transitions[i].from || j== transitions.length-1)
					{
					possibleTransitions.put(transitions[i].from,currentTransitions);
					i=j;
					break;
					}
	
				currentTransitions.put(transitions[j].to, transitions[j].probability);
			}
		}

		char current= start;
		HashMap<Character, Integer> counts = new HashMap<Character, Integer>();

		// iterating to count all the characters in randomly generated string
		for(int i=0; i<=steps;i++)
		{
			// if character not present already then count will be 1
			Integer count = counts.putIfAbsent(current, 1);

			// if character present in map then increase frequency by 1
			if(count != null)
				counts.put(current, count+1);

			// getting next randomly generated character character according to probability
			Character nextState= getNextState(current, possibleTransitions.get(current));

			// if there is no further transition
			if(nextState==null)
				break;

			// updating for next iteration 
			current= nextState;
		}

		return counts;
	}

	public static Character getNextState(char current,HashMap<Character,Double> currPossibleTransitions)
	{
		// edge case
		if(currPossibleTransitions==null)
			return null;

		double randomProb = Math.random();

		// iterating to get randomly generated next state according to probability
		for(Entry<Character,Double> possibleTransition: currPossibleTransitions.entrySet())
		{
			double currProb= possibleTransition.getValue();
			randomProb-= currProb;

			if(randomProb <=0)
				return possibleTransition.getKey();
		}

		return null;
	}

    // Driver Code
	public static void main(String[] args)
	{
		Transition[] transitions = {
				new Transition('a', 'a', 0.9),
				new Transition('a', 'b', 0.075),
				new Transition('a', 'c', 0.025),
				new Transition('b', 'a', 0.15),
				new Transition('b', 'b', 0.8),
				new Transition('b', 'c', 0.05),
				new Transition('c', 'a', 0.25),
				new Transition('c', 'b', 0.25),
				new Transition('c', 'c', 0.5)
		};
		
		System.out.println(countCharacters('a',transitions, 2000));

	}
}
