package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence
{
  
  public int longestConsecutive(int[] num) {
    int longest = 1;
    HashSet<Integer> set = new HashSet<Integer>();
    for (Integer in: num) set.add(in);
    for (Integer in: num) {
        int left = in - 1, right = in + 1;
        while (set.contains(left)) {
            set.remove(left);
            left --;
        }
        while (set.contains(right)) {
            set.remove(right);
            right ++;
        }
        longest = Math.max(longest, right - left - 1);
    }
    return longest;
}
  
  
  

  public int findLongestConsequence(int[] a)
  {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int max = 1;
    for (int i : a) {
      if (map.containsKey(i)) continue;
      map.put(i, 1);
      if (map.containsKey(i - 1)) {
        max = Math.max(max, merge(map, i - 1, i));
      }
      if (map.containsKey(i + 1)) {
        max = Math.max(max, merge(map, i, i + 1));
      }
      System.out.println(map.toString());
    }
    return max;
  }

  private int merge(HashMap<Integer, Integer> map, int left, int right)
  {
    int upper = right + map.get(right) - 1;
    int lower = left - map.get(left) + 1;
    int len = upper - lower + 1;
    map.put(upper, len);
    map.put(lower, len);
    return len;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    LongestConsecutiveSequence l = new LongestConsecutiveSequence();
    System.out.println(l.findLongestConsequence(new int[] { -7, 2, -3, 8, 9, 0,
        8, 4, -5, 8, -5, -5, 1, 6, 4, 3 }));
  }

}
