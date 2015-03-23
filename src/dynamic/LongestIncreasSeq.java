package dynamic;

import array.BinarySearch;

public class LongestIncreasSeq {

    // LIS[i] is the longest increase seq length in the array[0] to array[i]
    public static int LISn2(int[] array) {
	int[] LIS = new int[array.length];
	int length = 0;
	for (int i = 0; i < array.length; i++) {
	    LIS[i] = 1;
	    for (int j = 0; j < i; j++) {
		if (array[i] > array[j] && LIS[j] + 1 > LIS[i]) {
		    LIS[i] = LIS[j] + 1;
		}
	    }
	    if (LIS[i] > length)
		length = LIS[i];
	}
	return length;
    }

    // maxV[j] = smallest value x such that there is an increasing subsequence
    // of
    // length j ending at x
    public static int LISnlogn(int[] array) {
	int[] maxV = new int[array.length + 1];
	maxV[1] = array[0];
	maxV[0] = min(array) - 1;
	int[] LIS = new int[array.length];

	for (int i = 0; i < LIS.length; i++)
	    LIS[i] = 1;

	int nMaxLIS = 1;

	for (int i = 1; i < array.length; i++) {
	    int j;

	    // best part, reduce the time to nlogn
	    if (maxV[nMaxLIS] < array[i])
		j = nMaxLIS;
	    else
		j = BinarySearch.bsNear(maxV, array[i], nMaxLIS) - 1;
	    if (j != -1)
		LIS[i] = j + 1;
	    // for(j = nMaxLIS; j >= 0; j--){
	    // if(array[i] > maxV[j]){
	    // LIS[i] = j+1;
	    // break;
	    // }
	    // }

	    // update the amxV
	    if (LIS[i] > nMaxLIS) {
		// this is when there is new longest subseq
		nMaxLIS = LIS[i];
		maxV[nMaxLIS] = array[i];
	    } else if (maxV[j] < array[i] && array[i] < maxV[j + 1]) {
		// when we can reduece the max value alottle bit
		maxV[j + 1] = array[i];
	    }

	}

	return nMaxLIS;
    }

    public static int min(int[] array) {
	int min = array[0];
	for (int i = 0; i < array.length; i++) {
	    if (array[i] < min)
		min = array[i];
	}
	return min;
    }

    public static int max(int[] array) {
	int max = array[0];
	for (int i = 0; i < array.length; i++) {
	    if (array[i] > max)
		max = array[i];
	}
	return max;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] array = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
	System.out.println(LISnlogn(array));
    }

}
