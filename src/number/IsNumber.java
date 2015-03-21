package number;

public class IsNumber
{
  boolean isNumber(char[] str)
  {

    int i = 0;
    boolean dec = false; // is decimal?
    while (i < str.length) {
      if (str[i] == '-' || str[i] == '+') {
        if (i != 0) return false;
      }
      else if (str[i] == '.') {
        if (dec)
          return false; // we can have only one decimal point in a number
        else
          dec = true;

        if (i + 1 >= str.length) // make sure decimal is not last char in the
                                 // string
          return false;
      }
      else if (str[i] <= '0' || str[i] >= '9') return false;
      i++;
    }

    Double.parseDouble("");
    return dec;
  }

  // pass leetcode both
  public static boolean isNumber1(String s)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    int len = s.length();
    int i = 0, e = len - 1;
    while (i <= e && Character.isWhitespace(s.charAt(i)))
      i++;
    if (i > len - 1) return false;
    while (e >= i && Character.isWhitespace(s.charAt(e)))
      e--;
    // skip leading +/-
    if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;
    boolean num = false; // is a digit
    boolean dot = false; // is a '.'
    boolean exp = false; // is a 'e'
    while (i <= e) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        num = true;
      }
      else if (c == '.') {
        if (exp || dot) return false;
        dot = true;
      }
      else if (c == 'e') {
        if (exp || num == false) return false;
        exp = true;
        num = false;
      }
      else if (c == '+' || c == '-') {
        if (s.charAt(i - 1) != 'e') return false;
      }
      else {
        return false;
      }
      i++;
    }
    return num;
  }

  // return inputString,matches("[+-]?//d+(.//d+)?");

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(isNumber1("-1."));
  }

}
