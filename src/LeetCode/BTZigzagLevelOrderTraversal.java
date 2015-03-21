package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class BTZigzagLevelOrderTraversal
{

  // pass both, tricky
  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    if (root == null) return results;
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    ArrayList<Integer> line = new ArrayList<Integer>();
    int thislevelcnt = 1;
    int nextlevelcnt = 0;
    boolean reverse = false;
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
        if (reverse) {
          Collections.reverse(line);
        }
        reverse = !reverse;
        if (!line.isEmpty()) results.add(line);
        line = new ArrayList<Integer>();
        thislevelcnt = nextlevelcnt;
        nextlevelcnt = 0;
      }
    }
    return results;
  }

  // study when have time
  public ArrayList<ArrayList<Integer>> zigzagLevelOrder1(TreeNode root)
  {
    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    if (root == null) return results;
    ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
    ArrayList<Integer> depth = new ArrayList<Integer>();
    trees.add(root);
    depth.add(1);
    ArrayList<Integer> level1 = new ArrayList<Integer>();
    level1.add(root.val);
    results.add(level1);
    while (!trees.isEmpty()) {
      TreeNode parent = trees.remove(0);
      int curr_level = depth.remove(0);
      if (parent.left != null) {
        trees.add(parent.left);
        depth.add(curr_level + 1);
      }
      if (parent.right != null) {
        trees.add(parent.right);
        depth.add(curr_level + 1);
      }
      int size = depth.size();
      if (size > 0 && depth.get(0) == depth.get(size - 1)
          && curr_level == depth.get(0) - 1) {
        ArrayList<Integer> treelevel = new ArrayList<Integer>();
        if (depth.get(0) % 2 == 1) {
          for (int i = 0 ; i < trees.size() ; i++) {
            treelevel.add(trees.get(i).val);
          }
        }
        else {
          for (int i = 0 ; i < trees.size() ; i++) {
            treelevel.add(0, trees.get(i).val);
          }
        }
        results.add(treelevel);
      }
    }

    return results;

  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    BTZigzagLevelOrderTraversal b = new BTZigzagLevelOrderTraversal();
    b.zigzagLevelOrder(root);
  }

}
