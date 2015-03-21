package stringoperation;

public class SubString
{
  // k*n
  public static int Search(String haystack, String needle)
  {
    for (int i = 0 ; i < haystack.length() ; i++) {
      for (int j = 0 ; j < needle.length() && i + j < haystack.length() ; j++) {
        if (needle.charAt(j) != haystack.charAt(i + j)) {
          break;
        }
        else if (j == needle.length() - 1) {
          return i;
        }
      }
    }
    return -1;
  }

  public static int strtstr(String h, String n)
  {
    char[] needle = n.toCharArray();
    char[] haystack = h.toCharArray();
    int needleIndex = 0;

    for (int i = 0 ; i < h.length() ; i++) {
      if (needle[needleIndex] == haystack[i])
        needleIndex++;
      else {
        // Thanks to Cedric for the correct fix.
        i -= needleIndex;
        needleIndex = 0;
        continue;
      }

      if (needleIndex == n.length()) return i - n.length() + 1;
    }
    return -1;
  }

  // KMP
  private String text;
  private String pattern;
  private int[] failure;
  private int matchPoint;

  /**
   * Finds the first occurrence of the pattern in the text.
   */
  public boolean match()
  {
    int j = 0;
    if (text.length() == 0) return false;

    for (int i = 0 ; i < text.length() ; i++) {
      while (j > 0 && pattern.charAt(j) != text.charAt(i)) {
        j = failure[j - 1];
      }
      if (pattern.charAt(j) == text.charAt(i)) {
        j++;
      }
      if (j == pattern.length()) {
        matchPoint = i - pattern.length() + 1;
        return true;
      }
    }
    return false;
  }

  /**
   * Computes the failure function using a boot-strapping process,
   * where the pattern is matched against itself.
   */
  private void computeFailure()
  {
    int j = 0;
    failure[j] = 0;
    for (int i = 1 ; i < pattern.length() ; i++) {
      while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
        j = failure[j - 1];
      }
      if (pattern.charAt(j) == pattern.charAt(i)) {
        j++;
      }
      failure[i] = j;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

    System.out.println(SubString.Search("ABCDEEFGHLMNOPQRS", "DEEF"));
    System.out.println(SubString.strtstr("ABCDEEFGHLMNOPQRS", "DEEF"));
  }

}
