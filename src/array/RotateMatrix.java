package array;

public class RotateMatrix
{

  // rotate the matrix clockwise 90 degree
  public static void rotate(int[][] matrix)
  {
    int n = matrix.length;
    for (int level = 0 ; level < n / 2 ; level++) {
      int first = level;
      int last = n - 1 - level;
      for (int i = first ; i < last ; i++) {
        int top = matrix[first][i];
        int offset = i - first;
        matrix[first][i] = matrix[last - offset][first];

        matrix[last - offset][first] = matrix[last][last - offset];

        matrix[last][last - offset] = matrix[i][last];

        matrix[i][last] = top;
      }
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
