/**
 * @(#) TelWord.java Mar 4, 2010 9:33:12 AM
 * Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 * All right reserved
 */
package stringoperation;

/**
 * Class <code>TelWord</code>
 *
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Mar 4, 2010 9:33:12 AM
 *
 */
public class TelWord {

    public static char c[][] = {{' '}, {' '}, {'a', 'b', 'c'},
            {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}};

    public static void telWord(int[] telNum) {

        int n = telNum.length;
        int answer[] = new int[n];
        while (true) {
            for (int i = 0; i < n; i++)
                System.out.print(c[telNum[i]][answer[i]]);
            System.out.print("\n");

            int k = n - 1;
            while (k >= 0) {
                if (answer[k] < c[telNum[k]].length - 1) {
                    answer[k]++;
                    break;
                } else {
                    answer[k] = 0;
                    k--;
                }
            }
            if (k < 0)
                break;

        }
    }

    static final int PHONE_NUMBER_LENGTH = 7;

    void printTelephoneWords(int phoneNum[]) {
        char[] result = new char[PHONE_NUMBER_LENGTH];
        int i;

	/*
     * Initialize the result (in our example, put GWP1WAR in result).
	 */
        for (i = 0; i < PHONE_NUMBER_LENGTH; i++)
            result[i] = c[phoneNum[i]][1];

	/* Main loop begins */
        while (true) {
            for (i = 0; i < PHONE_NUMBER_LENGTH; ++i) {
                System.out.print(result[i]);
            }
            System.out.print('\n');

	    /*
	     * Start at the end and try to increment from right to left.
	     */
            for (i = PHONE_NUMBER_LENGTH - 1; i >= -1; i--) {
		/*
		 * You're done because you tried to carry the leftmost digit.
		 */
                if (i == -1)
                    return;

		/* Otherwise, we're not done and must continue. */

		/*
		 * You want to start with this condition so that you can deal
		 * with the special cases, 0 and 1 right away.
		 */
                if (c[phoneNum[i]][3] == result[i] || phoneNum[i] == 0
                        || phoneNum[i] == 1) {
                    result[i] = c[phoneNum[i]][1];
		    /* No break, so loop continues to next digit */
                } else if (c[phoneNum[i]][1] == result[i]) {
                    result[i] = c[phoneNum[i]][2];
                    break;
                } else if (c[phoneNum[i]][2] == result[i]) {
                    result[i] = c[phoneNum[i]][3];
                    break;
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int telNum[] = {2};
        TelWord.telWord(telNum);
    }

}
