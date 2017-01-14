package LeetCode;

public class AddLinkList {
    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public String toString() {
            return val + "";
        }
    }

    // working
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        if (l1 == null)
            return null;
        if (l2 == null)
            return null;

        ListNode result = null;
        ListNode current = null;
        while (l1 != null || l2 != null) {
            int digit = 0;
            if (l1 != null) {
                digit += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                digit += l2.val;
                l2 = l2.next;
            }
            digit += carry;
            if (digit >= 10) {
                carry = 1;
                digit -= 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(digit);

            if (result == null) {
                result = node;
            } else {
                current.next = node;
            }
            current = node;
            // useful for the last node
            if (carry > 0) {
                current.next = new ListNode(1);
            }

        }
        return result;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum % 10;
            sum = sum / 10;
            head.next = new ListNode(sum);
            head = head.next;
        }
        if (carry > 0) {
            head.next = new ListNode(carry);
        }
        return dummy.next;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode a = new ListNode(0);
        // a.next = new ListNode(8);
        // a.next.next = new ListNode(8);
        // a.next.next.next = new ListNode(9);
        // a.next.next.next.next = new ListNode(8);
        // a.next.next.next.next.next = new ListNode(6);
        // a.next.next.next.next.next.next = new ListNode(0);
        // a.next.next.next.next.next.next.next = new ListNode(1);
        // a.next.next.next.next.next.next.next.next = new ListNode(0);
        // a.next.next.next.next.next.next.next.next.next = new ListNode(1);

        ListNode b = new ListNode(0);
        // b.next = new ListNode(0);
        // b.next.next = new ListNode(5);
        // b.next.next.next = new ListNode(8);
        // b.next.next.next.next = new ListNode(3);
        // b.next.next.next.next.next = new ListNode(4);
        // b.next.next.next.next.next.next = new ListNode(0);
        // b.next.next.next.next.next.next.next = new ListNode(3);
        // b.next.next.next.next.next.next.next.next = new ListNode(4);

        // {0,9,1,9,8,6,0,1,0,1}, {7,3,5,8,3,4,0,3,4}
        addTwoNumbers1(a, b);

    }

}
