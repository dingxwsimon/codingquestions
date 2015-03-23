package array;

import java.util.Arrays;

public class MaxMinTogether {
    // same as Beauty of Programming
    public static int[] getMinMax(int arr[], int n) {
	int[] minmax = new int[2]; // min 0 max 1
	int i;

	/*
	 * If array has even number of elements then initialize the first two
	 * elements as minimum and maximum
	 */
	if (n % 2 == 0) {
	    if (arr[0] > arr[1]) {
		minmax[1] = arr[0];
		minmax[0] = arr[1];
	    } else {
		minmax[0] = arr[0];
		minmax[1] = arr[1];
	    }
	    i = 2; /* set the startung index for loop */
	}

	/*
	 * If array has odd number of elements then initialize the first element
	 * as minimum and maximum
	 */
	else {
	    minmax[0] = arr[0];
	    minmax[1] = arr[0];
	    i = 1; /* set the startung index for loop */
	}

	/*
	 * In the while loop, pick elements in pair and compare the pair with
	 * max and min so far
	 */
	while (i < n - 1) {
	    if (arr[i] > arr[i + 1]) {
		if (arr[i] > minmax[1])
		    minmax[1] = arr[i];
		if (arr[i + 1] < minmax[0])
		    minmax[0] = arr[i + 1];
	    } else {
		if (arr[i + 1] > minmax[1])
		    minmax[1] = arr[i + 1];
		if (arr[i] < minmax[0])
		    minmax[0] = arr[i];
	    }
	    i += 2; /*
		     * Increment the index by 2 as two elements are processed in
		     * loop
		     */
	}

	return minmax;
    }

    // return int[]{max, min}
    public static int[] search(int[] array, int start, int end) {
	if (end - start <= 1) {
	    if (array[start] > array[end]) {
		return new int[] { array[start], array[end] };
	    } else
		return new int[] { array[end], array[start] };
	}
	int mid = start + (end - start) / 2;
	int[] left = search(array, start, mid);
	int[] right = search(array, mid + 1, end);
	int[] result = new int[2];
	result[0] = left[0] > right[0] ? left[0] : right[0];
	result[1] = left[1] < right[1] ? left[1] : right[1];
	return result;
    }

    public static int[] search1(int[] array) {
	int[] result = new int[2];
	int size = array.length;
	int end = size % 2 == 0 ? size : size - 1;
	for (int i = 0; i < end; i += 2) {
	    if (array[i] < array[i + 1]) {
		int tmp = array[i];
		array[i] = array[i + 1];
		array[i + 1] = tmp;
	    }
	}

	int max = array[0];
	int min = array[1];
	for (int i = 0; i < size; i += 2) {

	    if (i + 1 < size) {
		if (array[i] > max)
		    max = array[i];
		if (array[i + 1] < min)
		    min = array[i + 1];
	    } else {
		if (array[i] > max)
		    max = array[i];
		if (array[i] < min)
		    min = array[i];
	    }
	}
	result[0] = max;
	result[1] = min;
	return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(Arrays.toString(search1(new int[] { 10, 2, 3, 4, 5,
		6, 7, 8, 1 })));
    }

}
