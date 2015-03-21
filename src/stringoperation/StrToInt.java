package stringoperation;

public class StrToInt
{
  public static int strToInt(String str)
      throws Exception
  {
    if (str == null) throw new Exception();

    boolean negative = false;
    boolean symbolFront = false;
    if (str.charAt(0) == '-') {
      symbolFront = true;
      negative = true;
    }
    if (str.charAt(0) == '+') {
      symbolFront = true;
      negative = false;
    }
    int i = 0;
    if (symbolFront) i = 1;
    int sum = 0;
    for ( ; i < str.length() ; i++) {
      if (str.charAt(i) < '0' || str.charAt(i) > '9')
        throw new Exception();
      else {
        int digit = str.charAt(i) - '0';
        if ((Integer.MAX_VALUE - digit) / 10 < sum)
          throw new Exception();
        else
          sum = sum * 10 + digit;
      }
    }

    if (negative) sum *= -1;
    return sum;

  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    try {
      System.out.println(StrToInt.strToInt("-01238"));
    }
    catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
