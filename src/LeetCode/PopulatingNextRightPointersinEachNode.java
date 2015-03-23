package LeetCode;

public class PopulatingNextRightPointersinEachNode {
    public static class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
	    val = x;
	}
    }

    // pass both
    public void connect(TreeLinkNode root) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (root == null)
	    return;
	if (root.left == null && root.right == null)
	    return;
	TreeLinkNode rsbling = root.next;
	root.left.next = root.right;
	if (rsbling != null) {
	    root.right.next = rsbling.left;
	}
	connect(root.left);
	connect(root.right);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
