package LeetCode;

import LeetCode.AddLinkList.ListNode;

public class SwapNode
{
  // pass both, myself
  public static ListNode swapPairs1(ListNode head)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    ListNode s = new ListNode(0);
    s.next = head;
    ListNode h = s;
    if (head == null || head.next == null) return head;
    while (head != null && head.next != null) {
      ListNode temp = head.next;
      head.next = temp.next;
      temp.next = s.next;
      s.next = temp;
      s = head;
      head = head.next;
    }
    return h.next;
  }

  // pass both
  public static ListNode swapPairs(ListNode head)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (head == null || head.next == null) {
      return head;
    }

    ListNode start = head;
    ListNode end = head.next;
    ListNode prev = new ListNode(0);
    head = end;

    while (start != null && start.next != null) {
      start.next = end.next;
      end.next = start;
      prev.next = end;
      prev = start;
      start = start.next;
      if (start != null && start.next != null) end = start.next;
    }
    return head;

  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    ListNode a = new ListNode(1);
    a.next = new ListNode(2);
    //a.next.next = new ListNode(3);
    //a.next.next.next = new ListNode(4);
    //a.next.next.next.next = new ListNode(5);
    swapPairs1(a);
  }

}
