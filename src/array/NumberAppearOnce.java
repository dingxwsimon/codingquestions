package array;

public class NumberAppearOnce
{

  // this can be a general methods
  public static int getSingle(int arr[], int n, int k)
  {
    // Initialize result
    int result = 0;

    int x, sum;

    // Iterate through every bit
    for (int i = 0 ; i < Integer.SIZE ; i++) {
      // Find sum of set bits at ith position in all
      // array elements
      sum = 0;
      x = (1 << i);
      for (int j = 0 ; j < n ; j++) {
        if ((arr[j] & x) > 0) sum++;
      }

      // The bits with sum not multiple of 3, are the
      // bits of element with single occurrence.
      if (sum % k > 0) result |= x;
    }

    return result;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(getSingle(new int[] { 12, 1, 12, 3, 12, 1, 1, 2, 3, 3 },
        10, 3));
  }

}
