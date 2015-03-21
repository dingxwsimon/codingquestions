package tree;

public class Node
{
  public Node left;
  public Node right;
  public int value;

  public String toString()
  {
    return value + "";
  }

  public Node()
  {

  }

  public Node(int v)
  {
    value = v;
  }

  /*
   * 10
   * / \
   * 6 14
   * / \ / \
   * 4 8 12 16
   * / \
   * 7 13
   */
  public static Node create()
  {
    Node root = new Node();
    root.value = 10;
    root.left = new Node(6);
    root.right = new Node(14);
    root.left.left = new Node(4);
    root.left.right = new Node(8);
    root.left.right.left = new Node(7);
    root.right.left = new Node(12);
    root.right.left.right = new Node(13);
    root.right.right = new Node(16);
    return root;
  }

  /*
   * 10
   * / \
   * 6 14
   * / \ / \
   * 4 8 12 16
   * / \ / \ / \
   * 7 9 11 13 15 17
   */

  public static Node create1()
  {
    Node root = new Node();
    root.value = 10;
    root.left = new Node(6);
    root.right = new Node(14);
    root.left.left = new Node(4);
    root.left.right = new Node(8);
    root.left.right.left = new Node(7);
    root.left.right.right = new Node(9);
    root.right.left = new Node(12);
    root.right.left.left = new Node(11);
    root.right.left.right = new Node(13);
    root.right.right = new Node(16);
    root.right.right.left = new Node(15);
    root.right.right.right = new Node(17);

    return root;
  }

}
