package dynamic;

public class SortingCost {
    public static final int NMAX = 10000;

    int cost(int[] a, int N) {
	int i, j, max, Nv;
	int[] V = new int[NMAX];
	int[] A = new int[NMAX];
	int[] B = new int[NMAX];
	int[] Cm = A, Cn = B; // (n-1)'th and n'th rows of C
	// Compute set V with no duplicates.
	// Remember where max element is.
	Nv = max = 0;
	for (i = 0; i < N; i++) {
	    for (j = 0; j < Nv; j++)
		if (a[i] == V[j])
		    break;
	    if (j == Nv) {
		V[Nv++] = a[i];
		if (V[j] > V[max])
		    max = j;
	    }
	    a[i] = j; // Convert a to indices.
	}
	// Fill in first row of C.
	for (i = 0; i < Nv; i++)
	    Cm[i] = (V[a[0]] >= V[i]) ? V[a[0]] - V[i] : 0;
	// Fill in the rest of the rows of C.
	for (i = 1; i < N; i++) {
	    for (j = 0; j < Nv; j++) {
		int del = Cm[j] + V[a[i]];
		int dec = (V[a[i]] <= V[j]) ? Cm[a[i]] : Cm[j] + V[a[i]] - V[j];
		Cn[j] = (del < dec) ? del : dec;
	    }
	    // Swap row buffers so current becomes previous.
	    int[] tmp = Cn;
	    Cn = Cm;
	    Cm = tmp;
	}
	return Cm[max];
    }

    // dp[n][x] = mincost of first n elements with x as the last one upbound
    public int getMin1(int[] input) {
	if (input.length <= 1)
	    return 0;
	int max = 0;
	for (int i = 0; i < input.length; i++) {
	    max = Math.max(max, input[i]);
	}
	int[][] dp = new int[input.length][max + 1];
	for (int j = 0; j <= max; j++) {
	    dp[0][j] = Math.max(0, input[0] - j);
	}
	for (int i = 1; i < dp.length; i++) {
	    for (int j = 0; j <= max; j++) {
		if (input[i] >= j) { // decrement
		    dp[i][j] = input[i] - j + dp[i - 1][j];
		} else { // delete
		    dp[i][j] = Math.min(input[i] + dp[i - 1][j],
			    dp[i - 1][input[i]]);
		}
	    }
	}
	return dp[input.length - 1][max];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] in = new int[] { 8, 1, 9, 10, 1 };
	int res = new SortingCost().getMin1(in);
	System.out.println(res);
    }

}
