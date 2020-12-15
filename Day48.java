import java.util.*;
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
		
		fromVertex.edges.get(dir).add(toVertex);
		toVertex.edges.get(oppDir).add(fromVertex);
		
		for(int refDir: DIRECTIONS)
		{
			if(refDir == dir)
				continue;
			
			for(Vertex neighbourDirVertex: fromVertex.edges.get(refDir))
			{
				if(neighbourDirVertex == toVertex)
					continue;
				
				neighbourDirVertex.edges.get(dir).add(toVertex);
				toVertex.edges.get(oppDir).add(neighbourDirVertex);
			}
		}
	}
	
	public static boolean isValidRule(Vertex fromVertex, Vertex toVertex, int dir)
	{
		int oppDir= getOppositeDir(dir);
		System.out.println(dir);
		System.out.println(fromVertex.edges.get(oppDir));
		if(fromVertex.edges.get(oppDir).contains(toVertex))
			return false;
		
		return true;
	}
	
	public static boolean validateRules(String[] rules)
	{
		HashMap<Character,Vertex> pointsMap= new HashMap<>();
		
		for(String rule: rules)
		{
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
			
			for(char charDir: pointsAndDirs[1].toCharArray())
			{
				System.out.println(charDir+" "+charDirs);
				int dir = charDirs.get(charDir);
				
				if(!isValidRule(fromVertex, toVertex, dir))
					return false;
				
				addEdges(fromVertex, toVertex, dir);
			}
		}
		
		return true;
		}
	
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