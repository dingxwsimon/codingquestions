package LeetCode;

import LeetCode.AddLinkList.ListNode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
	if (head == null) {
	    return head;
	}
	ListNode cur, pre, next, node; // sequence is like this:
				       // pre-next-...-cur-node
	cur = head.next;
	head.next = null;
	while (cur != null) {
	    node = cur.next; // save next node of cur
	    if (cur.val < head.val) // swap when cur is lower than head
	    {
		cur.next = head;
		head = cur;
	    } else {
		pre = head;
		next = head.next;
		while (next != null && next.val < cur.val) // if cur.val larger
							   // than
							   // next.val, pre++
							   // and next++
							   // (move to next)
		{
		    pre = next;
		    next = next.next;
		}
		cur.next = next; // insert cur
		pre.next = cur;
	    }
	    cur = node; // cur++ :move to next node
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
