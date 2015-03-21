package tree;

import java.util.LinkedList;

public class LevelPrint
{

  public static void levelPrint(Node root)
  {
    if (root == null) return;

    LinkedList<Node> q = new LinkedList<Node>();
    q.add(root);
    q.add(null);
    while (!q.isEmpty()) {
      Node tmp = q.pollFirst();
      if (tmp == null) {
        if (q.isEmpty()) break;
        q.add(null);
        System.out.print("\n");
      }
      else {
        if (tmp.left != null) q.add(tmp.left);
        if (tmp.right != null) q.add(tmp.right);
        System.out.print(tmp.value + " ");
      }
    }

  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    Node root = Node.create1();
    levelPrint(root);
  }

}
