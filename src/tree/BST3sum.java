package tree;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class BST3sum
{
  public void findTriplet(TreeNode root, int target)
  {
    TreeNode[] dll = convertToDll(root);
    TreeNode head = dll[0];
    TreeNode tail = dll[1];
    // note that the bst inorder dll should already in sorted by value
    TreeNode first = head;
    while (first.right != null) {
      TreeNode left = first.right;
      TreeNode right = tail;
      while (left.val < right.val) {
        int diff = first.val + left.val + right.val - target;
        if (diff == 0) {
          System.out.println("Found triplet: " + first.val + " " + left.val
              + " " + right.val + " for sum of " + target);
        }
        if (diff <= 0) {
          left = left.right;
        }
        if (diff >= 0) {
          right = right.left;
        }
      }
      first = first.right;
    }
  }

  private TreeNode[] convertToDll(TreeNode node)
  {
    TreeNode[] ans = new TreeNode[2];
    // do the left side of node
    if (node.left == null) {
      ans[0] = node;
    }
    else {
      TreeNode[] preAns = convertToDll(node.left);
      ans[0] = preAns[0];
      node.left = preAns[1];
      preAns[1].right = node;
    }
    // do the right side of node
    if (node.right == null) {
      ans[1] = node;
    }
    else {
      TreeNode[] postAns = convertToDll(node.right);
      ans[1] = postAns[1];
      node.right = postAns[0];
      postAns[0].left = node;
    }
    return ans;
  }

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
