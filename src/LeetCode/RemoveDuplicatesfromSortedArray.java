package LeetCode;

/*
 * Given a sorted array, remove the duplicates in place
 * such that each element appear only once and return the new length.
 * Do not allocate extra space for another array,
 * you must do this in place with constant memory.
 */
public class RemoveDuplicatesfromSortedArray {

    // Working!!!
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        if (n == 0)
            return 0;
        int start = 0;
        int end = 0;
        while (start < n) {
            if (A[start] == A[end]) {
                start++;
            } else {
                A[++end] = A[start++];
            }
        }
        return end + 1;
    }

    // Working!!!
    public int removeDuplicates1(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = A.length;
        int result = size;
        int start = 1;
        int end = 0;
        boolean twice = false;
        while (start < size) {
            if (A[start] == A[end] && !twice) {
                A[++end] = A[start++];
                twice = true;
            } else if (A[start] == A[end] && twice) {
                start++;
                result--;
            } else {
                twice = false;
                A[++end] = A[start++];
            }
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
