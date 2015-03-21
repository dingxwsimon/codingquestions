package linkedin;
import LeetCode.BTLevelOrderTraversal;
import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class TurntoleftLeaf
{
  /*Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes. 

Keep in mind: ALL RIGHT NODES IN ORIGINAL TREE ARE LEAF NODE.


/* for example, turn these:
 *
 *        1                 1
 *       / \                 / \
 *      2   3            2   3
 *     / \
 *    4   5
 *   / \
 *  6   7
 *
 * into these:
 *
 *        1               1
 *       /               /
 *      2---3         2---3
 *     /
 *    4---5
 *   /
 *  6---7
 *
 * where 6 is the new root node for the left tree, and 2 for the right tree.
 * oriented correctly:
 *
 *     6                   2
 *    / \                   / \
 *   7   4              3   1
 *        / \
 *       5   2
 *            / \
 *          3   1
 */
  
  
  
  TreeNode FlipTree ( TreeNode root )
  {
      if (root == null)
          return null;
      
      // Working base condition
      if( root.left == null && root.right == null) 
      {
          return root;
      }
      
      TreeNode newRoot = FlipTree(root.left);
      
      root.left.left = root.right;
      root.left.right = root;
      root.left = null;
      root.right = null;
      
      return newRoot;
  }
  public static void main(String[] args)
  {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    System.out.println(root.toString());
    TurntoleftLeaf b = new TurntoleftLeaf();
    System.out.println(b.FlipTree(root).toString());
  }

}
