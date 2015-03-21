package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeInorderTraversal
{

  public static class TreeNode
  {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x)
    {
      val = x;
    }

    public String toString()
    {
      levelOrder1();
      String treeStr = "";
      for(ArrayList<Integer> level : results){
        for(int i : level){
          treeStr += i + "-";
        }
        treeStr +="\n";
      }
      return treeStr;
    }
    
    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> levelOrder1()
    {
      LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
      queue.add(this);
      ArrayList<Integer> line = new ArrayList<Integer>();
      int thislevelcnt = 1;
      int nextlevelcnt = 0;
      while (queue.size() != 0) {
        TreeNode node = queue.pop();
        thislevelcnt--;
        if (node != null) {
          line.add(node.val);
          queue.add(node.left);
          queue.add(node.right);
          nextlevelcnt += 2;
        }
        if (thislevelcnt == 0) {
          if (!line.isEmpty()) results.add(line);
          line = new ArrayList<Integer>();
          thislevelcnt = nextlevelcnt;
          nextlevelcnt = 0;
        }
      }
      return results;
    }
    

  }

  public ArrayList<Integer> inorderTraversal(TreeNode root)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<Integer> result = new ArrayList<Integer>();
    inorder(root, result);
    return result;
  }

  public void inorder(TreeNode root, ArrayList<Integer> result)
  {
    if (root == null) return;
    inorder(root.left, result);
    result.add(root.val);
    inorder(root.right, result);
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
