package dynamic;

import java.util.Arrays;

public class SubsetSum
{

  /*
   * We create a boolean 2D table subset[][] and fill it in bottom up manner.
   * The value of subset[i][j] will be true if there is a subset of set[0..j-1]
   * with sum equal to i.,
   * otherwise false.
   * Finally, we return subset[sum][n]
   */
  // can solve partition problem ,this is more general
  public static boolean isSubsetSum(int[] arr, int sum)
  {
    int n = arr.length;

    boolean[][] subset = new boolean[sum + 1][n + 1];
    // The value of subset[i][j] will be true if there is a subset of
    // set[0..j-1]
    // with sum equal to i

    // If sum is 0, then answer is true
    for (int i = 0 ; i <= n ; i++)
      subset[0][i] = true;

    // If sum is not 0 and set is empty, then answer is false
    for (int i = 1 ; i <= sum ; i++)
      subset[i][0] = false;

    // Fill the subset table in botton up manner
    for (int i = 1 ; i <= sum ; i++) {
      for (int j = 1 ; j <= n ; j++) {
        subset[i][j] = subset[i][j - 1];
        if (i >= arr[j - 1])
          subset[i][j] = subset[i][j] || subset[i - arr[j - 1]][j - 1];
      }
    }

    /*
     * // uncomment this code to print table
     * for (int i = 0; i <= sum; i++)
     * {
     * for (int j = 0; j <= n; j++)
     * printf ("%4d", subset[i][j]);
     * printf("\n");
     * }
     */

    return subset[sum][n];
  }

 

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    
  }

}
