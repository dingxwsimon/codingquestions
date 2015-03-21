package number;

import java.util.LinkedList;

public class ReFormat
{
  // put the count of that number first

  public static void Reformat(int[] original, int length)
  {
    LinkedList<Integer> list = new LinkedList<Integer>();

    int currentCount = 0;
    int prev = original[0];
    for (int i = 0 ; i < length ; i++) {
      if (original[i] != prev) {
        list.add(currentCount);
        list.add(prev);
        currentCount = 1;
        prev = original[i];
      }
      else {
        currentCount++;
      }
    }
    list.add(currentCount);
    list.add(prev);

    System.out.println(list);
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    Reformat(new int[] { 1, 1, 2, 3, 3, 1 }, 6);
  }

}
