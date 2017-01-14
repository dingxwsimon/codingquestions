package stringoperation;

import java.util.Arrays;

public class RemovePatterns {
    /*
     * Eliminate all ��b�� and ��ac�� in an array of characters, you have to replace
     * them in-place, and you are only allowed to iterate over the char array
     * once.
     */

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "ac";
        char[] carray = str.toCharArray();
        int n = str.length();
        int l = 0;
        int r = 0;
        while (r < n) {
            if (carray[r] == 'b') {
                r++;
            } else if (carray[r] == 'a' && r < n - 1 && carray[r + 1] == 'c') {
                r += 2;
            } else {
                carray[l++] = carray[r++];
            }
        }
        System.out.println(new String(Arrays.copyOfRange(carray, 0, l)));
    }

}
