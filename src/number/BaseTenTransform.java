package number;

public class BaseTenTransform {
    public static int trans(String str, int base) {
        int n = str.length();
        if (n == 0)
            return 0;
        boolean negative = false;
        if (str.charAt(0) == '-')
            negative = true;
        int ret = 0;
        int pow = 1;
        for (int i = n - 1; i >= 0; i--) {
            char c = str.charAt(i);
            int digit = 0;
            if (c >= 'a')
                digit = 10 + c - 'a';
            else
                digit = c - '0';
            ret += digit * pow;
            pow = pow * base;
        }
        if (negative)
            return -1 * ret;

        return ret;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(trans("a1b", 16));
    }

}
