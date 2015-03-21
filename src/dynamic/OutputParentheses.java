/**
 * @(#) OutputParentheses.java Feb 22, 2010 6:16:35 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package dynamic;

/**
 * Class <code>OutputParentheses</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Feb 22, 2010 6:16:35 PM
 * 
 */
public class OutputParentheses
{

  public static void generate(String p, int l, int r, int n)
  {
    if (l == n && r == n) {
      System.out.println(p);
      return;
    }

    if (r > l) return;

    if (l >= r && l < n) generate(p + '{', l + 1, r, n);

    if (r < l) generate(p + '}', l, r + 1, n);

  }

  // simple easy to understand
  public static void printPar(int l, int r, char[] str, int count)
  {
    if (l < 0 || r < l) return; // invalid state
    if (l == 0 && r == 0) {
      System.out.println(str); // found one, so print it
    }
    else {
      if (l > 0) { // try a left paren, if there are some available
        str[count] = '(';
        printPar(l - 1, r, str, count + 1);
      }
      if (r > l) { // try a right paren, if there’s a matching left
        str[count] = ')';
        printPar(l, r - 1, str, count + 1);
      }
    }
  }

  // simple and clear
  public static void par(int n, int open, int closed, String str)
  {

    if (closed == n) {
      System.out.println(str);
      return;
    }

    if (open < n) {
      par(n, open + 1, closed, str + "{");
    }

    if (closed < open) {
      par(n, open, closed + 1, str + "}");
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    // OutputParentheses.generate("", 0, 0, 3);
    String s = "";
    // OutputParentheses.printPar(4, 4, str, 0);
    // generate(s, 0, 0, 4);
    par(4, 0, 0, s);
  }

}
