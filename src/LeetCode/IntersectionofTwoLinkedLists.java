package LeetCode;

import LeetCode.AddLinkList.ListNode;

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        if (headA == headB)
            return headA;
        ListNode ah = headA;
        ListNode bh = headB;
        int cntA = 0;
        int cntB = 0;
        while (ah.next != null) {
            ah = ah.next;
            cntA++;
        }

        while (bh.next != null) {
            bh = bh.next;
            cntB++;
        }

        if (ah != bh) {
            return null;
        }
        ah = headA;
        bh = headB;
        if (cntA > cntB) {
            int tmp = cntA - cntB;
            while (tmp > 0) {
                ah = ah.next;
                tmp--;
            }

        }
        if (cntA < cntB) {
            int tmp = cntB - cntA;
            while (tmp > 0) {
                bh = bh.next;
                tmp--;
            }

        }

        while (ah != bh) {
            ah = ah.next;
            bh = bh.next;
        }
        return ah;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
