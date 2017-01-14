package LeetCode;

import java.util.LinkedList;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class MaxDepthofBT {
    // pass both
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            root.val = 1;
        }
        // BFS
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node.left != null) {
                node.left.val = node.val + 1;
                queue.offer(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val + 1;
                queue.offer(node.right);
            }
        }
        return node.val;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
