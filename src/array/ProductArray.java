package array;

public class ProductArray
{
  // O(n) space O(1)
  public static int[] productArray(int arr[])
  {
    int n = arr.length;
    int i, temp = 1;

    /* Allocate memory for the product array */
    int[] prod = new int[n];
    for (i = 0 ; i < n ; i++)
      prod[i] = 1;

    /*
     * In this loop, temp variable contains product of
     * elements on left side excluding arr[i]
     */
    for (i = 0 ; i < n ; i++) {
      prod[i] = temp;
      temp *= arr[i];
    }

    /* Initialize temp to 1 for product on right side */
    temp = 1;

    /*
     * In this loop, temp variable contains product of
     * elements on right side excluding arr[i]
     */
    for (i = n - 1 ; i >= 0 ; i--) {
      prod[i] *= temp;
      temp *= arr[i];
    }
    return prod;
  }

  public int[] productArray1(int A[])
  {
    if (A == null || A.length == 0) return null;

    int product = 1;
    int zeroNum = 0;
    for (int i = 0 ; i < A.length ; i++) {
      if (A[i] == 0)
        zeroNum++;
      else
        product *= A[i];
    }
    int[] B = new int[A.length];
    if (zeroNum > 1) {
      return B;
    }
    if (zeroNum == 1) {
      for (int i = 0 ; i < B.length ; i++) {
        if (A[i] == 0) B[i] = product;
      }
      return B;
    }
    for (int i = 0 ; i < B.length ; i++) {
      B[i] = (int) product / A[i];
    }
    return B;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
