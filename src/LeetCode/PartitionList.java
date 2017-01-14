package LeetCode;

import LeetCode.AddLinkList.ListNode;

public class PartitionList {
    // one more short solution CC150 2.4
    public ListNode partition1(ListNode head, int x) {
        ListNode h = new ListNode(-1);
        ListNode bh = new ListNode(x);
        ListNode smaller = h, bigger = bh;
        // just 2 new node and link node behind them
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                smaller.next = cur;
                smaller = cur;
            } else {
                bigger.next = cur;
                bigger = cur;
                bigger.next = null;
            }
            cur = next;
        }
        smaller.next = bh.next;

        return h.next;
    }

    // pass both
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null)
            return head;

        ListNode start = head;
        ListNode large = null;
        ListNode small = null;
        ListNode largehead = null;
        boolean findsmall = false;
        boolean findlarge = false;

        while (start != null) {
            if (start.val < x) {
                if (!findsmall) {
                    findsmall = true;
                    head = start;
                    small = start;
                } else {
                    small.next = start;
                    small = start;
                }
            } else {
                if (!findlarge) {
                    largehead = start;
                    findlarge = true;
                    large = start;
                } else {
                    large.next = start;
                    large = start;
                }
            }
            start = start.next;

        }
        if (small == null || large == null)
            return head;
        small.next = largehead;
        large.next = null;
        return head;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode a = new ListNode(1);
        a.next = new ListNode(1);
        // a.next.next = new ListNode(1);
        // a.next.next.next = new ListNode(9);
        PartitionList p = new PartitionList();
        p.partition(a, 0);
    }

}
