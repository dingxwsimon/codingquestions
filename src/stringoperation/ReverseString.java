/**
8 * @(#) ReverseString.java Mar 8, 2010 11:54:41 AM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package stringoperation;

/**
 * Class <code>ReverseString</code>
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Mar 8, 2010 11:54:41 AM
 * 
 */
public class ReverseString
{
  // inplace inverse string
  public static void reverse(String str)
  {
    char[] c = str.toCharArray();

    int i = 0, j = str.length() - 1;

    while (i < j) {
      char ch = c[i];
      c[i] = c[j];
      c[j] = ch;
      i++;
      j--;
    }
    System.out.println(c);
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    ReverseString.reverse("simon");

  }

}
