package number;

public class GCD
{

  public static int GCD(int a, int b)
  {
    if (a < b) return GCD(b, a);
    if (b == 0)
      return a;
    else
      return GCD(a - b, b);
  }

}
