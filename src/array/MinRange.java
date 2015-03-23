package array;

public class MinRange {
    /*
     * You have k lists of sorted integers. Find the smallest range that
     * includes at least one number from each of the k lists.
     * 
     * For example, List 1: [4, 10, 15, 24, 26] List 2: [0, 9, 12, 20] List 3:
     * [5, 18, 22, 30]
     * 
     * The smallest range here would be [20, 24] as it contains 24 from list 1,
     * 20 from list 2, and 22 from list 3.
     */

    public static class IdxValuPair {
	int listIdx; /* belong to which array */
	int value; /* the data value */

	IdxValuPair(int _n, int _d) {
	    listIdx = _n;
	    value = _d;
	}

	IdxValuPair(IdxValuPair _pn) {
	    listIdx = _pn.listIdx;
	    value = _pn.value;
	}
    };

    public static void swap(IdxValuPair a, IdxValuPair b) {
	IdxValuPair c = a;
	a = b;
	b = c;
    }

    public static void adjust(int n, IdxValuPair a[]) {
	int i = 0, max = 0;
	int l = 0, r = 0;
	for (i = n / 2; i >= 0; i--) {
	    max = i;
	    l = 2 * i + 1;
	    r = 2 * i + 2;
	    if (l < n && a[l].value > a[max].value) {
		max = l;
	    }
	    if (r < n && a[r].value > a[max].value) {
		max = r;
	    }
	    if (max != i) {
		swap(a[max], a[i]);
	    }
	}
    }

    public static void heapsort(int n, IdxValuPair a[]) {
	int i = 0;
	adjust(n, a);
	for (i = n - 1; i > 0; i--) {
	    swap(a[0], a[i]);
	    adjust(i, a);
	}
    }

    public static void main(String[] args) {
	int m = 3;
	int n = 5;
	int ms = 0, me = 0;
	int ts = 0, te = 0;
	int a[][] = { { 4, 10, 15, 24, 26 }, { 0, 9, 12, 20, 35 },
		{ 5, 18, 22, 30, 50 } };
	int cur[] = { 1, 1, 1 }; /*
				  * record the current positions of each array
				  * which haven't been used
				  */
	IdxValuPair heap[] = { new IdxValuPair(0, a[0][0]),
		new IdxValuPair(1, a[1][0]), new IdxValuPair(2, a[2][0]) };

	heapsort(m, heap);
	ms = heap[0].value;
	me = heap[m - 1].value;
	while (true) {
	    heapsort(m, heap);
	    ts = heap[0].value;
	    te = heap[m - 1].value;
	    /* if the current range is smaller than the minimum range */
	    if (te - ts < me - ms) {
		ms = ts;
		me = te;
	    }

	    /*
	     * if the sub-array which the smallest element comes from hasn't to
	     * the end
	     */
	    if (cur[heap[0].listIdx] != n) {
		heap[0].value = a[heap[0].listIdx][cur[heap[0].listIdx]];
		cur[heap[0].listIdx] += 1;
	    } else {
		break;
	    }
	}
	System.out.println(ms);
	System.out.println(me);
    }

}
