package stackqueuelinkedlist;

import java.util.Stack;

public class MaxQueue {
    MaxStack A = new MaxStack();
    MaxStack B = new MaxStack();

    public void enqueue(int n) {
        B.push(n);
    }

    public int dequeue() {
        if (A.isEmpty()) {
            while (!B.isEmpty()) {
                A.push(B.pop());
            }
        }
        return A.pop();
    }

    public int max() {
        return Math.max(A.max(), B.max());
    }

    public static class MaxStack {
        public Stack<Integer> s = new Stack<Integer>();
        public Stack<Integer> max = new Stack<Integer>();

        public void push(int i) {
            s.push(i);
            // "=" needed to support duplicate
            if (max.isEmpty() || i >= max.peek()) {
                max.push(i);
            }
        }

        public int pop() {
            int i = s.pop();
            if (max.peek() == i) {
                max.pop();
            }
            return i;
        }

        public int max() {
            if (max.isEmpty())
                return -1;
            return max.peek();
        }

        public boolean isEmpty() {
            return s.isEmpty();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MaxQueue mq = new MaxQueue();
        mq.enqueue(5);
        mq.enqueue(6);
        mq.enqueue(3);
        mq.enqueue(4);
        mq.enqueue(4);
        mq.enqueue(3);
        mq.dequeue();
        mq.dequeue();
        System.out.println(mq.max());
        mq.dequeue();
        mq.dequeue();
        System.out.println(mq.max());

    }

}
