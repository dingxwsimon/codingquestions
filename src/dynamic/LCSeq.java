/**
 * @(#) LCSeq.java Jan 13, 2010 5:54:20 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package dynamic;


/**
 * Class <code>LCSeq</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Jan 13, 2010 5:54:20 PM
 * 
 */
public class LCSeq
{

  public int LCS(String str1, String str2)
  {
    int length1 = str1.length();
    int length2 = str2.length();

    int[][] c = new int[length1 + 1][length2 + 1];
    /*
     * Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j]
     * contains length of LCS of X[0..i-1] and Y[0..j-1]
     */
    for (int i = 1 ; i <= length1 ; i++) {
      for (int j = 1 ; j <= length2 ; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1))
          c[i][j] = c[i - 1][j - 1] + 1;
        else
          c[i][j] = Math.max(c[i][j - 1], c[i - 1][j]);
      }
    }

    return c[length1][length2];

  }

  // basically the two method are the same
  //this one can print out the subseq
  public static void LCS1(String x, String y)
  {
    int M = x.length();
    int N = y.length();

    // opt[i][j] = length of LCS of x[i..M] and y[j..N]
    int[][] opt = new int[M + 1][N + 1];

    // compute length of LCS and all subproblems via dynamic programming
    for (int i = M - 1 ; i >= 0 ; i--) {
      for (int j = N - 1 ; j >= 0 ; j--) {
        if (x.charAt(i) == y.charAt(j))
          opt[i][j] = opt[i + 1][j + 1] + 1;
        else
          opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
      }
    }

    // recover LCS itself and print it to standard output
    int i = 0, j = 0;
    while (i < M && j < N) {
      if (x.charAt(i) == y.charAt(j)) {
        System.out.print(x.charAt(i));
        i++;
        j++;
      }
      else if (opt[i + 1][j] >= opt[i][j + 1])
        i++;
      else
        j++;
    }
    System.out.println();
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    LCSeq lcs = new LCSeq();

    System.out.println(lcs.LCS("ABCDGH", "AEDFHR"));
    lcs.LCS1("ABCDGH", "AEDFHR");
    // abcdefghijklmnzyxwvutsrqpo
    // opqrstuvwxyzabcdefghijklmn
    // a1b2c3d4e
    // zz1yy2xx3ww4vv
    // lcs.LCS1("AGCAT","GAC");
  }

}
