/**
 * @(#) LCA.java Apr 3, 2010 8:42:21 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package tree;

/**
 * 
 * Class <code>LCA</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Apr 3, 2010 8:42:21 PM
 * 
 */
public class LCA {
    // best one, O(n)
    // thi swill return val1 node if val2 is not in the tree
    // so need to test against that

    public static Node LCABT(Node root, int val1, int val2) {
	if (root == null)
	    return null;
	if (root.value == val1 || root.value == val2)
	    return root;
	Node left = LCABT(root.left, val1, val2);
	Node right = LCABT(root.right, val1, val2);
	if (left != null && right != null)
	    return root;
	return left != null ? left : right;
    }

    public static class bothExist {
	public boolean v1 = false;
	public boolean v2 = false;
    }

    public static Node findLCAUtil(Node root, int val1, int val2, bothExist be) {
	if (root == null)
	    return null;
	if (root.value == val1) {
	    be.v1 = true;
	    return root;
	}
	if (root.value == val2) {
	    be.v2 = true;
	    return root;
	}
	Node left = findLCAUtil(root.left, val1, val2, be);
	Node right = findLCAUtil(root.right, val1, val2, be);
	if (left != null && right != null)
	    return root;
	return left != null ? left : right;
    }

    public static boolean find(Node root, int val) {
	if (root == null)
	    return false;
	if (root.value == val || find(root.left, val) || find(root.right, val)) {
	    return true;
	}
	return false;
    }

    public Node findLCA(Node root, int n1, int n2) {
	// Initialize n1 and n2 as not visited
	bothExist be = new bothExist();

	// Find lca of n1 and n2 using the technique discussed above
	Node lca = findLCAUtil(root, n1, n2, be);

	// Return LCA only if both n1 and n2 are present in tree
	if (be.v1 && be.v2 || be.v1 && find(lca, n2) || be.v2 && find(lca, n1))
	    return lca;

	// Else return NULL
	return null;
    }

    public static Node LCABST(Node root, int val1, int val2) {
	if (root == null)
	    return null;
	Node curr = root;
	Node par = root;
	while (curr != null) {

	    if (curr.value < val1 && curr.value < val2) {
		par = curr;
		curr = curr.right;
	    } else if (curr.value > val1 && curr.value > val2) {
		par = curr;
		curr = curr.left;
	    } else {
		return curr;
	    }

	}
	return null;

    }

    public static class Result {
	public Node node;
	public boolean isAncestor;

	public Result(Node n, boolean isAnc) {
	    node = n;
	    isAncestor = isAnc;
	}
    }

    Result helper(Node root, int p, int q) {
	if (root == null)
	    return new Result(null, false);
	if (root.value == p && root.value == q)
	    return new Result(root, true);
	Result rx = helper(root.left, p, q);
	if (rx.isAncestor) {
	    return rx;
	}

	Result ry = helper(root.right, p, q);
	if (ry.isAncestor) {
	    return ry;
	}

	if (rx.node != null && ry.node != null) {
	    return new Result(root, true);
	} else if (root.value == p || root.value == q) {
	    boolean isAnc = rx.node != null || ry.node != null ? true : false;
	    return new Result(root, isAnc);
	} else {
	    return new Result(rx.node != null ? rx.node : ry.node, false);
	}
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	System.out.println(LCA.LCABT(Node.create1(), 7, 11).value);

    }

}
