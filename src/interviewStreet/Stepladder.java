package interviewStreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class Stepladder
{
  public static ArrayList<WordNode> nodeList = new ArrayList<WordNode>();
  public static HashMap<WordNode, ArrayList<WordNode>> neighbors = new HashMap<WordNode, ArrayList<WordNode>>();

  public static Comparator<WordNode> myComparator = new Comparator<WordNode>() {

    @Override
    public int compare(WordNode o1, WordNode o2)
    {
      if (o1.score == o2.score)
        return 0;
      else if (o1.score > o2.score)
        return -1;
      else
        return 1;
    }
  };

  private static final Map<Character, Integer> myMap;
  static {
    myMap = new HashMap<Character, Integer>();
    myMap.put('A', 1);
    myMap.put('E', 1);
    myMap.put('I', 1);
    myMap.put('L', 1);
    myMap.put('N', 1);
    myMap.put('O', 1);
    myMap.put('R', 1);
    myMap.put('S', 1);
    myMap.put('T', 1);
    myMap.put('U', 1);
    myMap.put('D', 2);
    myMap.put('G', 2);
    myMap.put('B', 3);
    myMap.put('C', 3);
    myMap.put('M', 3);
    myMap.put('P', 3);
    myMap.put('F', 4);
    myMap.put('H', 4);
    myMap.put('V', 4);
    myMap.put('W', 4);
    myMap.put('Y', 4);
    myMap.put('K', 5);
    myMap.put('J', 8);
    myMap.put('X', 8);
    myMap.put('Q', 10);
    myMap.put('Z', 10);
  }

  public static void readDictionary()
  {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String line = br.readLine();
      int K = Integer.parseInt(line.trim());
      line = br.readLine();
      int N = Integer.parseInt(line.trim());
      for (int i = 0 ; i < N ; i++) {
        line = br.readLine();
        if (line.length() == K) {
          nodeList.add(new WordNode(line));
        }
      }
      System.out.println("finished readDictionary");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void computeNeighbors()
  {
    Collections.sort(nodeList, myComparator);
    System.out.println("finished sort");
    for (int i = 0 ; i < nodeList.size() ; i++) {
      WordNode wni = nodeList.get(i);
      for (int j = i + 1 ; j < nodeList.size() ; j++) {
        WordNode wnj = nodeList.get(j);
        if (oneDistance(wni.word, wnj.word)) {
          if (neighbors.containsKey(wni)) {
            neighbors.get(wni).add(wnj);
          }
          else {
            ArrayList<WordNode> l = new ArrayList<WordNode>();
            l.add(wnj);
            neighbors.put(wni, l);
          }

          if (neighbors.containsKey(wnj)) {
            neighbors.get(wnj).add(wni);
          }
          else {
            ArrayList<WordNode> l = new ArrayList<WordNode>();
            l.add(wni);
            neighbors.put(wnj, l);
          }
        }
      }
      if (!neighbors.containsKey(wni)) {
        ArrayList<WordNode> l = new ArrayList<WordNode>();
        neighbors.put(wni, l);
      }
    }
    System.out.println("finished computeNeighbors");
  }

  public static boolean oneDistance(String word1, String word2)
  {
    if (word1.length() != word2.length()) return false;
    int diff = 0;
    for (int i = 0 ; i < word1.length() ; i++) {
      if (word1.charAt(i) != word2.charAt(i)) diff++;
      if (diff > 1) return false;
    }
    return true;
  }

  public static void compHighestScore()
  {
    readDictionary();
    computeNeighbors();
    int highestScore = 0;

    for (WordNode w : nodeList) {
      System.out.println(w.word);
      int wScore = w.score;
      if (highestScore >= (wScore ^ 2)) continue;

      Stack<Ladder> stack = new Stack<Ladder>();
      stack.push(new Ladder(w, w, new ArrayList<WordNode>(), -w.score));
      while (!stack.isEmpty()) {
        Ladder old = stack.pop();
        int score = old.score + old.top.score + old.bottom.score;
        ArrayList<WordNode> ladd = new ArrayList<WordNode>(old.ladder);
        ladd.add(old.top);
        ladd.add(old.bottom);
        HashSet<WordNode> laddSet = new HashSet<WordNode>();
        for (WordNode wl : ladd) {
          laddSet.add(wl);
        }
        System.out.println("score = " + score + " highestScore = "
            + highestScore);
        if (score > highestScore) {
          highestScore = score;
        }
        ArrayList<WordNode> bottomNeighbors = new ArrayList<WordNode>();
        for (WordNode wl : neighbors.get(old.bottom)) {
          if (!laddSet.contains(wl) && old.bottom.score > wl.score)
            bottomNeighbors.add(wl);
        }

        ArrayList<WordNode> topNeighbors = new ArrayList<WordNode>();
        for (WordNode wl : neighbors.get(old.top)) {
          if (!laddSet.contains(wl) && old.top.score > wl.score)
            topNeighbors.add(wl);
        }

        for (WordNode wb : bottomNeighbors) {
          for (WordNode wt : topNeighbors) {
            int wtScore = wt.score;
            int wbScore = wb.score;
            if (wtScore != wbScore
                && score + wbScore * (wbScore + 1) / 2 + wtScore
                    * (wtScore + 1) / 2 > highestScore) {
              stack.push(new Ladder(wb, wt, ladd, score));
            }
          }
        }
      }
    }

    System.out.println(highestScore);
  }

  public static class Ladder
  {
    public WordNode bottom;
    public WordNode top;
    public ArrayList<WordNode> ladder;
    public int score;

    public Ladder(WordNode bottom, WordNode top, ArrayList<WordNode> ladder,
        int score)
    {
      super();
      this.bottom = bottom;
      this.top = top;
      this.ladder = ladder;
      this.score = score;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    compHighestScore();
  }

  public static class WordNode
  {
    public String word;
    public int score = 0;

    public WordNode(String word)
    {
      this.word = word;
      for (char c : word.toCharArray()) {
        score += myMap.get(c);
      }
    }
  }

}
