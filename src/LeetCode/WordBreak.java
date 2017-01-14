package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public List<String> wordBreak3(String s, Set<String> dict) {
        List<String> ans = new ArrayList<String>();
        if (s == null || s.length() == 0 || dict == null) {
            return ans;
        } else if (!canBreak(s, dict)) {
            return ans;
        }
        helper(ans, "", s, 0, dict);
        return ans;
    }

    private void helper(List<String> ans, String str, String s, int pos,
                        Set<String> dict) {
        int len = s.length();
        if (pos == len) {
            ans.add(str.substring(1));
            return;
        }
        for (int i = pos; i < len; i++) {
            String sub = s.substring(pos, i + 1);
            if (dict.contains(sub)) {
                helper(ans, str + " " + sub, s, i + 1, dict);
            }
        }
    }

    public boolean canBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    // this one output all the results
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by
        // each
        // test case.
        ArrayList<String> result = new ArrayList<String>();
        LinkedList<String> segment = new LinkedList<String>();
        boolean[][] table = new boolean[s.length()][s.length()];
        wordBreak(table, s, dict);// this is initial the table
        if (!table[0][s.length() - 1]) {
            return result;
        }
        recurseAdd(0, s, result, segment, table, dict);
        return result;
    }

    public void recurseAdd(int start, String input, ArrayList<String> result,
                           LinkedList<String> forNow, boolean table[][], Set<String> dict) {
        if (start == input.length()) {
            String newOne = "";
            for (int i = forNow.size() - 1; i >= 0; i--) {
                newOne += forNow.get(i) + " ";
            }
            result.add(newOne.trim());
            return;
        }
        for (int i = 1 + start; i <= input.length(); i++) {
            if (dict.contains(input.substring(start, i))) {// valid
                if (i < input.length()) {
                    if (table[i][input.length() - 1]) {
                        forNow.push(input.substring(start, i)); // push shi
                        // segment into
                        // stack;
                        recurseAdd(i, input, result, forNow, table, dict);
                        forNow.pop();
                    }
                } else {
                    forNow.push(input.substring(start, i)); // push shi segment
                    // into
                    // stack;
                    recurseAdd(i, input, result, forNow, table, dict);
                    forNow.pop();
                }

            }
        }

    }


    // only find whether breaking is possible or not
    public void wordBreak(boolean[][] dp, String s, Set<String> dict) {
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = dict.contains(s.substring(i, i + 1));
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                // boolean[j][j+i]
                if (dict.contains(s.substring(j, j + i + 1)))
                    dp[j][j + i] = true;
                else {
                    for (int k = j; k < j + i; k++) {
                        if (dp[j][k] && dp[k + 1][j + i]) {
                            dp[j][j + i] = true;
                            break;
                        }
                    }
                }
            }
        }
    }

    public boolean wordBreak2(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true; // set first to be true, why?
        // Because we need initial state

        for (int i = 0; i < s.length(); i++) {
            // should continue from match position
            if (!t[i])
                continue;

            for (String a : dict) {
                int len = a.length();
                int end = i + len;
                if (end > s.length())
                    continue;

                if (t[end])
                    continue;

                if (s.substring(i, end).equals(a)) {
                    t[end] = true;
                }
            }
        }

        return t[s.length()];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
