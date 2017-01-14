/**
 * @(#) AddDigit.java Mar 8, 2010 10:43:40 AM
 * Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 * All right reserved
 */
package number;

;

/**
 * Class <code>AddDigit</code>
 *
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Mar 8, 2010 10:43:40 AM
 *
 */
public class AddDigit {

    public static int add_digit(int k) {
        while (k > 9) {
            k = k / 10 + k % 10;
        }

        return k;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(AddDigit.add_digit(1234579));
    }

}
