package LeetCode;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays2(int A[], int B[]) {
	int n = A.length;
	int m = B.length;
	// the following call is to make sure len(A) <= len(B).
	// yes, it calls itself, but at most once, shouldn't be
	// consider a recursive solution
	if (n > m)
	    return findMedianSortedArrays(B, A);

	// now, do binary search
	int k = (n + m - 1) / 2;
	int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
	while (l < r) {
	    int midA = (l + r) / 2;
	    int midB = k - midA;
	    if (A[midA] < B[midB])
		l = midA + 1;
	    else
		r = midA;
	}

	// after binary search, we almost get the median because it must be
	// between
	// these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1]

	// if (n+m) is odd, the median is the larger one between A[l-1] and
	// B[k-l].
	// and there are some corner cases we need to take care of.
	int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k
		- l] : Integer.MIN_VALUE);
	if (((n + m) & 1) == 1)
	    return (double) a;

	// if (n+m) is even, the median can be calculated by
	// median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
	// also, there are some corner cases to take care of.
	int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k
		- l + 1] : Integer.MAX_VALUE);
	return (a + b) / 2.0;
    }

    /*
     * 1 index in A: aStart = -1 aEnd = k - 2 2 index in B bStart = -1 bEnd = 0
     * 3 if A[aEnd] < B[bEnd] A shrink by half, and B increase the coressponding
     * number
     */
    // pass both
    // easy to understand
    public double findMedianSortedArrays1(int A[], int B[]) {
	int m = A.length;
	int n = B.length;
	int total = m + n;
	if (total % 2 != 0)
	    return findKth(A, B, total / 2 + 1);
	else
	    return (findKth(A, B, total / 2) + findKth(A, B, total / 2 + 1)) / 2;

    }

    public double findKth(int[] A, int[] B, int k) {
	int m = A.length;
	int n = B.length;
	if (m > n)
	    return findKth(B, A, k);
	if (m == 0)
	    return B[k - 1];
	if (k == 1)
	    return Math.min(A[0], B[0]);
	int pa = Math.min(k / 2, m);
	int pb = k - pa;

	if (A[pa - 1] < B[pb - 1])
	    return findKth(Arrays.copyOfRange(A, pa, m), B, k - pa);
	else
	    return findKth(A, Arrays.copyOfRange(B, pb, n), k - pb);
    }

    // pass both
    // same as the mit idea
    public double findMedianSortedArrays(int A[], int B[]) {
	// Start typing your Java solution below
	// DO NOT write main() function

	int m = A.length, n = B.length;
	int left = 0, right = 0;

	// if m+n is even, then the median is the average of (m+n)/2 and (m+n)/2
	// - 1
	// if m+n is odd, then the median is (m+n)/2

	int mid = (m + n) / 2;
	// look for mid in A
	// [start, end]: close region to try. inclusive.
	int start = 0, end = m - 1, i = 0, j = 0;
	int median = 0;
	while (start <= end) {
	    i = (start + end) / 2;
	    j = mid - i;
	    // handle index out of bound here.
	    if (get(B, j - 1) <= get(A, i) && get(A, i) <= get(B, j)) {
		median = get(A, i);
		break;
	    } else if (get(A, i) < get(B, j - 1)) { // A[i] is smaller than the
						    // median
		start = i + 1;
		i = (start + end) / 2;
		j = mid - i;
	    } else if (get(A, i) > get(B, j)) { // A[i] is bigger than the
						// median
		end = i - 1;
		i = (start + end) / 2;
		j = mid - i;
	    }
	}

	if (start <= end) // found the median
	{
	    if ((m + n) % 2 == 0) { // index out of bound here
		int other = Math.max(get(A, i - 1), get(B, j - 1));
		return (median + other) * 0.5;
	    } else {
		return (double) median;
	    }
	} else { // not found the median
		 // look for median in B
	    return findMedianSortedArrays(B, A);
	}
    }

    public int get(int[] a, int i) {
	if (i < 0) {
	    return Integer.MIN_VALUE;
	} else if (i >= a.length) {
	    return Integer.MAX_VALUE;
	} else {
	    return a[i];
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	int A[] = { 1, 3, 5 };
	int B[] = { 2, 4 };
	double c = new MedianofTwoSortedArrays().findMedianSortedArrays1(A, B);
	System.out.println(c);
    }
}
