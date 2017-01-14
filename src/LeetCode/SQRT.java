package LeetCode;

public class SQRT {

    // this is clear, remember it
    public static int sqrt2(int x) {
        if (x <= 1)
            return x;

        int left = 0, right = x, mid;

        while ((right - left) > 1) {
            mid = left + (right - left) / 2;

            if (mid == x / mid)
                return mid;
            else if (x / mid < mid)
                right = mid;
            else
                left = mid;
        }

        return left;
    }

    public static int sqrt3(int x) {
        if (x <= 1)
            return x;

        int left = 0, right = x;
        int ret = 0;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (m > x / m) {
                right = m - 1;
            } else {
                left = m + 1;
                ret = m;
            }
        }
        return ret;
    }

    // binary search
    // pass both
    public int sqrt(int x) {
        if (x == 0)
            return 0;
        if (x <= 2)
            return 1;
        int s = 2;
        int prev = 1;
        while (!(s <= x / s && (s + 1) > x / (s + 1))) {
            if (s > x / s) {
                s = prev + (s - prev) / 2;
            } else {
                prev = s;
                s = s * s;
            }
        }

        return s;
    }

    public int sqrt1(int x) {
        double ans = x;

        while (Math.abs(ans * ans - x) > 0.0001) {
            ans = (ans + x / ans) / 2;
        }

        return (int) ans;
    }

    public static void main(String args[]) {
        System.out.println(sqrt3(10));

        float n = 25.0f;
        if (n < 0) {
            System.out.println("negative don't have square roots");
            System.exit(0);
        }
        float y = sqrt(n);
        System.out.println("sqrt is " + y);
    }

    static float sqrt(float n) {
        float low = 0, high = n;
        float mid = (low + high) / 2;
        while (Math.abs(mid * mid - n) > 0.00001) {

            if (mid * mid < n)
                low = mid;
            else if (mid * mid > n)
                high = mid;
            mid = (low + high) / 2;
        }
        return mid;
    }

}
