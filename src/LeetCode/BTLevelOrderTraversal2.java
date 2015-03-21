package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class BTLevelOrderTraversal2
{
  // pass both
  public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root)
  {
    // Start typing your Java solution below
    // DO NOT write main() function

    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    if (root == null) return ret;
    LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    list.addLast(root);
    int num = list.size();
    while (num > 0) {
      int p = 0;
      ArrayList<Integer> curr = new ArrayList<Integer>();
      while (p < num) {
        TreeNode n = list.pollFirst();
        if (n.left != null) list.addLast(n.left);
        if (n.right != null) list.addLast(n.right);
        curr.add(n.val);
        p++;
      }
      ret.add(0, curr);
      num = list.size();
    }
    return ret;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
