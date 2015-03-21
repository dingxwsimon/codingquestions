package tree;

import java.util.ArrayList;
import java.util.List;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class PrintVerticalOrder
{

  /*
   * Traverse the tree once and get the minimum and maximum horizontal distance
   * with respect to root.
   * Iterate for each vertical line at distance minimum to maximum from root.
   * This solution is O(n2), because getting the width of tree requires O(n)
   * time. (Wait, is it not? Think about a complete tree of 3 level and 7 nodes)
   * O(n) solution is available using a HashMap.
   */
  public List<List<Integer>> printVertically(TreeNode root)
  {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    // 1. find the range of left bound and right bound
    int[] range = new int[2];
    findRange(root, range, 0);

    // 2. calculate number of columns in the result
    int rootIndex = 0 - range[0];
    int columns = range[1] - range[0] + 1;
    for (int i = 0 ; i < columns ; i++) {
      ans.add(new ArrayList<Integer>());
    }

    // 3. fill in vertically in a recursive manner
    fillNode(ans, root, rootIndex);

    return ans;
  }

  private void fillNode(List<List<Integer>> ans, TreeNode node, int index)
  {
    if (node == null) {
      return;
    }
    ans.get(index).add(node.val);
    fillNode(ans, node.left, index - 1);
    fillNode(ans, node.right, index + 1);
  }

  private void findRange(TreeNode node, int[] range, int position)
  {
    if (node == null) {
      return;
    }
    if (position < range[0]) {
      range[0] = position;
    }
    if (position > range[1]) {
      range[1] = position;
    }
    findRange(node.left, range, position - 1);
    findRange(node.right, range, position + 1);
  }

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
