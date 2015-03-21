package dynamic;

public class Polygon
{
  public int getmax(int N, int[] list)
  {
    int dp[][] = new int[N][N]; /*
                                 * row i represents computing with starting
                                 * point of list[i] and column j represents the
                                 * max result with j numbers after list[i];
                                 */

    int max = Integer.MIN_VALUE;

    for (int i = 0 ; i < N ; i++) {
      dp[i][0] = list[i];
    }

    for (int j = 1 ; j < N ; j++) {
      for (int i = 0 ; i < N ; i++) {
        for (int k = 0 ; k < j ; k++) {

          // int val=compute(dp[i][k],operator[(i+k)%N],dp[(i+k+1)%N][j-k-1]);
          int val = 0;

          if (val > dp[i][j]) dp[i][j] = val;
          if (val > max && j == N - 1) max = val;
        }
      }
    }

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
