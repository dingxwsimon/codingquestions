package LeetCode;

import java.util.ArrayList;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class UniqueBSTrees2 {
    // pass both
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        return generateTree(num, 0, n - 1);
    }

    public ArrayList<TreeNode> generateTree(ArrayList<Integer> num, int start,
                                            int end) {
        ArrayList<TreeNode> results = new ArrayList<TreeNode>();
        if (start > end) {
            TreeNode n = null;
            results.add(n);
            return results;
        }
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> leftTrees = generateTree(num, start, i - 1);
            for (int j = 0; j < leftTrees.size(); j++) {
                TreeNode leftChild = leftTrees.get(j);
                ArrayList<TreeNode> rightTrees = generateTree(num, i + 1, end);
                for (int k = 0; k < rightTrees.size(); k++) {
                    TreeNode rightChild = rightTrees.get(k);
                    TreeNode root = new TreeNode(num.get(i));
                    root.left = leftChild;
                    root.right = rightChild;
                    results.add(root);
                }
            }
        }
        return results;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
