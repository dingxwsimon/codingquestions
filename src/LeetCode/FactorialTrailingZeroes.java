package LeetCode;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if (n < 5)
            return 0;
        int ret = 0;
        while (n > 0) {
            ret += n / 5;
            n = n / 5;
        }
        return ret;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
