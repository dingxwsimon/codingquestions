package LeetCode;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
	int[] ret = new int[] { -1, -1 };
	int l = 0;
	int r = numbers.length - 1;
	while (l < r) {
	    if (numbers[l] + numbers[r] == target) {
		ret[0] = l + 1;
		ret[1] = r + 1;
		return ret;
	    } else if (numbers[l] + numbers[r] > target) {
		r--;
	    } else {
		l++;
	    }
	}
	return ret;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
