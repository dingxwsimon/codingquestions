package array;

import java.util.Arrays;

public class CheckPairs {
    static boolean CheckPairable(int[] nums, int k) {
	int i, j;
	int[] counts;

	counts = new int[k];

	for (i = 0; i < k; i++) {
	    counts[i] = 0;
	}

	for (int num : nums) {
	    counts[num % k]++;
	}
	System.out.println(Arrays.toString(counts));

	if ((counts[0] & 0x1) != 0)
	    return (false);

	if ((k & 0x1) == 0) {
	    if ((counts[k / 2] & 0x1) != 0)
		return false;
	}

	for (i = 1, j = k - 1; i < j; i++, j--) {
	    if (counts[i] != counts[j])
		return (false);
	}

	return (true);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };
	System.out.println(CheckPairable(nums, 8));
    }

}
