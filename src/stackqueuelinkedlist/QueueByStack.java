package stackqueuelinkedlist;

import java.util.Stack;

public class QueueByStack {

    Stack<Integer> snew = new Stack<Integer>();
    Stack<Integer> sold = new Stack<Integer>();

    public int size() {
        return snew.size() + sold.size();
    }

    public void enqueue(int item) {
        snew.push(item);
    }

    public void shift() {
        if (sold.empty()) {
            while (!snew.empty()) {
                sold.push(snew.pop());
            }
        }
    }

    public int dequeue() {
        shift();
        return sold.pop();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
