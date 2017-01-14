package stackqueuelinkedlist;

import java.util.Stack;

public class MinStack {
    public Stack<Integer> s = new Stack<Integer>();
    public Stack<Integer> min = new Stack<Integer>();

    public void push(int i) {
        s.push(i);
        // "=" needed to support duplicate
        if (min.isEmpty() || i <= min.peek()) {
            min.push(i);
        }
    }

    public int pop() {
        int i = s.pop();
        if (min.peek() == i) {
            min.pop();
        }
        return i;
    }

    public int min() {
        return min.peek();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MinStack ms = new MinStack();
        ms.push(3);
        ms.push(4);
        ms.push(3);
        ms.pop();
        System.out.println(ms.min());
    }

}
