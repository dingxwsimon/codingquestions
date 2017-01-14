package LeetCode;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class BalancedBT {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode n) {
        if (n == null)
            return 0;

        return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
