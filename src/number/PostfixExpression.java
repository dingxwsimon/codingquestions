package number;

import java.util.Stack;

public class PostfixExpression
{
  private static void evaluatePostfixExpression(String s)
  {

    Stack<Integer> stack = new Stack<Integer>();
    char[] array = s.toCharArray();
    int i = 0;
    while (i < array.length) {
      if (isOperatr(array[i])) {
        int b = stack.pop();
        int a = stack.pop();
        int c = getResult(a, b, array[i]);
        stack.push(c);
      }
      else {
        stack.push(array[i] - '0');
      }
      i++;
    }
    System.out.println(stack.pop());
  }

  private static int getResult(int a, int b, char operator)
  {
    switch (operator) {
    case '+':
      return a + b;
    case '-':
      return a - b;
    case '*':
      return a * b;
    case '/':
      return a / b;
    case '%':
      return a % b;
    default:
      return a + b;
    }
  }

  private static boolean isOperatr(char c)
  {
    switch (c) {
    case '+':
    case '-':
    case '*':
    case '/':
    case '%':
      return true;
    }
    return false;
  }

  private static String iS;
  private static Stack s;

  public static void PostfixEval(String iString)
  {
    iS = iString;
    s = new Stack();
    String outputString = "";
    boolean fI = false;
    for (int i = 0 ; i < iS.length() ; i++) {
      char curChar = iS.charAt(i);
      if (!isOperator(curChar)) {
        outputString += Character.toString(curChar);
        if (i == (iS.length() - 1)) {
          while (!s.empty()) {
            outputString += s.pop();
          }
        }
      }
      else {
        if (fI) {
          if (pMin(curChar) && pMin((Character) s.peek())) {
            outputString += s.pop();
            s.push(curChar);
            if (i == (iS.length() - 1)) {
              while (!s.empty()) {
                outputString += s.pop();
              }
            }
          }
          else if (mDiv(curChar) && mDiv((Character) s.peek())) {
            outputString += s.pop();
            s.push(curChar);
            if (i == (iS.length() - 1)) {
              while (!s.empty()) {
                outputString += s.pop();
              }
            }
          }
          else if (pMin(curChar) && mDiv((Character) s.peek())) {
            outputString += s.pop();
            s.push(curChar);
            if (i == (iS.length() - 1)) {
              while (!s.empty()) {
                outputString += s.pop();
              }
            }
          }
          else if (mDiv(curChar) && pMin((Character) s.peek())) {
            s.push(curChar);
            if (i == (iS.length() - 1)) {
              while (!s.empty()) {
                outputString += s.pop();
              }
            }
          }
          else {
            outputString += Character.toString(curChar);
            if (i == (iS.length() - 1)) {
              while (!s.empty()) {
                outputString += s.pop();
              }
            }
          }
        }
        else {
          s.push(curChar);
          fI = true;
        }
      }
    }
    System.out.println(outputString);
  }

  public static boolean isOperator(char op)
  {
    switch (op) {
    case '+':
      return true;
    case '-':
      return true;
    case '/':
      return true;
    case '*':
      return true;
    case '^':
      return true;
    default:
      return false;
    }
  }

  public static boolean pMin(char op)
  {
    switch (op) {
    case '+':
      return true;
    case '-':
      return true;
    default:
      return false;
    }
  }

  public static boolean mDiv(char op)
  {
    switch (op) {
    case '*':
      return true;
    case '/':
      return true;
    default:
      return false;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    String s = "1+2*3-1";
    PostfixEval(s);
  }

}
