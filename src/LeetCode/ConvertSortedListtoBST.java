package LeetCode;

import LeetCode.AddLinkList.ListNode;
import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class ConvertSortedListtoBST
{
  // pass both
  public TreeNode sortedListRangeBST(ListNode head, ListNode tail)
  {
    if (head == tail || head == null) return null;
    ListNode curr = getMidNode(head, tail);
    TreeNode root = new TreeNode(curr.val);
    root.left = sortedListRangeBST(head, curr);
    root.right = sortedListRangeBST(curr.next, tail);
    return root;
  }

  public ListNode getMidNode(ListNode head, ListNode tail)
  {
    if (head.next == null || head.next == tail) return head;
    ListNode slow = head;
    ListNode fast = head.next.next;
    while (fast != null && fast != tail) {
      slow = slow.next;
      if (fast.next == null || fast.next == tail) {
        break;
      }
      fast = fast.next.next;
    }
    return slow;
  }

  public TreeNode sortedListToBST(ListNode head)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    return sortedListRangeBST(head, null);
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
