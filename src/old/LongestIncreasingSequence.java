/**
 * @(#) LongestIncreasingSequence.java Apr 4, 2010 8:19:11 PM
 * Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 * All right reserved
 */
package old;

/**
 * Class <code>LongestIncreasingSequence</code>
 *
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Apr 4, 2010 8:19:11 PM
 *
 */
public class

LongestIncreasingSequence {
    // if value does not appear into the array, but
    // arr[0] < value <arr[size] the function returns index,
    // arr[index-1] < value < arr[index]
    // if value<arr[0] the function returns zero
    // if value>arr[end] the function returns end+1
    public static int binarySearchNear(int[] arr, int end, int value) {
        int low = 0, high = end;
        if (value < arr[0])
            return 0;
        if (value > arr[end])
            return end + 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (low == high) {
                if (arr[low] == value)
                    return low;
                else

                    return low;
            } else {
                if (arr[middle] == value) {// value was found
                    return middle;
                }// value suppose to be left
                if (value < arr[middle]) {
                    high = middle;
                } // value suppose to be right
                else {
                    low = middle + 1;
                }
            }
        }
        return -1;
    }

    // // array contains different integer numbers,assumption: arr
    // calculation of the length of largest increment subsequence

    public static int LISLength(int[] arr) {
        int size = arr.length;
        int d[] = new

                int[size];
        d[0] = arr[0];
        int end = 0;
        for (int i = 1; i < size; i++) {
            int index = binarySearchNear(d, end, arr[i]);
            if (index <= end)
                d[index] = arr[i];
            else {
                end++;
                d[end] = arr[i];
            }
        }
        return end + 1;
    }

    // array contains integer different numbers,assumption: arr.length>2//
    // calculation of the length of largest increment subsequence

    public static int[] LIS(int[] arr) {
        int size = arr.length;
        int mat[][] = new int[size][size];
        int d[] = new int[size];
        mat[0][0] = arr[0];
        d[0] = arr[0];
        int end = 0;
        for (int i = 1; i < size; i++) {
            int index = binarySearchNear(d, end, arr[i]);
            mat[index][index] = arr[i];
            for (int j = 0; j < index; j++)
                mat[index][j] = mat[index - 1][j];
            for (int j = 0; j < index; j++)
                d[j] = mat[index - 1][j];
            d[index] = arr[i];
            if (index > end)
                end++;
        }
        int ans[] = new

                int[end + 1];
        for (int j = 0; j <= end; j++)
            ans[j] = mat[end][j];
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 2, -3, 4, -5, 6, -7};
        System.out.println(LISLength(arr));
        int[] d = LIS(arr);
        System.out.println(d.length);

        for (int i : d) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
