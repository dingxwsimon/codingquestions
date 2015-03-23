/**
 * @(#) HeapSort.java Apr 6, 2010 10:07:04 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package array;

import java.util.Arrays;

/**
 * Class <code>HeapSort</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Apr 6, 2010 10:07:04 PM
 * 
 */
public class HeapSort {
    // max heap
    // only sift the data[low] to the right place
    public static void sift(int[] data, int low, int high) {
	int i, j;
	i = low; // low is the parent
	j = 2 * i + 1; // j is the child
	while (j < high) {
	    // decide left or right child
	    if (j + 1 < high && data[j] < data[j + 1])
		j = j + 1;
	    // if the child if larger than parent, swap
	    if (data[i] < data[j]) {
		swap(data, i, j);
		i = j;
		j = 2 * i + 1;
	    } else
		break;
	}
    }

    public static void heapsort(int[] data) {
	int length = data.length;
	for (int i = length / 2 - 1; i >= 0; i--) {
	    sift(data, i, length - 1);
	}

	for (int i = length - 1; i >= 1; i--) {
	    swap(data, 0, i);
	    sift(data, 0, i - 1);
	}
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
	int[] data = { 2, 13, 1, 12, 11, 7, 9, 10, 20, 6 };
	HeapSort.heapsort(data);
	System.out.println(Arrays.toString(data));

    }

}
