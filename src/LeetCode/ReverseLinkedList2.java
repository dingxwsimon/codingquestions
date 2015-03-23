package LeetCode;

import LeetCode.AddLinkList.ListNode;

public class ReverseLinkedList2 {
    // less number of extra nodes similar to reversNodeinK
    public ListNode reverseBetween1(ListNode head, int m, int n) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int count = 1;
	ListNode prev = new ListNode(0);
	prev.next = head;
	ListNode cur = prev.next;
	ListNode h = prev;

	while (true) {
	    if (count >= m && count < n) {
		ListNode temp = cur.next;
		cur.next = temp.next;
		temp.next = prev.next;
		prev.next = temp;
	    } else if (count < m) {
		prev = cur;
		cur = cur.next;
	    } else if (count == n) {
		break;
	    }
	    count++;
	}

	return h.next;
    }

    // pass both
    public ListNode reverseBetween(ListNode head, int m, int n) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int count = 1;
	ListNode g = new ListNode(0);
	g.next = head;
	ListNode end = head;
	ListNode prev = head, cur = head.next, next = null, x = g;
	// this has less link manipulation
	while (true) {
	    if (count >= m && count < n) {
		next = cur.next;
		cur.next = prev;
		prev = cur;
		cur = next;
	    } else if (count < m) {
		x = prev;
		prev = cur;
		cur = cur.next;
	    } else if (count == n) {
		x.next.next = cur;
		x.next = prev;
		break;
	    }
	    count++;
	}

	return g.next;
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
	ReverseLinkedList2 r = new ReverseLinkedList2();
	r.reverseBetween1(a, 2, 4);

	// a.next.next.next.next = new ListNode(8);
    }

}
