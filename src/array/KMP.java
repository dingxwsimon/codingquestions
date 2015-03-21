package array;

import java.util.Arrays;

public class KMP
{

  // http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/

  public static void main(String[] argv)
  {
    //match("mississippi", "issip");
    computePartialMatchTable("AAABAAA");
  }

  // can only return the first match point, then it will throw exception
  // need to fix that
  public static void match(String text, String pattern)
  {
    int j = 0;
    if (text.length() == 0) return;
    int[] failure = computePartialMatchTable(pattern);
    int matchPoint = 0;
    for (int i = 0 ; i < text.length() && j < pattern.length() ; i++) {
      
      while (j > 0 && pattern.charAt(j) != text.charAt(i)) {
        j = failure[j - 1];
      }
      if (pattern.charAt(j) == text.charAt(i)) {
        j++;
      }
      if (j == pattern.length()) {
        matchPoint = i - pattern.length() + 1;
        System.out.println("find match start from " + matchPoint + text.substring(matchPoint));
        j = 0;
      }
    }
  }

  /*
   * failure[i] = the longest proper prefix of pat[0..i]
   * which is also a suffix of pat[0..i].
   */
  private static int[] computePartialMatchTable(String pattern)
  {
    int j = 0;
    int[] failure = new int[pattern.length()];
    for (int i = 1 ; i < pattern.length() ; i++) {
      if (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
        j = 0; //failure[j - 1];
      }
      if (pattern.charAt(j) == pattern.charAt(i)) {
        j++;
      }
      failure[i] = j;
    }
    return failure;
  }

}
