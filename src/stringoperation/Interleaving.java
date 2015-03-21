package stringoperation;

public class Interleaving
{
  // little similar to parenthesis generation
  public static void printIlsRecur(String str1, String str2, StringBuilder sb,
      int m, int n, int i)
  {
    // Base case: If all characters of str1 and str2 have been included in
    // output string, then print the output string
    if (m == 0 && n == 0) {
      System.out.println(sb);
    }
    // System.out.println("m = " + m + " n = " + n);
    // If some characters of str1 are left to be included, then include the
    // first character from the remaining characters and recur for rest
    if (m != 0) {
      sb.setCharAt(i, str1.charAt(0));
      printIlsRecur(str1.substring(1), str2, sb, m - 1, n, i + 1);
    }

    // If some characters of str2 are left to be included, then include the
    // first character from the remaining characters and recur for rest
    if (n != 0) {
      sb.setCharAt(i, str2.charAt(0));
      printIlsRecur(str1, str2.substring(1), sb, m, n - 1, i + 1);
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    StringBuilder sb = new StringBuilder("       ");
    printIlsRecur("abcd", "efg", sb, 4, 3, 0);
  }

}
