package number;

public class CopyPastLength
{

  static int findMaxK(int n)
  {
    int power = 2;
    double max = 0.0;
    int maxK = 0;
    while (n > 0) {
      n -= 2;
      double t = (double) n / power;
      double r = Math.pow(t, (double) power);
      if (r > max) {
        maxK = power;
        max = r;
      }
      power++;
    }
    return maxK;
  }

  static int f(int n)
  {
    if (n <= 7) return n;
    int k = findMaxK(n);

    int sum = n - 2 * (k - 1);
    int mul = 1;
    while (k > 0) {
      int avg = sum / k;
      mul *= avg;
      k--;
      sum -= avg;
    }

    assert (sum == 0);

    return mul;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(f(27));
  }

}
