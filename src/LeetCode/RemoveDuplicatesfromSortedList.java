package LeetCode;

import LeetCode.AddLinkList.ListNode;

public class RemoveDuplicatesfromSortedList {
    // pass both
    public ListNode deleteDuplicates(ListNode head) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (head == null || head.next == null)
	    return head;
	ListNode first = head.next;
	ListNode second = head;
	while (first != null) {
	    if (first.val == second.val) {
		first = first.next;
	    } else {
		second.next = first;
		second = first;
		first = first.next;
	    }
	}
	second.next = null;
	return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (head == null || head.next == null)
	    return head;
	ListNode start = head.next;
	ListNode end = head;

	while (start != null) {
	    if (start.val == end.val) {
		end.next = start.next;
		start = start.next;
	    } else {
		end.next = start;
		end = end.next;
		start = start.next;
	    }
	}
	return head;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
