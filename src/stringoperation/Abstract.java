package stringoperation;

import java.util.HashMap;
import java.util.Map;

public class Abstract
{

  private int[] keywordsArray; // this can be replaced by a hashmap "found"
  private int pBegin = 0;
  private int pEnd = 0;
  private int abstractBegin = 0;
  private int abstractEnd = 0;

  private int targetLen;

  private Map<String, Integer> map;

  public Abstract(String[] keywords)
  {
    int len = keywords.length;
    this.keywordsArray = new int[len];
    this.map = keywordsMap(keywords);
  }

  public String extractSummary(String description, String[] keywords)
  {
    String[] array = description.split(" ");
    return extract(array, keywords);
  }

  public String extract(String[] description, String[] keywords)
  {
    String summary = "";
    int nLen = description.length;
    targetLen = nLen + 1;
    while (true) {
      // walk through the description till all keywords are found
      while (!isAllExisted() && pEnd < nLen) {
        if (this.map.get(description[pEnd]) != null) {
          setKeywordsArray(keywordsArray, this.map.get(description[pEnd]), 0);
        }
        pEnd++;
      }
      // then advance the pBegin little by little till the length is minimized
      while (isAllExisted()) {
        if (pEnd - pBegin < targetLen) {
          targetLen = pEnd - pBegin;
          abstractBegin = pBegin;
          abstractEnd = pEnd - 1;
        }
        if (map.get(description[pBegin]) != null) {
          // reduce one count for the keyword
          setKeywordsArray(keywordsArray, map.get(description[pBegin]), 1);
        }
        pBegin++;
      }
      if (pEnd >= nLen) {
        break;
      }
    }
    for (int j = abstractBegin ; j <= abstractEnd ; j++) {
      if (j != abstractEnd) {
        summary = summary + description[j] + " ";
      }
      else {
        summary += description[j];
      }
    }
    return summary;
  }

  public Map<String, Integer> keywordsMap(String[] keywords)
  {
    Map<String, Integer> map = new HashMap<String, Integer>();
    int len = keywords.length;
    for (int i = 0 ; i < len ; i++) {
      map.put(keywords[i], i);
    }
    return map;
  }

  public void setKeywordsArray(int[] keywordsArray, int i, int flag)
  { // flag:0
    // add
    // flag:1
    // sub
    if (flag == 0) {
      keywordsArray[i]++;
    }
    else {
      keywordsArray[i]--;
    }
  }

  public boolean isAllExisted()
  {
    boolean result = true;
    for (int a : keywordsArray) {
      if (a == 0) {
        result = false;
        break;
      }
    }
    return result;
  }

  public static void main(String[] args)
  {
    String description = "hello software hello test world spring sun flower hello";
    String[] keywords = { "hello", "world", "sun" };
    Abstract nAbstract = new Abstract(keywords);
    System.out.println(nAbstract.extractSummary(description, keywords));
  }
}
