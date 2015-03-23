package LeetCode;

import java.util.Arrays;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class ConstructBTfromInPostTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
	if (inorder.length == 0)
	    return null;
	if (inorder.length == 1)
	    return new TreeNode(inorder[0]);

	// the last item in postorder is root
	TreeNode root = new TreeNode(postorder[postorder.length - 1]);

	int i = inorder.length - 1;
	for (; inorder[i] != root.val; i--)
	    ;

	// inorder.length == postorder.length
	if (i < inorder.length - 1) {
	    root.right = buildTree(
		    Arrays.copyOfRange(inorder, i + 1, inorder.length),
		    Arrays.copyOfRange(postorder, i, postorder.length - 1));
	}
	if (i > 0) {
	    root.left = buildTree(Arrays.copyOfRange(inorder, 0, i),
		    Arrays.copyOfRange(postorder, 0, i));
	}

	return root;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
