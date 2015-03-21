/**
 * @(#) ValidatBST.java Apr 6, 2010 10:53:09 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package tree;

import java.util.Stack;

/**
 * Class <code>ValidatBST</code>
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Apr 6, 2010 10:53:09 PM
 * 
 */
public class ValidatBST
{

  public static boolean validate(BinaryNode root)
  {
    Comparable prev = 0;
    Stack<BinaryNode> s = new Stack<BinaryNode>();
    BinaryNode p = root;
    if (p == null) {
      return false;
    }

    while (p != null || !s.isEmpty()) {
      if (p != null) {
        s.push(p);
        p = p.left;
      }
      else {
        p = s.pop();
        if (p.element.compareTo(prev) < 0) {
          return false;
        }
        prev = p.element;
        p = p.right;
      }
    }
    return true;
  }

  public static boolean isValidBST(BinaryNode node, Comparable MIN,
      Comparable MAX)
  {
    if (node == null) return true;
    if (node.element.compareTo(MIN) > 0 && node.element.compareTo(MAX) < 0
        && isValidBST(node.left, MIN, node.element)
        && isValidBST(node.right, node.element, MAX))
      return true;
    else
      return false;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    BinarySearchTree t = new BinarySearchTree();
    t.insert(1);
    t.insert(10);
    t.insert(3);
    t.insert(2);
    t.insert(7);
    t.insert(6);
    t.insert(5);
    t.insert(11);
    t.insert(12);
    t.insert(13);
    t.insert(14);
    // t.root.right.left.right.element = 17;

    System.out.println(ValidatBST.validate(t.root));

  }

}
