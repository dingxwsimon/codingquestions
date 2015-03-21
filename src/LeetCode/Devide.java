package LeetCode;

public class Devide
{

  public static int divide1(int dividend, int divisor)
  {
    int a = Math.abs(dividend);
    int b = Math.abs(divisor);

    // b maybe Integer.MIN_VALUE

    boolean neg = (dividend > 0 && divisor < 0)
        || (dividend < 0 && divisor > 0);
    if (divisor == 0) {

      return Integer.MAX_VALUE;
    }
    if (divisor == Integer.MIN_VALUE) {
      if (dividend == Integer.MIN_VALUE) {
        return 1;
      }
      else {
        return 0;
      }
    }
    if (dividend == Integer.MIN_VALUE) {
      if (neg) {
        return -1 + divide(dividend + b, b);
      }
      else {
        return 1 - divide(dividend + b, b);
      }
    }

    int product = b, result = 0;
    while (a >= b) {
      int q = 1;
      while (a - product >= product) {
        q = q << 1;
        product = product << 1;
      }
      System.out.println("a " + a + " b = " + b + " product = " + product
          + " q = " + q);
      a = a - product;
      product = b;
      result += q;
    }

    if (!neg) {
      return result;
    }
    else {
      return -result;
    }
  }

  // slow
  // pass both
  public static int divide(int dividend, int divisor)
  {
    if (dividend == 0 || divisor == 1) return dividend;
    if (dividend == divisor) return 1;
    int code;
    if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
      code = 0;// negative
    else
      code = 1;
    if (dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE)
      return 0;
    else if (dividend == Integer.MIN_VALUE && divisor == Integer.MAX_VALUE)
      return code == 0
                      ? -1
                      : 1;

    long div = dividend, div2 = divisor;
    div = Math.abs(div);
    div2 = Math.abs(div2);
    // System.out.println(div + " " + div2 + " " + code);
    double ret = Math.pow(10, Math.log10((div)) - Math.log10(((div2))));
    int result = (int) Math.floor(ret + 0.0000001);
    return code == 0
                    ? -result
                    : result;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(divide1(123456, 7));
  }

}
