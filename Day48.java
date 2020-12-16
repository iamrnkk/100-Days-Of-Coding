// This problem was asked by Uber.

// A rule looks like this:

// A NE B

// This means this means point A is located northeast of point B.

// A SW C

// means that point A is southwest of C.

// Given a list of rules, check if the sum of the rules validate. For example:

// A N B
// B NE C
// C N A

// does not validate, since A cannot be both north and south of C.

// A NW B
// A N B

// is considered valid.

import java.util.*;

// structure of each vertex in graph
class Vertex
{

	ArrayList<Set<Vertex>> edges = new ArrayList<>();
	char point;
	
	public Vertex(char point)
	{
		this.point= point;
		for(int i=0; i<4; i++)
			edges.add(new HashSet<>());
	}
	
	// optional, but would be useful in debugging
	// (if you use print statements for debugging like me xD)
	@Override
	public String toString() {
	    return this.point+"";
	}
}

public class Day48
{
	static final int N = 0;
	static final int E = 1;
	static final int S = 2;
	static final int W = 3;
	
	static final int[] DIRECTIONS = {N,E,S,W};
	
	static HashMap<Character,Integer> charDirs= new HashMap<>();
	static {
		charDirs.put('N', N);
		charDirs.put('E', E);
		charDirs.put('S', S);
		charDirs.put('W', W);
	}
	
	public static int getOppositeDir(int dir)
	{
		return (dir + 2) % 4;
	}
	
	public static void addEdges(Vertex fromVertex, Vertex toVertex, int dir)
	{
		int oppDir = getOppositeDir(dir);
		
		// if A is N of B then, we have to keep in mind that
		// B is also south of A
		fromVertex.edges.get(dir).add(toVertex);
		toVertex.edges.get(oppDir).add(fromVertex);
		
		// if, A N B
		// and B N C
		// then, this means A N C too 
		// so, we will add edges using this forEach loop
		for(Vertex neighbourVertex: toVertex.edges.get(dir))
		{
			if(neighbourVertex==fromVertex)
				continue;
			fromVertex.edges.get(dir).add(neighbourVertex);
			neighbourVertex.edges.get(oppDir).add(fromVertex);
		}
		
		// if, A N B
		// and C S B (in other words B N C)
		// then, this means A N C too 
		// so we will add edges using this forEach loop
		for(Vertex neighbourVertex: fromVertex.edges.get(oppDir))
		{
			if(neighbourVertex==toVertex)
				continue;
			toVertex.edges.get(dir).add(neighbourVertex);
			neighbourVertex.edges.get(oppDir).add(toVertex);
		}
	}
	
	public static boolean isValidRule(Vertex fromVertex, Vertex toVertex, int dir)
	{
		int oppDir= getOppositeDir(dir);
				
		// if the vertex is already present in opposite direction,
		// if, A N B
		// and A S B   
		// that means that second rule is wrong,
		// since A is already pressent in opposite direction
		if(fromVertex.edges.get(oppDir).contains(toVertex))
			return false;
		
		return true;
	}
	
	public static boolean validateRules(String[] rules)
	{
		HashMap<Character,Vertex> pointsMap= new HashMap<>();
		
		// loop to extract and analyze one rule at a time
		for(String rule: rules)
		{
			// splitting to array to separate and get rules and points easily
			String[] pointsAndDirs= rule.split(" ");
			
			char fromPoint= pointsAndDirs[2].charAt(0);
			char toPoint= pointsAndDirs[0].charAt(0);
			
			if(!pointsMap.containsKey(fromPoint))
			{
				Vertex fromVertex = new Vertex(fromPoint);
				pointsMap.put(fromPoint, fromVertex);
			}
			
			if(!pointsMap.containsKey(toPoint))
			{
				Vertex toVertex = new Vertex(toPoint);
				pointsMap.put(toPoint, toVertex);
			}
			
			Vertex fromVertex= pointsMap.get(fromPoint);
			Vertex toVertex= pointsMap.get(toPoint);
			
			// Since direction can be 0f 1 character and also of two characters(ex NE)
			// further breaking them and analyzing one at a time
			for(char charDir: pointsAndDirs[1].toCharArray())
			{
				int dir = charDirs.get(charDir);
				
				if(!isValidRule(fromVertex, toVertex, dir))
					return false;
				
				addEdges(fromVertex, toVertex, dir);
			}
		}
		
		return true;
		}
	
	// Driver code
	public static void main(String args[])
	{
		String[] rules = {
							"A N B",
							"B NE C",
							"C N A"
						  };
		System.out.println(validateRules(rules));
		}
	}