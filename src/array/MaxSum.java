/**
 * @(#) MaxSum.java Jan 11, 2010 4:18:48 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package array;

/**
 * Class <code>MaxSum</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Jan 11, 2010 4:18:48 PM
 * 
 */
public class MaxSum
{

  // handle negative also
  public int maxSum(int[] data)
  {
    if (data == null) return 0;
    int n = data.length;
    int nAll = data[0];
    int nStart = data[0];

    for (int i = 1 ; i < n ; i++) {
      if (nStart < 0) nStart = 0;
      nStart += data[i];
      if (nStart > nAll) nAll = nStart;
    }

    return nAll;
  }
  
  
  public static int maxSubArraySum(int a[])
  {
     int max_so_far = a[0], i;
     int curr_max = a[0];
   
     for (i = 1; i < a.length; i++)
     {
          curr_max = Math.max(a[i], curr_max+a[i]);
          max_so_far = Math.max(max_so_far, curr_max);
     }
     return max_so_far;
  }

  // this function out put the start and end index of the max sum sequence
  public int maxSum1(int[] data)
  {
    int n = data.length;
    int nAll = data[0];
    int nStart = data[0];
    int start = 0;
    int end = 0;
    for (int i = 1 ; i < n ; i++) {
      if (nStart < 0) {
        nStart = 0;
        start = i;
      }
      nStart += data[i];
      if (nStart > nAll) {
        nAll = nStart;
        end = i;
      }
    }
    System.out.println("start from " + start + " and end at " + end);

    return nAll;
  }

  // O(n*n*m)
  public int maxMatrixSum(int[][] data)
  {
    int max = Integer.MIN_VALUE;
    int[][] ps = PS(data);
    int n = data.length;
    int m = data[0].length;
    for (int a = 1 ; a <= n ; a++)
      for (int c = a ; c <= n ; c++) {

        int start = BC(ps, a, c, 1);
        int all = BC(ps, a, c, 1);
        for (int i = 2 ; i <= m ; i++) {
          if (start < 0) start = 0;
          start += BC(ps, a, c, i);
          if (start > all) all = start;
        }
        if (all > max) max = all;
      }
    return max;
  }

  public int BC(int[][] ps, int a, int c, int i)
  {
    return ps[c][i] - ps[a - 1][i] - ps[c][i - 1] + ps[a - 1][i - 1];
  }

  public int[][] PS(int[][] data)
  {
    int[][] ps = new int[data.length + 1][data[0].length + 1];
    for (int i = 0 ; i <= data.length ; i++)
      ps[i][0] = 0;
    for (int i = 0 ; i <= data[0].length ; i++)
      ps[0][i] = 0;
    for (int i = 1 ; i <= data.length ; i++)
      for (int j = 1 ; j <= data[0].length ; j++)
        ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1]
            + data[i - 1][j - 1];
    return ps;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    int[] a = new int[] { -1, -2, -3, -4, -10, -8 };
    int data[][] = new int[][] { { -6, 4, 3, -5 }, { 10, -7, 9, -2 } };

    MaxSum ms = new MaxSum();
    System.out.println(ms.maxSubArraySum(a));
    System.out.println(ms.maxMatrixSum(data));

  }

}
