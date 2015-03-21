package array;

public class SubArraySum
{
  // Given an unsorted array of nonnegative integers,
  // find a continous subarray which adds to a given number.
  // not work for negative element
  public static int subArraySum(int arr[], int sum)
  {
    int n = arr.length;
    /*
     * Initialize curr_sum as value of first element
     * and starting point as 0
     */
    int curr_sum = arr[0], start = 0, i;

    /*
     * Add elements one by one to curr_sum and if the curr_sum exceeds the
     * sum, then remove starting element
     */
    for (i = 1 ; i <= n ; i++) {
      // If curr_sum exceeds the sum, then remove the starting elements
      while (curr_sum > sum && start < i - 1) {
        curr_sum = curr_sum - arr[start];
        start++;
      }

      // If curr_sum becomes equal to sum, then return true
      if (curr_sum == sum) {
        System.out.println("Sum found between indexes " + start + " and "
            + (i - 1));
        return 1;
      }

      // Add this element to curr_sum
      if (i < n) curr_sum = curr_sum + arr[i];
    }

    // If we reach here, then no subarray
    System.out.println("No subarray found");
    StringBuilder sb = new StringBuilder();
    return 0;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    int[] a = { 1, 1, 100, -100, 1, 5 };
    // TODO Auto-generated method stub
    System.out.println(subArraySum(a, 3));
  }

}
