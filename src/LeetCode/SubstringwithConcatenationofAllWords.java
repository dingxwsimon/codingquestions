package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubstringwithConcatenationofAllWords {
    // You are given a string, S, and a list of words, L, that are all of the
    // same length.
    // Find all starting indices of substring(s) in S that is a concatenation of
    // each word
    // in L exactly once and without any intervening characters.

    public static ArrayList<Integer> findSubstring2(String S, String[] L) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<Integer> ans = new ArrayList<Integer>();
	HashMap<String, Integer> ids = new HashMap<String, Integer>();
	int m = S.length();
	int n = L.length;
	int len = L[0].length();
	int[] need = new int[n];
	for (int i = 0; i < n; i++) {
	    if (!ids.containsKey(L[i]))
		ids.put(L[i], i);
	    need[ids.get(L[i])]++;
	}

	int[] s = new int[m];
	for (int i = 0; i < m; i++) {
	    s[i] = -1;// there is a word in L that can be found start from s[i]
	}
	for (int i = 0; i < m - len + 1; ++i) {
	    String sub = S.substring(i, i + len);
	    if (ids.containsKey(sub)) {
		s[i] = ids.get(sub);
	    }
	}
	for (int offset = 0; offset < len; offset++) {
	    int[] found = new int[n];
	    int count = 0, begin = offset;
	    for (int i = offset; i < m - len + 1; i += len) {
		if (s[i] < 0) {
		    begin = i + len;
		    count = 0;
		    found = new int[n];
		} else {
		    int id = s[i];
		    found[id]++;
		    if (need[id] > 0 && found[id] <= need[id]) {
			count++;
		    }
		    if (count == n) {
			ans.add(begin);
		    }
		    if ((i - begin) / len + 1 == n) {
			id = s[begin];
			if (need[id] > 0 && need[id] == found[id]) {
			    count--;
			}
			found[id]--;
			begin += len;
		    }
		}
	    }
	}
	return ans;
    }

    // pass both O(NL)
    public static ArrayList<Integer> findSubstring1(String S, String[] L) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<Integer> ans = new ArrayList<Integer>();
	HashMap<String, Integer> need = new HashMap<String, Integer>();
	HashMap<String, Integer> found = new HashMap<String, Integer>();
	for (String l : L) {
	    if (need.get(l) == null)
		need.put(l, 1);
	    else
		need.put(l, need.get(l) + 1);
	}
	int l = L[0].length();
	int n = L.length;
	loop: for (int i = 0; i < S.length() - l * n + 1; i++) {
	    String sub = S.substring(i, i + l);
	    // if L has this sub
	    if (need.get(sub) != null) {
		found.clear();
		found.put(sub, 1);
		// if i is the answer
		// then i + n * L should contain all L
		for (int j = 1; j < n; j++) {
		    int s = i + j * l;
		    sub = S.substring(s, s + l);

		    if (found.get(sub) == null)
			found.put(sub, 1);
		    else
			found.put(sub, found.get(sub) + 1);

		    Integer toFind = need.get(sub);
		    if (toFind == null)
			continue loop;

		    Integer foundVal = found.get(sub);

		    if (foundVal > toFind)
			continue loop;
		    found.put(sub, foundVal);
		}
		ans.add(i);
	    }

	}
	return ans;
    }

    // there exist linear algorithm

    // pass both take longer time?
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
	// Start typing your Java solution below
	// DO NOT write main() function

	ArrayList<Integer> ret = new ArrayList<Integer>();
	if (L.length == 0) {
	    return ret;
	}

	// I will create another string array without the duplcates
	ArrayList<String> l = new ArrayList<String>();
	ArrayList<Integer> c = new ArrayList<Integer>();

	Arrays.sort(L);
	for (int i = 0; i < L.length; i++) {
	    l.add(L[i]);
	    int count = 1;
	    while (i + 1 < L.length && L[i].equals(L[i + 1])) {
		i++;
		count++;
	    }
	    c.add(count);
	}

	int[] starts = new int[S.length()];

	for (int i = 0; i < S.length(); i++) {
	    starts[i] = -1;
	    for (int j = 0; j < l.size(); j++) {
		if (S.substring(i).startsWith(l.get(j))) {
		    starts[i] = j;
		}
	    }
	}

	int step = L[0].length();

	for (int i = 0; i <= S.length() - step * L.length; i++) {
	    int[] perm = new int[L.length];
	    boolean needTest = true;
	    for (int j = 0; j < L.length; j++) {
		perm[j] = starts[i + j * step];
		if (perm[j] == -1) {
		    needTest = false;
		}
	    }
	    if (needTest && testPerm(perm, c)) {
		ret.add(i);
	    }
	}

	return ret;
    }

    private static boolean testPerm(int[] perm, ArrayList<Integer> c) {
	int[] count = new int[c.size()];
	for (int i = 0; i < count.length; i++) {
	    count[i] = 0;
	}

	for (int i = 0; i < perm.length; i++) {
	    count[perm[i]]++;
	}

	for (int i = 0; i < count.length; i++) {
	    if (count[i] != c.get(i)) {
		return false;
	    }
	}

	return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
	String[] L = { "fooo", "barr", "wing", "ding", "wing" };
	System.out.println(findSubstring2(s, L));
    }

}
