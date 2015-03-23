package LeetCode;

public class PlusOne {
    // pass both
    public int[] plusOne(int[] digits) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (digits == null || digits.length < 1)
	    return digits;
	int n = digits.length;
	int residu = 1;
	for (int i = n - 1; i >= 0; i--) {
	    if (digits[i] + residu == 10) {
		digits[i] = 0;
		residu = 1;
	    } else {
		digits[i] = digits[i] + residu;
		residu = 0;
	    }
	}
	if (residu == 1) {
	    int[] result = new int[n + 1];
	    result[0] = 1;
	    for (int i = 1; i < n + 1; i++)
		result[i] = digits[i - 1];
	    return result;
	} else
	    return digits;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
