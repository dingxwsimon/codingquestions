package tree;

public class ConstructBSTfromSortedArray {

    public BinaryNode createBST(int a[], int start, int end) {
        if (end < start)
            return null;
        int mid = (start + end) / 2;
        BinaryNode n = new BinaryNode(a[mid]);

        n.left = createBST(a, start, mid - 1);
        n.right = createBST(a, mid + 1, end);
        return n;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
