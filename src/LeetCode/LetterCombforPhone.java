package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombforPhone {
    public List<String> letterCombinations2(String digits) {
	List<String> ret = new LinkedList<String>();
	if (digits == null) {
	    return ret;
	}
	String[] pad = new String[] { " ", "", "abc", "def", "ghi", "jkl",
		"mno", "pqrs", "tuv", "wxyz" };
	helper(ret, "", pad, digits, 0);
	return ret;
    }

    public void helper(List<String> ret, String cur, String[] pad,
	    String digits, int level) {
	if (level == digits.length()) {
	    ret.add(cur);
	    return;
	}
	for (char c : pad[digits.charAt(level) - '0'].toCharArray()) {
	    helper(ret, cur + c, pad, digits, level + 1);
	}
    }

    public static char c[][] = { { ' ' }, { ' ' }, { 'a', 'b', 'c' },
	    { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
	    { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
	    { 'w', 'x', 'y', 'z' } };

    // DPS easy to remember

    public static ArrayList<String> letterCombinations1(String digits) {
	ArrayList<String> result = new ArrayList<String>();
	helper(digits, result, 0, "");
	return result;
    }

    public static void helper(String digits, ArrayList<String> result,
	    int level, String ret) {
	if (level == digits.length()) {
	    result.add(new String(ret));
	    return;
	}
	char ch = digits.charAt(level);
	for (int i = 0; i < c[ch - '0'].length; i++) {
	    helper(digits, result, level + 1, ret + c[ch - '0'][i]);
	}
    }

    // pass both
    public static ArrayList<String> letterCombinations(String digits) {
	ArrayList<String> result = new ArrayList<String>();

	int n = digits.length();
	int answer[] = new int[n];
	while (true) {
	    String comb = "";
	    for (int i = 0; i < n; i++)
		comb += c[digits.charAt(i) - '0'][answer[i]];
	    result.add(comb);

	    int k = n - 1;
	    while (k >= 0) {
		if (answer[k] < c[digits.charAt(k) - '0'].length - 1) {
		    answer[k]++;
		    break;
		} else {
		    answer[k] = 0;
		    k--;
		}
	    }
	    if (k < 0)
		break;

	}
	return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(letterCombinations("823").toString());
	System.out.println(letterCombinations1("823").toString());
    }

}
