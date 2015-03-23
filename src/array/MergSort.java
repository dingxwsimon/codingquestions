/**
 * @(#) MergSort.java Mar 23, 2010 2:14:16 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package array;

/**
 * Class <code>MergSort</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Mar 23, 2010 2:14:16 PM
 * 
 */
public class MergSort {

    private static int[] mergeSort(int[] data, int left, int right) {
	if (data == null)
	    return null;
	if (data.length < 2)
	    return data;
	if (left < right) {
	    int middle = left + ((right - left) >> 1);
	    mergeSort(data, left, middle);
	    mergeSort(data, middle + 1, right);
	    merge(data, left, middle + 1, right);
	}
	return data;
    }

    private static void merge(int[] data, int left, int middle, int right) {

	int[] tmpArray = new int[data.length];
	int leftEnd = middle - 1;
	int tmpPos = left;
	int numElements = right - left + 1;

	while (left <= leftEnd && middle <= right) {
	    if (data[left] < (data[middle]))
		tmpArray[tmpPos++] = data[left++];
	    else
		tmpArray[tmpPos++] = data[middle++];
	}

	while (left <= leftEnd)
	    tmpArray[tmpPos++] = data[left++];

	while (middle <= right)
	    tmpArray[tmpPos++] = data[middle++];

	for (int i = 0; i < numElements; i++, right--)
	    data[right] = tmpArray[right];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] data = { 2, 3, 1, 5, 4 };
	MergSort.mergeSort(data, 0, 4);
	System.out.println("");
    }

}
