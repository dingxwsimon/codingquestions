package LeetCode;

public class MaximumSubarray {
    public int maxSubArray1(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int max = A[0];
        int cur = A[0];
        for (int i = 1; i < A.length; i++) {
            cur = Math.max(cur + A[i], A[i]);
            max = Math.max(cur, max);
        }
        return max;
    }

    // pass both
    public int maxSubArray(int[] data) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (data == null)
            return 0;
        int n = data.length;
        int nAll = data[0];
        int nStart = data[0];

        for (int i = 1; i < n; i++) {
            if (nStart < 0)
                nStart = 0;
            nStart += data[i];
            if (nStart > nAll)
                nAll = nStart;
        }

        return nAll;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MaximumSubarray m = new MaximumSubarray();
        System.out.println(m.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1,
                -5, 4}));

    }

}
