package stackqueuelinkedlist;

import stackqueuelinkedlist.AddLinkList.ListNode;

public class MidList {
    // now let's create a test case
    public static void main(String[] args) {
	ListNode myListNode = new ListNode(1);
	myListNode.next = new ListNode(2);
	myListNode.next.next = new ListNode(3);
	myListNode.next.next.next = new ListNode(4);
	myListNode.next.next.next.next = new ListNode(5);// 1,2,3,4,5 so the mid
							 // point is expected to
							 // be 3
	myListNode.next.next.next.next.next = new ListNode(6);
	myListNode.next.next.next.next.next.next = new ListNode(7);// 1,2,3,4,5,6,7
								   // so mid
								   // point
								   // expected
								   // to be 4
	MidListNode(myListNode);
    }

    // now we try to implement the method, as we discussed in slide we need two
    // support variables
    static int myListNodeLength = 0;// this is to keep track of length
    static int currentReverseIndex = 0;// this is to keep track of index in
				       // reverse order

    // notice, this method does not return the value, this is somehow similar as
    // a traversal
    public static void MidListNode(ListNode myListNode) {
	// firstly we proceed the length and do the recursion
	if (myListNode != null) {
	    myListNodeLength++;
	    MidListNode(myListNode.next);
	    // after recursion, we can update the current index, and if you look
	    // at control flow, the next
	    // statement won't be first executed until we reach last node
	    currentReverseIndex++;
	}
	// now we only need to decide if
	// currentReverseIndex/myListNodeLength=1/2
	if (currentReverseIndex * 2 == myListNodeLength
		|| currentReverseIndex * 2 == myListNodeLength + 1)// myListNodeLength
								   // can be
								   // even or
								   // odd
	    System.out.println("Find mid point: " + myListNode.val);
    }

}
