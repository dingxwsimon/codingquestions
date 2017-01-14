package array;

public class LongestContiguousArray {
    /*
     * you have an array of integers, find the longest subarray which consists
     * of numbers that can be arranged in a sequence, e.g.: a =
     * {4,5,1,5,7,4,3,6,3,1,9} max subarray = {5,7,4,3,6}
     */
    // different from leetcode
    public static int getLCSubArray(int[] a) {
        int n = a.length;
        boolean[] hash = new boolean[n];
        int[][] max_val = getRMQMax(a);
        int[][] min_val = getRMQMin(a);
        int best = 0;
        for (int i = 0; i < n; i++) {
            hash[a[i]] = true;
            for (int j = i + 1; j < n; j++) {
                if (hash[a[j]])
                    break;
                hash[a[j]] = true;
                if (max_val[i][j] - min_val[i][j] == Math.abs(i - j)) {
                    if (Math.abs(i - j) < best)
                        best = Math.abs(i - j);
                }
            }
            hash = new boolean[n];
        }
        return best;
    }

    // max[i][j] = max value from A[i] to A[j]
    public static int[][] getRMQMax(int[] A) {
        int N = A.length;
        int[][] M = new int[N][N];

        int i, j;
        for (i = 0; i < N; i++)
            M[i][i] = A[i];
        for (i = 0; i < N; i++)
            for (j = i + 1; j < N; j++)
                if (M[i][j - 1] > A[j])
                    M[i][j] = M[i][j - 1];
                else
                    M[i][j] = A[j];
        return M;
    }

    public static int[][] getRMQMin(int[] A) {
        int N = A.length;
        int[][] M = new int[N][N];

        int i, j;
        for (i = 0; i < N; i++)
            M[i][i] = A[i];
        for (i = 0; i < N; i++)
            for (j = i + 1; j < N; j++)
                if (M[i][j - 1] < A[j])
                    M[i][j] = M[i][j - 1];
                else
                    M[i][j] = A[j];
        return M;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
