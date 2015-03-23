package LeetCode;

import java.util.ArrayList;

public class PascalTriangle {
    // pass both
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
	// Start typing your C/C++ solution below
	// DO NOT write int main() function
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	if (numRows < 1)
	    return result;
	ArrayList<Integer> start = new ArrayList<Integer>();
	start.add(1);
	result.add(start);// first row (result[0])

	for (int i = 1; i < numRows; i++) {
	    ArrayList<Integer> pre = result.get(i - 1);
	    ArrayList<Integer> vec = new ArrayList<Integer>();
	    vec.add(1);
	    for (int j = 1; j < i; j++) {
		int temp = pre.get(j - 1) + pre.get(j);
		vec.add(temp);
	    }
	    vec.add(1);
	    result.add(vec);
	}
	return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
