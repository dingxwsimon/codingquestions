package LeetCode;

public class SetMatrixZeroes
{
  // pass both
  // can use one row and one column in the matrix as storage
  public void setZeroes(int[][] matrix)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    int m = matrix.length;
    if (m == 0) return;
    int n = matrix[0].length;
    if (n == 0) return;

    int[] rows = new int[m];
    int[] columns = new int[n];
    for (int i = 0 ; i < m ; i++) {
      for (int j = 0 ; j < n ; j++) {
        if (matrix[i][j] == 0) {
          rows[i] = 1;
          columns[j] = 1;
        }
      }
    }

    for (int i = 0 ; i < m ; i++) {
      for (int j = 0 ; j < n ; j++) {
        if ((rows[i] == 1) || columns[j] == 1) matrix[i][j] = 0;
      }
    }
    return;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    SetMatrixZeroes s = new SetMatrixZeroes();
    s.setZeroes(new int[][] { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 },
        { 1, 2, 1, 3 }, { 0, 0, 1, 1 } });
  }

}
