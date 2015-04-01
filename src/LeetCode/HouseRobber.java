package LeetCode;

public class HouseRobber {

    public int rob(int[] num) {
	if (num == null || num.length == 0)
	    return 0;
	int n = num.length;
	if (n == 1)
	    return num[0];
	int[] prev = new int[n];
	prev[0] = num[0];
	prev[1] = Math.max(num[0], num[1]);
	for (int i = 2; i < n; i++) {
	    prev[i] = Math.max(prev[i - 1], prev[i - 2] + num[i]);
	}
	return prev[n - 1];
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
