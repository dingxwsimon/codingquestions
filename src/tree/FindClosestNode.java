package tree;

public class FindClosestNode {
    // Find the 'closest' value in a BST with a given value M
    public static int getClosetTreeNode(Node t, int v) {
        if (t == null) {
            throw new IllegalArgumentException("Null input");
        }

        int closetTreeNodeValue = 0;
        int minDist = Integer.MAX_VALUE;
        while (true) {
            if (t == null)
                break;
            if (t.value == v) { // no need to traverse down further
                return v;
            } else if (t.value < v) {

                if ((v - t.value) < minDist) {
                    minDist = v - t.value;
                    closetTreeNodeValue = t.value;
                }
                t = t.right;
            } else { // t.value > v

                if ((t.value - v) < minDist) {
                    minDist = t.value - v;
                    closetTreeNodeValue = t.value;
                }
                t = t.left;
            }
        }

        return closetTreeNodeValue;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
