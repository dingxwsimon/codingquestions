package LeetCode;

public class ZigZagConv {
    // nice one
    public String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < nRows; i++) {
            for (int j = 0, k = i; k < s.length(); j++) {
                sb.append(s.charAt(k));
                if (i == 0 || i == (nRows - 1)) {
                    k += 2 * (nRows - 1); // 2row -2
                } else {
                    if (j % 2 == 0) {
                        k += 2 * (nRows - i - 1);// 2row -2 - 2i
                    } else {
                        k += 2 * i;
                    }
                }
            }
        }

        return sb.toString();
    }

    // Straight forward lot of extra space
    public String convert1(String s, int nRows) {
        char[] cstr = s.toCharArray();

        if (nRows <= 1)
            return s;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < nRows; i++) {
            sb[i] = new StringBuffer();
        }

        int len = 2 * nRows - 2;
        for (int i = 0; i < cstr.length; i++) {
            int k = i % len;
            if (k < nRows) {
                sb[k].append(cstr[i]);
            } else {
                sb[2 * nRows - k - 2].append(cstr[i]);
            }
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < nRows; i++) {
            result.append(sb[i].toString());
        }
        return result.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
