package LeetCode;

public class FirstMissingPositive {
    public static int firstMissingPositive1(int[] A) {
	// put i to A[i-1], so the array looks like: 1, 2, 3, ...

	for (int i = 0; i < A.length; i++) {
	    while (A[i] != i + 1) {
		if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1]) {
		    break;
		}

		int tmp = A[A[i] - 1];
		A[A[i] - 1] = A[i];
		A[i] = tmp;
	    }
	}

	for (int i = 0; i < A.length; i++) {
	    if (A[i] != i + 1) {
		return i + 1;
	    }
	}
	return A.length + 1;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] A = new int[] { 2, 2, 4 };
	System.out.println(firstMissingPositive1(A));
    }

}
