/**
 * @(#) Compare.java May 25, 2010 8:36:55 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package number;

;

/**
 * Class <code>Compare</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since May 25, 2010 8:36:55 PM
 * 
 */
public class Compare {

    public static int GetMax(int a, int b) {
	int c = a - b;
	int k = (c >> 31) & 0x1;
	int max = a - k * c;
	return max;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(Compare.GetMax(5, -10));
    }

}
