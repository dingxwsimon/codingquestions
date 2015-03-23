package dynamic;

public class LongestPalindromicSubsequence {
    int lps(char[] str) {
	int n = str.length;
	int i, j, cl;
	int[][] L = new int[n][n]; // Create a table to store results of
				   // subproblems

	// Strings of length 1 are palindrome of lentgh 1
	for (i = 0; i < n; i++)
	    L[i][i] = 1;

	// Build the table. Note that the lower diagonal values of table are
	// useless and not filled in the process. The values are filled in a
	// manner similar to Matrix Chain Multiplication DP solution (See
	// http://www.geeksforgeeks.org/archives/15553). cl is length of
	// substring
	for (cl = 2; cl <= n; cl++) {
	    for (i = 0; i < n - cl + 1; i++) {
		j = i + cl - 1;
		if (str[i] == str[j] && cl == 2)
		    L[i][j] = 2;
		else if (str[i] == str[j])
		    L[i][j] = L[i + 1][j - 1] + 2;
		else
		    L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
	    }
	}

	return L[0][n - 1];
    }

    public static int maxLengthPalindrome(int[] values, int i, int j) {
	// check if indexes cross each other
	// return 1 if index overlap for else condition below
	// return 0 if index i<j for condition if below
	if (j <= i)
	    return j - i + 1;
	if (values[i] == values[j])
	    return 2 + maxLengthPalindrome(values, i + 1, j - 1);
	else
	    return Math.max(maxLengthPalindrome(values, i + 1, j),
		    maxLengthPalindrome(values, i, j - 1));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
