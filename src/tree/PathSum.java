package tree;

import java.util.LinkedList;

public class PathSum
{
  // could find sum by path start and end from anywhere
  // CC150 4.9
  public static void findsum(Node head, int sum, int[] path, int level)
  {
    if (head == null) return;
    path[level] = head.value;
    /*
     * Look up through the path we have traversed to see if our path equals
     * sum
     */
    int t = 0;
    for (int i = level ; i >= 0 ; i--) {
      t += path[i];
      if (t == sum) {
        // We have found sum by starting at the current node and
        // counting upwards until level i *.
        print(path, i, level);
      }
    }
    findsum(head.left, sum, path, level + 1); // traverse left
    findsum(head.right, sum, path, level + 1); // traverse right
    path[level] = Integer.MIN_VALUE;
  }

  public static void print(int[] path, int start, int end)
  {
    for (int i = start ; i <= end ; i++) {
      System.out.print(path[i] + " ");
    }
    System.out.println();
  }

  public static int depth(Node node)
  {
    if (node == null)
      return 0;
    else
      return 1 + Math.max(depth(node.left), depth(node.right));
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    // pathSum(Node.create1(), 17, path, 0);
    Node root = Node.create1();
    int[] path = new int[depth(root)];
    findsum(root, 23, path, 0);
    System.out.println();
  }

}
