package LeetCode;

public class UniquePath2
{

  // pass both
  public int uniquePathsWithObstacles(int[][] obstacleGrid)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (obstacleGrid.length == 0) return 0;
    if (obstacleGrid[0].length == 0) return 0;
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    int[][] res = new int[m][n];
    boolean obstacle = false;
    for (int i = 0 ; i < m ; i++) {
      if (obstacleGrid[i][0] == 1) obstacle = true;
      if (obstacle)
        res[i][0] = Integer.MAX_VALUE;
      else
        res[i][0] = 1;
    }
    obstacle = false;
    for (int j = 0 ; j < n ; j++) {
      if (obstacleGrid[0][j] == 1) obstacle = true;
      if (obstacle)
        res[0][j] = Integer.MAX_VALUE;
      else
        res[0][j] = 1;
    }

    for (int i = 1 ; i < m ; i++) {
      for (int j = 1 ; j < n ; j++) {
        if (obstacleGrid[i][j] == 1
            || (res[i][j - 1] == Integer.MAX_VALUE && res[i - 1][j] == Integer.MAX_VALUE))
          res[i][j] = Integer.MAX_VALUE;
        else if (res[i][j - 1] != Integer.MAX_VALUE
            && res[i - 1][j] == Integer.MAX_VALUE)
          res[i][j] = res[i][j - 1];
        else if (res[i][j - 1] == Integer.MAX_VALUE
            && res[i - 1][j] != Integer.MAX_VALUE)
          res[i][j] = res[i - 1][j];
        else
          res[i][j] = res[i][j - 1] + res[i - 1][j];

      }
    }
    if (res[m - 1][n - 1] == Integer.MAX_VALUE)
      return 0;
    else
      return res[m - 1][n - 1];
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    UniquePath2 u = new UniquePath2();
    u.uniquePathsWithObstacles(new int[][] { { 0, 0 }, { 1, 0 } });
  }

}
