/**
 * @(#) DeleteDup.java Jan 21, 2010 7:16:08 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package stringoperation;

/**
 * Class <code>DeleteDup</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Jan 21, 2010 7:16:08 PM
 * 
 */
public class DeleteDup {
    // running time n^2
    public char[] removeDuplicates(char[] str) {
	// tail always point to the duplicate char
	// if (!str)
	// return;

	int len = str.length;
	if (len < 2)
	    return str;
	// tail maintain the last index of the non-dup char array
	int tail = 1;
	for (int i = 1; i < len; ++i) {
	    int j;
	    for (j = 0; j < tail; ++j)
		if (str[i] == str[j])
		    break;
	    if (j == tail) {
		str[tail] = str[i];
		++tail;
	    }
	}
	str[tail] = '\0';
	return str;
    }

    public char[] removeDuplicates1(char[] str) {
	if (str == null)
	    return str;
	int len = str.length;

	if (len < 2)
	    return str;
	int tail = 1;
	for (int i = 0; i < len; ++i) {
	    int j;
	    for (j = 0; j < tail; ++j) {
		if (str[i] == str[j]) {
		    int k;
		    for (k = j; k < len - 1; k++)
			str[k] = str[k + 1];
		    str[k] = '\0';
		}
	    }

	}
	return str;
    }

    public char[] removeDuplicates2(char[] str) {
	int i, j;
	int Length = str.length;
	/* new length of modified array */
	int NewLength = 1;

	for (i = 1; i < Length; i++) {

	    for (j = 0; j < NewLength; j++) {

		if (str[i] == str[j])
		    break;
	    }

	    /*
	     * if none of the values in index[0..j] of array is not same as
	     * array[i], then copy the current value to corresponding new
	     * position in array
	     */

	    if (j == NewLength)
		str[NewLength++] = str[i];
	}
	str[NewLength] = 0;
	return str;
    }

    // sort and then using this nlogn, but this violate the natrual order of the
    // array
    public char[] removeDupfromOrder(char[] str) {
	int i = 1, j = 0;
	int Length = str.length;

	while (i <= Length - 1) {
	    if (str[i] == str[i - 1])
		j++;
	    else
		str[i - j] = str[i];
	    i++;

	}
	str[i - j] = '\0';
	return str;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

	String string = "";

	char[] str = { 'a', 'b', 'd', 'c', 'e', 'c', 'b', 'd' };
	DeleteDup rd = new DeleteDup();
	// System.out.println(rd.removeDupfromOrder(str));
	System.out.println(rd.removeDuplicates(str));

    }

}
