package tree;

public class BinarySuccessor {

    public static Node findRightSuccessor(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    // This can use for BT
    public static Node inorderSuccessor(Node root, int key, Node parent) {
        if (root == null)
            return null;
        // get the node with the target value, now find the successor
        if (root.value == key) {
            if (root.right != null)
                return findRightSuccessor(root.right);
            else
                return parent;
        }

        Node left = inorderSuccessor(root.left, key, root);
        if (left != null)
            return left;
        if (parent != null)
            System.out.println("parent is " + parent.value + " and root is "
                    + root.value);
        return inorderSuccessor(root.right, key, parent);
    }

    public static Node inorderSuccessor(Node root, int key) {
        return inorderSuccessor(root, key, null);
    }

    // this can be a iterator this is only for BST
    Node inOrderSuccessor(Node root, Node n) {
        // step 1 of the above algorithm
        if (n.right != null)
            return findRightSuccessor(n.right);

        Node succ = null;

        // Start from root and search for successor down the tree
        while (root != null) {
            if (n.value < root.value) {
                succ = root;
                root = root.left;
            } else if (n.value > root.value)
                root = root.right;
            else
                break;
        }

        return succ;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(inorderSuccessor(Node.create1(), 17).value);
    }

}
