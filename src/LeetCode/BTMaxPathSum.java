package LeetCode;

import java.util.ArrayList;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class BTMaxPathSum {

    private int maxsum = 0;

    public int maxPathSum2(TreeNode root) {
        maxsum = Integer.MIN_VALUE;
        findMax(root);
        return maxsum;
    }

    public int findMax(TreeNode n) {
        if (n == null)
            return 0;
        int left = findMax(n.left);
        int right = findMax(n.right);
        maxsum = Math.max(left + n.val + right, maxsum);
        int ret = n.val + Math.max(left, right);
        return ret > 0 ? ret : 0;

    }

    // max sum start and end at any node
    // this can be leaf to another leaf
    // which is same with CC150 4.9
    // this is working
    public int maxPathSum1(TreeNode root) {
        int[] r = helper(root);
        return r[1];
    }

    private int[] helper(TreeNode node) {
        if (node == null)
            return new int[]{0, Integer.MIN_VALUE};

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int[] r = new int[2];
        r[0] = Math.max(node.val,
                Math.max(node.val + left[0], node.val + right[0]));

        r[1] = Math.max(Math.max(r[0], Math.max(left[1], right[1])), left[0]
                + right[0] + node.val);
        return r;
    }

    /*
     * One needs to handle three cases: Left tree path plus the current root.
     * Right tree path plus the current root. The path passes through the root
     * and hence one needs to consider the left path + current root + right
     * path. In addition compare with the max path so far and update
     * accordingly.
     */
    // not passing new oj
    public static int maxPathSum(TreeNode root) {
        // pass the curmanx in an array that contains only one value
        ArrayList<Integer> curMax = new ArrayList<Integer>();
        curMax.add(Integer.MIN_VALUE);
        maxSubPath(root, curMax);
        return curMax.get(0);
    }

    private static int maxSubPath(TreeNode root, ArrayList<Integer> curMax) {
        if (root == null)
            return 0;
        int leftMax = Math.max(0, maxSubPath(root.left, curMax));
        int rightMax = Math.max(0, maxSubPath(root.right, curMax));

        curMax.set(0, Math.max(curMax.get(0), root.val + leftMax + rightMax));
        System.out.println(curMax.get(0));
        return Math.max(root.val + leftMax, root.val + rightMax);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        System.out.println(maxPathSum(root));
    }

}
