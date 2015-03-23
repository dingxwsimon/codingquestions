package LeetCode;

import java.util.Stack;

public class ValidParenthes {
    // pass both
    public boolean isValid(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function
	Stack<Character> stack = new Stack<Character>();
	if (s == null || s.isEmpty())
	    return true;
	for (int i = 0; i < s.length(); i++) {
	    char cur = s.charAt(i);
	    if (cur == '{' || cur == '[' || cur == '(')
		stack.push(cur);
	    else {
		if (stack.isEmpty())
		    return false;
		if (cur == '}') {
		    if (stack.peek() != '{')
			return false;
		    stack.pop();
		} else if (cur == ')') {
		    if (stack.peek() != '(')
			return false;
		    stack.pop();
		} else if (cur == ']') {
		    if (stack.peek() != '[')
			return false;
		    stack.pop();
		}
	    }
	}
	if (stack.isEmpty())
	    return true;
	else
	    return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
