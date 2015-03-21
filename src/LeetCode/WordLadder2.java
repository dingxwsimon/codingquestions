package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2
{

  Map<String, List<String>> map;
  List<List<String>> results;

  public List<List<String>> findLadders(String start, String end,
      Set<String> dict)
  {
    results = new ArrayList<List<String>>();
    if (dict.size() == 0) return results;

    int min = Integer.MAX_VALUE;

    Queue<String> queue = new ArrayDeque<String>();
    queue.add(start);

    map = new HashMap<String, List<String>>();

    Map<String, Integer> ladder = new HashMap<String, Integer>();
    for (String string : dict)
      ladder.put(string, Integer.MAX_VALUE);
    ladder.put(start, 0);

    dict.add(end);
    // BFS: Dijisktra search
    while (!queue.isEmpty()) {

      String word = queue.poll();

      int step = ladder.get(word) + 1;// 'step' indicates how many steps are
                                      // needed to travel to one word.

      if (step > min) break;

      for (int i = 0 ; i < word.length() ; i++) {
        StringBuilder builder = new StringBuilder(word);
        for (char ch = 'a' ; ch <= 'z' ; ch++) {
          builder.setCharAt(i, ch);
          String new_word = builder.toString();
          if (ladder.containsKey(new_word)) {
            // Check if it is the shortest path to one word.
            if (step > ladder.get(new_word))
              continue;
            else if (step < ladder.get(new_word)) {
              queue.add(new_word);
              ladder.put(new_word, step);
            }
            else
              ;// It is a KEY line. If one word already appeared in one ladder,
               // Do not insert the same word inside the queue twice. Otherwise
               // it gets TLE.

            if (map.containsKey(new_word)) // Build adjacent Graph
              map.get(new_word).add(word);
            else {
              List<String> list = new LinkedList<String>();
              list.add(word);
              map.put(new_word, list);
              // It is possible to write three lines in one:
              // map.put(new_word,new LinkedList<String>(Arrays.asList(new
              // String[]{word})));
              // Which one is better?
            }

            if (new_word.equals(end)) min = step;

          }// End if dict contains new_word
        }// End:Iteration from 'a' to 'z'
      }// End:Iteration from the first to the last
    }// End While

    // BackTracking
    LinkedList<String> result = new LinkedList<String>();
    backTrace(end, start, result);

    return results;
  }

  private void backTrace(String word, String start, List<String> list)
  {
    if (word.equals(start)) {
      list.add(0, start);
      results.add(new ArrayList<String>(list));
      list.remove(0);
      return;
    }
    list.add(0, word);
    if (map.get(word) != null) {
      for (String s : map.get(word)) {
        backTrace(s, start, list);
      }
    }
    list.remove(0);
  }

  // can not use bfs cause we can not meintain several lists same time
  // this is dfs
  public static ArrayList<ArrayList<String>> wordLadderII(String start,
      String end, HashSet<String> dict)
  {
    ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
    ArrayList<String> path = new ArrayList<String>();
    wordLadderIIHelper(start, end, dict, path, ret);

    int min = 0;
    for (ArrayList<String> item : ret) {
      min = (min == 0 || item.size() < min)
                                           ? min = item.size()
                                           : min;
    }

    for (int i = 0 ; i < ret.size() ; i++) {
      // REMEMBER the "i--" when removing elements from ArrayList
      if (ret.get(i).size() > min) ret.remove(i--);
    }
    return ret;
  }

  // this find all the path, not only shortest one
  public static void wordLadderIIHelper(String start, String end,
      HashSet<String> dict, ArrayList<String> path,
      ArrayList<ArrayList<String>> ret)
  {
    path.add(start);
    char[] sArr = start.toCharArray();
    for (int i = 0 ; i < sArr.length ; i++) {
      char origin = sArr[i];
      for (char c = 'a' ; c <= 'z' ; c++) {
        if (c != origin) {
          sArr[i] = c;
          String temp = new String(sArr);
          if (temp.equals(end)) {
            path.add(temp);
            ret.add(new ArrayList<String>(path));
            path.remove(path.size() - 1);
          }
          else if (dict.contains(temp) && !path.contains(temp))
            wordLadderIIHelper(temp, end, dict, path, ret);
        }
      }
      sArr[i] = origin;
    }
    path.remove(path.size() - 1);
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    WordLadder2 w = new WordLadder2();
    HashSet<String> dict = new HashSet<String>();
    dict.add("hot");
    dict.add("dot");
    dict.add("dog");
    dict.add("lot");
    dict.add("log");
    System.out.println(w.wordLadderII("hit", "cog", dict).toString());
  }

}
