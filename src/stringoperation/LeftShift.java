package stringoperation;

public class LeftShift
{

  // left shift will be achieved by reverse three times
  public static char[] leftShift(char[] input, int n)
  {
    if (input == null || n < 0) return null;

    if (n >= input.length) n = n % input.length;

    if (n == 0) return input;

    for (int i = 0, j = input.length - 1 ; i < j ; i++, j--) {
      char tmp = input[i];
      input[i] = input[j];
      input[j] = tmp;
    }

    for (int i = 0, j = input.length - 1 - n ; i < j ; i++, j--) {
      char tmp = input[i];
      input[i] = input[j];
      input[j] = tmp;
    }
    for (int i = input.length - n, j = input.length - 1 ; i < j ; i++, j--) {
      char tmp = input[i];
      input[i] = input[j];
      input[j] = tmp;
    }
    return input;
  }

  public static int gcd(int a, int b)
  {

    if (b == 0)
      return a;
    else
      return gcd(b, a % b);
  }

  // inplace, awsome
  public static char[] leftShift1(char[] str, int m)
  {
    int lenOfStr = str.length;
    int numOfGroup = gcd(lenOfStr, m);
    int elemInSub = lenOfStr / numOfGroup;

    for (int j = 0 ; j < numOfGroup ; j++) {
      char tmp = str[j];
      int i;
      for (i = 0 ; i < elemInSub - 1 ; i++)
        str[(j + i * m) % lenOfStr] = str[(j + (i + 1) * m) % lenOfStr];
      str[(j + i * m) % lenOfStr] = tmp;
    }
    return str;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(LeftShift.leftShift1("abcdefgh".toCharArray(), 3));
  }

}
