package LeetCode;

public class MinPathSum {
    // pass both
    public int minPathSum(int[][] grid) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int m = grid.length;
	if (m == 0)
	    return -1;
	int n = grid[0].length;
	if (n == 0)
	    return -1;
	int[][] res = new int[m][n];
	res[0][0] = grid[0][0];
	for (int i = 1; i < m; i++) {
	    res[i][0] = res[i - 1][0] + grid[i][0];
	}

	for (int j = 1; j < n; j++) {
	    res[0][j] = res[0][j - 1] + grid[0][j];
	}

	for (int i = 1; i < m; i++) {
	    for (int j = 1; j < n; j++) {
		res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
	    }
	}

	return res[m - 1][n - 1];

    }

    public int minPathSum1(int[][] grid) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int m = grid[0].length;
	int n = grid.length;

	for (int i = n - 2; i >= 0; i--) {
	    grid[i][m - 1] += grid[i + 1][m - 1];
	}
	for (int i = m - 2; i >= 0; i--) {
	    grid[n - 1][i] += grid[n - 1][i + 1];
	}

	for (int j = m - 2; j >= 0; j--) {
	    for (int i = n - 2; i >= 0; i--) {
		grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
	    }
	}

	return grid[0][0];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	MinPathSum m = new MinPathSum();
	System.out.println(m.minPathSum(new int[][] { { 1, 2 }, { 5, 6 },
		{ 1, 1 } }));
    }

}
