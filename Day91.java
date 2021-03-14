// This problem was asked by Facebook.

// Given a string of parentheses, find the balanced string that can be produced from it using the minimum number of insertions and deletions. If there are multiple solutions, return any of them.

// For example, given "(()", you could return "(())". Given "))()(", you could return "()()()()".


public class Day91 
{
	public static String balanceBrackets(String s)
	{
		StringBuffer fixed= new StringBuffer();
		int count= 0;
		
		for(char c: s.toCharArray())
		{
			if(c=='(')
			{
				count++;
				fixed.append('(');
			}
			else
			{
				if(count==0)
					fixed.append('(');
				else
					count--;
				fixed.append(')');
			}
		}
		
		while(count>0)
		{
			fixed.append(')');
			count--;
		}
		
		return fixed.toString();
	}
	
	public static void main(String args[])
	{
		String s="))()(";
		System.out.println(balanceBrackets(s));
	}
}