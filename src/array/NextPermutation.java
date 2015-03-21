package array;

import java.util.Arrays;

public class NextPermutation
{

  public static boolean nextPermutation(int[] p)
  {
    int a = p.length - 2;
    // step1
    while (a >= 0 && p[a] >= p[a + 1]) {
      a--;
    }
    if (a == -1) {
      return false;
    }
    // step2
    int b = p.length - 1;
    while (p[b] <= p[a]) {
      b--;
    }
    // step3
    int t = p[a];
    p[a] = p[b];
    p[b] = t;
    // step4
    for (int i = a + 1, j = p.length - 1 ; i < j ; i++, j--) {
      t = p[i];
      p[i] = p[j];
      p[j] = t;
    }
    return true;
  }

  public static void nearestNum(int[] x, int[] y)
  {
    int[] hist = new int[10];
    for (int i = 0 ; i < x.length ; i++) {
      hist[x[i]]++;
    }

    for (int i = 0 ; i < y.length ; i++) {
      int digit = y[i];
      if (hist[digit] == 0) {
        // get the next number and then print x from small to big
        for (int j = digit + 1 ; j < 10 ; j++) {
          if (hist[j] > 0) {
            x[i] = j;
            hist[j]--;
            // just output the rest digit in x
            // from small to big
            int orderidx = i + 1;
            for (int k = 0 ; k < 10 ; k++) {
              if (hist[k] > 0) {
                while (hist[k] > 0) {
                  x[orderidx] = k;
                  hist[k]--;
                  orderidx++;
                }
              }
            }
            return;
          }
        }
        // if come here throw exception?
      }
      // there is a match
      else {
        x[i] = digit;
        hist[digit]--;
      }
    }
    nextPermutation(x);
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    int[] a = new int[] { 4, 5, 3, 2, 1 };
    int[] b = new int[] { 2, 4, 1, 0 };
    nextPermutation(a);
    System.out.println(Arrays.toString(a));
    nearestNum(a, b);
    System.out.println(Arrays.toString(a) + "\n" + Arrays.toString(b));
  }

}
