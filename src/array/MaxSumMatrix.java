package array;

public class MaxSumMatrix {
    // CC150
    public static void clearArray(int[] array) {
	for (int i = 0; i < array.length; i++) {
	    array[i] = 0;
	}
    }

    public static int maxSubMatrix(int[][] matrix) {
	int rowCount = matrix.length;
	int colCount = matrix[0].length;

	int[] partialSum = new int[colCount];
	int maxSum = 0; // Max sum is an empty matrix

	for (int rowStart = 0; rowStart < rowCount; rowStart++) {
	    clearArray(partialSum);

	    for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
		for (int i = 0; i < colCount; i++) {
		    partialSum[i] += matrix[rowEnd][i];
		}

		int tempMaxSum = maxSubArray(partialSum, colCount);

		// if you want to track the coordinates, add code here to do
		// that
		maxSum = Math.max(maxSum, tempMaxSum);
	    }
	}
	return maxSum;
    }

    // this is the same as maxsum in array
    public static int maxSubArray(int array[], int N) {
	int maxSum = 0;
	int runningSum = 0;

	for (int i = 0; i < N; i++) {
	    runningSum += array[i];
	    maxSum = Math.max(maxSum, runningSum);

	    /*
	     * If running_sum is < 0 no point in trying to continue the series.
	     * Reset.
	     */
	    if (runningSum < 0) {
		runningSum = 0;
	    }
	}

	return maxSum;
    }

    public static String printMatrix(int[][] m) {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < m.length; i++) {
	    for (int j = 0; j < m[i].length; j++) {
		sb.append(m[i][j] + "\t");
	    }
	    sb.append("\n");
	}
	return sb.toString();
    }

    public static String printMatrix(boolean[][] m) {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < m.length; i++) {
	    for (int j = 0; j < m[i].length; j++) {
		sb.append(m[i][j] + "\t");
	    }
	    sb.append("\n");
	}
	return sb.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int data[][] = new int[][] { { -6, 4, 3, -5 }, { 10, -7, 9, -2 } };
	System.out.println(maxSubMatrix(data));
    }

}
