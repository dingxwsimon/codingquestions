package LeetCode;

import java.util.Stack;

public class MaximalRectangle {
    // pass both
    public static int maximalRectangle(char[][] matrix) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int m = matrix.length;
	if (m == 0)
	    return 0;
	int n = matrix[0].length;
	if (n == 0)
	    return 0;
	int maxrec = 0;
	int[] height = new int[n];
	for (int i = 0; i < m; i++) {

	    for (int j = 0; j < n; j++) {
		if (matrix[i][j] == '1')
		    height[j]++;
		else
		    height[j] = 0;
	    }
	    int tmp = largestRectangleArea(height);
	    if (maxrec < tmp)
		maxrec = tmp;
	}
	return maxrec;

    }

    // this is the same method of largest rectangle in histogram
    public static int largestRectangleArea(int[] height) {
	Stack<Integer> p = new Stack<Integer>();
	int i = 0, m = 0;
	int n = height.length;
	if (n < 1)
	    return 0;
	int[] h = new int[n + 1];
	for (int j = 0; j < n; j++)
	    h[j] = height[j];
	h[n] = 0;

	while (i < h.length) {
	    if (p.empty() || h[p.peek()] <= h[i])
		p.push(i++);
	    else {
		int t = p.pop();
		m = Math.max(m, h[t] * (p.empty() ? i : i - p.peek() - 1));
	    }
	}
	return m;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
    }

}
