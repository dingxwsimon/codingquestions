package tree;

import java.util.Stack;

public class Traverse {
    // http://en.wikipedia.org/wiki/Tree_traversa
    public static void inOrderItr(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node p = root;
        do {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.println(p.value);
            p = p.right;
        } while (p != null || !stack.empty());
    }

    public static void inOrderItr1(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node p = root;
        while (p != null || !stack.empty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                System.out.print(p.value + " ");
                p = p.right;
            }
        }
        System.out.println();
    }

    public static void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.value);
            inOrderRec(root.right);
        }
    }

    public static void MorrisTraversal(Node root) {
        Node current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.println(current.value);
                current = current.right;
            } else {
        /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

		/* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

		/*
		 * Revert the changes made in if part to restore the original
		 * tree i.e., fix the right child of predecssor
		 */
                else {
                    pre.right = null;
                    System.out.println(current.value);
                    current = current.right;
                } /* End of if condition pre.right == null */
            } /* End of if condition current.left == null */
        } /* End of while */
    }

    public static void preOrderItr1(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                System.out.println(p.value);
                stack.push(p.right);
                p = p.left;
            } else
                p = stack.pop();
        }
    }

    public static void preOrderItr(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node p = root;
        stack.add(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            System.out.println(p.value);
            if (p.right != null) {
                stack.add(p.right);
            }
            if (p.left != null) {
                stack.add(p.left);
            }
        }
    }

    public static void preOrderRec(Node root) {
        if (root != null) {
            System.out.println(root.value);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public static void backOrderItr(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node prev = null;
        while (!stack.isEmpty()) {
            Node n = stack.peek();
            // we are traversing down the tree
            if (prev == null || prev.left == n || prev.right == n) {
                if (n.left != null)
                    stack.push(n.left);
                else if (n.right != null)
                    stack.push(n.right);
            }
            // we are traversing up the tree from the left
            else if (n.left == prev) {
                if (n.right != null)
                    stack.push(n.right);
            }
            // we are traversing up the tree from the right
            else {
                System.out.println(stack.pop().value);
            }
            prev = n;
        }
    }

    void postOrderTraversalIterativeTwoStacks(Node root) {
        if (root == null)
            return;
        Stack<Node> s = new Stack<Node>();
        Stack<Node> output = new Stack<Node>();
        s.push(root);
        while (!s.empty()) {
            Node curr = s.peek();
            output.push(curr);
            s.pop();
            if (curr.left != null)
                s.push(curr.left);
            if (curr.right != null)
                s.push(curr.right);
        }
        while (!output.empty()) {
            System.out.println(output.peek().value);
            output.pop();
        }
    }

    public static void backOrderItr1(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        Stack<Integer> tag = new Stack<Integer>();
        Node p = root;
        do {
            while (p != null) {
                stack.push(p);
                tag.push(0);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                if (tag.peek() == 1) {
                    System.out.println(stack.pop().value);
                    tag.pop();
                } else {
                    p = stack.peek();
                    if (!stack.isEmpty()) {
                        p = p.right;
                        tag.pop();
                        tag.push(1);
                    }
                }
            }
        } while (p != null || !stack.isEmpty());

    }

    public static void backOrderRec(Node root) {
        if (root != null) {
            backOrderRec(root.left);
            backOrderRec(root.right);
            System.out.println(root.value);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Traverse.MorrisTraversal(Node.create());
        Traverse.inOrderItr(Node.create());
    }

}
