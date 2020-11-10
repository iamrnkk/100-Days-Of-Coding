// This problem was asked by Google.
// You're given a string consisting solely of (, ), and *. * can represent either a (, ), or an empty string.
// Determine whether the parentheses are balanced.
// For example, (()* and (*) are balanced. )*( is not balanced.

public class Day26 
{
	public static boolean isBalanced(String s)
	{
		// counters
		int bracketsOpened=0, bracketsClosed=0;

		for(int i= 0; i< s.length(); i++)
		{
			if(s.charAt(i) == '(')
				{
				bracketsOpened++;
				bracketsClosed++;
				}
			
			else if(s.charAt(i)== ')')
			{
				// checking best possibility and storing it to counter
				bracketsClosed= Math.max(bracketsClosed-1, 0);
				bracketsOpened--;
			}
			else
			{
				// checking best possibility and storing it to counter
				bracketsClosed= Math.max(bracketsClosed-1, 0);
				bracketsOpened++;
			}
		}
		
		if(bracketsOpened < 0)
			return false;
		
		return bracketsClosed==0;
	}
	
	public static void main(String args[])
	{
		String s ="((*))";
		System.out.println(isBalanced(s));
	}
}