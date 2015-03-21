package number;

public class CircleLastRemain
{
  public static int LastRemaining_Solution2(int n, int m)
  {
    // invalid input
    if (n <= 0 || m < 0) return -1;

    // if there are only one integer in the circle initially,
    // of course the last remaining one is 0
    int lastinteger = 0;

    // find the last remaining one in the circle with n integers
    for (int i = 2 ; i <= n ; i++)
      lastinteger = (lastinteger + m) % i;

    return lastinteger;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(LastRemaining_Solution2(10, 5));
  }

}
