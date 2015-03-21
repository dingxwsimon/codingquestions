/**
 * @(#) spiral.java Jun 2, 2010 9:36:32 AM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package array;

/**
 * Class <code>spiral</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Jun 2, 2010 9:36:32 AM
 * 
 */
public class spiral
{

  // iterative
  public static void PrintInSpiral(int[][] numbers, int size)
  {
    for (int i = size - 1, j = 0 ; i >= 0 ; i--, j++) {
      for (int k = j ; k < i ; k++)
        System.out.println(numbers[j][k] + " ");
      for (int k = j ; k < i ; k++)
        System.out.println(numbers[k][i] + " ");
      for (int k = i ; k > j ; k--)
        System.out.println(numbers[i][k] + " ");
      for (int k = i ; k > j ; k--)
        System.out.println(numbers[k][j] + " ");
    }
    if (size % 2 == 1) System.out.println(numbers[size / 2][size / 2]);
  }

  // recursive
  public static void print_spiral(int mat[][], int m, int n, int k)
  {
    if (m <= 0 || n <= 0) return;
    if (m == 1) {
      for (int j = 0 ; j < n ; j++)
        System.out.println(mat[k][k + j] + " ");
      return;
    }
    if (n == 1) {
      for (int i = 0 ; i < m ; i++)
        System.out.println(mat[k + i][k] + " ");
      return;
    }
    // print from top left
    for (int j = 0 ; j < n - 1 ; j++)
      System.out.println(mat[k][k + j] + " ");
    // print from top right
    for (int i = 0 ; i < m - 1 ; i++)
      System.out.println(mat[k + i][k + n - 1] + " ");
    // print from bottom right
    for (int j = 0 ; j < n - 1 ; j++)
      System.out.println(mat[k + m - 1][k + n - 1 - j] + " ");
    // print from bottom left
    for (int i = 0 ; i < m - 1 ; i++)
      System.out.println(mat[k + m - 1 - i][k] + " ");
    print_spiral(mat, m - 2, n - 2, k + 1);
  }

  public static void print_spiral_helper(int mat[][], int m, int n)
  {
    print_spiral(mat, m, n, 0);
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    int[][] data = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    // print_spiral_helper(data, 4,4);
    PrintInSpiral(data, 3);
  }

}
