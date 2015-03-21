package LeetCode;

public class SearchRotatedSortedArray
{

  // if duplicates are allowed there is no log(n) algorithm

  // pass both
  public static int search(int[] A, int target)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    int l = 0;
    int u = A.length - 1;
    while (l <= u) {
      int m = l + (u - l) / 2;
      if (A[m] == target) return m;
      if (A[l] <= A[m]) {
        if (target >= A[l] && target < A[m])
          u = m - 1;
        else
          l = m + 1;
      }
      else {
        if (A[m] < target && target <= A[u])
          l = m + 1;
        else
          u = m - 1;
      }

    }
    return -1;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    int[] data = new int[] { 1 };
    System.out.println(search(data, 0));
  }

}
