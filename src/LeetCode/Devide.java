package LeetCode;

public class Devide {

    public static int divide1(int dividend, int divisor) {
        if (divisor == 1) // Trival case 1
            return dividend;

        // Use negative integers to avoid integer overflow
        if (dividend > 0)
            return -divide(-dividend, divisor);
        if (divisor > 0)
            return -divide(dividend, -divisor);

        if (dividend > divisor) // Trivial case 2
            return 0;

        if ((dividend == Integer.MIN_VALUE) && (divisor == -1)) // Overflow case
            return Integer.MAX_VALUE;

        // Find the highest mult = (divisor * 2^shifts) which is <= dividend
        // by shifting mult to the left without causing an overflow.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations.
        int min_divisor = Integer.MIN_VALUE >> 1;
        int mult = divisor; // = divisor * 2^shifts
        int shifts = 0;
        while ((mult >= min_divisor) && (mult > dividend)) {
            mult <<= 1;
            ++shifts;
        }

        // Compute the result by shifting mult to the right.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the
        // outer loop.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the
        // inner loop
        // (in total, not per outer iteration).
        int result = 0;
        int power = 1 << shifts; // = 2^shifts
        while (dividend <= divisor) {
            shifts = 0;
            while (mult < dividend) {
                mult >>= 1;
                ++shifts;
            }
            dividend -= mult;
            power >>= shifts;
            result |= power; // Adds power to result
        }

        return result;
    }

    // slow
    // pass both
    public static int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 1)
            return dividend;
        if (dividend == divisor)
            return 1;
        int code;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
            code = 0;// negative
        else
            code = 1;
        if (dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE)
            return 0;
        else if (dividend == Integer.MIN_VALUE && divisor == Integer.MAX_VALUE)
            return code == 0 ? -1 : 1;

        long div = dividend, div2 = divisor;
        div = Math.abs(div);
        div2 = Math.abs(div2);
        // System.out.println(div + " " + div2 + " " + code);
        double ret = Math.pow(10, Math.log10((div)) - Math.log10(((div2))));
        int result = (int) Math.floor(ret + 0.0000001);
        return code == 0 ? -result : result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(divide1(123456, 7));
    }

}
