package LeetCode;

import java.util.ArrayList;

public class SpiralMatrix
{
  // pass both
  public ArrayList<Integer> spiralOrder(int[][] matrix)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (matrix.length == 0) return result;
    if (matrix[0].length == 0) return result;
    print_spiral(matrix, matrix.length, matrix[0].length, 0, result);
    return result;
  }

  public static void print_spiral(int mat[][], int m, int n, int k,
      ArrayList<Integer> result)
  {
    if (m <= 0 || n <= 0) return;
    if (m == 1) {
      for (int j = 0 ; j < n ; j++)
        result.add(mat[k][k + j]);
      return;
    }
    if (n == 1) {
      for (int i = 0 ; i < m ; i++)
        result.add(mat[k + i][k]);
      return;
    }
    // print from top left
    for (int j = 0 ; j < n - 1 ; j++)
      result.add(mat[k][k + j]);
    // print from top right
    for (int i = 0 ; i < m - 1 ; i++)
      result.add(mat[k + i][k + n - 1]);
    // print from bottom right
    for (int j = 0 ; j < n - 1 ; j++)
      result.add(mat[k + m - 1][k + n - 1 - j]);
    // print from bottom left
    for (int i = 0 ; i < m - 1 ; i++)
      result.add(mat[k + m - 1 - i][k]);
    print_spiral(mat, m - 2, n - 2, k + 1, result);
  }

  public ArrayList<Integer> spiralOrder1(int[][] matrix) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<Integer> ret = new ArrayList<Integer>();
    if(matrix == null) return ret;
    if (matrix.length == 0) return ret;
    if (matrix[0].length == 0) return ret;
    int n = matrix.length;
    int i = 0, j = n-1;
    for(; i < j; i++,j--){
        for(int k = i; k < j; k++){
            ret.add(matrix[i][k]);
        }
        for(int k = i; k < j; k++){
            ret.add(matrix[k][j]);
        }
        for(int k = j; k > i; k--){
            ret.add(matrix[j][k]);
        }
        for(int k = j; k > i; k--){
            ret.add(matrix[k][i]);
        }
    }
    if(i == j) ret.add(matrix[i][j]);
    return ret;
}
  
  
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    SpiralMatrix sp = new SpiralMatrix();
    int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    
    System.out.println(sp.spiralOrder1(matrix));

  }

}
