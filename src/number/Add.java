package number;

;

/**
 * @(#) Add.java Dec 1, 2009 10:08:07 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */

/**
 * Class <code>Add</code>
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Dec 1, 2009 10:08:07 PM
 * 
 */
public class Add
{
  // CC150
  public static int add_no_arithm(int a, int b)
  {
    if (b == 0) return a;
    int sum = a ^ b; // add without carrying
    int carry = (a & b) << 1; // carry, but dont add
    return add_no_arithm(sum, carry); // recurse
  }

  int add(int a, int b)
  {
    int cry, add;
    do {
      add = a ^ b;
      cry = (a & b) << 1;

      a = add;
      b = cry;
    } while (cry != 0);
    return add;
  }

  int divide(int a, int b)
  {
    if (b == 0) throw new ArithmeticException();

    boolean neg = (a > 0) ^ (b > 0);
    if (a < 0) {
      a = -a;
    }

    if (b < 0) {
      b = -b;
    }

    if (a < b) return 0;

    int msb = 0;
    for (msb = 0 ; msb < 32 ; msb++) {
      if ((b << msb) >= a) {
        break;
      }
    }

    int q = 0;
    for (int i = msb ; i >= 0 ; i--) {
      if ((b << i) > a) {
        continue;
      }
      q |= (1 << i);
      a -= (b << i);
    }

    if (neg) return -q;

    return q;
  }

  public static void main(String[] args)
  {
    int a = 231;
    int b = 789;

    int c = Add.add_no_arithm(a, b);
    System.out.println(c);
  }
}
