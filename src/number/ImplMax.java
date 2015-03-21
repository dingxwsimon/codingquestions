package number;

public class ImplMax
{
  public static int flip(int bit)
  {
    return 1 ^ bit;
  }

  // 1 if a is positive, 0 if a is negative
  public static int sign(int a)
  {
    return flip((a >> 31) & 0x1);
  }

  public static int getMaxNaive(int a, int b)
  {
    int k = sign(a - b);
    int q = flip(k);
    return a * k + b * q;
  }

  public static int getMax(int a, int b)
  {
    int c = a - b;
    int sa = sign(a);
    int sb = sign(b);
    int sc = sign(c);

    int use_signof_a = sa ^ sb;
    int use_signof_c = flip(sa ^ sb);

    int k = use_signof_a * sa + use_signof_c * sc;
    int q = flip(k);
    return a * k + b * q;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(flip(0));
  }

}
