import java.util.Stack;
import java.util.HashMap;
public class Day60 
{
	public static boolean isBalanced(String expression)
	{
		HashMap<Character,Character> bracketsMap = new HashMap<>();
		bracketsMap.put(')','(');
		bracketsMap.put('}','{');
		bracketsMap.put(']','[');
		
		Stack<Character> balanceChecker = new Stack<>();
		
		for(int i=0; i< expression.length(); i++)
		{
			if(expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[' )
				balanceChecker.push(expression.charAt(i));
			
			else
			{
				if(balanceChecker.size()==0)
					return false;
				if(balanceChecker.peek()== bracketsMap.get(expression.charAt(i)))
					balanceChecker.pop();
			}
			
		}
		
		return balanceChecker.size()==0;
	}
	
	public static void main(String args[])
	{
		String expression= "{()}";
		
		System.out.println(isBalanced(expression));
	}
	
}