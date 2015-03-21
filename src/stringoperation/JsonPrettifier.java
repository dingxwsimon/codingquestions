package stringoperation;

public class JsonPrettifier
{
  public void prettify(String input)
      throws Exception
  {

    // observation the rules for Json format:
    // 1. each line end with either a { , or }
    // 2. indentation depends on number of brackets
    int len = input.length();
    int left = 0;
    int right = 0;
    int tab = 0;

    while (left < len) {
      // first, advance right pointer to the next line break point
      while (right < len) {
        if (input.charAt(right) == '}' || input.charAt(right) == ']') {
          // first case, if point to a closing bracket
          tab--;
          // indentation should change right away should we find a
          // closing bracket
          if (right + 1 < len && input.charAt(right + 1) != ',') {
            break;
          }
        }
        else if (input.charAt(right) == ',' || input.charAt(right) == '{'
            || input.charAt(right) == '[') {
          // second case, break at , or {
          break;
        }
        else if (right + 1 < len
            && (input.charAt(right + 1) == '}' || input.charAt(right + 1) == ']')) {
          // third case, break prior to }
          // we need not swap the order of first and third case,
          // because when we found a closing bracket, we need to
          // change indentation right away
          break;
        }
        right++;
      }

      // now print the chars from left pointer to right inclusively
      if (right == len) {
        // end of input
        if (tab != 0) {
          throw new Exception("Json format error!");
        }
        right--;
        // this is for the convenience of printing last line
      }
      printIndentation(tab);
      System.out.println(input.substring(left, right + 1));
      if (input.charAt(right) == '{' || input.charAt(right) == '[') {
        tab++;
      }

      // last, update pointers
      left = ++right;
    }
  }

  private void printIndentation(int tab)
  {
    for (int i = 0 ; i < tab ; i++) {
      System.out.print("    ");
    }
  }

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
