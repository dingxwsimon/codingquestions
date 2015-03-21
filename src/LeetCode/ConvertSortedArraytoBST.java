package LeetCode;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class ConvertSortedArraytoBST
{
  // pass both
  public TreeNode sortedArrayToBST(int[] num)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    int m = num.length;
    if (m < 1) return null;
    return sortedArrayToBST(num, 0, m - 1);
  }

  public TreeNode sortedArrayToBST(int[] num, int start, int end)
  {
    if (start > end) return null;
    int middle = start + (end - start) / 2;
    TreeNode root = new TreeNode(num[middle]);
    root.left = sortedArrayToBST(num, start, middle - 1);
    root.right = sortedArrayToBST(num, middle + 1, end);
    return root;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    ConvertSortedArraytoBST c = new ConvertSortedArraytoBST();
    c.sortedArrayToBST(new int[] { 0 });
  }

}
