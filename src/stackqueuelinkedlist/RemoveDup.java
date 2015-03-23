package stackqueuelinkedlist;

public class RemoveDup {

    public static class Node {
	Node next;
	int data;
    }

    // inplace delete duplicate in a linked list
    public static void DelDup(Node head) {
	Node current = head;
	Node tail = head;
	if (current == null)
	    return;
	current = tail.next; // invariant
	while (current != null) {
	    Node runner = head;
	    while (runner != current) {
		if (runner.data == current.data) {
		    Node tmp = current.next;
		    tail.next = current = tmp;
		    break;
		}
	    }
	    if (runner == current) {
		tail = current;
		current = current.next;
	    }
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
