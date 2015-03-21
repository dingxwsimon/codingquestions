package LeetCode;

public class RemoveElement
{

  // pass both
  public static int removeElement(int[] A, int elem)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    int n = A.length;
    int cur = 0;
    int res = 0;
    while (cur < n) {
      if (A[cur] == elem) {
        cur++;
      }
      else {
        A[res++] = A[cur++];
      }
    }

    return res;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    removeElement(new int[] { 1, 2, 3, 4 }, 1);
  }

}
