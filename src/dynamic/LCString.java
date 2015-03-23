/**
 * @(#) LCString.java Jan 13, 2010 5:36:51 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package dynamic;

/**
 * Class <code>LCString</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Jan 13, 2010 5:36:51 PM
 * 
 */
public class LCString {

    public String LCStr1(String str1, String str2) {
	int length1 = str1.length();
	int length2 = str2.length();
	String rec = "";
	int max = 0;

	int[][] c = new int[length1][length2];

	for (int i = 0; i < length1; ++i) {
	    for (int j = 0; j < length2; j++) {
		if (str1.charAt(i) == str2.charAt(j)) {
		    if (i == 0 || j == 0)
			c[i][j] = 1;
		    else
			c[i][j] = c[i - 1][j - 1] + 1;
		    if (c[i][j] > max) {
			max = c[i][j];
			rec = "";
		    }
		    if (max == c[i][j]) {
			rec = str1.substring(i - max + 1, i + 1);
		    }
		}
	    }
	}
	return rec;
    }

    public String LCStr(String str1, String str2) {
	int length1 = str1.length();
	int length2 = str2.length();
	int length3, k = 0;
	int max = 0;
	int index = 0;
	int i = 0;
	while (i < length1) {
	    int j = 0;
	    while (j < length2) {
		if (str1.charAt(i) == str2.charAt(j)) {
		    length3 = 1;
		    for (k = 1; k < length1 - i && k < length2 - j
			    && str1.charAt(i + k) == str2.charAt(j + k); k++)
			length3++;
		    if (length3 > max) {
			index = i;
			max = length3;
		    }
		    j += length3;
		} else
		    j++;
	    }
	    i++;
	}

	return str1.substring(index, index + max);

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	LCString lcs = new LCString();
	// System.out.println("aabcdababce".substring(1,5));

	System.out.println(lcs.LCStr1("aabcdafbabce", "12abcabcdafce"));
    }

}
