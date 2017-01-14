package array;

import java.util.Arrays;

public class SortThreeColor {

    /*
     * Given an array with n objects colored red, white or blue, sort them so
     * that objects of the same color are adjacent, with the colors in the order
     * red, white and blue. Here, we will use the integers 0, 1, and 2 to
     * represent the color red, white , and blue respectively. Note: You are not
     * suppose to use the library's sort function for this problem. Follow up: A
     * rather straight forward solution is a two-pass algorithm using counting
     * sort. First, iterate the array counting number of 0's, 1's, and 2's, then
     * overwrite array with total number of 0's, then 1's and followed by 2's.
     * Could you come up with an one-pass algorithm using only constant space?
     */

    // worked!!!!
    public void sortColors(int[] A) {
        int n = A.length;
        if (n < 2)
            return;
        int start = 0;
        int end = n - 1;

        int i = 0;
        while (start <= n - 1 && A[start] == 0)
            start++;
        while (end >= 0 && A[end] == 2)
            end--;

        while (i <= end && start < end) {
            if (i < start)
                i = start;
            if (A[i] == 0) {
                swap(A, i, start);
                start++;
            } else if (A[i] == 2) {
                swap(A, i, end);
                end--;
            } else {
                i++;
            }
            while (start <= n - 1 && A[start] == 0)
                start++;
            while (end >= 0 && A[end] == 2)
                end--;
        }
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // work under C++
    public void sort(int[] A) {
        int n = A.length;
        if (n <= 1)
            return;
        int zeroptr = 0;
        int twoptr = n - 1;
        int i = 0;
        while (A[zeroptr] == 0)
            zeroptr++;
        while (A[twoptr] == 2)
            twoptr--;
        while (zeroptr <= twoptr && i <= twoptr) {
            if (i < zeroptr)
                i = zeroptr;
            switch (A[i]) {
                case 0:
                    swap(A, zeroptr, i);
                    break;
                case 1:
                    i++;
                    break;
                case 2:
                    swap(A, twoptr, i);
                    break;
                default:
                    break;
            }
            while (A[zeroptr] == 0)
                zeroptr++;
            while (A[twoptr] == 2)
                twoptr--;
        }
    }

    // correct
    public void sort1(int[] A) {
        int[] count = new int[3];
        for (int i = 0; i < 3; i++) {
            count[i] = 0;

        }

        for (int i = 0; i < A.length; i++) {
            count[A[i]]++;
        }
        int start = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = start; j < start + count[i]; j++) {
                A[j] = i;
            }
            start += count[i];
        }
        System.out.println(Arrays.toString(A));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{0};
        SortThreeColor s = new SortThreeColor();
        s.sortColors(A);
        System.out.println(Arrays.toString(A));
    }

}
