package LeetCode;

public class PalindromePartitioning2 {
    // pass both
    // pos(i)(j)=true if s(i)==s(j) && pos(i+1)(j-1)
    // dp(i)=min(1+dp(j+1) if s(i,j) is palindrome, j from i until n)
    public int minCut(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int n = s.length();
	boolean[][] pos = new boolean[n][n];
	int[] dp = new int[n + 1];
	for (int i = 0; i < n + 1; i++) {
	    dp[i] = n - i;
	}

	for (int i = n - 1; i >= 0; i--) {
	    for (int j = i; j < n; j++) {
		if (s.charAt(i) == s.charAt(j)
			&& ((j - i) < 2 || pos[i + 1][j - 1])) {
		    pos[i][j] = true;
		    dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
		}

	    }
	}
	return dp[0] - 1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	PalindromePartitioning2 p = new PalindromePartitioning2();
	System.out.println(p.minCut("cabababcbc"));
    }

}
