package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import LeetCode.InsertInterval.Interval;

public class ScrambleString {
    // good idea, easy to understand
    public boolean isScramble(String s1, String s2) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int n = s1.length();
	if (n == 1) {
	    return s1.equals(s2);
	}
	for (int i = 1; i <= s2.length() / 2; i++) {
	    String x1 = s1.substring(0, i), x2 = s2.substring(0, i), y1 = s1
		    .substring(n - i), y2 = s2.substring(n - i);
	    String a1 = s1.substring(i), a2 = s2.substring(i), b1 = s1
		    .substring(0, n - i), b2 = s2.substring(0, n - i);

	    boolean r1 = isScramble(x1, x2) && isScramble(a1, a2);
	    if (r1)
		return true;
	    boolean r2 = isScramble(x1, y2) && isScramble(a1, b2);
	    if (r2)
		return true;
	    boolean r3 = isScramble(y1, x2) && isScramble(b1, a2);
	    if (r3)
		return true;
	    boolean r4 = isScramble(y1, y2) && isScramble(b1, b2);
	    if (r4)
		return true;
	}

	return false;
    }

    // DP
    // dp[i][j][k] = true if s1 start from i, s2 start from j,
    // the two string which lenght = k are scramble string
    // 1. if they are equal, is true
    // 2. if give a point, their substring
    // is scramble or cross scramble, is true
    public boolean isScramble1(String s1, String s2) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int n = s1.length();
	boolean[][][] dp = new boolean[n][n][n + 1];

	for (int i = n - 1; i >= 0; i--)
	    for (int j = n - 1; j >= 0; j--)
		for (int k = 1; k <= n - Math.max(i, j); k++) {
		    if (s1.substring(i, i + k).equals(s2.substring(j, j + k)))
			dp[i][j][k] = true;
		    else {
			for (int l = 1; l < k; l++) {
			    if (dp[i][j][l] && dp[i + l][j + l][k - l]
				    || dp[i][j + k - l][l]
				    && dp[i + l][j][k - l]) {
				dp[i][j][k] = true;
				break;
			    }
			}
		    }
		}

	return dp[0][0][n];
    }

    /*
     * 1) For each element in indexArr, if it is just smaller than or greater
     * than the one on either of its side, then merge them into an interval. 2)
     * For each interval, we do the same, to see if its head or its tail is just
     * smaller than or greater than its neighbors, if so, merge them
     * accordingly. 3) Once we go through the indexArr once, see if there is
     * just one interval left in indexArr.
     */
    public static Boolean googleScrambleString(String s1, String s2) {
	Stack<Interval> stack1 = new Stack<Interval>(), stack2 = new Stack<Interval>();
	for (int i = 0; i < s1.length(); i++) {
	    int index = s2.indexOf(s1.charAt(i));
	    if (index < 0)
		return false;
	    else
		stack1.push(new Interval(index, index));
	}
	while (stack1.size() > 0) {
	    Interval outInterval = stack1.pop();
	    if (stack2.size() == 0)
		stack2.push(outInterval);
	    else {
		while (stack2.size() > 0
			&& (stack2.peek().start - outInterval.end == 1 || stack2
				.peek().end + 1 == outInterval.start)) {
		    Interval stack2Pop = stack2.pop();
		    outInterval = new Interval(Math.min(stack2Pop.start,
			    outInterval.start), Math.max(stack2Pop.end,
			    outInterval.end));
		}
		stack2.push(outInterval);
	    }
	}
	return stack2.size() == 1;
    }

    public static Boolean googleScrambleStringWithDuplication(String s1,
	    String s2) {
	Stack<String> stack1 = new Stack<String>(), stack2 = new Stack<String>();
	for (int i = 0; i < s2.length(); i++)
	    stack1.push(s2.charAt(i) + "");
	List<String> availableStrList = new ArrayList<String>();
	while (stack1.size() > 0) {
	    availableStrList.add(stack1.pop());
	    List<String> combinedStrList = new ArrayList<String>();
	    // extend the string from Stack2
	    while (stack2.size() > 0) {
		for (String str : availableStrList) {
		    if (s1.contains(str + stack2.peek())
			    && !combinedStrList.contains(str + stack2.peek()))
			combinedStrList.add(str + stack2.peek());
		    if (s1.contains(stack2.peek() + str)
			    && !combinedStrList.contains(stack2.peek() + str))
			combinedStrList.add(stack2.peek() + str);
		}
		if (combinedStrList.size() == 0)
		    break;
		else {
		    stack2.pop();
		    availableStrList = combinedStrList;
		    combinedStrList = new ArrayList<String>();
		}
	    }
	    // When we have multiple candidates
	    while (availableStrList.size() > 1) {
		// checking which one is better by extending from Stack1
		while (stack1.size() > 0) {
		    for (String str : availableStrList) {
			if (s1.contains(str + stack1.peek())
				&& !combinedStrList.contains(str
					+ stack1.peek()))
			    combinedStrList.add(str + stack1.peek());
			if (s1.contains(stack1.peek() + str)
				&& !combinedStrList.contains(stack1.peek()
					+ str))
			    combinedStrList.add(stack1.peek() + str);
		    }
		    if (combinedStrList.size() == 0)
			break;
		    else {
			stack1.pop();
			availableStrList = combinedStrList;
			combinedStrList = new ArrayList<String>();
		    }
		}
	    }
	    stack2.push(availableStrList.get(0));
	    availableStrList = new ArrayList<String>();
	}
	return stack2.size() == 1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	ScrambleString s = new ScrambleString();
	System.out.println(s.googleScrambleStringWithDuplication("aabbbaccd",
		"bcdabacba"));
    }

}
