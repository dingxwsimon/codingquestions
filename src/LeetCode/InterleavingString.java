package LeetCode;

import array.MaxSumMatrix;

public class InterleavingString
{
  // pass both
  // isInterleaving(s1,len1,s2,len2,s3,len3)
  // = (s3.lastChar == s1.lastChar) && isInterleaving(s1,len1 -
  // 1,s2,len2,s3,len3 - 1)
  // ||(s3.lastChar == s2.lastChar) && isInterleaving(s1,len1,s2,len2 -
  // 1,s3,len3 - 1)
  // DP, matrix
  public boolean isInterleave(String s1, String s2, String s3)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    int m = s1.length();
    int n = s2.length();
    int len = s3.length();
    if (n + m != len) {
      return false;
    }
    if (m == 0) return s2.equals(s3);
    if (n == 0) return s1.equals(s3);

    boolean[][] result = new boolean[m + 1][n + 1];
    for (int i = 1 ; i <= m ; i++) {
      if (s1.charAt(i - 1) == s3.charAt(i - 1)) result[i][0] = true;
    }
    System.out.println(MaxSumMatrix.printMatrix(result));
    for (int j = 1 ; j <= n ; j++) {
      if (s2.charAt(j - 1) == s3.charAt(j - 1)) result[0][j] = true;
    }

    for (int i = 1 ; i <= m ; i++)
      for (int j = 1 ; j <= n ; j++) {
        if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && result[i - 1][j])
          result[i][j] = true;
        if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && result[i][j - 1])
          result[i][j] = true;
      }
    System.out.println(MaxSumMatrix.printMatrix(result));
    return result[m][n];
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    InterleavingString i = new InterleavingString();
    System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
  }

}
