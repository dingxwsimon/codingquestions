package tree;

import java.util.Stack;

public class Stats {
    public static int height(Node root) {
	if (root == null)
	    return 0;
	return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int diameterOpt(Node root, Height height) {
	/*
	 * lh --> Height of left subtree rh --> Height of right subtree
	 */
	Height lh = new Height(), rh = new Height();

	/*
	 * ldiameter --> diameter of left subtree rdiameter --> Diameter of
	 * right subtree
	 */
	int ldiameter = 0, rdiameter = 0;

	if (root == null) {
	    height.height = 0;
	    return 0; /* diameter is also 0 */
	}

	/*
	 * Get the heights of left and right subtrees in lh and rh And store the
	 * returned values in ldiameter and ldiameter
	 */
	ldiameter = diameterOpt(root.left, lh);
	rdiameter = diameterOpt(root.right, rh);

	/*
	 * Height of current node is max of heights of left and right subtrees
	 * plus 1
	 */
	height.height = Math.max(lh.height, rh.height) + 1;

	return Math.max(lh.height + rh.height + 1,
		Math.max(ldiameter, rdiameter));
    }

    public static class Height {
	int height = 0;
    }

    public static int maxDepth(Node root) {
	if (root == null) {
	    return 0;
	}
	return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // max depth iterative
    public static int maxDepthItr(Node root) {
	if (root == null)
	    return 0;
	Stack<Node> s = new Stack<Node>();
	s.push(root);
	int maxDepth = 0;
	Node prev = null;
	while (!s.isEmpty()) {
	    Node cur = s.peek();
	    if (prev == null || prev.left == cur || prev.right == cur) {
		if (cur.left != null)
		    s.push(cur.left);
		else if (cur.right != null)
		    s.push(cur.right);
	    } else if (cur.left == prev) {
		if (cur.right != null)
		    s.push(cur.right);
	    } else
		s.pop();
	    prev = cur;
	    if (s.size() > maxDepth)
		maxDepth = s.size();
	}
	return maxDepth;
    }

    int minDepth(Node root) {
	if (root == null) {
	    return 0;
	}
	return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    // O(n^2)
    boolean isBalanced(Node root) {
	if (root == null)
	    return true;
	int heightdiff = Math.abs(maxDepth(root.left) - maxDepth(root.right));
	if (heightdiff > 1)
	    return false;
	else
	    return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Height h = new Height();
	h.height = 0;
	System.out.println(diameterOpt(Node.create1(), new Height()));
    }

}
