package CrackingCoding;

public class c1_2 {

    public void reverse(char[] str) {
	int n = str.length;
	int l = 0;
	int r = n - 1;
	while (l < r) {
	    char tmp = str[l];
	    str[l] = str[r];
	    str[r] = tmp;
	}
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
