package LeetCode;

public class RegexMatch {
    // just remember
    public boolean isMatch(String s, String p) {
        char[] str1 = s.toCharArray();
        char[] str2 = p.toCharArray();
        return isMatch(str1, str2, 0, 0);
    }

    public boolean isMatch(char[] str1, char[] str2, int start1, int start2) {
        if (start2 == str2.length)
            return start1 == str1.length;

        // if next is not *
        if (!(start2 < str2.length - 1 && str2[start2 + 1] == '*')) {
            return (start1 < str1.length)
                    && (str1[start1] == str2[start2] || str2[start2] == '.')
                    && isMatch(str1, str2, start1 + 1, start2 + 1);
        }

        // if next is *
        while (start1 < str1.length && start2 < str2.length
                && (str1[start1] == str2[start2] || str2[start2] == '.')) {
            if (isMatch(str1, str2, start1, start2 + 2))
                return true;
            start1++;
        }
        return isMatch(str1, str2, start1, start2 + 2);

    }

    // basically the same idea
    public boolean isMatch1(String s, String p) {
        if (s == null)
            return p == null;
        return m(s, p, 0, 0);
    }

    public boolean m(String s, String p, int i, int j) {
        if (j == p.length())
            return i == s.length();
        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if (i == s.length())
                return false;
            return (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
                    && m(s, p, ++i, ++j);
        }
        while (i < s.length()
                && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))
            if (m(s, p, i++, j + 2))
                return true;
        return m(s, p, i, j + 2);
    }

    // A DP solution: Let D[i,j] = can the sub pattern p[0..j-1] cover the first
    // i
    // characters of s[0...i-1]?
    // pass
    public boolean isMatch2(String s, String p) {
        if (s == null || p == null)
            return false;
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = i > 1 ? dp[i - 2][0] : false;
                if (i < 2)
                    continue;
                if (p.charAt(i - 2) != '.') {
                    for (int j = 1; j <= sLen; j++) {
                        if (dp[i - 1][j]
                                || (i >= 2 && dp[i - 2][j])
                                || (j >= 2 && dp[i][j - 1]
                                && s.charAt(j - 1) == s.charAt(j - 2) && s
                                .charAt(j - 2) == p.charAt(i - 2))) {
                            dp[i][j] = true;
                        }
                    }
                } else {
                    int j = 1;
                    while (j <= sLen && !dp[i - 2][j] && !dp[i - 1][j]) {
                        j++;
                    }
                    for (; j <= sLen; j++) {
                        dp[i][j] = true;
                    }
                }
            } else {
                for (int j = 1; j <= sLen; j++) {
                    if (dp[i - 1][j - 1]
                            && (s.charAt(j - 1) == p.charAt(i - 1) || p
                            .charAt(i - 1) == '.')) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[pLen][sLen];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RegexMatch r = new RegexMatch();
        System.out.println(r.isMatch2("", ".*"));
    }

}
