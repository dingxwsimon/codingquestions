package LeetCode;

import LeetCode.AddLinkList.ListNode;

public class ReversNodeinK {

    // pass both
    // need to understand
    public static ListNode reverseKGroup(ListNode head, int k) {
	if (k <= 1 || head == null || head.next == null)
	    return head;

	ListNode prev = new ListNode(0);
	prev.next = head;
	head = prev;

	ListNode cur = prev.next;
	while (cur != null) {
	    int count = k;
	    while (cur != null && count > 1) {
		cur = cur.next;
		count--;
	    }

	    if (cur != null) {
		cur = prev.next;
		count = k;
		// different way of reverse
		// change link three times, but only one moving index(cur)
		// rather than three
		while (count > 1) {
		    ListNode temp = cur.next;
		    cur.next = temp.next;
		    temp.next = prev.next;
		    prev.next = temp;
		    count--;
		}
		prev = cur;
		cur = prev.next;
	    }
	}

	return head.next;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	ListNode a = new ListNode(1);
	a.next = new ListNode(2);
	a.next.next = new ListNode(3);
	a.next.next.next = new ListNode(4);
	a.next.next.next.next = new ListNode(5);

	reverseKGroup(a, 2);
    }

}
