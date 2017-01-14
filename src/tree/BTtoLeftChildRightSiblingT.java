package tree;

public class BTtoLeftChildRightSiblingT {
    public static Node siblingsTransform(Node root) {
        if (root == null)
            return null;
        siblingsTransform(root.left);
        siblingsTransform(root.right);
        if (root.left != null) {
            root.left.right = root.right;
            root.right = null;
        } else {
            root.left = root.right;
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
