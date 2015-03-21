/**
 * @(#) InShuffle.java Mar 31, 2010 12:13:40 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package array;

/**
 * Class <code>InShuffle</code> given a1a2a3a4b1b2b3b4 convert to
 * a1b1a2b2a3b3a4b4
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Mar 31, 2010 12:13:40 PM
 * 
 */
public class InShuffle
{

  public static void shuffle1(char ar[], int n)
  {
    for (int i = 0, j = 1 ; i < n ; i++, j += 2) {
      rightrotate(ar, j, n + i);
    }
  }

  public static void rightrotate(char[] data, int start, int end)
  {
    char temp = data[end];
    int i = 0;
    for (i = end ; i > start ; i--) {
      data[i] = data[i - 1];
    }
    data[i] = temp;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    char[] ar = { 'a', 'b', 'c', 'd', 'e', 'f', '1', '2', '3', '4', '5', '6' };
    int n = 6;
    InShuffle.shuffle1(ar, n);
    System.out.println(ar);
  }

}
