/**
 * @(#) TestSubmallsetString.java Apr 3, 2010 11:49:33 AM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package old;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * You r given a large string of characters lets call it Sbig. Then there is a
 * small set of characters lets call it Ssmall. You have to find smallest
 * substring of Sbig which contains all characters in Ssmall.
 * 
 */
public class TestSubmallsetString {
    static LinkedHashMap map = new LinkedHashMap();

    static int[][] vvv;

    public static int calc()

    {
	int total = 0;
	int min = 99999;
	int index = -1;
	for (int i = 0; i < vvv.length; i++)

	{
	    for (int j = 0; j < vvv[i].length; j++)

	    {
		for (int k = j + 1; k < vvv[i].length; k++)

		{
		    total += Math.abs(vvv[i][j] - vvv[i][k]);

		}

	    }
	    if (total < min)

	    {
		index = i;
		min = total;

	    }
	    total = 0;

	}
	return index;

    }

    public static void fillCrossProductArray(String s, String sStr)

    {
	int colIndex = 0;
	int rowPointer = 0;
	int tLength = vvv.length;
	int counter = 0;
	int tmp = 0;
	for (int xx = 0; xx < sStr.length(); ++xx) // start with "a" level

	{
	    Object[] l = ((HashSet) map.get(sStr.charAt(xx))).toArray();
	    for (int i1 = 0; i1 < l.length; i1++) // loop array

	    {
		tmp = tLength / l.length;
		for (int kk = rowPointer; kk < vvv.length; kk += tLength) // loop
		// rows

		{
		    while (counter < tmp)

		    {
			vvv[kk + counter][colIndex] = (Integer) l[i1];
			counter++;

		    }
		    counter = 0;

		}
		rowPointer += tLength / l.length;

	    }
	    tLength = tLength / l.length;
	    rowPointer = 0;
	    colIndex++;

	}

    }

    public static void init(String s, String sStr)

    {
	for (int i = 0; i < sStr.length(); i++)

	{
	    map.put(sStr.charAt(i), new LinkedHashSet());

	}
	for (int i = 0; i < sStr.length(); i++)

	{
	    for (int j = 0; j < s.length(); j++)

	    {
		if (s.charAt(j) == sStr.charAt(i))

		{
		    ((LinkedHashSet) map.get(sStr.charAt(i))).add(j);

		}

	    }

	}
	Iterator it = map.keySet().iterator();
	int numOfRow = 1;
	HashSet hs = null;
	for (int i = 0; i < map.size(); i++)

	{
	    hs = ((LinkedHashSet) map.get(it.next()));
	    System.out.println(hs);
	    numOfRow *= hs.size();

	}
	vvv = new int[numOfRow][sStr.length()];

    }

    public static void test(String s, String sStr)

    {
	String origS = s;

	init(s, sStr);
	fillCrossProductArray(s, sStr);
	int idx = calc();

	System.out.println(s);
	System.out.println(sStr);
	for (int i = 0; i < vvv.length; i++)

	{
	    for (int j = 0; j < vvv[i].length; j++)

	    {
		System.out.print(vvv[i][j] + ",");

	    }
	    System.out.println();

	}
	System.out.println("Shortest path");
	int begin = vvv[idx][0];
	int end = vvv[idx][0];
	int j = 0;
	for (; j < vvv[idx].length; j++) {
	    if (vvv[idx][j] > end)
		end = vvv[idx][j];
	    if (vvv[idx][j] < begin)
		begin = vvv[idx][j];
	    System.out.print(vvv[idx][j] + ",");

	}

	System.out.println(origS.substring(begin, end + 1));

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	TestSubmallsetString.test("hello what are you doing", "eto");
    }

}
