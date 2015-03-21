package array;

import java.util.Arrays;
import java.util.LinkedList;

public class SlidingWin
{
  /*
   * Input: A long array A[], and a window width w
   * Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
   * Requirement: Find a good optimal way to get B[i]
   */

  public static void maxSlidingWindow(int A[], int n, int w, int B[])
  {
    LinkedList<Integer> Q = new LinkedList<Integer>();
    for (int i = 0 ; i < w ; i++) {
      while (!Q.isEmpty() && A[i] >= A[Q.getLast()])
        Q.pollLast();
      Q.addLast(i);
    }
    for (int i = w ; i < n ; i++) {
      B[i - w] = A[Q.getFirst()];
      while (!Q.isEmpty() && A[i] >= A[Q.getLast()])
        Q.pollLast();
      while (!Q.isEmpty() && Q.getFirst() <= i - w)
        Q.pollFirst();
      Q.addLast(i);
    }
    B[n - w] = A[Q.getFirst()];
  }

  //basically two methods are the same
  public static int[] getMaxInSlideWindow(int[] A, Integer w)
  {
    // invalid input
    if (A == null || w <= 0 || A.length - w + 1 <= 0) return null;

    int[] B = new int[A.length - w + 1];

    // auxiliary queue that is sorted in descending order
    LinkedList<Integer> q = new LinkedList<Integer>();

    for (int i = 0 ; i < A.length ; i++) {
      // enqueue. Remove those smaller values
      int data = A[i];
      // if the A[i] is violating q's sequence, then remove all the smaller
      // element in q
      while (!q.isEmpty() && q.getLast() < data) {
        q.removeLast();
      }
      q.addLast(data);

      if (i < w - 1) {
        continue;
      }

      // dequeue. If the current number is the maximum. Also remove it
      // from the queue
      Integer max = q.getFirst();
      B[i - w + 1] = max;
      if (A[i - w + 1] == max) {
        q.removeFirst();
      }
    }

    return B;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    int[] in = new int[] { 4, 3, 2, 1, 5, 7, 6, 8, 9 };
    int[] out = new int[in.length];
    maxSlidingWindow(in, 9, 3, out);
    System.out.println(Arrays.toString(out));
    System.out.println(Arrays.toString(getMaxInSlideWindow(in, 3)));
    System.out.println("");
  }

}
