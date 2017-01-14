package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class BTLevelOrderTraversal {
    // pass both BFS
    public ArrayList<ArrayList<Integer>> levelOrder1(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return results;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        ArrayList<Integer> line = new ArrayList<Integer>();
        int thislevelcnt = 1;
        int nextlevelcnt = 0;
        while (queue.size() != 0) {
            TreeNode node = queue.pop();
            thislevelcnt--;
            if (node != null) {
                line.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
                nextlevelcnt += 2;
            }
            if (thislevelcnt == 0) {
                if (!line.isEmpty())
                    results.add(line);
                line = new ArrayList<Integer>();
                thislevelcnt = nextlevelcnt;
                nextlevelcnt = 0;
            }
        }
        return results;
    }

    // pass both DFS
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return results;
        // Start DFS from the root, level=0
        levelOrderDFS(results, root, 0);
        return results;
    }

    public void levelOrderDFS(ArrayList<ArrayList<Integer>> results,
                              TreeNode node, int level) {
        // reach a new level, and created this level, add the node
        if (results.size() - 1 < level) {
            ArrayList<Integer> newLevel = new ArrayList<Integer>();
            newLevel.add(node.val);
            results.add(newLevel);
        }
        // append the node to the existing level it correspond to
        else {
            ArrayList<Integer> existLevel = results.get(level);
            existLevel.add(node.val);
            results.set(level, existLevel);
        }
        // DFS recursion on left and right respectively
        if (node.left != null) {
            levelOrderDFS(results, node.left, level + 1);
        }
        if (node.right != null) {
            levelOrderDFS(results, node.right, level + 1);
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return ret;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.push(root);
        int cur = 1;
        int next = 0;
        ArrayList<Integer> line = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            TreeNode n = q.pop();
            cur--;
            if (n != null) {
                q.add(n.left);
                q.add(n.right);
                next += 2;
                line.add(n.val);
            }

            if (cur == 0) {
                if (!line.isEmpty())
                    ret.add(0, line);
                line = new ArrayList<Integer>();
                cur = next;
                next = 0;
            }
        }
        return ret;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        // root.right.left = new TreeNode(15);
        // root.right.right = new TreeNode(7);

        BTLevelOrderTraversal b = new BTLevelOrderTraversal();
        System.out.println(b.levelOrderBottom(root));
    }

}
