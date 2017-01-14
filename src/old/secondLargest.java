/**
 * @(#) secondLargest.java Jan 11, 2010 1:42:29 PM
 * Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 * All right reserved
 */
package old;

/**
 * Class <code>secondLargest</code>
 *
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Jan 11, 2010 1:42:29 PM
 *
 */
public class secondLargest {

    public int count = 0;

    public int[] getSec(int[] data, int start, int end) {
        if (end - start <= 1) {
            if (data[start] < data[end]) {
                count++;
                return new int[]{data[end], data[start]};
            } else {
                count++;
                return new int[]{data[start], data[end]};
            }
        }

        int[] left = getSec(data, start, start + (end - start) / 2);
        int[] right = getSec(data, start + (end - start) / 2 + 1, end);
        int[] current = new int[2];
        if (left[0] > right[0]) {
            count++;
            current[0] = left[0];
            if (right[0] > left[1]) {
                count++;
                current[1] = right[0];
            } else {
                count++;
                current[1] = left[1];
            }

        } else {
            count++;
            current[0] = right[0];
            if (right[1] > left[0]) {
                count++;
                current[1] = right[1];
            } else {
                count++;
                current[1] = left[0];
            }
        }
        return current;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int data[] = new int[]{2, 5, 8, 37, 3, 9, 1, 6, 12, 15, 18, 17, 13,
                19, 11, 16, 22, 25, 28, 27, 23, 29, 21, 26, 32, 35, 38, 34, 33,
                39, 31, 36};
        secondLargest sl = new secondLargest();
        int newdata[] = sl.getSec(data, 0, data.length - 1);
        System.out.println(data.length + " " + newdata[0] + " " + newdata[1]
                + " " + sl.count);
    }

}
