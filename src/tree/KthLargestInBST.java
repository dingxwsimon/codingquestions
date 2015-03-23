package tree;

import java.util.ArrayList;

public class KthLargestInBST {

    public static Node kthLargest(Node t, int k, ArrayList<Integer> count) {
	if (t == null) {
	    return null;
	}
	Node right = kthLargest(t.right, k, count);
	if (right != null)
	    return right;
	count.set(0, count.get(0) + 1);

	if (count.get(0) == k) {
	    return t;
	}
	return kthLargest(t.left, k, count);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Node root = Node.create();
	ArrayList<Integer> count = new ArrayList<Integer>();
	count.add(0);
	System.out.println(kthLargest(root, 3, count));
    }

}
