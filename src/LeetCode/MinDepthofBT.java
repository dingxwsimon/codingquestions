package LeetCode;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class MinDepthofBT {
    // pass both
    public int minDepth(TreeNode root) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (root == null)
	    return 0;
	int dLeft = minDepth(root.left);
	int dRight = minDepth(root.right);
	if (dLeft > 0 && dRight > 0)
	    return (1 + Math.min(dLeft, dRight));
	if (dLeft == 0 && dRight == 0)
	    return 1;
	return (1 + (dLeft > 0 ? dLeft : dRight));
	// this is not a leave node yet
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
