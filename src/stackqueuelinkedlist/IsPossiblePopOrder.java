package stackqueuelinkedlist;

import java.util.Stack;

public class IsPossiblePopOrder
{
  public static boolean isPoss(int[] pushArray, int[] popArray, int length)
  {
    boolean isPop = false;
    int pop = 0;
    int push = 0;
    Stack<Integer> stack = new Stack<Integer>();
    // n^2
    while (pop < length) {
      while (stack.isEmpty() || stack.peek() != popArray[pop]) {
        if (push >= length) break;
        stack.push(pushArray[push]);
        push++;
      }
      if (stack.peek() != popArray[pop]) break;
      stack.pop();
      pop++;
    }
    if (stack.isEmpty() && pop == length) isPop = true;

    return isPop;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    int[] push = new int[] { 1, 2, 3, 4, 5 };
    int[] pop = new int[] { 4, 3, 5, 1, 2 };
    System.out.println(isPoss(push, pop, 5));
  }

}
