package tree;

public class BTToDoubleLinkedList {
    /*
     * 1. If left subtree exists, process the left subtree бн..1.a) Recursively
     * convert the left subtree to DLL. бн..1.b) Then find inorder predecessor of
     * root in left subtree (inorder predecessor is rightmost node in left
     * subtree). бн..1.c) Make inorder predecessor as previous of root and root
     * as next of inorder predecessor. 2. If right subtree exists, process the
     * right subtree (Below 3 steps are similar to left subtree). бн..2.a)
     * Recursively convert the right subtree to DLL. бн..2.b) Then find inorder
     * successor of root in right subtree (inorder successor is leftmost node in
     * right subtree). бн..2.c) Make inorder successor as next of root and root
     * as previous of inorder successor. 3. Find the leftmost node and return it
     * (the leftmost node is always head of converted DLL).
     */

    /*
     * This is the core function to convert Tree to list. This function follows
     * steps 1 and 2 of the above algorithm
     */
    Node bintree2listUtil(Node root) {
	// Base case
	if (root == null)
	    return root;

	// Convert the left subtree and link to root
	if (root.left != null) {
	    // Convert the left subtree
	    Node left = bintree2listUtil(root.left);

	    // Find inorder predecessor. After this loop, left
	    // will point to the inorder predecessor
	    for (; left.right != null; left = left.right)
		;

	    // Make root as next of the predecessor
	    left.right = root;

	    // Make predecssor as previous of root
	    root.left = left;
	}

	// Convert the right subtree and link to root
	if (root.right != null) {
	    // Convert the right subtree
	    Node right = bintree2listUtil(root.right);

	    // Find inorder successor. After this loop, right
	    // will point to the inorder successor
	    for (; right.left != null; right = right.left)
		;

	    // Make root as previous of successor
	    right.left = root;

	    // Make successor as next of root
	    root.right = right;
	}

	return root;
    }

    // The main function that first calls bintree2listUtil(), then follows step
    // 3
    // of the above algorithm
    Node bintree2list(Node root) {
	// Base case
	if (root == null)
	    return root;

	// Convert to DLL using bintree2listUtil()
	root = bintree2listUtil(root);

	// bintree2listUtil() returns root node of the converted
	// DLL. We need pointer to the leftmost node which is
	// head of the constructed DLL, so move to the leftmost node
	while (root.left != null)
	    root = root.left;

	return (root);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
