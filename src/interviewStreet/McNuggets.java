package interviewStreet;

public class McNuggets
{

  public static boolean McNuggets(int n)
  {
    boolean ret = false;

    if (n < 1) return false;

    if ((n % 6 == 0) || (n % 9 == 0) || (n % 20 == 0)) return true;

    if (ret == false && n > 20) ret = McNuggets(n - 20);

    if (ret == false && n > 9) ret = McNuggets(n - 9);

    if (ret == false && n > 6) ret = McNuggets(n - 6);

    return ret;
  }

  public static boolean canBuyNMcNuggets(int n)
  {
    return n >= 0
        && (n == 0 || n % 6 == 0 || n % 9 == 0 || n % 20 == 0
            || canBuyNMcNuggets(n - 6) || canBuyNMcNuggets(n - 9) || canBuyNMcNuggets(n - 20));
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(McNuggets(33));
  }

}
