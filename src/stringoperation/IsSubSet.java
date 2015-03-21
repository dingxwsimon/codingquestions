package stringoperation;

import java.util.BitSet;

public class IsSubSet
{

  // hashmap, or sort, ...

  // this idea can not handle the duplicate charracters
  public static boolean isSubSet(char[] input1, char[] input2)
  {
    if (input1 == null || input2 == null) return false;
    BitSet bs = new BitSet(128);
    bs.clear();
    for (int i = 0 ; i < input2.length ; i++) {
      bs.set((int) input2[i]);
    }
    for (int i = 0 ; i < input1.length ; i++) {
      bs.clear((int) input1[i]);
    }

    return bs.isEmpty();
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(IsSubSet.isSubSet("ABCDEEFGHLMNOPQRS".toCharArray(),
        "DEEEF".toCharArray()));
  }

}
