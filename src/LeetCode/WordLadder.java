package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class WordLadder
{

  public int ladderLength(String start, String end, HashSet<String> dict)
  {
    Math.min(1,0);
    Set<String> visited = new HashSet<String>();
    Queue<String> queue = new LinkedList<String>();
    queue.offer(start);
    int distance = 1;
    int count = 1;
    visited.add(start);

    while (!queue.isEmpty()) {
      while (count > 0) {
        String w = (String) queue.poll();
        for (String str : getOneEditWords(w)) {
          if (str.equals(end)) return distance + 1;
          if (dict.contains(str) && !visited.contains(str)) {
            queue.offer(str);
            visited.add(str);
          }
        }
        count--;
      }
      distance++;
      count = queue.size();
    }
    return 0;
  }
  
  public int ladderLength1(String start, String end, HashSet<String> dict) {
      // Start typing your Java solution below
      // DO NOT write main() function
      HashSet<String> visited = new HashSet<String>();
      LinkedList<String> q = new LinkedList<String>();
      q.add(start);
      int len = 1;
      int count=1;
      visited.add(start);
      while(!q.isEmpty()){
          while(count > 0){
              String s = q.poll();
              char[] sA = s.toCharArray();
              for(int i = 0; i < sA.length; i++){
                  char orign = sA[i];
                  for(char j = 'a'; j <= 'z'; j++){
                      if(j != orign){
                          sA[i]=j;
                          String tmp = new String(sA);
                          if(tmp.equals(end)){
                              return len+1;
                          }
                          if(dict.contains(tmp) && !visited.contains(tmp)){
                              q.offer(tmp);
                              visited.add(tmp);
                          }
                      }
                  }
                  sA[i]=orign;
              }
              count--;
          }
          len++;
          count = q.size();
      }
      return 0;
  }

  // this is from CC150 18.10
  // only return 1 shortest path
  // BFS
  public static LinkedList<String> transform(String startWord, String stopWord,
      Set<String> dictionary)
  {
    startWord = startWord.toLowerCase();
    stopWord = stopWord.toLowerCase();
    Queue<String> actionQueue = new LinkedList<String>();
    Set<String> visitedSet = new HashSet<String>();
    Map<String, String> backtrackMap = new TreeMap<String, String>();

    actionQueue.add(startWord);
    visitedSet.add(startWord);

    while (!actionQueue.isEmpty()) {
      String w = actionQueue.poll();
      // For each possible word v from w with one edit operation
      for (String v : getOneEditWords(w)) {
        if (v.equals(stopWord)) {
          // Found our word! Now, back track.
          LinkedList<String> list = new LinkedList<String>();
          // Append v to list
          list.add(v);
          while (w != null) {
            list.add(0, w);
            w = backtrackMap.get(w);
          }
          return list;
        }

        // If v is a dictionary word
        if (dictionary.contains(v) && !visitedSet.contains(v)) {
          actionQueue.add(v);
          visitedSet.add(v); // mark visited
          backtrackMap.put(v, w);
        }
      }
    }
    return null;
  }

  private static Set<String> getOneEditWords(String word)
  {
    Set<String> words = new HashSet<String>();
    // for every letter
    for (int i = 0 ; i < word.length() ; i++) {
      char[] wordArray = word.toCharArray();
      // change that letter to something else
      for (char c = 'a' ; c <= 'z' ; c++) {
        if (c != word.charAt(i)) {
          wordArray[i] = c;
          words.add(new String(wordArray));
        }
      }
    }
    return words;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    WordLadder w = new WordLadder();
    HashSet<String> dict = new HashSet<String>();
    dict.add("hot");
    dict.add("dot");
    dict.add("dog");
    dict.add("lot");
    dict.add("log");
    System.out.println(w.ladderLength1("hit", "cog", dict));
  }

}
