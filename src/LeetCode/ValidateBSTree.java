package LeetCode;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class ValidateBSTree {
    // pass both
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        return isValidBSTHelper(root.left, min, root.val)
                && isValidBSTHelper(root.right, root.val, max);
    }

    public static int last_printed = Integer.MIN_VALUE;

    // should be correct, not pass the test because the static
    public boolean checkBST(TreeNode root) {
        if (root == null)
            return true;

        if (!checkBST(root.left))
            return false;
        if (root.val < last_printed)
            return false;
        last_printed = root.val;
        if (!checkBST(root.right))
            return false;
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        ValidateBSTree v = new ValidateBSTree();
        System.out.println(v.checkBST(root));
    }

}
