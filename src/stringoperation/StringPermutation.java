/**
 * @(#) StringPermutation.java Dec 2, 2009 9:28:44 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package stringoperation;


/**
 * Class <code>StringPermutation</code>
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Dec 2, 2009 9:28:44 PM
 * 
 */
public class StringPermutation
{

  public static int num = 0;

  public static void permute(String str)
  {
    int length = str.length();
    boolean[] used = new boolean[length];
    StringBuffer out = new StringBuffer();
    char[] in = str.toCharArray();

    doPermute(in, out, used, length, 0);
    // doCombination(in, out, used, length, 0, 3, 0);
  }

  public static void doPermute(char[] in, StringBuffer out, boolean[] used,
      int length, int level)
  {
    if (level == length) {
      System.out.println(out);
      return;
    }

    for (int i = 0 ; i < length ; i++) {
      if (used[i]) continue;
      out.append(in[i]);
      used[i] = true;
      doPermute(in, out, used, length, level + 1);
      used[i] = false;
      out.setLength(out.length() - 1);
    }
  }

  public static void doCombination(char[] in, StringBuffer out, boolean[] used,
      int length, int level, int k, int start)
  {
    if (level == k) {
      System.out.println(out);
      num++;
      return;
    }

    for (int i = start ; i < length ; i++) {
      out.append(in[i]);
      // if(i < length -1)
      doCombination(in, out, used, length, level + 1, k, i + 1);
      out.setLength(out.length() - 1);
    }
  }

  /*
   * public static ArrayList getPermutes(String s) {
   * ArrayList permutes = new ArrayList();
   * for(int i = 0; i < s.length(); i++) {
   * char c = s.charAt(i);
   * String[] words = getPermutes(s.removeChar(c));
   * for (String word : words) {
   * permutes.append(c + word);
   * }
   * }
   * return permutes;
   * }
   */

  public static void permutation(char[] array, int i)
  {
    int j;
    if (i == array.length) {
      System.out.println(array);
    }
    else {
      for (j = i ; j < array.length ; j++) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        permutation(array, i + 1);
        tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
      }
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    StringPermutation.permutation("1234".toCharArray(), 0);
  }

}
