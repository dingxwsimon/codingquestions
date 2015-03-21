package stringoperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// not working yet
public class ParseWords
{
  public static String sentence = "dogsandcats";
  public static HashSet<String> dictionary = new HashSet<String>();

  static {
    dictionary.add("cat");
    dictionary.add("dog");
    dictionary.add("and");
    dictionary.add("sand");
    dictionary.add("dogs");
    dictionary.add("cats");
  }
  static ArrayList<String> oneresult = new ArrayList<String>();
  //http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
  boolean wordBreak(String str)
  {
    int size = str.length();

    // Base case
    if (size == 0) return true;

    // Try all prefixes of lengths from 1 to size
    for (int i = 1 ; i <= size ; i++) {
      // The parameter for dictionaryContains is str.substr(0, i)
      // str.substr(0, i) which is prefix (of input string) of
      // length 'i'. We first check whether current prefix is in
      // dictionary. Then we recursively check for remaining string
      // str.substr(i, size-i) which is suffix of length size-i
      String prefix = str.substring(0, i);
      System.out.println(prefix);
      if (dictionary.contains(prefix) && wordBreak(str.substring(i, size))) {
        oneresult.add(prefix);
        return true;
      }
    }

    // If we have tried all prefixes and none of them worked
    return false;
  }
  
  
  boolean wordBreak1(String str)
  {
    int size = str.length();
    if (size == 0) return true;

    // Create the DP table to store results of subroblems. The value wb[i]
    // will be true if str[0..i-1] can be segmented into dictionary words,
    // otherwise false.
    boolean[] wb = new boolean[size + 1];

    for (int i = 1 ; i <= size ; i++) {
      // if wb[i] is false, then check if current prefix can make it true.
      // Current prefix is "str.substr(0, i)"
      if (wb[i] == false && dictionary.contains(str.substring(0, i))) {
        oneresult.add(str.substring(0, i));
        wb[i] = true;
      }

      // wb[i] is true, then check for all substrings starting from
      // (i+1)th character and store their results.
      if (wb[i] == true) {
        // If we reached the last prefix
        if (i == size) return true;

        for (int j = i + 1 ; j <= size ; j++) {
          // Update wb[j] if it is false and can be updated
          // Note the parameter passed to dictionaryContains() is
          // substring starting from index 'i' and length 'j-i'
          if (wb[j] == false && dictionary.contains(str.substring(i, j))) {
            oneresult.add(str.substring(i, j));
            wb[j] = true;
          }

          // If we reached the last character
          if (j == size && wb[j] == true) return true;
        }
      }
    }

    /*
     * Uncomment these lines to print DP table "wb[]"*/
     System.out.println(Arrays.toString(wb));
     

    // If we have tried all prefixes and none of them worked
    return false;
  }
  
  

  // dfs
  // this is elegant
  static ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();

  // just return one possible segment
  public ArrayList<ArrayList<String>> segmentString(String s,
      HashSet<String> dict)
  {
    ArrayList<String> result = new ArrayList<String>();
    dfs(result, s, dict, 0);
    return all;
  }

  public void dfs(ArrayList<String> result, String s, HashSet<String> dict,
      int level)
  {
    if (level == s.length()) {
      all.add(new ArrayList<String>(result));
      return;
    }
    for (int i = level + 1 ; i <= s.length() ; i++) {
      String sub = s.substring(level, i);
      if (dict.contains(sub)) {
        result.add(sub);
        dfs(result, s, dict, i);
        result.remove(result.size() - 1);
      }
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    ParseWords p = new ParseWords();

    //System.out.println(p.segmentString(sentence, dictionary).toString());
    System.out.println(p.wordBreak1(sentence));
    System.out.println(oneresult.toString());
  }

}
