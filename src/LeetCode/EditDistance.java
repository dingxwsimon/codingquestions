package LeetCode;

import array.MaxSumMatrix;

public class EditDistance {

    // pass both
    // very important
    public static int minDistance(String word1, String word2) {
	int m = word1.length();
	int n = word2.length();
	int[][] d = new int[m + 1][n + 1];
	for (int i = 0; i <= m; i++) {
	    d[i][0] = i;
	}
	for (int j = 0; j <= n; j++) {
	    d[0][j] = j;
	}
	for (int j = 1; j <= n; j++) {
	    for (int i = 1; i <= m; i++) {
		if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
		    d[i][j] = d[i - 1][j - 1];
		} else {
		    d[i][j] = min((d[i - 1][j] + 1), (d[i][j - 1] + 1),
			    (d[i - 1][j - 1] + 1));
		}
	    }
	}
	System.out.println(MaxSumMatrix.printMatrix(d));
	return (d[m][n]);
    }

    public static int min(int a, int b, int c) {
	return (Math.min(Math.min(a, b), c));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	System.out.println(minDistance("ABCD", "BCED"));

    }

}
