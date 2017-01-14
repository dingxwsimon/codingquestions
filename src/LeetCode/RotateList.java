package LeetCode;

import LeetCode.AddLinkList.ListNode;

public class RotateList {
    // pass both
    public static ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int i = 1;
        if (head == null || head.next == null)
            return head;
        if (n == 0)
            return head;
        ListNode node = head;
        while (node.next != null) {
            i++;
            node = node.next;
        }
        ListNode end = node;
        if (n >= i)
            n = n % i;
        if (n == 0)
            return head;

        node = head;
        for (int j = 1; j < i - n; j++) {
            node = node.next;
        }
        ListNode newhead = node.next;
        node.next = null;
        end.next = head;

        return newhead;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        // a.next.next = new ListNode(8);
        // a.next.next.next = new ListNode(9);
        rotateRight(a, 2);
    }

}
