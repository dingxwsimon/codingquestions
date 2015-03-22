package LeetCode;

import java.util.Stack;

public class MinStack {
    public Stack<Integer> s = new Stack<Integer>();
    public Stack<Integer> min = new Stack<Integer>();

    public void push(int i) {
	s.push(i);
	if (min.isEmpty() || i <= min.peek()) {
	    min.push(i);
	}
    }

    public void pop() {
	int i = s.pop();
	if (min.peek() == i) {
	    min.pop();
	}
    }

    public int top() {
	return s.peek();
    }

    public int getMin() {
	return min.peek();
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
