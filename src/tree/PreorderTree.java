package tree;

import java.util.ArrayList;

public class PreorderTree
{
  /*
   * Given an array representing the pre-order traversal for binary tree,
   * print all possible binary trees' in-order traversal
   */
  public static ArrayList<Node> printAllTree(int[] pre, int start, int end)
  {
    ArrayList<Node> returnTrees = new ArrayList<Node>();

    if (start > end || end < 0 || end > pre.length) {
      returnTrees.add(null);
      return returnTrees;
    }
    if (start == end) {
      returnTrees.add(new Node(pre[start]));
      return returnTrees;
    }

    for (int i = start ; i <= end ; i++) {
      ArrayList<Node> left = printAllTree(pre, start + 1, i);
      ArrayList<Node> right = printAllTree(pre, i + 1, end);
      for (Node eachLeft : left) {
        for (Node eachRight : right) {
          Node tempRoot = new Node(pre[start]);
          tempRoot.left = eachLeft;
          tempRoot.right = eachRight;
          returnTrees.add(tempRoot);
        }
      }
    }

    return returnTrees;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    int[] testPre = new int[]{1,2,3};
    ArrayList<Node> testResult = printAllTree(testPre, 0, testPre.length -1);
    for(Node n : testResult){
      Traverse.inOrderItr1(n);
    }
  }

}
