package LeetCode;

public class UniqueBSTrees {
    // pass both
    /*
     * numTrees(i+1)=append the last node to the rightmost leaf of
     * bst(i)[numTrees(i)] + append the last node as the root of
     * bst(i)[numTrees(i)] + insert the last node as non-leaf node
     * sum(k=1...i)(bst(k-1)*bst(i-k)
     */
    // DP
    // this is Catalan number, which is (2n)!/ ((n+1)! (n)!)
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0 || n == 1 || n == 2)
            return n;
        int bst[] = new int[n + 1];
        bst[0] = 1;
        bst[1] = 1;
        bst[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                bst[i] += bst[j] * bst[i - 1 - j];
            }
            bst[i] += 2 * bst[i - 1];
        }
        return bst[n];
    }

    public static int numTrees1(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        int num = 0;
        for (int i = 0; i < n; i++) {
            int left = numTrees1(i);
            int right = numTrees1(n - i - 1);
            num += left * right;
        }
        return num;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UniqueBSTrees u = new UniqueBSTrees();
        System.out.println(u.numTrees(19));
        System.out.println(u.numTrees1(19));
    }

}
