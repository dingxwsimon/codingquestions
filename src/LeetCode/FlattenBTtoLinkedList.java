package LeetCode;

import java.util.Stack;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class FlattenBTtoLinkedList
{
  /*
   * recurrence:
   * 1) if current node is null or leaf, return it.
   * 2) get the left child and right child of current node,
   * 2.1)if the left is not null, set the left as the current node's right,
   * flat the left tree. return the tail of left child tree as current node.
   * 2.2)if the right is not null, set the right as the current node's right,
   * flat the right tree. return the tail of left child tree as current node.
   */
  public TreeNode flatten_recurr(TreeNode root)
  {
    if (root == null || (root.left == null && root.right == null)) return root;

    TreeNode left = root.left;
    TreeNode right = root.right;

    root.left = null;

    if (left != null) {
      root.right = left;
      root = flatten_recurr(left);
    }

    if (right != null) {
      root.right = right;
      root = flatten_recurr(right);
    }

    return root;
  }

  /*
   * preOrder:
   * 1) check, if current node is null or leaf, return it.
   * 2) init a stack to store the right child tree
   * 3) preOrder travel the tree
   * 3.1) if current node has left child, store the right child in stack,
   * change the left child to right.
   * 3.2) else, get the right child from the stack and
   * set it as the right child as the current node
   */
  public TreeNode flatten_preOrder(TreeNode root)
  {
    if (root == null || (root.left == null && root.right == null)) return root;

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {

      while (curr.left != null) {
        if (curr.right != null) stack.push(curr.right);

        curr.right = curr.left;
        curr.left = null;
        curr = curr.right;
      }

      if (curr.right == null && !stack.isEmpty()) curr.right = stack.pop();

      curr = curr.right;
    }
    return root;
  }

  // ETL
  public void flatten(TreeNode root)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode p = root;
    stack.add(p);
    TreeNode prev = new TreeNode(0);
    TreeNode t = prev;
    while (!stack.isEmpty()) {
      p = stack.pop();
      prev.left = null;
      prev.right = p;
      prev = p;
      if (p.right != null) stack.add(p.right);
      if (p.left != null) stack.add(p.left);
    }
    root = t.right;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(1);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(6);
    FlattenBTtoLinkedList f = new FlattenBTtoLinkedList();
    f.flatten(root);
  }

}
