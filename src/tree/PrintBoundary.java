package tree;

public class PrintBoundary {
    // Print a full binary tree's boundary in counterclockwise order
    public void PrintBoundary(Node root) {
	preorderLeftOnly(root);
	inorderLeafOnly(root);
	postorderRightOnly(root);
    }

    // we have some duplicates as they are at the edge of two boundaries
    // we decide to print those left/right boundary nodes only if they are
    // leaves (mid step)
    private boolean ifLeaf(Node myT) {
	return myT != null && myT.left == null && myT.right == null;
    }

    // now define first method that is similar to preorder to print left
    // boundary
    private void preorderLeftOnly(Node root) {
	if (this != null && !ifLeaf(root))
	    System.out.print(root.value + ">");
	if (root.left != null)
	    preorderLeftOnly(root.left);
    }

    // now define the 2nd method to in-order traversal the tree but only print
    // leaf nodes!
    private void inorderLeafOnly(Node root) {// leaf not left, sorry it is LEAF
	if (this == null)
	    return;
	if (root.left != null)
	    inorderLeafOnly(root.left);
	// make sure it is leaf before printing
	if (root.left == null && root.right == null)
	    System.out.print(root.value + ">");
	if (root.right != null)
	    inorderLeafOnly(root.right);
    }

    // This is the similar-to-postorder traversal with dealing right children
    // only
    private void postorderRightOnly(Node root) {
	if (root.right != null)
	    postorderRightOnly(root.right);
	if (this != null && !ifLeaf(root))
	    System.out.print(root.value + ">");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
