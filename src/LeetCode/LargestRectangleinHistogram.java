package LeetCode;

import java.util.Stack;

public class LargestRectangleinHistogram
{

  // pass both simple!! decent
  public static int largestRectangleArea1(int[] height)
  {
    Stack<Integer> p = new Stack<Integer>();
    int i = 0, m = 0;
    int n = height.length;
    if (n < 1) return 0;
    int[] h = new int[n + 1];
    for (int j = 0 ; j < n ; j++)
      h[j] = height[j];
    h[n] = 0;

    while (i < h.length) {
      if (p.empty() || h[p.peek()] <= h[i]) // it does not matter <= or <
        p.push(i++);
      else {
        int t = p.pop();
        m = Math.max(m, h[t] * (p.empty()
                                         ? i
                                         : i - p.peek() - 1));
      }
    }
    return m;
  }

  /*
   * Step by step to crack Programming Interview questions Q39: Find Largest
   * Rectangle Size in a Histogram in linear time.
   * E.g. in histogram {2,4,2,1}, the largest rectangle starts from 1st until
   * 3rd with height of 2. The largest size is thus 6.
   * Solution:
   * Use Stack to keep track of height and start indexes
   * Compare current height with previous one
   * #1: current Larger than previous (top of height stack)
   * Push current height & index as candidate rectangle start position
   * #2: current EQUALS previous
   * Ignore, as largest rectangle will start from previous with same height
   * #3: current is less than previous
   * Need keep popping out previous heights, and compute the candidate rectangle
   * with height and width (current index MINUS previous index)
   * Push the height and index (appropriate position) to stacks
   */

  public static int largestRectangleArea(int[] height)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    Stack<Integer> heights = new Stack<Integer>();
    Stack<Integer> indexes = new Stack<Integer>();
    int largestsize = 0;
    for (int i = 0 ; i < height.length ; i++) {
      if (heights.isEmpty() || height[i] > heights.peek()) {
        heights.push(height[i]);
        indexes.push(i);
      }
      else if (height[i] < heights.peek()) {
        int lastindex = 0;

        while (!heights.isEmpty() && height[i] < heights.peek()) {
          lastindex = indexes.pop();
          int tempsize = heights.pop() * (i - lastindex);
          if (tempsize > largestsize) {
            largestsize = tempsize;
          }
        }

        heights.push(height[i]);
        indexes.push(lastindex);
      }
    }

    while (!heights.isEmpty()) {
      int tempsize = heights.pop() * (height.length - indexes.pop());
      if (tempsize > largestsize) {
        largestsize = tempsize;
      }
    }

    return largestsize;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    int[] histo = { 2, 4, 2, 1 };
    System.out.println(largestRectangleArea1(histo));
  }

}
