package LeetCode;

public class SearchForRange
{
  public int[] searchRange2(int[] A, int target)
  {
    int[] ret = { -1, -1 };
    if (A == null || A.length == 0) return ret;
    int l = bs(A, target);
    if (l > A.length - 1 || A[l] != target) return ret;
    int r = bs(A, target + 1);
    ret[0] = l;
    ret[1] = r - 1;
    return ret;
  }

  public int bs(int[] a, int x)
  {
    int l = 0, r = a.length - 1;
    int ret = -1;
    while (l < r) {
      int m = (l + r) / 2;
      if (a[m] < x) {
        l = m + 1;
      }
      else {
        r = m;
      }
    }
    return (a[l] < x)
                     ? l + 1
                     : l;
  }

  // pass both, remember it
  public int[] searchRange(int[] A, int target)
  {
    // Start typing your Java solution below
    // DO NOT write main() function

    int[] ret = new int[2];
    ret[0] = bs1(A, target - 1) + 1;
    ret[1] = bs1(A, target);

    if (ret[1] == -1 || A[ret[1]] != target) {
      ret[0] = -1;
      ret[1] = -1;
    }

    return ret;
  }

  // return the index of the biggest element smaller than or equal to x
  // if any element in a is bigger than x, return -1
  // the following is used often, just remember it.
  public int bs1(int[] a, int x)
  {
    int start = 0, end = a.length - 1, mid = (a.length - 1) / 2;
    int ret = -1;

    while (start <= end) {
      mid = (start + end) / 2;
      if (a[mid] > x) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
        ret = mid;
      }
    }

    return ret;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
