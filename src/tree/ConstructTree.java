/**
 * @(#) ConstructTree.java Mar 29, 2010 3:38:06 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package tree;

;

/**
 * Class <code>ConstructTree</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Mar 29, 2010 3:38:06 PM
 * 
 */
public class ConstructTree {

    // given the pre order and inorder traverse of the tree, construct the
    // binary
    // s tree
    public static int[] preOrder = { 1, 2, 4, 3, 5, 6 };

    public static int[] inOrder = { 4, 2, 1, 5, 3, 6 };

    public static BinaryNode bintree(int preB, int preE, int inB, int inE) {
	BinaryNode head = new BinaryNode(), s;
	int k, l;

	if (preE >= preB) {
	    head.element = preOrder[preB];
	    k = inB;

	    while (inOrder[k] != preOrder[preB])
		k++;
	    // now k is the root of the subtree

	    l = preB + k - inB;

	    if (k == inB)
		head.left = null;
	    else {
		s = bintree(preB + 1, l, inB, k - 1);
		head.left = s;
	    }

	    if (k == inE)
		head.right = null;
	    else {
		s = bintree(l + 1, preE, k + 1, inE);
		head.right = s;
	    }

	}
	return head;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

	BinarySearchTree t = new BinarySearchTree();
	t.printInOrder(ConstructTree.bintree(0, 5, 0, 5));

    }

}
