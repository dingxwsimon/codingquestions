package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses2(String s) {
	List<String> ans = new LinkedList<String>();
	if (s == null || s.length() == 0) {
	    return ans;
	}
	helper(ans, s, "", 0, 0);
	return ans;
    }

    private void helper(List<String> ans, String s, String path, int pos,
	    int count) {
	if (count == 4) {
	    if (pos == s.length()) {
		ans.add(path.substring(1));
	    }
	    return;
	}
	for (int i = pos; i < s.length(); i++) {
	    if (i - pos >= 3) {
		break;
	    }
	    if (!isValidNum(s.substring(pos, i + 1))) {
		continue;
	    }
	    String newPath = path + "." + s.substring(pos, i + 1);
	    helper(ans, s, newPath, i + 1, count + 1);
	}
    }

    private boolean isValidNum(String str) {
	if (str.length() > 1 && str.charAt(0) == '0') {
	    return false;
	}
	int num = Integer.parseInt(str);
	if (num < 0 || 255 < num) {
	    return false;
	}
	return true;
    }

    // pass both
    public ArrayList<String> restoreIpAddresses(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function

	// Brute force. So sad!
	ArrayList<String> res = new ArrayList<String>();
	if (s.length() > 12 || s.length() < 4) {
	    return res;
	}

	int n = s.length();

	int i = 0;
	for (int j = i + 1; j < n; j++) {
	    for (int k = j + 1; k < n; k++) {
		for (int l = k + 1; l < n; l++) {
		    String a = s.substring(i, j), b = s.substring(j, k), c = s
			    .substring(k, l), d = s.substring(l);
		    if (isValidIp(a, b, c, d)) {
			res.add(a + "." + b + "." + c + "." + d);
		    }
		}
	    }
	}

	return res;
    }

    // REMEMBER
    public boolean isValidIp(String a, String b, String c, String d) {
	boolean lenVal = a.length() < 5 && b.length() < 5 && c.length() < 5
		&& d.length() < 5;
	if (!lenVal) {
	    return false;
	}

	boolean zVal = (a.length() == 1 || a.charAt(0) != '0')
		&& (b.length() == 1 || b.charAt(0) != '0')
		&& (c.length() == 1 || c.charAt(0) != '0')
		&& (d.length() == 1 || d.charAt(0) != '0');

	if (!zVal) {
	    return false;
	}

	int aV = Integer.parseInt(a), bV = Integer.parseInt(b), cV = Integer
		.parseInt(c), dV = Integer.parseInt(d);

	boolean vVal = (aV >> 8) == 0 && (bV >> 8) == 0 && (cV >> 8) == 0
		&& (dV >> 8) == 0;

	return vVal;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	RestoreIPAddresses r = new RestoreIPAddresses();
	System.out.println(r.restoreIpAddresses("19216811"));
    }

}
