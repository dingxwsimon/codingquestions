package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets2
{
  
  public List<List<Integer>> subsetsWithDup3(int[] num)
  {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (num == null || num.length == 0) {
      return result;
    }
    Arrays.sort(num);
    helper(result, new LinkedList<Integer>(), num, 0);
    return result;
  }

  private void helper(List<List<Integer>> ans, List<Integer> path, int[] num,
      int position)
  {
    ans.add(new LinkedList<Integer>(path));
    for (int i = position ; i < num.length ; i++) {
      if (i > position && num[i - 1] == num[i]) {
        // if duplicate, only append num[position]
        continue;
      }
      path.add(num[i]);
      helper(ans, path, num, i + 1);
      path.remove(path.size() - 1);
    }
  }

  
  
  
  // pass both
  // similar with combination sum 2
  public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num)
  {
    // Start typing your Java solution below
    // DO NOT write main() function

    // almost the same backtrack algorithm of combination sum II
    if (num.length == 0) {
      return null;
    }
    Arrays.sort(num);

    int[] backtrack = new int[num.length + 1];
    backtrack[0] = -1;
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    ss(num, result, 0, backtrack);

    return result;
  }

  // backtrack array contains the indexes
  public void ss(int[] num, ArrayList<ArrayList<Integer>> result, int level,
      int[] backtrack)
  {
    ArrayList<Integer> x = new ArrayList<Integer>();
    for (int i = 1 ; i <= level ; i++) {
      x.add(num[backtrack[i]]);
    }
    result.add(x);

    for (int i = backtrack[level] + 1 ; i < num.length ; i++) {
      backtrack[level + 1] = i;
      System.out.println("the level is " + level + " and i is " + i
          + " and backtrack is " + Arrays.toString(backtrack));
      ss(num, result, level + 1, backtrack);

      while (i + 1 < num.length && num[i] == num[i + 1]) {
        i++;
      }
    }

  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    Subsets2 s = new Subsets2();
    System.out.println(s.subsetsWithDup(new int[] { 1, 2, 2, 3 }).toString());
  }

}
