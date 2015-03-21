package tree;

public class TrimBST
{
  /*You are given a BST, and min, max elements. Your task is to trim this BST 
   * so that it contains the elements between the min and the max elements. */
  public static Node trimBST(Node root, int min, int max)
  {
    if (root == null) return root;
    if (root.value > max) return trimBST(root.left, min, max);
    if (root.value < min) return trimBST(root.right, min, max);
    root.left = trimBST(root.left, min, max);
    root.right = trimBST(root.right, min, max);
    return root;
  }

  public static Node trimBST1(Node root, int min, int max)
  {

    while (root != null) {
      if (root.value > max)
        root = root.left;
      else if (root.value < min)
        root = root.right;
      else
        break;
    }
    // Now it takes care even if BST does not exist in range of min and max
    if (root == null) return null;

    Node temp = root;
    // Now truncate the branch where node is < min
    while (temp != null) {
      if (temp.left != null && temp.left.value < min) {
        temp.left = null;
        break;
      }
    }
    temp = root;
    // Now truncate the branch where node is > max
    while (temp != null) {
      if (temp.right != null && temp.right.value > max) {
        temp.right = null;
        break;
      }
    }

    return root;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
