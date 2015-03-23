package number;

import java.util.Stack;

public class ExpressionEvaluate {

    public static double eval(String expr) {
	Stack<Double> nums = new Stack<Double>();
	Stack<Character> ops = new Stack<Character>();

	for (int i = 0; i < expr.length(); i++) {
	    char c = expr.charAt(i);
	    if (c >= '0' && c <= '9') {
		nums.push((double) (c - '0'));
	    } else {
		if (c == ')') {
		    while (ops.peek() != '(') {
			calc_one(nums, ops);
		    }
		} else if (c == '(') {
		    ops.push(c);
		} else {
		    while (!ops.empty()
			    && get_level(c) <= get_level(ops.peek())) {
			calc_one(nums, ops);
		    }
		}
	    }
	}
	while (!ops.empty()) {
	    calc_one(nums, ops);
	}
	return nums.peek();
    }

    public static void calc_one(Stack<Double> nums, Stack<Character> ops) {

    }

    public static int get_level(char c) {
	return 0;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
