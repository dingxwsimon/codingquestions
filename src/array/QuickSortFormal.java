/**
 * @(#) QuickSort.java Apr 6, 2010 9:43:58 PM
 * Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 * All right reserved
 */
package array;

import java.util.Arrays;

/**
 * Class <code>QuickSort</code>
 *
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Apr 6, 2010 9:43:58 PM
 *
 */
public class QuickSortFormal {
    public static void quicksort(int[] data, int low, int high) {
        if (low < high) {
            int pivot = (low + high) / 2;
            int storeindex = partition(data, low, high, pivot);
            quicksort(data, low, storeindex - 1);
            quicksort(data, storeindex + 1, high);
        }
    }

    public static int partition(int[] data, int low, int high, int pivot) {
        int temp = data[pivot];
        swap(data, high, pivot);

        int storeindex = low;

        for (int i = low; i < high; i++) {
            if (data[i] <= temp) {
                swap(data, i, storeindex);
                storeindex++;
            }
        }
        swap(data, storeindex, high);
        return storeindex;
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] data = {2, 13, 1, 12, 11, 7, 9, 10, 20, 6};
        QuickSortFormal.quicksort(data, 0, 9);
        System.out.println(Arrays.toString(data));
    }

}
