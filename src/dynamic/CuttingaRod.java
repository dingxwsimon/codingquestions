package dynamic;

public class CuttingaRod {
  /*
   * Given a rod of length n inches and an array of prices that contains prices
   * of all pieces of size smaller than n. Determine the maximum value
   * obtainable by cutting up the rod and selling the pieces.
   */

  int cutRod(int price[], int n) {
    int[] val = new int[n + 1];
    val[0] = 0;
    int i, j;

    // Build the table val[] in bottom up manner and return the last entry
    // from the table
    for (i = 1; i <= n; i++) {
      int max_val = Integer.MIN_VALUE;
      for (j = 0; j < i; j++)
        max_val = Math.max(max_val, price[j] + val[i - j - 1]);
      val[i] = max_val;
    }

    return val[n];
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
