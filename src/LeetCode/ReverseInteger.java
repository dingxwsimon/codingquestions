package LeetCode;

public class ReverseInteger {

    // pass both easy
    public int reverse(int x) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (x == 0)
	    return x;
	boolean negative = false;
	if (x < 0) {
	    negative = true;
	    x *= -1;
	}
	int n = 0;
	while (x > 0) {
	    n = n * 10 + x % 10;
	    x /= 10;
	}
	if (negative)
	    n *= -1;

	return n;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
