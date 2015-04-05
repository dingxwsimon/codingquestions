package CrackingCoding;

import java.util.Stack;

public class c3_2 {
    public static class NodeWithMin {
	public int value;
	public int min;

	public NodeWithMin(int v, int min) {
	    value = v;
	    this.min = min;
	}
    }

    public static class StackWithMin extends Stack<NodeWithMin> {
	public void push(int value) {
	    int newMin = Math.min(value, min());
	    super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
	    if (this.isEmpty()) {
		return Integer.MAX_VALUE;
	    } else {
		return peek().min;
	    }
	}
    }

    public static class StackWithMin2 extends Stack<Integer> {
	Stack<Integer> s2;

	public StackWithMin2() {
	    s2 = new Stack<Integer>();
	}

	public void push(int value) {
	    if (value <= min()) {
		s2.push(value);
	    }
	    super.push(value);
	}

	public Integer pop() {
	    int value = super.pop();
	    if (value == min()) {
		s2.pop();
	    }
	    return value;
	}

	public int min() {
	    if (s2.isEmpty()) {
		return Integer.MAX_VALUE;
	    } else {
		return s2.peek();
	    }
	}
    }

    public static void main(String[] args) {
	StackWithMin stack = new StackWithMin();
	StackWithMin2 stack2 = new StackWithMin2();
	for (int i = 0; i < 15; i++) {
	    int value = AssortedMethods.randomIntInRange(0, 100);
	    stack.push(value);
	    stack2.push(value);
	    System.out.print(value + ", ");
	}
	System.out.println('\n');
	for (int i = 0; i < 15; i++) {
	    System.out.println("Popped " + stack.pop().value + ", "
		    + stack2.pop());
	    System.out.println("New min is " + stack.min() + ", "
		    + stack2.min());
	}
    }

}
