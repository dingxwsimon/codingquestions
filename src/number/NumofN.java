/**
 * @(#) NumofN.java Dec 1, 2009 9:43:20 PM
 * Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 * All right reserved
 */
package number;

/**
 * Class <code>NumofN</code>
 *
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Dec 1, 2009 9:43:20 PM
 *
 */
public class NumofN {

    public static int countNs(int num, int n) {
        int iCount = 0;
        int iFactor = 1;

        while (num / iFactor != 0) {
            int iLower = num - (num / iFactor) * iFactor;
            int iCur = (num / iFactor) % 10;
            int iHigher = num / (iFactor * 10);

            if (iCur < n) {
                iCount += iHigher * iFactor;
            } else if (iCur == n) {
                iCount += iHigher * iFactor + iLower + 1;
            } else if (iCur > n) {
                iCount += (iHigher + 1) * iFactor;
            }

            iFactor *= 10;

        }

        System.out.println(iCount);

        return iCount;
    }

    // from 1 - num, how many digit n appears
    public static void main(String[] args) {
        int num = 2145;
        int n = 2;

        System.out.println(countNs(num, n));
    }
}
