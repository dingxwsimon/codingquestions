package LeetCode;

public class MergeTwoArrays {

    // Working!!!
    public static void merge(int A[], int m, int B[], int n) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int length = A.length;
	int i = m - 1;
	int j = n - 1;

	while (i >= 0 && j >= 0) {
	    if (A[i] > B[j]) {
		A[--length] = A[i--];
	    } else {
		A[--length] = B[j--];
	    }
	}
	if (length > 0) {
	    if (i < 0) {
		while (j >= 0) {
		    A[--length] = B[j--];
		}
	    }
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
