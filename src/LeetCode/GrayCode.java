package LeetCode;

import java.util.ArrayList;

public class GrayCode
{

  // really nice
  public static ArrayList<Integer> grayCode1(int n)
  {
    ArrayList<Integer> ret = new ArrayList<Integer>();
    int count = 0x01 << n;
    for (int i = 0 ; i < count ; ++i) {
      System.out.println(Integer.toBinaryString(i) + " "
          + Integer.toBinaryString(i ^ (i >> 1)));
      ret.add(i ^ (i >> 1));
    }
    return ret;
  }

  /*
   * The gray code is a binary numeral system where two successive values differ
   * in only one bit.
   * Given a non-negative integer n representing the total number of bits in the
   * code, print the sequence of gray code. A gray code sequence must begin with
   * 0.
   * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
   */

  public ArrayList<Integer> grayCode(int n)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (n == 0) {
      result.add(0);
      return result;
    }
    gray("", n, result);
    return result;
  }

  public void yarg(String prefix, int n, ArrayList<Integer> result)
  {
    if (n == 0) {
      System.out.println(prefix);
      result.add(Integer.parseInt(prefix, 2));
    }
    else {
      gray(prefix + "1", n - 1, result);
      yarg(prefix + "0", n - 1, result);
    }
  }

  // append order n gray code to end of prefix string, and print
  public void gray(String prefix, int n, ArrayList<Integer> result)
  {
    if (n == 0) {
      System.out.println(prefix);
      result.add(Integer.parseInt(prefix, 2));
    }
    else {
      gray(prefix + "0", n - 1, result);
      yarg(prefix + "1", n - 1, result);
    }
  }

  public static void main(String[] args)
  {
    GrayCode g = new GrayCode();
    System.out.println(g.grayCode1(3));
  }

}
