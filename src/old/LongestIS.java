/**
 * @(#) LongestIS.java Jan 13, 2010 6:33:29 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package old;

/**
 * Class <code>LongestIS</code>
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Jan 13, 2010 6:33:29 PM
 * 
 */
public class LongestIS
{

  // n^2
  public int LIS(int[] data)
  {
    int max = 0;
    int length = data.length;
    int[] lis = new int[length];
    int[] prev = new int[length];
    int pi = -1;
    int p;

    for (int i = 0 ; i < length ; i++) {
      prev[i] = -1;
    }

    for (int i = 0 ; i < length ; i++) {
      lis[i] = 1;
      for (int j = 0 ; j < i ; j++) {
        if (data[i] > data[j] && lis[j] + 1 > lis[i]) {
          lis[i] = lis[j] + 1;
          prev[i] = j;
        }
      }
    }

    for (int i = 0 ; i < length ; i++)
      if (lis[i] > max) {
        max = lis[i];
        pi = i;
      }

    p = data[pi];
    while (pi != -1) {
      p = data[pi];
      System.out.println(p);
      pi = prev[pi];

    }

    return max;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    LongestIS lis = new LongestIS();
    int[] data = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7,
        15 };
    System.out.println(lis.LIS(data));

  }
}
