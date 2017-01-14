package tree;

import java.util.LinkedList;

public class AncestorMatrix {
    public static int[][] a = new int[9][9];

    public static void setArray(LinkedList<Integer> arr, Node node) {

        if (node == null)
            return;

        arr.addLast(node.value);

        setArray(arr, node.left);
        setArray(arr, node.right);

        arr.removeLast();

        for (int i : arr)
            a[i][node.value] = 1;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
