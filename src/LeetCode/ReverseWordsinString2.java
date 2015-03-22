package LeetCode;

public class ReverseWordsinString2 {
    public void reverseWords(char[] s) {
	if (s == null || s.length == 0)
	    return;
	reverse(s, 0, s.length - 1);
	int l = 0;
	int r = 0;
	while (r < s.length) {
	    while (r < s.length && s[r] != ' ') {
		r++;
	    }
	    reverse(s, l, r - 1);
	    l = r + 1;
	    r = r + 1;
	}
    }

    public void reverse(char[] s, int l, int r) {
	while (l < r) {
	    char tmp = s[l];
	    s[l] = s[r];
	    s[r] = tmp;
	    l++;
	    r--;
	}
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
