package LeetCode;

public class Search2DMatrix
{
  // pass both
  public boolean searchMatrix(int[][] matrix, int target)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    int m = matrix.length;
    if (m == 0) return false;
    int n = matrix[0].length;
    if (n == 0) return false;

    int l = 0;
    int u = m * n - 1;

    while (l <= u) {
      int mid = l + (u - l) / 2;
      int row = mid / n;
      int column = mid % n;
      if (matrix[row][column] == target) return true;
      if (matrix[row][column] > target)
        u = mid - 1;
      else
        l = mid + 1;
    }
    return false;
  }

  public static boolean searchMatrix1(int[][] matrix, int target)
  {
    int m = matrix.length;
    if (m == 0) return false;
    int n = matrix[0].length;
    if (n == 0) return false;
    int i = 0;
    int j = n - 1;
    while (i < m && j >= 0) {
      if (matrix[i][j] == target)
        return true;
      else if (matrix[i][j] > target)
        j--;
      else
        i++;
    }
    return false;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    Search2DMatrix s = new Search2DMatrix();
    System.out.println(s.searchMatrix(new int[][] { { 1 }, { 1 } }, 2));
  }

}
