package number;

public class FindClosestPerfectSquare {
    public static int find(int num) {
        int num_sqrt = (int) Math.sqrt(num);
        int num_prev = num_sqrt;
        int num_next = num_sqrt + 1;
        int sqr_prev = num_prev ^ 2;
        int sqr_next = num_next ^ 2;
        if (num - sqr_prev < sqr_next - num)
            return sqr_prev;
        else
            return sqr_next;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
