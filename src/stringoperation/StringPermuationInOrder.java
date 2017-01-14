package stringoperation;

import java.util.Arrays;

public class StringPermuationInOrder {
    public static String reverse(char[] chars, int l, int h) {
        while (l < h) {
            swap(chars, l, h);
            l++;
            h--;
        }
        return String.copyValueOf(chars);
    }

    public static void swap(char[] chars, int l, int h) {
        char temp = chars[l];
        chars[l] = chars[h];
        chars[h] = temp;
    }

    public static int findCeil(char[] str, char first, int l, int h) {
        int ceilIndex = l;

        // Now iterate through rest of the elements and find
        // the smallest character greater than 'first'
        for (int i = l + 1; i <= h; i++)
            if (str[i] > first && str[i] < str[ceilIndex])
                ceilIndex = i;

        return ceilIndex;
    }

    // the same as next permutation in package array
    public static void sotedPerm(String str) {
        int size = str.length();

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean finished = false;
        while (!finished) {
            System.out.println(chars.toString());

            int i = 0;
            for (i = size - 2; i >= 0; i--) {
                if (chars[i] < chars[i + 1])
                    break;
            }

            if (i == -1) {
                finished = true;
            } else {
                int ceilIndex = findCeil(chars, chars[i], i + 1, size - 1);
                swap(chars, i, ceilIndex);
                Arrays.sort(chars, i + 1, size - 1);
            }

        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
