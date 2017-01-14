package CrackingCoding;

import java.util.EmptyStackException;

public class c3_1 {

    public static class StackData {
        public int start;
        public int pointer;
        public int size = 0;
        public int capacity;

        public StackData(int _start, int _capacity) {
            start = _start;
            pointer = _start - 1;
            capacity = _capacity;
        }

        public boolean isWithinStack(int index, int total_size) {
            // Note: if stack wraps, the head (right side) wraps around to the
            // left.
            if (start <= index && index < start + capacity) {
                // non-wrapping, or "head" (right side) of wrapping case
                return true;
            } else if (start + capacity > total_size
                    && index < (start + capacity) % total_size) {
                // tail (left side) of wrapping case
                return true;
            }
            return false;
        }
    }

    public static class FullStackException extends Exception {
        private static final long serialVersionUID = 1L;

        public FullStackException() {
            super();
        }

        public FullStackException(String message) {
            super(message);
        }
    }

    static int stackSize = 10;
    static int[] buffer = new int[stackSize * 3];

    // 3 stack pointers to keep track of the index of the top element
    static int[] stackPointer = {-1, -1, -1};

    public static void main(String[] args) throws Exception {
        push(2, 4);
        System.out.println("Peek 2: " + peek(2));
        push(0, 3);
        push(0, 7);
        push(0, 5);
        System.out.println("Peek 0: " + peek(0));
        pop(0);
        System.out.println("Peek 0: " + peek(0));
        pop(0);
        System.out.println("Peek 0: " + peek(0));
    }

    static void push(int stackNum, int value) throws Exception {
    /* Check that we have space for the next element */
        if (stackPointer[stackNum] + 1 >= stackSize) {
            throw new FullStackException();
        }
	/* Increment stack pointer and then update top value */
        stackPointer[stackNum]++;
        buffer[absTopOfStack(stackNum)] = value;
    }

    static int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int value = buffer[absTopOfStack(stackNum)]; // Get top
        buffer[absTopOfStack(stackNum)] = 0; // Clear index
        stackPointer[stackNum]--; // Decrement pointer
        return value;
    }

    static int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return buffer[absTopOfStack(stackNum)];
    }

    static boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    /* returns index of the top of the stack "stackNum", in absolute terms */
    static int absTopOfStack(int stackNum) {
        return stackNum * stackSize + stackPointer[stackNum];
    }
}
