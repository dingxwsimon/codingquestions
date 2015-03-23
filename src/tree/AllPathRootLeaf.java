package tree;

import java.util.ArrayList;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class AllPathRootLeaf {

    void printPathsRecur(TreeNode node, ArrayList<Integer> path,
	    ArrayList<ArrayList<Integer>> ret) {
	if (node == null)
	    return;

	/* append this node to the path array */
	path.add(node.val);

	/* it's a leaf, so print the path that led to here */
	if (node.left == null && node.right == null) {
	    ret.add(new ArrayList<Integer>(path));
	} else {
	    /* otherwise try both subtrees */
	    printPathsRecur(node.left, path, ret);
	    printPathsRecur(node.right, path, ret);
	}
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
