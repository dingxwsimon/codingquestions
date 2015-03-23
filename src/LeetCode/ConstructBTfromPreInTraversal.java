package LeetCode;

import java.util.Arrays;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class ConstructBTfromPreInTraversal {
    // pass both
    // need study
    public TreeNode buildTree(int[] preorder, int[] inorder) {
	if (preorder.length == 0) {
	    return null;
	}

	// the first item in preorder is root
	TreeNode root = new TreeNode(preorder[0]);
	if (preorder.length == 1) {
	    return root;
	}

	int i = 0;
	for (; inorder[i] != root.val; i++)
	    ;

	if (i > 0) {
	    root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1),
		    Arrays.copyOfRange(inorder, 0, i));
	}
	if (i < inorder.length - 1) {
	    root.right = buildTree(
		    Arrays.copyOfRange(preorder, i + 1, preorder.length),
		    Arrays.copyOfRange(inorder, i + 1, inorder.length));
	}

	return root;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	ConstructBTfromPreInTraversal c = new ConstructBTfromPreInTraversal();
	c.buildTree(new int[] { -1 }, new int[] { -1 });
    }

}
