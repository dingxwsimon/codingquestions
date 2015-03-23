package array;

import java.util.Arrays;

public class PairSum {

    // given an array, check the index of two number that sum up with a certain
    // number
    public static void pairSum(int[] array, int sum) {
	if (array == null || array.length == 0)
	    return;
	Arrays.sort(array);
	for (int i = 0, j = array.length - 1; i <= j; i++, j--) {
	    if (array[i] + array[j] == sum) {
		System.out.println("there is a pair " + array[i] + " "
			+ array[j]);
		i++;
		j--;
	    } else if (array[i] + array[j] > sum) {
		j--;
	    } else
		i++;
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int test[] = { 9, 3, 6, 5, 7, -1, 13, 14, -2, 12, 0 };
	pairSum(test, 12);
    }

}
