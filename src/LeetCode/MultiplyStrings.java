package LeetCode;

public class MultiplyStrings
{

  // pass both self ***
  public static String multiply1(String num1, String num2)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (num1.equals("0") || num2.equals("0")) return "0";
    int[] result = new int[num1.length() + num2.length() + 1];
    int[] line = new int[num1.length() + num2.length() + 1];
    for (int i = num1.length() - 1 ; i >= 0 ; i--) {

      for (int k = 0 ; k < line.length ; k++) {
        line[k] = 0;
      }
      int carry = 0;
      for (int j = num2.length() - 1 ; j >= 0 ; j--) {
        int digit = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
        carry = digit / 10;
        line[i + j + 2] = digit % 10;
      }
      line[1 + i] = carry;

      carry = 0;
      for (int j = result.length - 1 ; j >= 0 ; j--) {
        int digit = result[j] + line[j] + carry;
        carry = digit / 10;
        result[j] = digit % 10;
      }
    }

    StringBuffer sb = new StringBuffer();
    boolean start = false;
    for (int i = 0 ; i < result.length ; i++) {
      if (start || result[i] > 0) {
        sb.append(result[i]);
        start = true;
      }
    }
    return sb.toString();
  }

  public static String multiply(String num1, String num2)
  {
    int[] result = new int[num1.length() + num2.length() + 1];
    int[] line = new int[num1.length() + num2.length() + 1];
    if (num1.equals("0") || num2.equals("0")) return "0";

    for (int i = 0 ; i < num2.length() ; i++) {

      for (int k = 0 ; k < line.length ; k++)
        line[k] = 0;

      int residue = 0;
      for (int k = 0 ; k < num1.length() ; k++) {

        int digit = (num2.charAt(num2.length() - 1 - i) - '0')
            * (num1.charAt(num1.length() - 1 - k) - '0') + residue;
        residue = digit / 10;
        digit = digit % 10;
        // this is the place shift line by 1 for every i
        line[k + i] = digit;
      }

      line[num1.length() + i] = residue;

      residue = 0;
      for (int k = 0 ; k < result.length ; k++) {
        int digit = result[k] + line[k] + residue;
        residue = digit / 10;
        digit = digit % 10;

        result[k] = digit;
      }
    }

    StringBuffer sb = new StringBuffer();

    boolean matter = false;
    for (int i = 0 ; i < result.length ; i++) {

      if (matter == true || result[result.length - 1 - i] > 0) {
        sb.append(result[result.length - 1 - i]);
        matter = true;
      }
    }

    return sb.toString();
  }

  public static String add(String a, String b)
  {
    int size = Math.max(a.length(), b.length());
    int[] result = new int[size + 1];
    int residue = 0;
    for (int k = 0 ; k < size ; k++) {
      int digit = 0;
      if (k < b.length() && k < a.length())
        digit = (b.charAt(b.length() - 1 - k) - '0')
            + (a.charAt(a.length() - 1 - k) - '0') + residue;
      else if (k < b.length())
        digit = (b.charAt(b.length() - 1 - k) - '0') + residue;
      else if (k < a.length())
        digit = (a.charAt(a.length() - 1 - k) - '0') + residue;
      residue = digit / 10;
      digit = digit % 10;
      result[k] = digit;
    }

    result[size] = residue;

    StringBuffer sb = new StringBuffer();

    boolean matter = false;
    for (int i = 0 ; i < result.length ; i++) {

      if (matter == true || result[result.length - 1 - i] > 0) {
        sb.append(result[result.length - 1 - i]);
        matter = true;
      }
    }

    return sb.toString();
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    String num = "123";
    String num2 = "234";
    System.out.println(MultiplyStrings.multiply1(num, num2));
    // System.out.println(MultiplyStrings.add(num, num2));
    // Decode.simple(num);
  }

}
