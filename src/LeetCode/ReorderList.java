package LeetCode;

import LeetCode.AddLinkList.ListNode;

public class ReorderList {
    public void reorderList(ListNode L) {
	if (L == null || L.next == null || L.next.next == null)
	    return;
	ListNode mid = FindMid(L);
	// now reverse 2nd half
	ListNode secondhalf = Reverse1(mid.next);
	ListNode firsthalf = L;
	// do not forget to update mid.next==null
	mid.next = null;// otherwise we are duplicating L1 and L2
	L = Merge(firsthalf, secondhalf);
    }

    // as the key method for interweaving the linked list involves three steps
    // 1. find the mid point
    // 2. reverse the 2nd half of list
    // 3. merge them in place
    // we are going to define all three supporting methods before declaring the
    // main interweave method

    // first method, to find mid point of array in linear time
    // the trick is using two pointers (fast/slow) until fast meets the null
    private ListNode FindMid(ListNode L) {
	ListNode fast = L;// two steps per move
	ListNode slow = L;// one step per move
	while (fast != null && fast.next != null && slow != null) {
	    fast = fast.next.next;
	    slow = slow.next;
	}
	return slow;
    }

    // 2nd support method, to reverse the list
    private ListNode Reverse(ListNode start) {
	ListNode currentNode = start;
	ListNode prevNode = null;
	while (currentNode != null) {
	    // save value of next Node
	    ListNode nextNode = currentNode.next;

	    // change link
	    currentNode.next = prevNode;

	    // List traverse
	    prevNode = currentNode;
	    currentNode = nextNode;
	}
	return prevNode;
    }

    private ListNode Reverse1(ListNode start) {
	ListNode currentNode = start;
	ListNode prevNode = new ListNode(2);
	prevNode.next = start;
	while (currentNode.next != null) {

	    ListNode temp = currentNode.next;
	    currentNode.next = temp.next;
	    temp.next = prevNode.next;
	    prevNode.next = temp;

	}
	return prevNode.next;
    }

    // so the 3rd method is to merge two lists into one, by picking one from
    // each
    // other
    private ListNode Merge(ListNode L1, ListNode L2) {
	// however, one assumption is that the length of L1>L2, because of our
	// mid
	// algorithm
	ListNode merged = new ListNode(0);// its next is the resulting merged
					  // list
	ListNode current = merged;// current points where we are at the time of
				  // merging
	int turn = 1;// we define a turn to know which list element to be merged
		     // per
		     // loop cycle
	while (L1 != null && L2 != null) {
	    if (turn == 1)// pick from L1
	    {
		current.next = L1;
		L1 = L1.next;// update L1's index to right
		turn = 2;// next loop we pick from L2
	    } else// pick from L2
	    {
		current.next = L2;
		L2 = L2.next;// update L1's index to right
		turn = 1;// back to L1 next cycle
	    }
	    current = current.next;// update the current pointer
	}
	// as we said L1's length may be longer than L2 considering size of
	// array
	if (L1 != null) // we merge the remaining L1 to our current.next
	    current.next = L1;

	return merged.next;
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
	ReorderList r = new ReorderList();
	r.reorderList(a);

    }

}
