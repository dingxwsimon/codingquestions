package number;

public class PascalTriangle
{

  public static void print(int n)
  {

    for (int line = 1 ; line <= n ; line++) {
      int c = 1;
      for (int i = 1 ; i <= line ; i++) {
        System.out.print(c + " ");
        c = c * (line - 1) / i;
      }
      System.out.print("\n");
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    print(10);
  }

}
