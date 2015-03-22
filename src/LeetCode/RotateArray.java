package LeetCode;

public class RotateArray {
    public void rotate(int[] nums, int k) {
	if (nums == null || nums.length == 0)
	    return;
	int n = nums.length;
	int m = k % n;
	int l = 0;
	int r = n - 1;
	reverse(nums, l, r);
	reverse(nums, l, m - 1);
	reverse(nums, m, r);
    }

    public void reverse(int[] nums, int l, int r) {
	while (l < r) {
	    int tmp = nums[l];
	    nums[l] = nums[r];
	    nums[r] = tmp;
	    l++;
	    r--;
	}
    }
}
