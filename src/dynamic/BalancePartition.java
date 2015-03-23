package dynamic;

public class BalancePartition {

    // given an array, try to partition them so that the two separate part have
    // the closest sum
    // p[i][j] = 1 if some subset of a[0]..a[i] has sum of j else 0
    public static int bp(int[] array) {
	int k = LongestIncreasSeq.max(array);// just get the maximum element of
					     // the
					     // array
	int maxsum = k * array.length;
	int[][] p = new int[array.length][maxsum + 1];
	for (int j = 0; j <= maxsum; j++)
	    p[0][j] = j == array[0] ? 1 : 0;

	// time complexity n^2*maxsum
	for (int i = 1; i < array.length; i++) {
	    for (int j = 0; j <= maxsum; j++)
		if (j - array[i] > 0) {
		    p[i][j] = Math.max(p[i - 1][j], p[i - 1][j - array[i]]);
		} else {
		    p[i][j] = p[i - 1][j];
		}
	}
	// System.out.println( p);
	int sum = 0;

	for (int i = 0; i < array.length; i++)
	    sum += array[i];

	sum = sum / 2;

	int min = sum;
	int subsum = 0;
	for (int j = 0; j <= maxsum; j++) {
	    if (p[array.length - 1][j] == 1 && Math.abs(j - sum) < min) {
		min = Math.abs(j - sum);
		subsum = j;
	    }
	}
	System.out.println(min);
	return subsum;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int array[] = { 2, 10, 3, 8, 5, 7, 9, 5, 3, 2 };
	System.out.println(bp(array));
    }

}
