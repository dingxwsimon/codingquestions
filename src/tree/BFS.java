package tree;

import java.util.LinkedList;

public class BFS
{

  // queue
  public static void BFS(Node root)
  {
    LinkedList<Node> q = new LinkedList<Node>();
    q.addLast(root);
    while (!q.isEmpty()) {
      Node n = q.pollFirst();
      System.out.println(n.value);
      if (n.left != null) q.addLast(n.left);
      if (n.right != null) q.addLast(n.right);
    }

  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    BFS(Node.create());
  }

}
