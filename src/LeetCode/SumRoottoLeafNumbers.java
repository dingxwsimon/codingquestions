package LeetCode;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
	return sumNumbers(root, 0);
    }

    private int sumNumbers(final TreeNode node, final int prefix) {
	if (node == null) {
	    return 0;
	}

	int ourSum = prefix * 10 + node.val;

	if (node.left == null && node.right == null) {
	    return ourSum;
	} else {
	    return sumNumbers(node.left, ourSum)
		    + sumNumbers(node.right, ourSum);
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
