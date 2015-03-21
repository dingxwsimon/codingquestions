package LeetCode;

import java.util.ArrayList;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class PathSum2
{
  public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum)
  {
    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> temp = new ArrayList<Integer>();
    findPath(results, temp, root, sum);
    return results;

  }

  public void findPath(ArrayList<ArrayList<Integer>> results,
      ArrayList<Integer> temp, TreeNode root, int sum)
  {
    if (root == null) return;
    temp.add(root.val);
    if (root.val == sum && root.left == null && root.right == null) {
      results.add((ArrayList<Integer>) temp.clone());
    }
    else {
      findPath(results, temp, root.left, sum - root.val);
      findPath(results, temp, root.right, sum - root.val);
    }
    temp.remove(temp.size() - 1);
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
