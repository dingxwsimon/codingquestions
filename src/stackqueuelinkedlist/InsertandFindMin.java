package stackqueuelinkedlist;

import stackqueuelinkedlist.AddLinkList.ListNode;

public class InsertandFindMin
{
  // Insert an element in a ordered (ascending) circular linked list. After
  // inserting return the node with the smallest element.
  int insertAndReturnMin(ListNode p, int n)
  {
    // Null list
    if (p == null) {
      p = new ListNode(n);
      p.next = p;
      return n;
    }
    // single node list
    if (p.next == p) {
      p.next = new ListNode(n);
      p.next.next = p;
      return Math.min(p.val, p.next.val);
    }

    // general case
    ListNode prev = p;
    p = p.next;
    int flag = 0;
    while (true) {
      // non-edge case
      if ((prev.val < p.val) && (prev.val < n) && (n < p.val)) {
        // insert node and exit this loop
        ListNode temp = new ListNode(n);
        prev.next = temp;
        temp.next = p;
        break;
      }
      // edge case
      else if ((prev.val > p.val)) {
        if ((n > prev.val && n > p.val) // n is new max elem
            || ((n < prev.val && n < p.val) && flag == 1)) // n is new min elem
        {
          ListNode temp = new ListNode(n);
          prev.next = temp;
          temp.next = p;

          return (flag == 1)
                            ? n
                            : p.val;
        }
      }
      prev = p;
      p = p.next;
    }
    // if not returned from above we already have node inserted
    while (prev.val < p.val) {
      prev = p;
      p = p.next;
    }
    return p.val;
  }

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
