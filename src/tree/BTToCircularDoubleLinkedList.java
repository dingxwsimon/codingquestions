package tree;

public class BTToCircularDoubleLinkedList {
    /*
     * helper function -- given two list nodes, join them together so the second
     * immediately follow the first. Sets the .next of the first and the
     * .previous of the second.
     */
    public static void join(Node a, Node b) {
	a.right = b;
	b.left = a;
    }

    /*
     * helper function -- given two circular doubly linked lists, append them
     * and return the new list.
     */
    public static Node append(Node a, Node b) {
	// if either is null, return the other
	if (a == null)
	    return (b);
	if (b == null)
	    return (a);

	// find the last node in each using the .previous pointer
	Node aLast = a.left;
	Node bLast = b.left;

	// join the two together to make it connected and circular
	join(aLast, b);
	join(bLast, a);

	return (a);
    }

    /*
     * --Recursion-- Given an ordered binary tree, recursively change it into a
     * circular doubly linked list which is returned.
     */
    public static Node treeToList(Node root) {
	// base case: empty tree -> empty list
	if (root == null)
	    return (null);

	// Recursively do the subtrees (leap of faith!)
	Node aList = treeToList(root.left);
	Node bList = treeToList(root.right);

	// Make the single root node into a list length-1
	// in preparation for the appending
	root.left = root;
	root.right = root;

	// At this point we have three lists, and it's
	// just a matter of appending them together
	// in the right order (aList, root, bList)
	aList = append(aList, root);
	aList = append(aList, bList);

	return (aList);
    }

    /*
     * Given a non-empty tree, insert a new node in the proper place. The tree
     * must be non-empty because Java's lack of reference variables makes that
     * case and this method messier than they should be.
     */
    public static void treeInsert(Node root, int newData) {
	if (newData <= root.value) {
	    if (root.left != null)
		treeInsert(root.left, newData);
	    else
		root.left = new Node(newData);
	} else {
	    if (root.right != null)
		treeInsert(root.right, newData);
	    else
		root.right = new Node(newData);
	}
    }

    // Do an inorder traversal to print a tree
    // Does not print the ending "\n"
    public static void printTree(Node root) {
	if (root == null)
	    return;
	printTree(root.left);
	System.out.print(Integer.toString(root.value) + " ");
	printTree(root.right);
    }

    // Do a traversal of the list and print it out
    public static void printList(Node head) {
	Node current = head;

	while (current != null) {
	    System.out.print(Integer.toString(current.value) + " ");
	    current = current.right;
	    if (current == head)
		break;
	}

	System.out.println();
    }

    // Demonstrate tree->list with the list 1..5
    public static void main(String[] args) {

	// first build the tree shown in the problem document
	// http://cslibrary.stanford.edu/109/
	Node root = new Node(4);
	treeInsert(root, 2);
	treeInsert(root, 1);
	treeInsert(root, 3);
	treeInsert(root, 5);

	System.out.println("tree:");
	printTree(root); // 1 2 3 4 5
	System.out.println();

	System.out.println("list:");
	Node head = treeToList(root);
	printList(head); // 1 2 3 4 5 yay!
    }

}
