// This problem was asked by Facebook.

// Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

// For example, given the string "([])[]({})", you should return true.

// Given the string "([)]" or "((()", you should return false.

import java.util.Stack;
import java.util.HashMap;
import java.util.Scanner;
public class Day60 
{
	public static boolean isBalanced(String expression)
	{
		// Maps opening and closing brackets of same type
		HashMap<Character,Character> bracketsMap = new HashMap<>();
		bracketsMap.put(')','(');
		bracketsMap.put('}','{');
		bracketsMap.put(']','[');
		
		// stack that will store all the opening brackets encountered
		// and will be popped out when encountering the closing bracket
		Stack<Character> balanceChecker = new Stack<>();
		
		for(int i=0; i< expression.length(); i++)
		{
			char currBracket= expression.charAt(i);
			
			// when found opening bracket i.e '(', '{', '['
			if(bracketsMap.containsValue(currBracket))
					balanceChecker.push(currBracket);
			
			// when found closing bracket i.e ')', '}', ']'  
			else
			{
				if(balanceChecker.size()==0)
					return false;
				
				// if opening and closing brackets of same type are encountered
				if(balanceChecker.peek()== bracketsMap.get(currBracket))
					balanceChecker.pop();
			}
			
		}
		
		return balanceChecker.size()==0;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter String: ");
		String expression= sc.next();
		
		System.out.println(isBalanced(expression));
		
		sc.close();
	}
}