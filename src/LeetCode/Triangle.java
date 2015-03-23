package LeetCode;

import java.util.ArrayList;

public class Triangle {

    // pass both
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	// Start typing your Java solution below
	// DO NOT write main() function
	for (int i = triangle.size() - 2; i >= 0; i--) {
	    for (int j = 0; j < triangle.get(i).size(); j++) {
		triangle.get(i).set(
			j,
			triangle.get(i).get(j)
				+ Math.min(triangle.get(i + 1).get(j), triangle
					.get(i + 1).get(j + 1)));
	    }
	}
	return triangle.get(0).get(0);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
