package array;

public class ContinuousSubArraySumZero {
    // Given an array write a function to print all continuous
    // subsequences in the array which sum of 0.

    /*
     * This is not the best dynamic programming method. A simple way is, use an
     * array sum[i] to present the sum from data[0] to data[i]. A special 0 at
     * beginning to simplify the logic later. Then, just find the same values in
     * sum[]. For example, [-1, -3, 4, 5, -2, -7] [0, -1, -4, 0, 5, 3, -4] There
     * is a pair 0, that mean the range from 0 to 2. Another pair -4, that means
     * the range form 2 to 5.
     */
    // this is still O(n^2)

    // dp ap[i][j] == sum of A[i]toA[j];

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
