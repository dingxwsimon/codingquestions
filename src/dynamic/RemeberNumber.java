package dynamic;

import java.io.PrintWriter;

public class RemeberNumber {
    public static int score(String num) {
	int n = num.length();
	int[] dp = new int[n];
	if (n < 2)
	    return 0;
	dp[0] = 0;
	if (num.charAt(0) == num.charAt(1))
	    dp[1] = 2;
	else
	    dp[1] = 0;
	if (n == 2)
	    return dp[1];
	if (dp[1] == 2) {
	    if (num.charAt(2) == num.charAt(1))
		dp[2] = 2;
	    else
		dp[2] = 1;
	} else {
	    if (num.charAt(2) == num.charAt(1)
		    || num.charAt(2) == num.charAt(0))
		dp[2] = 1;
	    else
		dp[2] = 0;
	}
	for (int i = 3; i < n; i++) {
	    if (num.charAt(i) == num.charAt(i - 1)) {
		if (num.charAt(i) != num.charAt(i - 2))
		    dp[i] = Math.max(dp[i - 2] + 2, dp[i - 3]);
		else {
		    dp[i] = Math.max(dp[i - 3], dp[i - 2]) + 2;
		}
	    } else {
		if (num.charAt(i) != num.charAt(i - 2))
		    dp[i] = Math.max(dp[i - 2], dp[i - 3]);
		else
		    dp[i] = Math.max(dp[i - 2], dp[i - 3] + 1);
	    }

	}
	return dp[n - 1];
    }

    public static void main(String[] args) {
	new RemeberNumber().run("12377788");
	System.out.println(score("12377788"));
    }

    PrintWriter out = null;

    int score(String str, int start, int len) {
	if (len == 2) {
	    if (str.charAt(start) == str.charAt(start + 1))
		return 2;
	} else if (len == 3) {
	    char[] a = str.substring(start, start + 3).toCharArray();
	    if (a[0] == a[1] && a[1] == a[2])
		return 2;
	    else if (a[0] == a[1] || a[0] == a[2] || a[1] == a[2])
		return 1;
	}
	return 0;
    }

    void run(String str) {

	int n = str.length();
	int[] dp = new int[3];

	for (int i = 2; i <= n; i++) {
	    int max = 0;
	    if (i >= 3 && i - 3 != 1)
		max = Math.max(max, score(str, n - i, 3) + dp[(i - 3) % 3]);

	    if (i >= 2 && i - 2 != 1)
		max = Math.max(max, score(str, n - i, 2) + dp[(i - 2) % 3]);

	    dp[i % 3] = max;
	}

	System.out.println(dp[n % 3]);

    }

}
