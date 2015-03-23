package array;

public class DistanceMax {

    // Given an array arr[], find the maximum j-i such that arr[j] > arr[i].
    public static void MaxDiff(int[] array) {
	int left = 0;
	int right = 0;
	int n = array.length;
	int[] lMin = new int[n];
	int[] rMax = new int[n];

	/*
	 * Construct LMin[] such that LMin[i] stores the minimum value from
	 * (arr[0], arr[1], ... arr[i])
	 */
	lMin[0] = array[0];
	for (int i = 1; i < n; i++) {
	    lMin[i] = Math.min(array[i], lMin[i - 1]);
	}
	/*
	 * Construct RMax[] such that RMax[j] stores the maximum value from
	 * (arr[j], arr[j+1], ..arr[n-1])
	 */
	rMax[n - 1] = array[n - 1];
	for (int i = n - 2; i >= 0; i--) {
	    rMax[i] = Math.max(array[i], rMax[i + 1]);
	}
	int maxdiff = 0;
	int i = 0;
	int j = 0;

	/* Traverse both arrays from left to right to find optimum j - i */
	while (i < n && j < n) {
	    if (lMin[i] < rMax[j]) {
		if (j - i > maxdiff) {
		    maxdiff = j - i;
		    left = i;
		    right = j;
		}
		j++;
	    } else
		i++;

	}
	System.out.println(left + " " + right);

    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] array = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
	MaxDiff(array);
    }
}
