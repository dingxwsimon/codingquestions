package LeetCode;

import LeetCode.AddLinkList.ListNode;

public class RemoveNfromEnd {
    // pass both self
    public ListNode removeNthFromEnd1(ListNode head, int n) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ListNode h = new ListNode(0);
	h.next = head;
	ListNode first = h;
	while (n > 0) {
	    first = first.next;
	    if (first == null)
		return head;
	    n--;
	}
	ListNode second = h;
	while (first.next != null) {
	    first = first.next;
	    second = second.next;
	}
	second.next = second.next.next;
	return h.next;
    }

    // pass both
    public ListNode removeNthFromEnd(ListNode head, int n) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (head == null)
	    return head;

	ListNode first = head;
	ListNode second = head;

	for (int i = 1; i < n; i++) {
	    first = first.next;
	    if (first == null)
		return head;
	}
	if (first.next == null)
	    return second.next;

	first = first.next;
	while (first.next != null) {
	    first = first.next;
	    second = second.next;
	}
	second.next = second.next.next;
	return head;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
