package array;

public class MaxBitonic {

    /*
     * Given an array A[0 ... n-1] containing n positive integers, a subarray
     * A[i ... j] is bitonic if there is a k with i <= k <= j such that A[i] <=
     * A[i + 1] ... <= A[k] >= A[k + 1] >= .. A[j - 1] > = A[j]. Write a
     * function that takes an array as argument and returns the length of the
     * maximum length bitonic subarray. Expected time complexity of the solution
     * is O(n) Simple Examples 1) A[] = {12, 4, 78, 90, 45, 23}, the maximum
     * length bitonic subarray is {4, 78, 90, 45, 23} which is of length 5. 2)
     * A[] = {20, 4, 1, 2, 3, 4, 2, 10}, the maximum length bitonic subarray is
     * {1, 2, 3, 4, 2} which is of length 5. Extreme Examples 1) A[] = {10}, the
     * single element is bitnoic, so output is 1. 2) A[] = {10, 20, 30, 40}, the
     * complete array itself is bitonic, so output is 4. 3) A[] = {40, 30, 20,
     * 10}, the complete array itself is bitonic, so output is 4.
     */

    public static int botonic(int[] array) {
        int i = 0;
        int n = array.length;
        int[] incr = new int[n];
        int[] decr = new int[n];
        int max = 0;

        incr[0] = 1;
        decr[n - 1] = 1;
        for (i = 1; i < n; i++) {
            if (array[i] > array[i - 1])
                incr[i] = incr[i - 1] + 1;
            else
                incr[i] = 1;
        }
        for (i = n - 2; i >= 0; i--) {
            if (array[i] > array[i + 1])
                decr[i] = decr[i + 1] + 1;
            else
                decr[i] = 1;
        }

        max = incr[0] + decr[0] - 1;
        for (i = 1; i < n; i++) {
            if (incr[i] + decr[i] - 1 > max)
                max = incr[i] + decr[i] - 1;
        }
        return max;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {12, 4, 78, 90, 45, 23};
        System.out.println(botonic(arr));
    }

}
