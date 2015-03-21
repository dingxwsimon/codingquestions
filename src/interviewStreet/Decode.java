package interviewStreet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import tree.Trie;

public class Decode
{

  public static void transformDict()
  {
    try {
      BufferedReader br = new BufferedReader(new FileReader("./dict.txt"));
      String line = "";
      while ((line = br.readLine()) != null) {
        String transformedStr = transformWord(line);
        if (tranDict.containsKey(transformedStr)) {
          tranDict.get(transformedStr).add(line);
        }
        else {
          ArrayList<String> wordLists = new ArrayList<String>();
          wordLists.add(line);
          tranDict.put(transformedStr, wordLists);
        }
      }
    }
    catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  static HashMap<String, ArrayList<String>> tranDict = new HashMap<String, ArrayList<String>>();

  public static String transformWord(String word)
  {
    StringBuilder sb = new StringBuilder();
    for (int i = 0 ; i < word.length() ; i++) {
      sb.append(((word.charAt(i) - 97) % 5 + 1) + "");
    }
    return sb.toString();
  }

  private static Trie trie = new Trie();

  public void constructDict(ArrayList<String> words)
  {
    for (String word : words)
      trie.insert(word);
  }

  public static void constrDict()
  {
    try {
      BufferedReader br = new BufferedReader(new FileReader("./dict.txt"));
      String line = "";
      while ((line = br.readLine()) != null) {
        trie.insert(line);
      }
    }
    catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private static String[] mapping = { "afkpuz", "bglqv", "chmrw", "dinsx",
      "ejoty" };

  public static void telWord(String message)
  {
    constrDict();
    int[] telNum = new int[message.length()];
    for (int i = 0 ; i < telNum.length ; i++) {
      telNum[i] = message.charAt(i) - 49;
    }
    int n = telNum.length;
    int answer[] = new int[n];
    while (true) {
      if (trie.search(getResult(telNum, answer, n - 1)) == 1)
        System.out.println(getResult(telNum, answer, n - 1));
      int k = n - 1;
      while (k >= 0) {
        answer[k]++;
        while (answer[k] <= mapping[telNum[k]].length() - 1
            && trie.search(getResult(telNum, answer, k)) == 0) {
          answer[k]++;
        }
        if (answer[k] <= mapping[telNum[k]].length() - 1)
          break;
        else {
          answer[k] = 0;
          k--;
        }
      }
      if (k < 0) break;
    }
  }

  public static String getResult(int[] telNum, int[] answer, int k)
  {
    StringBuilder result = new StringBuilder();
    for (int i = 0 ; i <= k ; i++)
      result.append(mapping[telNum[i]].charAt(answer[i]));
    // System.out.println("current resutl " + result.toString());
    return result.toString();
  }

  public static void simple(String message)
  {
    transformDict();
    if (tranDict.containsKey(message)) {
      for (String word : tranDict.get(message)) {
        System.out.println(word);
      }
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    String num = "2545";
    Decode.telWord(num);
    // Decode.simple(num);
  }

}
