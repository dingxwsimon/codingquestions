package LeetCode;

public class Candy {

    public static int candy(int[] ratings) {
	//this is a test
	if (ratings == null || ratings.length == 0)
	    return 0;
	int n = ratings.length;
	int nCandyCnt = 0;// /Total candies
	int nSeqLen = 0; // / Continuous ratings descending sequence length
	int nPreCanCnt = 1; // / Previous child's candy count
	int nMaxCntInSeq = nPreCanCnt;
	nCandyCnt++;// Counting the first child's candy.
	if (n == 1)
	    return nCandyCnt;
	for (int i = 1; i < n; i++) {
	    // if r[k]>r[k+1]>r[k+2]...>r[k+n],r[k+n]<=r[k+n+1],
	    // r[i] needs n-(i-k)+(Pre's) candies(k<i<k+n)
	    // But if possible, we can allocate one candy to the child,
	    // and with the sequence extends, add the child's candy by one
	    // until the child's candy reaches that of the prev's.
	    // Then increase the pre's candy as well.

	    // if r[k] < r[k+1], r[k+1] needs one more candy than r[k]
	    //
	    if (ratings[i] < ratings[i - 1]) {
		// Now we are in a sequence
		nSeqLen++;
		if (nMaxCntInSeq == nSeqLen) {
		    // The first child in the sequence has the same candy as the
		    // prev
		    // The prev should be included in the sequence.
		    nSeqLen++;
		}
		nCandyCnt += nSeqLen;
		nPreCanCnt = 1;
	    } else {
		if (ratings[i] > ratings[i - 1]) {
		    nPreCanCnt++;
		} else {
		    nPreCanCnt = 1;
		}
		nCandyCnt += nPreCanCnt;
		nSeqLen = 0;
		nMaxCntInSeq = nPreCanCnt;
	    }
	}

	return nCandyCnt;
    }

    public int candy2(int[] ratings) {
	if (ratings == null || ratings.length == 0)
	    return 0;
	int n = ratings.length;
	int[] left = new int[n];
	int[] right = new int[n];
	for (int i = 0; i < n; i++) {
	    left[i] = 1;
	    right[i] = 1;
	}
	for (int i = 1; i < n; i++) {
	    if (ratings[i] > ratings[i - 1]) {
		left[i] = left[i - 1] + 1;
	    }
	}
	for (int i = n - 2; i >= 0; i--) {
	    if (ratings[i] > ratings[i + 1]) {
		right[i] = right[i + 1] + 1;
	    }
	}
	int sum = 0;
	for (int i = 0; i < n; i++) {
	    sum += Math.max(left[i], right[i]);
	}
	return sum;
    }

    public int candy1(int[] ratings) {
	int[] candy = new int[ratings.length];
	// allocate candies, considering the minimal rating on the left
	candy[0] = 1;
	for (int i = 1; i < ratings.length; i++) {
	    candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;
	}
	// modify the allocation, considering the minimal rating on the right
	int totalCandy = candy[ratings.length - 1];
	for (int i = ratings.length - 2; i >= 0; i--) {
	    candy[i] = (ratings[i] > ratings[i + 1] && candy[i + 1] + 1 > candy[i]) ? candy[i + 1] + 1
		    : candy[i];
	    // count total candies by the way
	    totalCandy += candy[i];
	}
	return totalCandy;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(candy(new int[] { 2, 2 }));
    }

}
