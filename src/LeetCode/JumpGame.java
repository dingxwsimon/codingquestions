package LeetCode;

public class JumpGame
{

  // pass both
  public static boolean canJumps(int[] A)
  {
    int n = A.length;
    int[] jumps = new int[n];
    if (n <= 1) return true;
    if (A[0] == 0) return false;
    jumps[0] = 0;
    for (int i = 1 ; i < n ; i++) {
      jumps[i] = Integer.MAX_VALUE;
      for (int j = 0 ; j < i ; j++) {
        if (i <= j + A[j] && jumps[j] != Integer.MAX_VALUE) {
          jumps[i] = jumps[j] + 1;
          break;
        }
      }
      if (jumps[i] == Integer.MAX_VALUE) return false;
    }

    return jumps[n - 1] != Integer.MAX_VALUE;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
