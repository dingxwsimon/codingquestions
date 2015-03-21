package LeetCode;

import java.util.ArrayList;

public class TextJustification
{
  // pass both, myself
  public ArrayList<String> fullJustify1(String[] words, int L)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<String> result = new ArrayList<String>();
    if (words == null || words.length == 0) return result;
    ArrayList<String> line = new ArrayList<String>();

    int totallength = 0;
    for (int i = 0 ; i < words.length ; i++) {
      totallength += words[i].length();
      if (totallength + line.size() > L) {
        int numspaces = L - totallength + words[i].length();
        result.add(geneLine(line, numspaces, L));
        line.clear();
        totallength = words[i].length();
      }
      line.add(words[i]);
    }
    int numspaces = L - totallength;
    ArrayList<Integer> spaces = new ArrayList<Integer>();
    for (int j = 0 ; j < line.size() - 1 ; j++) {
      spaces.add(1);
    }
    spaces.add(numspaces - line.size() + 1);

    StringBuffer lineresult = new StringBuffer();
    lineresult.append(line.get(0));
    for (int j = 0 ; j < spaces.size() ; j++) {
      for (int k = 0 ; k < spaces.get(j) ; k++)
        lineresult.append(" ");
      if (j < line.size() - 1) lineresult.append(line.get(j + 1));
    }

    result.add(lineresult.toString());

    return result;
  }

  public String geneLine(ArrayList<String> line, int numspaces, int L)
  {
    ArrayList<Integer> spaces = new ArrayList<Integer>();
    if (line.size() == 1) {
      spaces.add(numspaces);
    }
    else {
      int each = numspaces / (line.size() - 1);
      int residu = numspaces % (line.size() - 1);
      for (int j = 0 ; j < line.size() - 1 ; j++)
        if (residu > 0) {
          spaces.add(each + 1);
          residu--;
        }
        else
          spaces.add(each);
    }
    StringBuffer lineresult = new StringBuffer();
    lineresult.append(line.get(0));
    for (int j = 0 ; j < spaces.size() ; j++) {
      for (int k = 0 ; k < spaces.get(j) ; k++)
        lineresult.append(" ");
      if (j < line.size() - 1) lineresult.append(line.get(j + 1));
    }
    return lineresult.toString();
  }

  public ArrayList<String> fullJustify(String[] words, int L)
  {
    ArrayList<String> result = new ArrayList<String>();
    int i = 0;
    while (i < words.length) {
      // store all words of a line together
      ArrayList<String> line = new ArrayList<String>();
      int len = 0;

      while (len + words[i].length() <= L) {
        line.add(words[i]);
        len += words[i].length() + 1;
        i++;
        if (i == words.length) break;
      }

      StringBuffer sb = new StringBuffer();

      // case1: only one word in a line
      if (line.size() == 1) {
        String word1 = line.get(0);
        sb.append(word1);
        for (int j = 0 ; j < L - word1.length() ; j++) {
          sb.append(" ");
        }
        result.add(sb.toString());
      }

      // case2: last line
      else if (i == words.length) {
        int totalLength = 0;
        for (int j = 0 ; j < line.size() - 1 ; j++) {
          String str = line.get(j);

          sb.append(str);
          sb.append(" ");
          totalLength += str.length() + 1;
        }
        String lastWord = line.get(line.size() - 1);
        sb.append(lastWord);
        totalLength += lastWord.length();
        for (int j = 0 ; j < L - totalLength ; j++) {
          sb.append(" ");
        }
        result.add(sb.toString());
      }

      // case 3: justify from two ends
      else {
        int totalLength = line.get(0).length();
        int lineSize = line.size();
        for (int j = 1 ; j < lineSize ; j++) {
          totalLength += line.get(j).length();
        }
        int numSpace = L - totalLength;
        int avgSpace = numSpace / (lineSize - 1);
        int remainSpace = numSpace % (lineSize - 1);

        for (int j = 0 ; j < lineSize - 1 ; j++) {
          sb.append(line.get(j));

          // distribute spaces evenly
          for (int k = 0 ; k < avgSpace ; k++) {
            sb.append(" ");
          }

          // distribute remaining spaces
          if (remainSpace > 0) {
            sb.append(" ");
            remainSpace--;
          }
        }
        String lastWord = line.get(lineSize - 1);
        sb.append(lastWord);
        result.add(sb.toString());
      }
    }

    return result;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    TextJustification t = new TextJustification();
    System.out.println(t.fullJustify1(
        new String[] { "Here", "is", "an", "example", "of", "text",
            "justification." }, 14).toString());
  }

}
