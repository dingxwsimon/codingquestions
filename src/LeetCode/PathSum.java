package LeetCode;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class PathSum {
    // pass both
    // boolean sum from root to leave
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;
        else
            return hasPathSum(root.left, sum - root.val)
                    || hasPathSum(root.right, sum - root.val);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
