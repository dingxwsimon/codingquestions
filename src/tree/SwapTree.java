/**
 * @(#) SwapTree.java Mar 23, 2010 2:34:27 PM
 * Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 * All right reserved
 */
package tree;

import java.util.Stack;

/**
 * Class <code>SwapTree</code>
 *
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Mar 23, 2010 2:34:27 PM
 *
 */
public class SwapTree {

    public static Stack bfs(BinaryNode root) {
        if (root == null)
            return null;

        Stack<BinaryNode> stack = new Stack();
        Stack<BinaryNode> full = new Stack();
        BinaryNode tmp;
        stack.push(root);
        full.push(root);

        while (!stack.empty()) {
            tmp = stack.pop();

            if (tmp.left != null) {
                stack.push(tmp.left);
                full.push(tmp.left);
            }
            if (tmp.right != null) {
                stack.push(tmp.right);
                full.push(tmp.right);
            }

        }
        // store the reverse-preorder
        return full;
    }

    public static BinaryNode swap(BinaryNode root) {
        Stack<BinaryNode> stack = bfs(root);
        BinaryNode newroot = new BinaryNode();
        BinaryNode tmp = new BinaryNode();
        while (!stack.empty()) {
            newroot = stack.pop();
            if (newroot.left != null || newroot.right != null) {
                tmp = newroot.left;
                newroot.left = newroot.right;
                newroot.right = tmp;
            }

        }

        return newroot;
    }

    public static void MirrorRecursively(Node pNode) {
        if (pNode == null)
            return;

        // swap the right and left child sub-tree
        Node pTemp = pNode.left;
        pNode.left = pNode.right;
        pNode.right = pTemp;

        // mirror left child sub-tree if not null
        if (pNode.left != null)
            MirrorRecursively(pNode.left);

        // mirror right child sub-tree if not null
        if (pNode.right != null)
            MirrorRecursively(pNode.right);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinarySearchTree t = new BinarySearchTree();
        t.insert(1);
        t.insert(8);
        t.insert(6);
        t.insert(3);
        t.insert(9);
        t.printInOrder(SwapTree.swap(t.root));

    }

}
