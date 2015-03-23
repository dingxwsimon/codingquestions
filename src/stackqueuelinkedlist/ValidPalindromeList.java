package stackqueuelinkedlist;

import java.util.Stack;

import stackqueuelinkedlist.ReverseLinkedList.Node;

public class ValidPalindromeList {
    public boolean validate(Node root) {
	Node fast = root;
	Node slow = root;
	Stack<Node> s = new Stack<Node>();
	while (fast != null && fast.next != null) {
	    fast = fast.next.next;
	    s.push(slow);
	    slow = slow.next;
	}
	while (slow != null) {
	    int l = s.pop().element;
	    int r = slow.element;
	    if (l != r)
		return false;
	    slow = slow.next;
	}
	return true;
    }

    public static class Result {
	public Node node;
	public boolean result;

	public Result(Node node, boolean result) {
	    super();
	    this.node = node;
	    this.result = result;
	}
    }

    public Result isPalin(Node head, int length) {
	if (head == null || length == 0) {
	    return new Result(null, true);
	} else if (length == 1) {
	    return new Result(head.next, true);
	} else if (length == 2) {
	    return new Result(head.next.next, head.element == head.next.element);
	}
	Result res = isPalin(head.next, length - 2);
	if (!res.result || res.node == null) {
	    return res;
	} else {
	    res.result = head.element == res.node.element;
	    res.node = res.node.next;
	    return res;
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
