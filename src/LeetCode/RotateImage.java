package LeetCode;

public class RotateImage {

    public void rotate1(int[][] matrix) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int n = matrix.length;
	for (int i = 0, j = n - 1; i < j; i++, j--) {
	    for (int k = i; k < j; k++) {
		int tmp = matrix[i][k];
		matrix[i][k] = matrix[n - k - 1][i];
		matrix[n - k - 1][i] = matrix[j][n - k - 1];
		matrix[j][n - k - 1] = matrix[k][j];
		matrix[k][j] = tmp;
	    }
	}
	return;
    }

    // pass both
    public void rotate(int[][] matrix) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int n = matrix.length;
	for (int level = 0; level < n / 2; level++) {
	    int first = level;
	    int last = n - 1 - level;
	    for (int i = first; i < last; i++) {
		int tmp = matrix[first][i];
		int offset = i - first;
		matrix[first][i] = matrix[last - offset][first];
		matrix[last - offset][first] = matrix[last][last - offset];
		matrix[last][last - offset] = matrix[i][last];
		matrix[i][last] = tmp;
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
