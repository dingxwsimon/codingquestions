package LeetCode;

import LeetCode.AddLinkList.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
	if (head == null || head.next == null)
	    return head;
	int n = 0;
	ListNode h = head;
	while (h != null) {
	    h = h.next;
	    n++;
	}
	int m = n / 2;
	h = head;
	ListNode prev = null;
	while (m > 0) {
	    prev = h;
	    h = h.next;
	    m--;
	}
	prev.next = null;
	ListNode r = sortList(h);
	ListNode l = sortList(head);
	return merge(l, r);
    }

    public ListNode merge(ListNode l, ListNode r) {
	ListNode h = new ListNode(0);
	ListNode ret = h;
	while (l != null && r != null) {
	    if (l.val < r.val) {
		h.next = l;
		l = l.next;
		h = h.next;
		h.next = null;
	    } else {
		h.next = r;
		r = r.next;
		h = h.next;
		h.next = null;
	    }
	}
	if (l != null) {
	    h.next = l;
	} else {
	    h.next = r;
	}
	return ret.next;
    }
}
