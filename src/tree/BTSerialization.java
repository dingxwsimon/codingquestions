package tree;

import java.io.OutputStream;

public class BTSerialization {
    public String treeStr = "";
    public Node root = null;

    public void writeBinaryTree(Node p) {
        if (p == null) {
            treeStr += "# ";
        } else {
            treeStr += p.value + " ";
            writeBinaryTree(p.left);
            writeBinaryTree(p.right);
        }
    }

    public int index = 0;

    public void readBinaryTree1(StringBuffer in) {
        index = 0;
        root = readBinaryTree(in);
    }

    /*
     * Since we have two child nodes for every nodes, so index will never out of
     * boundary
     */
    Node readBinaryTree(StringBuffer in) {
        String c = in.substring(index, in.indexOf(" ", index));
        index = in.indexOf(" ", index) + 1;

        if (c.equals("#")) {
            return null;
        } else {
            Node p = new Node(Integer.parseInt(c));
            p.left = readBinaryTree(in);
            p.right = readBinaryTree(in);
            return p;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node root = Node.create();
        BTSerialization bts = new BTSerialization();
        bts.root = root;
        bts.writeBinaryTree(bts.root);
        System.out.println(bts.treeStr);
        bts.readBinaryTree1(new StringBuffer(bts.treeStr));
        Traverse.inOrderItr(bts.root);
    }
}
