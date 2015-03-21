package LeetCode;

public class CountAndSay
{
  // working!!
  public static String countAndSay(int n)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    String seq = "1";
    for (int i = 1 ; i < n ; i++) {
      String temp = "";
      char prev = seq.charAt(0);
      int count = 1;
      for (int j = 1 ; j < seq.length() ; j++) {
        if (prev == seq.charAt(j)) {
          count++;
        }
        else {
          temp += count + "" + prev;
          prev = seq.charAt(j);
          count = 1;
        }
      }
      temp += count + "" + prev;
      seq = temp;
      System.out.println(seq);
    }

    return seq;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(countAndSay(3));
  }

}
