package array;

public class BalancePoint {
    // geeksforgeeks,
    // only return one, could return all of them
    public static int bp2(int[] a) {
        int sum = 0;
        int leftsum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];

        for (int i = 0; i < a.length; i++) {
            sum -= a[i];
            if (leftsum == sum)
                return i;
            leftsum += a[i];
        }
        return -1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // System.out.println(bp(new int[]{1,2,9,4,-1}));
        System.out.println(bp2(new int[]{1, -1, -1, 2}));
    }

}
