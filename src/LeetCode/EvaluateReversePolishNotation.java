package LeetCode;

public class EvaluateReversePolishNotation
{
  public static boolean isOperand(String s)
  {
    int a = 0;
    try {
      a = Integer.parseInt(s);
    }
    catch (Exception ignore) {
      return false;
    }
    return true;
  }

  public static boolean isOperator(String token)
  {
    String tokenList = "+-*/";
    if (tokenList.indexOf(token) >= 0) return true;
    return false;
  }

  public static String applyOperator(String operand1, String operand2,
      String operator)
  {
    int value1 = Integer.parseInt(operand1);
    int value2 = Integer.parseInt(operand2);
    int result = 0;

    if (operator.equals("+")) {
      result = value1 + value2;
    }
    else if (operator.equals("-")) {
      result = value1 - value2;
    }
    else if (operator.equals("*")) {
      result = value1 * value2;
    }
    else if (operator.equals("/")) {
      result = value1 / value2;
    }

    return "" + result; // convert result to String
  }

  public static int evalRPN(String[] tokens) 
  {
    java.util.Stack<String> stack = new java.util.Stack<String>();

    
    for (String token : tokens) {
      if (isOperand(token)) {
        stack.push(token);
      }
      if (isOperator(token)) {
        String operand2 = stack.pop();
        String operand1 = stack.pop();
        String value = applyOperator(operand1, operand2, token);
        stack.push(value);
      }
    }

    String result = stack.pop();
    return Integer.parseInt(result);
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(evalRPN(new String[]{"0","3","/"}));
  }

}
