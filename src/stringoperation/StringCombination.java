package stringoperation;

public class StringCombination
{
  // print all subsets of the characters in s
  public static void comb1(String s)
  {
    comb1("", s);
  }

  // print all subsets of the remaining elements, with given prefix
  private static void comb1(String prefix, String s)
  {
    if (s.length() > 0) {
      System.out.println(prefix + s.charAt(0));
      comb1(prefix + s.charAt(0), s.substring(1));
      comb1(prefix, s.substring(1));
    }
  }

  // alternate implementation
  public static void comb2(String s)
  {
    comb2("", s);
  }

  private static void comb2(String prefix, String s)
  {
    System.out.println(prefix);
    for (int i = 0 ; i < s.length() ; i++)
      comb2(prefix + s.charAt(i), s.substring(i + 1));
  }

  // using bitset operation
  public static void AllSubsets(char[] ary, int n)
  {
    long i;
    long c = 1 << n;
    // iterate through all the different combination of 1 and 0
    for (i = 1 ; i < c ; ++i) {
      long tmp = i;
      int elem = 0;
      // print the number where the bit is 1
      while (tmp > 0) {
        if ((tmp & 1) == 1) System.out.print(ary[elem]);
        tmp >>= 1;
        ++elem;
      }
      System.out.print("\n");
    }
  }

  // read in N from command line, and print all subsets among N elements
  public static void main(String[] args)
  {
    int N = 5;
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String elements = alphabet.substring(0, N);

    // using first implementation
    comb1(elements);
    System.out.println("**************************************");

    AllSubsets(elements.toCharArray(), N);

    // using second implementation
    // comb2(elements);
    // System.out.println();
  }

}
