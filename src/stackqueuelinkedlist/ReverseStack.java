package stackqueuelinkedlist;

import java.util.Stack;

public class ReverseStack {
    public static boolean bottomUp = false;

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty() || bottomUp) {
            bottomUp = true;
            return;
        }

        int k = s.pop();
        reverseStack(s);
        s.push(k);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack<Integer> s = new Stack<Integer>();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        reverseStack(s);
        System.out.println(s);
    }

}
