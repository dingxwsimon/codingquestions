package stackqueuelinkedlist;

import stackqueuelinkedlist.AddLinkList.ListNode;

public class CircleList
{
  public static ListNode findBegin(ListNode head)
  {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) break;
    }
    if (fast == null || fast.next == null) return null;

    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return fast;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
