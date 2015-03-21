package dynamic;

public class MakePalindrome
{
  public static String shortest(String base)
  {
    int[][] len = new int[50][50];
    int[][] pad = new int[50][50];
    int n;

    String ans = "";
    int i, j, l;

    n = base.length();
    for (i = 0 ; i < n ; i++) {
      len[i][i] = 1;
      pad[i][i] = 4;
      len[i + 1][i] = 0;
      pad[i + 1][i] = 4;
    }

    for (l = 2 ; l <= n ; l++) {
      for (i = 0 ; i <= n - l ; i++) {
        char h, t;
        j = i + l - 1;
        h = base.charAt(i);
        t = base.charAt(j);
        if (h == t) {
          len[i][j] = len[i + 1][j - 1] + 2;
          pad[i][j] = 3;
        }
        else {
          if (len[i + 1][j] < len[i][j - 1]) {
            len[i][j] = len[i + 1][j] + 2;
            pad[i][j] = 1;
          }
          if (len[i + 1][j] > len[i][j - 1]) {
            len[i][j] = len[i][j - 1] + 2;
            pad[i][j] = 2;
          }
          if (len[i + 1][j] == len[i][j - 1]) {
            if (h < t) {
              len[i][j] = len[i + 1][j] + 2;
              pad[i][j] = 1;
            }
            else {
              len[i][j] = len[i][j - 1] + 2;
              pad[i][j] = 2;
            }
          }
        }
      }
    }

    // cout<<"end";

    i = 0;
    j = n - 1;
    l = 0;
    while (i < j) {

      switch (pad[i][j]) {
      case 1:
        ans = ans + base.charAt(i);
        i++;
        l++;
        break;
      case 2:
        ans = ans + base.charAt(j);
        j--;
        l++;
        break;
      case 3:
        ans = ans + base.charAt(i);
        i++;
        j--;
        l++;
        break;
      case 4:
        break;
      }
    }
    if (i == j) ans += base.charAt(i);
    for (i = l - 1 ; i >= 0 ; i--) {
      ans += ans.charAt(i);
    }
    return ans;

  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    // anw ADEEDBDEEDA
    System.out.println(shortest("EEDBDEDA"));
  }

}
