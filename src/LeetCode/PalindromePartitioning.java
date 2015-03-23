package LeetCode;

import java.util.ArrayList;

public class PalindromePartitioning {
    // pass both
    ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();

    boolean isPalin(String s, int i, int j) {
	while (i < j) {
	    if (s.charAt(i) != s.charAt(j))
		return false;
	    i++;
	    j--;
	}
	return true;
    }

    void dfs(String s, int level, ArrayList<String> al) {
	if (level == s.length()) {
	    all.add(new ArrayList<String>(al));
	    return;
	}
	for (int i = level + 1; i <= s.length(); i++) {
	    if (isPalin(s, level, i - 1)) {
		al.add(s.substring(level, i));
		dfs(s, i, al);
		al.remove(al.size() - 1);
	    }
	}
    }

    public ArrayList<ArrayList<String>> partition(String s) {
	all.clear();
	ArrayList<String> al = new ArrayList<String>();
	dfs(s, 0, al);
	return all;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	PalindromePartitioning p = new PalindromePartitioning();
	System.out.println(p.partition("amanaplanacanalpanama").toString());
    }

}
