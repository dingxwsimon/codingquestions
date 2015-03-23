package array;

import java.util.ArrayList;

public class IntersectionOfTwoSortedArrays {
    public static ArrayList<Integer> intersection(int[] A, int[] B) {
	ArrayList<Integer> ret = new ArrayList<Integer>();

	int m = A.length;
	int n = B.length;
	int i = 0;
	int j = 0;
	while (i < m && j < n) {
	    if (A[i] < B[j]) {
		i++;
	    } else if (A[i] > B[j]) {
		j++;
	    } else {
		ret.add(A[i]);
		i++;
		j++;
	    }
	}
	return ret;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] A = new int[] { 1, 2, 3, 4, 5, 6 };
	int[] B = new int[] { 5, 6, 7, 8, 9 };
	System.out.println(intersection(A, B));
    }

}
