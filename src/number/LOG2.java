package number;

public class LOG2 {
    public static double log2(double val) {
        int lox, hix;
        double rval, lval;
        hix = 0;
        while ((1 << hix) < val)
            hix++;
        lox = hix - 1;
        lval = (1 << lox);
        rval = (1 << hix);
        double lo = lox, hi = hix;
        while (Math.abs(lval - val) > 1e-7) {
            double mid = (lo + hi) / 2;
            double midValue = Math.sqrt(lval * rval);

            if (midValue > val) {
                hi = mid;
                rval = midValue;
            } else {
                lo = mid;
                lval = midValue;
            }
        }
        return lo;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(log2(64.0));
    }

}
