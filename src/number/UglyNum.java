package number;

import java.util.LinkedList;

public class UglyNum {

    public static int getKthMagicNumber(int k) {
	if (k <= 0)
	    return 0;
	int val = 1;
	LinkedList<Integer> Q2 = new LinkedList<Integer>();
	LinkedList<Integer> Q3 = new LinkedList<Integer>();
	LinkedList<Integer> Q5 = new LinkedList<Integer>();
	Q2.addLast(2);
	Q3.addLast(3);
	Q5.addLast(5);
	for (--k; k > 0; --k) { // we¡¯ve done one iter already
	    val = Math.min(Q2.getFirst(),
		    Math.min(Q3.getFirst(), Q5.getFirst()));
	    if (val == Q5.getFirst()) {
		Q5.pollFirst();
	    } else {
		if (val == Q3.getFirst()) {
		    Q3.pollFirst();
		} else { // must be from Q3
		    Q2.pollFirst();
		    Q2.addLast(val * 2);
		}
		Q3.addLast(val * 3);
	    }
	    Q5.addLast(val * 5);
	}
	return val;
    }

    // this is beatiful
    public static int uglyNum(int k) {
	int a, b, c, n = 0;
	long[] ugly = new long[1502];
	long x, y, z = 0;
	ugly[1] = a = b = c = n = 1;
	while (n < k) {
	    x = 2 * ugly[a];
	    y = 3 * ugly[b];
	    z = 5 * ugly[c];
	    ugly[++n] = Math.min(x, Math.min(y, z));
	    if (ugly[n] == x)
		a++;
	    if (ugly[n] == y)
		b++;
	    if (ugly[n] == z)
		c++;
	}
	System.out.println("The 1500'th ugly number is " + ugly[1500]);
	return 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(getKthMagicNumber(1500));
    }

}
