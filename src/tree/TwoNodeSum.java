package tree;

import java.util.Stack;

public class TwoNodeSum {
    // idea similar to two sum in array
    public void printTwoNodeValueEqualToX(Node root, Integer target) {
        Stack<Node> leftStack = new Stack<Node>();
        Stack<Node> rightStack = new Stack<Node>();
        Node scan = root;
        while (scan != null) {
            leftStack.add(scan);
            scan = scan.left;
        }
        scan = root;
        while (scan != null) {
            rightStack.add(scan);
            scan = scan.right;
        }

        do {
            if (leftStack.peek().value + rightStack.peek().value > target) {
                Node rightElem = rightStack.pop();
                if (rightElem.left != null) {
                    scan = rightElem.left;
                    while (scan != null) {
                        rightStack.add(scan);
                        scan = scan.right;
                    }
                }
            } else if (leftStack.peek().value + rightStack.peek().value < target) {
                Node leftElem = leftStack.pop();
                if (leftElem.right != null) {
                    scan = leftElem.right;
                    while (scan != null) {
                        leftStack.add(scan);
                        scan = scan.left;
                    }
                }
            } else {
                System.out.println(leftStack.peek().value + ", "
                        + rightStack.peek().value);
                return;
            }
        } while (leftStack.peek().value < rightStack.peek().value);

        System.out.println("not found");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
