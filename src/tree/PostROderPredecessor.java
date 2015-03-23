package tree;

public class PostROderPredecessor {
    /*
     * To find the postorder predecessor of node u: If u has a right child, r,
     * then pred(u) is r. Otherwise If u has a left child, l, then pred(u) is l.
     * Otherwise if u has a left sibling, ls, then pred(u) is ls Otherwise if u
     * has an ancestor, v, which is a right child and has a left sibling, vls,
     * then pred(u) is vls Otherwise, pred(u) is unde fined.
     * 
     * 
     * 
     * The simplest way is to save the predecessor in a variable, and then
     * update it while traversing the BT with post-order. 1) set predecessor =
     * null 2) traverse BT with post-order 3) if current_node == input_node {
     * return predecessor; } else { predecessor = current_node } 4) goto step 3)
     */

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
