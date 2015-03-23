/**
 * @(#) ReverseNum.java Mar 7, 2010 10:52:26 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package number;

/**
 * Class <code>ReverseNum</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Mar 7, 2010 10:52:26 PM
 * 
 */
public class ReverseNum {

    //
    public static void Rev(int n) {
	int reversedNumber = 0;
	boolean negative = false;
	if (n < 0) {
	    negative = true;
	    n *= -1;
	}
	while (n > 0) {
	    reversedNumber = 10 * reversedNumber + n % 10;
	    n /= 10;

	}
	if (negative)
	    reversedNumber *= -1;
	System.out.println(reversedNumber);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	ReverseNum.Rev(-6543);
    }

}
