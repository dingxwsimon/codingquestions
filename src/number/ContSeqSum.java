package number;

public class ContSeqSum {

    // Find continuous sequence, whose sum is n
    public static void FindContinuousSequence(int n) {
        if (n < 3)
            return;

        int small = 1;
        int big = 2;
        int middle = (1 + n) / 2;
        int sum = small + big;

        while (small < middle) {
            // we are lucky and find the sequence
            if (sum == n)
                PrintContinuousSequence(small, big);

            // if the current sum is greater than n,
            // move small forward
            while (sum > n) {
                sum -= small;
                small++;

                // we are lucky and find the sequence
                if (sum == n)
                    PrintContinuousSequence(small, big);
            }

            // move big forward
            big++;
            sum += big;
        }
    }

    public static void PrintContinuousSequence(int small, int big) {
        for (int i = small; i <= big; ++i)
            System.out.print(i + " ");

        System.out.print("\n");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FindContinuousSequence(10);
    }

}
