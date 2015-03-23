package LeetCode;

public class AddBinary {
    // pass both, myself
    public String addBinary(String a, String b) {
	// Start typing your Java solution below
	// DO NOT write main() function
	StringBuilder sb = new StringBuilder();
	int ai = a.length() - 1;
	int bi = b.length() - 1;
	int carry = 0;
	while (ai >= 0 || bi >= 0) {
	    int sum = carry;
	    if (ai >= 0) {
		sum += a.charAt(ai) - '0';
		ai--;
	    }
	    if (bi >= 0) {
		sum += b.charAt(bi) - '0';
		bi--;
	    }
	    if (sum >= 2) {
		carry = 1;
		sum -= 2;
	    } else
		carry = 0;
	    sb.insert(0, sum);
	}
	if (carry > 0)
	    sb.insert(0, carry);
	return sb.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
    }

}
