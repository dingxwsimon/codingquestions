package dynamic;

public class ApplePass
{
  /*
   * N boys are sitting in a circle. Each of them have some apples in their
   * hand.
   * You find that the total number of the apples can be divided by N.
   * So you want to divide the apples equally among all the boys.
   * But they are so lazy that each one of them only wants to give one apple to
   * one of the neighbors at one step.
   * Calculate the minimal number of steps to make each boy have the same number
   * of apples.
   * Input Given:
   * 1. A number N => number of children.
   * 2. Sequence of N numbers, each representing number of apples a child has.
   * <<P.S.>>
   * Passing an apple means a child giving away one apple to one of its
   * neighbour.
   * Even if 2 separate children can pass apples simultaneously or one child can
   * pass 1-1 apple to each of its neighbours then that will still be counted as
   * 2 steps and not 1 step.
   */

  public static class Child
  {
    int AppleCount;

    Child()
    {
      AppleCount = 0;
    }

    Child(int appleCount)
    {
      AppleCount = appleCount;
    }
  };

  // Returns false if there are no apples to pass, true otherwise
  public static boolean PassApples(Child[] children, int childCount,
      int appleCount)
  {

    // Check our kids and see if there are more apples to be passed on
    boolean needsPass = false;
    int endIdx = childCount - 1;
    for (int i = 0 ; i < childCount ; ++i) {

      int prevChildIdx;

      if (i == 0)
        prevChildIdx = childCount - 1;
      else
        prevChildIdx = i - 1;

      // If the child before us has less apples than desired, pass it to him
      if (children[prevChildIdx].AppleCount < appleCount
          && children[i].AppleCount > 0) {
        children[prevChildIdx].AppleCount += 1;
        children[i].AppleCount -= 1;
        needsPass = true;
      }
      else {
        // If this child has excess apples, pass it along.
        if (children[i].AppleCount > appleCount) {
          children[i].AppleCount -= 1;
          children[(i + 1) % childCount].AppleCount += 1;
          needsPass = true;
        }
      }
    }

    return needsPass;
  }

  public static void main(String[] args)
  {

    // @TODO: Read the values in from input, or a file or something...
    int CHILDCOUNT = 5;
    Child children[] = new Child[5];// { 3, 4, 6, 10, 2 };

    // Find total apples
    int totalApples = 0;
    for (int i = 0 ; i < CHILDCOUNT ; ++i)
      totalApples += children[i].AppleCount;

    boolean needsPass = true;
    int numPasses = 0;
    while (needsPass) {
      if (PassApples(children, CHILDCOUNT, totalApples / CHILDCOUNT))
        ++numPasses;
      else
        needsPass = false;
    }

  }
}
