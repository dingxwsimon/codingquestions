package LeetCode;

public class RemoveDuplicatesfromSortedArray2 {
    // pass both
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int size = A.length;
        int result = size;
        int start = 1;
        int end = 0;
        int count = 1;
        while (start < size) {

            if (A[start] != A[end]) {
                count = 1;
                A[++end] = A[start++];
            }
            // first duplicate
            else if (count == 1) {
                count--;
                A[++end] = A[start++];
            } else if (count == 0) {
                start++;
                result--;
            }
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RemoveDuplicatesfromSortedArray2 r = new RemoveDuplicatesfromSortedArray2();
        System.out.println(r.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

}
