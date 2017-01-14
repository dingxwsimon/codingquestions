/**
 * @(#) ShiftArray.java Mar 23, 2010 2:46:33 PM
 * Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 * All right reserved
 */
package array;

/**
 * Class <code>ShiftArray</code>
 *
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Mar 23, 2010 2:46:33 PM
 *
 */
public class ShiftArray {

    public static void reverse(int[] data, int left, int right) {

        for (; left < right; left++, right--) {

            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
    }

    public static int[] shift(int[] data, int k) {
        if (data.length < 2)
            return data;
        int n = data.length;
        k = k % n;

        reverse(data, 0, n - 1);
        reverse(data, 0, n - k - 1);
        reverse(data, n - k, n - 1);
        return data;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] data = {1, 2, 3, 4, 5};
        ShiftArray.shift(data, 2);
        System.out.println(data);

    }

}
