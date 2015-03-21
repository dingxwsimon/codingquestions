/**
 * @(#) AllSubset.java Jan 21, 2010 9:18:36 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package dynamic;

import java.util.ArrayList;

/**
 * Class <code>AllSubset</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Jan 21, 2010 9:18:36 PM
 * 
 */
public class AllSubset
{
  public static void AllSubsets(int[] ary, int n)
  {
    long i;
    long c = 1 << n;
    for (i = 1 ; i < c ; ++i) {
      long tmp = i;
      int elem = 0;
      while (tmp > 0) {
        if ((tmp & 1) == 1) System.out.print(ary[elem]);
        tmp >>= 1;
        ++elem;
      }
      System.out.print("\n");
    }
  }

  public static void recursiveGenKSubsets(boolean[] subset, int n, int k)
  {
    // Base case 1: Since n equals k, the entire set needs to
    // be generated. Set the remaining elements true and
    // print out the set.
    if (n == k) {
      for (int i = 0 ; i < n ; i++)
        subset[i] = true;

      // printSubset(subset);
      return;
    }

    // Base case 2: Since k equals 0, it means that the subset
    // has been completely generated. Set the remaining elements
    // false and print out the subset.
    if (k == 0) {
      for (int i = 0 ; i < n ; i++)
        subset[i] = false;

      // printSubset(subset);
      return;
    }

    // Recursive case
    if (k > 0 && n > k) {
      // Missing code for recursive call 1
      subset[n - 1] = true;
      recursiveGenKSubsets(subset, n - 1, k - 1);

      // Missing code for recursive call 2
      subset[n - 1] = false;
      recursiveGenKSubsets(subset, n - 1, k);
    }
  }

  /*
   * public static void KSubSets( int n, int k, int depth, String SubSet, int i)
   * {
   * if (depth == k)
   * System.out.println(SubSet);
   * else if (n - i + 1 >= k - depth)
   * {
   * char[] Num = new char[128];
   * for (int j = i; j <= n; j++)
   * {
   * System.out.println(Num + (SubSet.compareTo("") == 0 ? "" : ",") + j);
   * KSubSets(n, k, depth + 1, SubSet + Num, j + 1);
   * }
   * }
   * }
   */

  public static void KSubSets(int n, int k, int level, int[] data, int i,
      StringBuffer out)
  {
    if (level == k) {
      System.out.println(out);

    }
    else if (k - level <= n - i + 1) {
      for (int j = i ; j < n ; j++) {
        out.append(data[j]);
        KSubSets(n, k, level + 1, data, j + 1, out);
        out.setLength(out.length() - 1);
      }
    }

  }

  // good idea, natural to understand
  public static ArrayList<ArrayList<Integer>> getSubsets(
      ArrayList<Integer> set, int index)
  {
    ArrayList<ArrayList<Integer>> allsubsets;
    if (set.size() == index) { // Base case - add empty set
      allsubsets = new ArrayList<ArrayList<Integer>>();
      allsubsets.add(new ArrayList<Integer>());
    }
    else {
      allsubsets = getSubsets(set, index + 1);
      int item = set.get(index);
      ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
      for (ArrayList<Integer> subset : allsubsets) {
        ArrayList<Integer> newsubset = new ArrayList<Integer>();
        newsubset.addAll(subset); //
        newsubset.add(item);
        moresubsets.add(newsubset);
      }
      allsubsets.addAll(moresubsets);
    }
    return allsubsets;
  }

  public static void main(String[] args)
  {
    // int[] ary = {1,2,3,4};
    // AllSubset as = new AllSubset();
    // as.AllSubsets(ary, 4);

    // int[] data = {1,2,3,4,5};
    // StringBuffer out = new StringBuffer();
    // AllSubset.AllSubsets(data,5);
    // AllSubset.KSubSets(5, 3, 0, data, 0, out);

    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 1 ; i < 4 ; i++) {
      list.add(i);
    }
    ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
    System.out.println(subsets.toString());

  }

}
