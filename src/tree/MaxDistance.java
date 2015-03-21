package tree;

public class MaxDistance
{
  // find the max distance between any two nodes in a binary tree
  //diameter

  public static class Node
  {
    Node left;

    Node right;

    int maxLeft;

    int maxRight;

    int value;
  }

  public static int maxLen;

  // this is the diameter
  public static void findMaxLen(Node root)
  {
    if (root == null) return;

    if (root.left == null) root.maxLeft = 0;
    if (root.right == null) root.maxRight = 0;

    if (root.left != null) {
      findMaxLen(root.left);
    }
    if (root.right != null) {
      findMaxLen(root.right);
    }

    if (root.left != null) {
      int tempMax = 0;
      tempMax = root.left.maxLeft > root.left.maxRight
                                                      ? root.left.maxLeft
                                                      : root.left.maxRight;
      root.maxLeft = tempMax + 1;
    }
    if (root.right != null) {
      int tempMax = 0;
      tempMax = root.right.maxLeft > root.left.maxRight
                                                       ? root.right.maxLeft
                                                       : root.right.maxRight;
      root.maxRight = tempMax + 1;
    }
    if (root.maxLeft + root.maxRight > maxLen)
      maxLen = root.maxLeft + root.maxRight;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println();
  }

}
