package LeetCode;

public class PermutationSequence
{
  // pass both
  public static String getPermutation(int n, int k)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    int[] p = new int[n];
    for (int i = 1 ; i < n + 1 ; i++) {
      p[i - 1] = i;
    }
    while (k > 1 && nextPermutation(p)) {
      k--;
    }
    String result = "";
    for (int i = 0 ; i < n ; i++)
      result += p[i];
    return result;
  }

  public static boolean nextPermutation(int[] p)
  {
    int n = p.length;
    int k = p.length - 2;
    while (k >= 0 && p[k] >= p[k + 1])
      k--; 
    if (k == -1) return false;

    int l = p.length - 1;
    while (l > k && p[l] <= p[k])
      l--;

    int tmp = p[k];
    p[k] = p[l];
    p[l] = tmp;

    for (int i = k + 1, j = n - 1 ; i < j ; i++, j--) {
      tmp = p[i];
      p[i] = p[j];
      p[j] = tmp;
    }
    return true;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(getPermutation(4, 3));
  }

}
