package LeetCode;

import java.util.Arrays;

public class BestTimetoBuyandSellStock {

    public int maxProfit1(int[] prices) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (prices.length < 2)
	    return 0;

	int buy_date = 0;
	int max_profit = 0;

	for (int i = 0; i < prices.length; i++) {
	    if (prices[i] < prices[buy_date]) {
		buy_date = i;
	    }
	    int tmp_profit = prices[i] - prices[buy_date];
	    if (tmp_profit > max_profit)
		max_profit = tmp_profit;
	}
	return max_profit;
    }

    public int maxProfit2(int[] prices) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (prices == null || prices.length < 2)
	    return 0;

	int maxProfit = 0;

	for (int i = 1; i < prices.length; i++) {
	    if (prices[i] > prices[i - 1])
		maxProfit += prices[i] - prices[i - 1];
	}
	return maxProfit;
    }

    // better, more clear, easy to remeber
    public int maxProfit3_1(int[] prices) {
	int n = prices.length;
	if (n <= 1)
	    return 0;
	int[] historyprofit = new int[n];
	int[] futureprofit = new int[n];
	int valley = prices[0];
	int peak = prices[n - 1];
	int maxprofit = 0;
	for (int i = 0; i < n; i++) {
	    valley = Math.min(valley, prices[i]);
	    if (i > 0) {
		historyprofit[i] = Math.max(historyprofit[i - 1], prices[i]
			- valley);
	    }
	}
	for (int i = n - 1; i >= 0; i--) {
	    peak = Math.max(peak, prices[i]);
	    if (i < n - 1) {
		futureprofit[i] = Math.max(futureprofit[i + 1], peak
			- prices[i]);
	    }
	    maxprofit = Math.max(historyprofit[i] + futureprofit[i], maxprofit);
	}
	return maxprofit;
    }

    public int maxProfit3_2(int[] prices) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (prices == null || prices.length < 2)
	    return 0;
	int n = prices.length;
	int buy_date = 0;
	int sell_date = n - 1;
	int max = 0;
	int[] history = new int[n];
	int[] future = new int[n];
	for (int i = 0; i < n; i++) {
	    if (prices[i] < prices[buy_date]) {
		buy_date = i;
	    }
	    if (i > 0)
		history[i] = Math.max(history[i - 1], prices[i]
			- prices[buy_date]);
	}
	for (int i = n - 1; i >= 0; i++) {
	    if (prices[i] > prices[sell_date]) {
		sell_date = i;
	    }
	    if (i < n - 1)
		future[i] = Math.max(future[i + 1], prices[sell_date]
			- prices[i]);
	    max = Math.max(max, future[i] + history[i]);
	}
	return max;
    }

    // DP: t(i,j) is the max profit for up to i transactions by time j (0<=i<=K,
    // 0<=j<=T).
    // tmpMax means the maximum profit of just doing at most i-1 transactions,
    // using at most first j-1 prices,
    // and buying the stock at price[j] - this is used for the next loop.
    public int maxProfit4(int k, int[] prices) {
	int len = prices.length;
	if (k >= len / 2)
	    return maxProfit2(prices);

	int[][] t = new int[k + 1][len];
	for (int i = 1; i <= k; i++) {
	    int tmpMax = t[i - 1][0] - prices[0];
	    for (int j = 1; j < len; j++) {
		t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
		tmpMax = Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
	    }
	}
	return t[k][len - 1];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	BestTimetoBuyandSellStock b = new BestTimetoBuyandSellStock();
	System.out.println(b.maxProfit3_2(new int[] { 1, 2 }));
    }

}
