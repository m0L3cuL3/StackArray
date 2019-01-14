/*

	Name: Sean Myko C. Baang
	Section: CC12 - CCB
	Date: 1/11/2019

*/

import java.util.Scanner;
public class StackArray
{
	/* Stack class */
	/* somewhat similar to class Stack */
	static class Stack
	{
		
		int head = -1; // similar to int head = null;
		char arr[] = new char[100];
		
		/* push() function */
		void push(char el)
		{
			if(head == (arr.length - 1))
			{
				System.out.println("Stack is already full!");
			}
			else
			{
				arr[++head] = el; // adds the element to the stack
			}
		}
		
		/* pop() function */
		char pop()
		{
			if(head == -1)
			{
				System.out.println("Stack is already empty!");
				return '0'; // prints 0 if true.
			}
			else
			{
				char el = arr[head];
				--head;
				return el;
			}
		}
		
		/* isEmpty() function */
		boolean isEmpty()
		{
			return (head == -1) ? true : false; // ask if the statement is either true or false;
		}
	}
	
	/* isMatch() function */
	static boolean isMatch(char parent_1, char parent_2)
	{
		if(parent_1 == '(' && parent_2 == ')')
			return true;
		else
			return false;
	}
	
	/* isBalanced() function */
	static boolean isBalanced(String exp)
	{
		Stack stack = new Stack();
		
		/* checking of parentheses */
		for(int i = 0; i < exp.length(); i++)
		{
			/* checks if parenthesis is '(' */
			if(exp.charAt(i) == '(')
			{
				stack.push(exp.charAt(i));
			}
			
			/* checks if parenthesis is ')' */
			if(exp.charAt(i) == ')')
			{
				
				/* if stack is empty */
				if(stack.isEmpty())
				{
					return false;
				}
				
				/* if stack contains pair */
				else if(!isMatch(stack.pop(), exp.charAt(i)))
				{
					return false;
				}
			}
		}
		
		/* checks if stack does not contain closing parenthesis */
		if(stack.isEmpty())
			return true; // balance if true
		else
		{
			return false; // unbalance if false
		}
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter number of cases: ");
		int numExp = in.nextInt();
		String arr[] = new String[numExp];
		
		System.out.println("Enter parentheses: ");
		for(int i = 0; i < numExp; i++)
		{
			String exp = in.next();
			arr[i] = exp;
		}
		
		for(int i = 0; i < numExp; i++)
		{
			System.out.println("Case #" + (i+1) + ": " + isBalanced(arr[i]));
		}
	}
}