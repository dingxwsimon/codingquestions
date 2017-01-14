package tree;

public class BackOrderArray {
    // check if an array could be a back order travesal of a BST
    public static boolean isBack(int[] array, int start, int end) {
        int root = array[end];
        int i = end - 1;

        while (array[i] > root && i >= start) {
            i--;
        }
        // now i is the greatest element in the right subtree
        // all the element between start and i is the left subtree
        for (int j = start; j <= i; j++) {
            if (array[i] > root)
                return false;
        }

        boolean left = true;
        if (i > start)
            left = isBack(array, start, i);

        boolean right = true;
        if (i < end - 1)
            right = isBack(array, i + 1, end);

        return (left && right);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
