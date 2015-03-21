package number;

class PostfixConverter
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

  public static boolean isOperator(String s)
  {
    String operatorList = "+-*/";
    return operatorList.indexOf(s) >= 0;
  }

  public static int precedence(String operator)
  {
    int precedence = 0;
    if (operator.equals("+")) {
      precedence = 1;
    }
    else if (operator.equals("-")) {
      precedence = 1;
    }
    else if (operator.equals("*")) {
      precedence = 2;
    }
    else if (operator.equals("/")) {
      precedence = 2;
    }
    return precedence;
  }

  public static String convert(String infix)
  {
    java.util.Stack<String> stack = new java.util.Stack<String>();
    String postfix = "";
    String space = " ";
    java.util.StringTokenizer st = new java.util.StringTokenizer(infix);
    while (st.hasMoreTokens()) {
      String token = st.nextToken();
      if (isOperand(token)) {
        postfix += token + space;
      }
      else if (token.equals("(")) {
        stack.push(token);
      }
      else if (isOperator(token)) {
        while (!stack.empty() && precedence(stack.peek()) >= precedence(token)) {
          postfix += stack.pop() + space;
        }
        stack.push(token);
      }
      else if (token.equals(")")) {
        while (!stack.peek().equals("(")) {
          postfix += stack.pop() + space;
        }
        stack.pop(); // pop the left parenthesis
      }
    }
    System.out.println("stack = " + stack.toString());
    while (!stack.empty()) {
      postfix += stack.pop() + space;
    }
    return postfix;
  }

  public static void main(String[] args)
      throws Exception
  {
    String infix = "( 6 + 2 ) * 5 - 8 / 4"; // change this line as needed
    String postfix = convert(infix);
    System.out.println("infix=" + infix);
    System.out.println("postfix=" + postfix);
    System.out.println("evaluation=" + PostfixEvaluator.evaluate(postfix));
  }
}
