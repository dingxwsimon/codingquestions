package tree;

public class GreaterSumTree {
    /*
     * In a BST, I want to replace all nodes with value which is the sum of all
     * the nodes which are greater than equal to the current node.
     */
    // reverse inorder traversal
    int sum = 0;

    public void changeTree(Node root) {
	if (root != null) {
	    changeTree(root.right);
	    root.value = sum + root.value;
	    sum = root.value;
	    changeTree(root.left);
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
