package LeetCode;

import java.util.TreeSet;

public class WildcardMatching {

    // ETL
    public boolean isMatch(String s, String p) {
	// Start typing your Java solution below
	// DO NOT write main() function

	int i = 0, j = 0;

	// the following is a recursive one, it timed out on large input
	if (p.length() == 0) {
	    return s.length() == 0;
	}
	if (s.length() == 0) {
	    return p.equals("") || allStar(p);
	}

	if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
	    return isMatch(s.substring(1), p.substring(1));
	}

	if (p.charAt(0) == '*') {
	    return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
	}

	return false;
    }

    public boolean allStar(String s) {
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) != '*') {
		return false;
	    }
	}

	return true;
    }

    // passed java version
    // Time: O(|s||p|*log|s|), Space: O(|s|)
    // Time can also optimize to O(|s||p|)
    public boolean isMatch3(String s, String p) {
	// without this optimization, it will fail for large data set
	int plenNoStar = 0;
	for (char c : p.toCharArray())
	    if (c != '*')
		plenNoStar++;
	if (plenNoStar > s.length())
	    return false;

	s = " " + s;
	p = " " + p;
	int slen = s.length();
	int plen = p.length();

	boolean[] dp = new boolean[slen];
	TreeSet<Integer> firstTrueSet = new TreeSet<Integer>();
	firstTrueSet.add(0);
	dp[0] = true;

	boolean allStar = true;
	for (int pi = 1; pi < plen; pi++) {
	    if (p.charAt(pi) != '*')
		allStar = false;
	    for (int si = slen - 1; si >= 0; si--) {
		if (si == 0) {
		    dp[si] = allStar ? true : false;
		} else if (p.charAt(pi) != '*') {
		    if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')
			dp[si] = dp[si - 1];
		    else
			dp[si] = false;
		} else {
		    int firstTruePos = firstTrueSet.isEmpty() ? Integer.MAX_VALUE
			    : firstTrueSet.first();
		    if (si >= firstTruePos)
			dp[si] = true;
		    else
			dp[si] = false;
		}
		if (dp[si])
		    firstTrueSet.add(si);
		else
		    firstTrueSet.remove(si);
	    }
	}
	return dp[slen - 1];
    }

    // should be the correct idea
    public boolean isMatch1(String s, String p) {
	boolean star = false;
	int si = 0;
	int pi = 0;
	int str = 0, pat = 0;
	for (; str < s.length(); str++, pat++) {
	    char pchar = '\0';
	    if (pat < p.length())
		pchar = p.charAt(pat);
	    switch (pchar) {
	    // no matter s.charAt(i) could match
	    case '?':
		break;
	    case '*':
		star = true;
		// ignore *
		si = str;
		pi = pat;
		do {
		    ++pi;
		} while (pi < p.length() && p.charAt(pi) == '*');
		// if after *, p is empty return true
		if (pi >= p.length())
		    return true;
		// start rematching
		str = si - 1;
		pat = pi - 1;
		break;
	    default:
		if (s.charAt(str) != pchar) {
		    // if no * in front
		    if (!star)
			return false;
		    // start from si and (pi after *)
		    ++si;
		    str = si - 1;
		    pat = pi - 1;
		}
		break;
	    }
	}

	while (pat < p.length() && p.charAt(pat) == '*')
	    ++pat;
	return (pat >= p.length());

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	WildcardMatching w = new WildcardMatching();

	System.out.println(w.isMatch1("aa", "a*"));

    }

}
