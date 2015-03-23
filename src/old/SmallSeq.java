/**
 * @(#) SmallSeq.java Mar 3, 2010 3:02:32 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package old;

import java.util.ArrayList;

/**
 * Class <code>SmallSeq</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Mar 3, 2010 3:02:32 PM
 * 
 */
public class SmallSeq {
    public static void getSeq() {
	String big = "hello what are you doing";
	String small = "eo";

	int[] sfa;
	ArrayList<int[]> allPoss = new ArrayList<int[]>();

	char c;
	int j = 0;

	while (j < big.length()) {
	    sfa = new int[small.length()];

	    for (int i = 0; i < small.length(); i++) {
		c = small.charAt(i);

		while (j < big.length()) {
		    if (big.charAt(j) == c) {
			sfa[i] = j;
			i++;
			j++;
			break;
		    } else {
			j++;
		    }
		}
	    }
	    j = sfa[0] + 1;

	    allPoss.add(sfa);
	}

	if (allPoss.size() == 0)
	    System.out.println("not found");

	int shortest = 0;
	int[] currShortest = allPoss.get(shortest);
	int d1 = currShortest[currShortest.length - 1] - currShortest[0];

	for (int k = 1; k < allPoss.size(); k++) {
	    int[] atNow = allPoss.get(k);
	    int d2 = atNow[atNow.length - 1] - atNow[0];
	    if (d2 < d1) {
		shortest = k;
		currShortest = atNow;
		d1 = currShortest[currShortest.length - 1] - currShortest[0];
	    }
	}

	System.out.println("Shortest is start from " + currShortest[0] + " to "
		+ currShortest[currShortest.length - 1]);
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	SmallSeq.getSeq();
    }

}
