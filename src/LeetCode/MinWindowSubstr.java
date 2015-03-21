package LeetCode;public class MinWindowSubstr{  //Given a string S and a string T, find the minimum window in S   //which will contain all the characters in T in complexity O(n).  // ...end...start...  // O(N)  public String minWindow1(String S, String T)  {    int sLen = S.length();    int tLen = T.length();    int[] needToFind = new int[256];    for (int i = 0 ; i < tLen ; i++) {      needToFind[T.charAt(i)]++;    }    int[] hasFound = new int[256];    int r = 0, l = 0, len = 0, min = sLen;    String minStr = S;    while (r < sLen) {      int rc = S.charAt(r);      if (needToFind[rc] == 0) {        //no need this char        r++;        continue;      }      hasFound[rc]++;      if (needToFind[rc] >= hasFound[rc]) len++;      if (len == tLen) {        int lc = S.charAt(l);        while (needToFind[lc] == 0 || needToFind[lc] < hasFound[lc]) {          if (hasFound[lc] > 0) hasFound[lc]--;          l++;          lc = S.charAt(l);        }        if (r - l + 1 < min) {          min = r - l + 1;          minStr = S.substring(l, r + 1);        }      }      r++;    }    if (len == tLen)      return minStr;    else      return "";  }  // working!!!!  public String minWindow(String S, String T)  {    if (S.length() < T.length() || T.length() == 0) return "";    String minStr = S + " ";    // -- cnt arrays used for judging whether all characters    // in target string are included in window sub-string.    int[] wndCnts = new int[256];    int[] tgtCnts = new int[256];    char[] temp = T.toCharArray();    for (char c : temp) {      tgtCnts[c]++;    }    int head, tail;    head = tail = 0;    // -- skip letters that not meaningful --    // find the first char in target    while (head < S.length() && !charInTarget(S.charAt(head), tgtCnts)) {      head++;    }    ;    tail = head;    // -- start looping --    while (head < S.length()) {      while (tail <= head && !charInTarget(S.charAt(tail), tgtCnts)) {        tail++;      }      ;      // -- grow to the match --      // forward the head to the index that contains the target      while (head < S.length() && !windowValid(tgtCnts, wndCnts)) {        char c = S.charAt(head++);        if (charInTarget(c, tgtCnts)) {          wndCnts[c]++;        }      }      if (windowValid(tgtCnts, wndCnts)) {        if (minStr.length() > head - tail) {          minStr = S.substring(tail, head);        }      }      else        break;      // -- reduce the match --      while (tail < head && windowValid(tgtCnts, wndCnts)) {        char c = S.charAt(tail++);        if (charInTarget(c, tgtCnts)) {          wndCnts[c]--;          if (windowValid(tgtCnts, wndCnts) && minStr.length() > head - tail) {            minStr = S.substring(tail, head);          }        }        else if (minStr.length() > head - tail) {          minStr = S.substring(tail, head);        }      }    }    if (minStr.equals(S + " ")) return "";    return minStr;  }  boolean windowValid(int[] tgtCnts, int[] wndCnts)  {    for (int i = 0 ; i < tgtCnts.length ; i++) {      if (tgtCnts[i] > wndCnts[i]) return false;    }    return true;  }  boolean charInTarget(char c, int[] target)  {    return (target[c] > 0);  }  /**   * @param args   */  public static void main(String[] args)  {    // TODO Auto-generated method stub    // "ADOBECODEBANC", "ABC"    MinWindowSubstr mws = new MinWindowSubstr();    // abcabdebac cea    System.out.println(mws.minWindow("abcabdebac", "cea"));  }}