package dynamic;

public class MaximumSumIncreasingSubsequence
{
  // This problem is a variation of standard Longest Increasing Subsequence
  // (LIS) problem
  int maxSumIS(int arr[], int n)
  {
    int[] msis = new int[n];
    int i, j, max = 0;

    /* Initialize msis values for all indexes */
    for (i = 0 ; i < n ; i++)
      msis[i] = arr[i];

    /* Compute maximum sum values in bottom up manner */
    for (i = 1 ; i < n ; i++)
      for (j = 0 ; j < i ; j++)
        if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i])
          msis[i] = msis[j] + arr[i];

    /* Pick maximum of all msis values */
    for (i = 0 ; i < n ; i++)
      if (max < msis[i]) max = msis[i];

    return max;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
