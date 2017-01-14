package LeetCode;

public class SearchInsertPos {

    public int searchInsert2(int[] A, int target) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return (A[l] < target) ? l + 1 : l;
    }

    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = bs(A, target);
        if (result == -1)
            return 0;
        if (A[result] == target)
            return result;
        return result + 1;
    }

    public int bs(int[] a, int x) {
        int start = 0, end = a.length - 1, mid = (a.length - 1) / 2;
        int ret = -1;

        while (start <= end) {
            mid = (start + end) / 2;
            if (a[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
                ret = mid;
            }
        }

        return ret;
    }

    // simple?
    int searchInsert(int A[], int n, int target) {
        if (n == 0)
            return 0;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
