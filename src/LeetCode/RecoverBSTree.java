package LeetCode;

import java.util.Stack;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class RecoverBSTree {
    // remember, same as above little different in inorder
    public void recoverTree1(TreeNode root) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (root == null)
	    return;
	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode large = root;
	TreeNode small = root;
	TreeNode p = root;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);
	boolean foundL = false;
	while (!stack.empty() || p != null) {
	    if (p != null) {
		stack.push(p);
		p = p.left;
	    } else {
		p = stack.pop();
		System.out.println("p " + p.val);
		// this is where the traverse print the node
		if (p.val < prev.val && !foundL) {
		    large = prev;
		    foundL = true;
		    small = p;
		}
		if (p.val < small.val && foundL) {
		    small = p;
		}
		System.out
			.println("large " + large.val + " small " + small.val);
		prev = p;
		p = p.right;
	    }
	}
	System.out.println("large " + large.val + " small " + small.val);
	int tmp = small.val;
	small.val = large.val;
	large.val = tmp;
    }

    // pass both two number in bst are sawpped recover them
    public void recoverTree(TreeNode root) {
	// Start typing your Java solution below
	// DO NOT write main() function
	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode p = root;
	TreeNode cur = root;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);
	TreeNode large = root;
	TreeNode small = root;
	boolean findlarge = false;
	do {
	    while (p != null) {
		stack.push(p);
		p = p.left;
	    }
	    p = stack.pop();
	    cur = p;
	    if (cur.val < prev.val && !findlarge) {
		large = prev;
		findlarge = true;
		small = cur;
	    }
	    if (cur.val < small.val && findlarge) {
		small = cur;
	    }
	    prev = cur;
	    p = p.right;
	} while (p != null || !stack.empty());

	int tmp = large.val;
	large.val = small.val;
	small.val = tmp;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	TreeNode root = new TreeNode(1);
	root.right = new TreeNode(3);
	root.right.right = new TreeNode(2);

	RecoverBSTree r = new RecoverBSTree();
	r.recoverTree1(root);
    }

}
