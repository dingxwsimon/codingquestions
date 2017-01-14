package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import LeetCode.AddLinkList.ListNode;

public class MergeSortedLists {

    // pass both
    // simpler
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode h = head;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                l1 = l1.next;
            } else {
                h.next = l2;
                l2 = l2.next;
            }
            h = h.next;
        }
        if (l1 != null) {
            h.next = l1;
        } else if (l2 != null) {
            h.next = l2;
        }
        return head.next;
    }

    // heap *** important
    private Comparator<ListNode> pqComparator;

    public ListNode mergeKLists2(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;
        pqComparator = new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        };
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
                pqComparator);

        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }

        ListNode head = new ListNode(0);
        ListNode p = head;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null)
                pq.add(node.next);
            p.next = node;
            p = p.next;
        }

        return head.next;
    }

    // pass both
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0)
            return null;
        int curSize = lists.size();
        while (curSize > 1) {
            // upper ceil
            int halfSize = (1 + curSize) / 2;
            // merge i,i + halfSize
            for (int i = 0; i < halfSize && i + halfSize < curSize; ++i) {
                ListNode first = lists.get(i);
                ListNode second = lists.get(i + halfSize);
                ListNode result = mergeTwoLists(first, second);
                lists.set(i, result);
            }
            // set curSize to halfsize
            curSize = halfSize;
        }
        return lists.get(0);
    }

    // workiing!!! O(nlog(n))
    public static ListNode mergeKLists1(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode result = new ListNode(0);
        ListNode head = result;
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (ListNode l : lists) {
            if (l == null)
                continue;
            while (l != null) {
                al.add(l.val);
                l = l.next;
            }
        }
        if (al.isEmpty())
            return null;
        Collections.sort(al);
        ListNode prev = new ListNode(0);
        for (int i : al) {
            head.val = i;
            head.next = new ListNode(0);
            prev = head;
            head = head.next;
        }
        prev.next = null;

        return result;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // [{-1,1},{-3,1,4},{-2,-1,0,2}]
        ListNode a = new ListNode(1);
        // a.next = new ListNode(1);

        ListNode b = new ListNode(2);
        // b.next = new ListNode(-1);
        // b.next.next = new ListNode(4);

        ListNode c = new ListNode(-2);
        c.next = new ListNode(-1);
        c.next.next = new ListNode(0);
        c.next.next.next = new ListNode(2);

        mergeTwoLists(a, b);

        ArrayList<ListNode> lists = new ArrayList<ListNode>();
        lists.add(a);
        lists.add(b);
        lists.add(c);

        // mergeKLists(lists);

    }

}
