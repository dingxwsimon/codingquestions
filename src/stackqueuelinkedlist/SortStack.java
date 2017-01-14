package stackqueuelinkedlist;

import java.util.Stack;

public class SortStack {

    public static Stack sortStack(Stack<Integer> s) {
        Stack<Integer> result = new Stack<Integer>();

        while (!s.isEmpty()) {
            int k = s.pop();
            while (!result.isEmpty() && k < result.peek()) {
                s.push(result.pop());
            }
            result.push(k);
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack<Integer> s = new Stack<Integer>();
        s.push(5);
        s.push(3);
        s.push(4);
        s.push(2);
        s.push(1);
        System.out.println(s);

        System.out.println(sortStack(s));
    }

}
