package LeetCode;

public class SingleNumber {

    // Given an array of integers, every element appears three times except for
    // one. Find that single one.
    int singleNumber(int A[]) {
	int count[] = new int[32];
	int result = 0;
	for (int i = 0; i < 32; i++) {
	    for (int j = 0; j < A.length; j++) {
		if (((A[j] >> i) & 1) == 1) {
		    count[i]++;
		}
	    }
	    result |= ((count[i] % 3) << i);
	}
	return result;
    }

    // Given an array of integers, every element appears twice except for one.
    // Find that single one.
    public int singleNumber1(int[] A) {
	if (A == null || A.length == 0)
	    return 0;
	int ret = 0;
	for (int i = 0; i < A.length; i++) {
	    ret ^= A[i];
	}
	return ret;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
