package LeetCode;

import java.util.ArrayList;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class SymmetricTree
{
  // pass both
  public boolean isSymmetric(TreeNode root)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (root == null) return true;

    return isMirror(root.left, root.right);
  }

  public boolean isMirror(TreeNode p, TreeNode q)
  {
    if (p == null && q == null) return true;
    if (p == null && q != null) return false;
    if (p != null && q == null) return false;

    if (p.val == q.val)
      return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    else
      return false;
  }

  public boolean isSymmetric1(TreeNode root)
  {
    if (root == null) return true;

    ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
    ArrayList<Integer> depth = new ArrayList<Integer>();
    trees.add(root);
    depth.add(1);
    while (!trees.isEmpty()) {
      TreeNode parent = trees.remove(0);
      int curr_depth = depth.remove(0);
      if (parent != null) {
        trees.add(parent.left);
        depth.add(curr_depth + 1);
        trees.add(parent.right);
        depth.add(curr_depth + 1);
      }

      int size = depth.size();

      if (!depth.isEmpty() && curr_depth == depth.get(0) - 1
          && depth.get(0) == depth.get(size - 1)) {
        int i = 0;
        int j = size - 1;

        while (i < j) {
          if (trees.get(i) == null) {
            if (trees.get(j) == null) {
              i++;
              j--;
            }
            else
              return false;
          }
          else if (trees.get(i) != null && trees.get(j) == null) {
            return false;
          }
          else if (trees.get(i).val == trees.get(j).val) {
            i++;
            j--;
          }
          else {
            return false;
          }

        }

      }

    }

    return true;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
