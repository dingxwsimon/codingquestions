/**
 * @(#) SpecSort.java Feb 22, 2010 7:35:57 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package old;

/**
 * Class <code>SpecSort</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Feb 22, 2010 7:35:57 PM
 * 
 */
public class SpecSort
{

  public static int[] arrangeOddEven(int a[])
  {
    int s = 0;
    int e = a.length - 1;
    while (s < e) {
      while (a[s] % 2 == 1)
        s++; // skip odds
      while (a[e] % 2 == 2)
        e++; // skip evens
      int t = a[s];
      a[s] = a[e];
      a[e] = t; // do swap
      s++;
      e--;
    }

    int os = 0; // odd start
    int oe = s--; // odd end
    int es = e++; // even start
    int ee = a.length - 1; // even end

    // Now my sort both array
    for (int i = os ; i <= oe ; i++)
      for (int j = os + 1 ; j <= oe ; j++)
        if (a[i] < a[j]) {
          int t = a[i];
          a[i] = a[j];
          a[j] = t;
        }// swap

    for (int i = es ; i <= ee ; i++)
      for (int j = es + 1 ; j <= ee ; j++)
        if (a[i] > a[j]) {
          int t = a[i];
          a[i] = a[j];
          a[j] = t;
        } // swap
    return a;
  }

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    int[] a = { 13, 11, 5, 7, 22, 24, 8, 13, 9, 2, 4, 6, 8 };
    int[] b = SpecSort.arrangeOddEven(a);
    for (int i : a)
      System.out.println(i);
  }
}
