package LeetCode;

import java.util.ArrayList;

public class GenerateParenthesis {

    // pass both
    public ArrayList<String> generateParenthesis(int n) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<String> result = new ArrayList<String>();
	String s = "";
	generate(n, 0, 0, s, result);

	return result;
    }

    public void generate(int n, int open, int close, String s,
	    ArrayList<String> result) {
	if (close == n) {
	    result.add(s);
	    return;
	}

	if (open < n) {
	    generate(n, open + 1, close, s + "(", result);
	}
	if (close < open) {
	    generate(n, open, close + 1, s + ")", result);
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	GenerateParenthesis g = new GenerateParenthesis();

	System.out.println(g.generateParenthesis(3).toString());
    }

}
