package array;

import java.util.Arrays;

public class OverlapDisk
{
  public static void main(String[] args)
  {
    int[] array1 = { 1, 5, 2, 1, 4, 0 };
    System.out.println("result1 = " + number_of_disc_intersections(array1));
  }

  /*
   * Given an array A of N integers we draw N discs in a 2D plane,
   * such that i-th disc has center in (0,i) and a radius A[i].
   * We say that k-th disc and j-th disc intersect, if
   * and k-th and j-th discs have at least one common point.
   * Write a function
   * which given an array A describing N discs as explained above,
   * returns the number of pairs of intersecting discs. =
   */

  public static int number_of_disc_intersections(int[] A)
  {
    int N = A.length;
    double[] begin = new double[N];
    double[] end = new double[N];
    for (int i = 0 ; i < N ; i++) {
      begin[i] = i - A[i];
      end[i] = i + A[i];
    }
    Arrays.sort(begin);

    int sum = 0;
    for (int i = 0 ; i < N ; i++) {
      double e = end[i];
      int index = Arrays.binarySearch(begin, e + 0.5);
      int insert = -(index + 1);
      sum += (insert - i - 1);
      if (sum > 10000000) {
        return (-1);
      }
    }

    return sum;
  }

}
