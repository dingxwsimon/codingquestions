package LeetCode;

import array.MaxSumMatrix;

public class DistinctSubsequences {
    /*
     * Solution: using dynamic programming. Initiating a two dimensional array
     * of m*n, where n and m are the lengths of S and T respectively. An array
     * entry array[i][j] indicate the number of subsequences of the first i
     * characters in T, within the first j characters in S. First, initiating
     * the first line. The if S.charAt(0) and T.charAt(0) is the same, the first
     * entry of array should be 1. Then we look if the first character of T
     * appear again in S. If so, we increment the value of the entry by one. 2.
     * The first column except array[0][0] should all be 0. 3. Then, updating
     * the inside elements. if the ith character of T is the same as the jth
     * character of S, a new match occurs. array[i][j] is calculated by summing
     * up the entry in its left up cell (indicating the condition before
     * handling the current characters in both array) and the entry in its left
     * cell (indicating the matching before introducing the current character in
     * array S). If they are not the same, just copy the number from its left
     * cell, indicating there is no new match. 4. In the end, simply return
     * array[n-1][m-1]. r a b b b i t r 1 1 1 1 1 1 1 a 0 1 1 1 1 1 1 b 0 0 1 2
     * 3 3 3 b 0 0 0 1 3 3 3 i 0 0 0 0 0 3 3 t 0 0 0 0 0 0 3
     */

    // DP f(i,j) = f(i-1,j) + s[i]==t[i] ? f(i-1,j-1) : 0
    // pass both
    public int numDistinct1(String S, String T) {
	int m = S.length();
	int n = T.length();

	if (m == 0 || n == 0)
	    return 0;
	// use dp, set up a two dimensional array to keep the temporal result
	int[][] array = new int[n][m];
	// initiate the result of comparing first characters
	if (S.charAt(0) == T.charAt(0)) {
	    array[0][0] = 1;
	}
	// initiate the first line
	for (int j = 1; j < m; j++) {
	    if (S.charAt(j) == T.charAt(0)) {
		array[0][j] = array[0][j - 1] + 1;
	    } else {
		array[0][j] = array[0][j - 1];
	    }
	}
	// keep going through each character
	// if two characters are same, result is the current number
	// + previous number of matched sequence before this character
	// otherwise, keep the current number
	for (int i = 1; i < n; i++) {
	    for (int j = 1; j < m; j++) {
		if (T.charAt(i) == S.charAt(j)) {
		    array[i][j] = array[i - 1][j - 1] + array[i][j - 1];
		} else {
		    array[i][j] = array[i][j - 1];
		}
	    }
	}
	System.out.println(MaxSumMatrix.printMatrix(array));
	return array[n - 1][m - 1];
    }

    // f(i, j) = f(i - 1, j) + S[i] == T[j]? f(i - 1, j - 1) : 0
    public int numDistinct2(String S, String T) {
	int[][] c = new int[S.length() + 1][T.length() + 1];
	for (int i = 0; i <= S.length(); i++)
	    for (int j = 0; j <= i && j <= T.length(); j++)
		c[i][j] = j == 0 ? 1 : c[i - 1][j]
			+ (S.charAt(i - 1) == T.charAt(j - 1) ? c[i - 1][j - 1]
				: 0);
	return c[S.length()][T.length()];
    }

    // f(i, j) = f(i - 1, j) + S[i] == T[j]? f(i - 1, j - 1) : 0
    // Where f(i, j) is the number of distinct sub-sequence for T[0:j] in
    // S[0:i].
    // We can use O(T) space since the ith-iteration only depends on the i-1th
    // iteration
    // and when we calculate from f(i, j) to f(i, 0) for the ith iteration.
    public int numDistinct(String S, String T) {
	int[] occurence = new int[T.length() + 1];
	occurence[0] = 1;
	for (int i = 0; i < S.length(); i++) {
	    for (int j = T.length() - 1; j >= 0; j--)
		if (S.charAt(i) == T.charAt(j)) {
		    if (occurence[j] > 0)
			occurence[j + 1] += occurence[j];
		}
	}
	return occurence[T.length()];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	DistinctSubsequences d = new DistinctSubsequences();
	System.out.println(d.numDistinct("rabbbit", "rabbit"));
    }

}
