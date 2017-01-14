package LeetCode;

import java.util.Arrays;

public class SortColors {
    // this is the Dutch national flag problem
    // pass both
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = 0, r = A.length - 1, i = 0;
        while (i <= r) {
            if (A[i] == 0) {
                swap(A, i, l);
                l++;
                i++;
            } else if (A[i] == 2) {
                swap(A, i, r);
                r--;
            } else {
                i++;
            }
            System.out.println(Arrays.toString(A));
        }
        System.out.println(Arrays.toString(A));
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SortColors s = new SortColors();
        int[] A = new int[]{1, 0};
        s.sortColors(A);
    }

}
