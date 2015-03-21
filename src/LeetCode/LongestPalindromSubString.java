package LeetCode;

public class LongestPalindromSubString
{

  public String expandAroundCenter(String s, int c1, int c2)
  {
    int l = c1, r = c2;
    int n = s.length();
    while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    return s.substring(l + 1, r);
  }

  // pass both O(n^2)
  public String longestPalindromeSimple(String s)
  {
    int n = s.length();
    if (n == 0) return "";
    String longest = s.substring(0, 1); // a single char itself is a palindrome
    for (int i = 0 ; i < n - 1 ; i++) {
      String p1 = expandAroundCenter(s, i, i);
      if (p1.length() > longest.length()) longest = p1;

      String p2 = expandAroundCenter(s, i, i + 1);
      if (p2.length() > longest.length()) longest = p2;
    }
    return longest;
  }

  /*
   * my....j.....id.....i....mx
   * ..........................
   * j = 2*id-i
   * if (mx - i > P[j])
   * P[i] = P[j];
   * else //P[j] >= mx - i
   * P[i] = mx - i; // p[i] get the min, and start match again
   */

  // manacher's algorithm
  // pass both O(n)
  // p[i] is the max length of the palindrom center at S[i], including S[i]
  // id is the center, mx = id + P[id]
  public String longestPalindrome(String s)
  {
    String T = preProcess(s);
    int n = T.length();
    int[] P = new int[n];
    int id = 0, mx = 0;
    for (int i = 1 ; i < n - 1 ; i++) {
      int i_mirror = 2 * id - i; // equals to i' = C - (i-C)

      P[i] = (mx > i)
                     ? Math.min(mx - i, P[i_mirror])
                     : 0;

      // Attempt to expand palindrome centered at i
      while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i]))
        P[i]++;

      // If palindrome centered at i expand past R,
      // adjust center based on expanded palindrome.
      if (i + P[i] > mx) {
        id = i;
        mx = i + P[i];
      }
    }

    // Find the maximum element in P.
    int maxLen = 0;
    int centerIndex = 0;
    for (int i = 1 ; i < n - 1 ; i++) {
      if (P[i] > maxLen) {
        maxLen = P[i];
        centerIndex = i;
      }
    }
    return s.substring((centerIndex - 1 - maxLen) / 2,
        (centerIndex - 1 - maxLen) / 2 + maxLen);
  }

  public String preProcess(String s)
  {
    int n = s.length();
    if (n == 0) return "^$";
    String ret = "^";
    for (int i = 0 ; i < n ; i++)
      ret += "#" + s.substring(i, i + 1);

    ret += "#$";
    return ret;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    LongestPalindromSubString lp = new LongestPalindromSubString();
    System.out.println(lp.longestPalindromeSimple("abb"));
  }

}
