package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;

import LeetCode.PopulatingNextRightPointersinEachNode.TreeLinkNode;

public class PopulatingNextRightPointersinEachNode2
{
  // pass both
  public void connect(TreeLinkNode root)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (root == null) return;
    ArrayList<TreeLinkNode> level = new ArrayList<TreeLinkNode>();
    LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    queue.add(root);
    int thislevel = 1;
    int nextlevel = 0;
    while (!queue.isEmpty()) {
      TreeLinkNode node = queue.pop();
      thislevel--;
      if (node != null) {
        level.add(node);
        queue.add(node.left);
        queue.add(node.right);
        nextlevel += 2;
      }
      if (thislevel == 0) {
        TreeLinkNode prev = null;
        if (!level.isEmpty()) {
          for (TreeLinkNode n : level) {
            if (prev != null) {
              if (n != null) {
                prev.next = n;
                prev = n;
              }
            }
            else {
              prev = n;
            }
          }
          level.get(level.size() - 1).next = null;
        }
        level.clear();
        thislevel = nextlevel;
        nextlevel = 0;
      }
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    TreeLinkNode root = new TreeLinkNode(0);
    PopulatingNextRightPointersinEachNode2 p = new PopulatingNextRightPointersinEachNode2();
    p.connect(root);
  }

}
