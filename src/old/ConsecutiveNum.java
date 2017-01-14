/**
 * @(#) ConsecutiveNum.java Mar 7, 2010 8:56:23 AM
 * Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 * All right reserved
 */
package old;

;

/**
 * Class <code>ConsecutiveNum</code>
 *
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Mar 7, 2010 8:56:23 AM
 *
 */
public class ConsecutiveNum {

    private static void print_all_series(int n) {
        int max = (int) Math.sqrt((double) 2 * n);

        if (n % 2 == 1) {
            System.out.println((int) (n / 2) + " " + (int) ((n / 2) + 1));
            return;
        }

        for (int i = 3; i < max; i = i + 2) {
            if (n % i == 0) {
                int x = n / i;
                if (x - (int) (i / 2) > 1) {
                    System.out.println((int) (x - ((i - 1) / 2)) + " "
                            + (int) (x + ((i - 1) / 2)));
                    // return;
                }
            }
        }

        for (int i = 4; i < max; i = i + 2) {
            int kx = n - ((i * (i - 1)) / 2);
            if (kx % i == 0) {
                int x = kx / i;
                System.out.println(x + " " + (int) (x + i - 1));
                // return;
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ConsecutiveNum.print_all_series(68);
    }

}
