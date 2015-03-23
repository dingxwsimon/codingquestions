package array;

// find the maximum sum possible in an array of positive integers by selecting
// the
// elements in such a way that no two elements are next to each other
public class MaxSumNoNeighbor {

    public static int maxSum(int[] housevalue) {
	if (housevalue == null)
	    return 0;
	int n = housevalue.length;
	if (n == 0)
	    return 0;
	if (n == 1)
	    return housevalue[0];
	int[] robvalue = new int[n];
	robvalue[0] = housevalue[0];
	robvalue[1] = Math.max(housevalue[0], housevalue[1]);
	for (int i = 2; i < n; i++) {
	    robvalue[i] = Math.max(robvalue[i - 2] + housevalue[i],
		    robvalue[i - 1]);
	}

	return robvalue[n - 1];
    }

    public static void main(String[] args) {
	System.out.println(maxSum(new int[] { 1 }));
    }

}
