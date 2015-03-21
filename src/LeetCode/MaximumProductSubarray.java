package LeetCode;

public class MaximumProductSubarray
{

  public static int func(int[] a) {
    int n = a.length;
    int[] max = new int[n];
    int[] min = new int[n];
    max[0] = min[0] = a[0];
    int value = max[0];
    for (int i = 1; i < n; ++i) {
      max[i] = Math.max(Math.max(a[i], max[i - 1] * a[i]), min[i - 1]
          * a[i]);
      min[i] = Math.min(Math.min(a[i], max[i - 1] * a[i]), min[i - 1]
          * a[i]);
      value = Math.max(value, max[i]);
    }
    return value;
  }

  
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
