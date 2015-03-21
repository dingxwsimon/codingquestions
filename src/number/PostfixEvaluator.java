package number;

class PostfixEvaluator
{
  public static boolean isOperand(String s)
  {
    double a = 0;
    try {
      a = Double.parseDouble(s);
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
    double value1 = Double.parseDouble(operand1);
    double value2 = Double.parseDouble(operand2);
    double result = 0;

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

  public static double evaluate(String postfix)
  {
    java.util.Stack<String> stack = new java.util.Stack<String>();

    java.util.StringTokenizer st = new java.util.StringTokenizer(postfix);
    while (st.hasMoreTokens()) {
      String token = st.nextToken();
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
    return Double.parseDouble(result);
  }

  public static void main(String[] args)
      throws Exception
  {
    String postfix = "5 6 2 + * 12 4 / - "; // change this line as needed
    double result = evaluate(postfix);
    System.out.println("evaluate[" + postfix + "]=" + result);
  }
}
