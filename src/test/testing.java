package test;

import java.util.ArrayList;

public class testing {
    public static int maxProfit1(int[] prices) {
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

    public static void main(String[] args) {
	ArrayList<String> strings = new ArrayList<String>();
	strings.add("Hello, World!");
	strings.add("Welcome to CoderPad.");
	strings.add("This pad is running Java 8.");

	for (String string : strings) {
	    System.out.println(string);
	}
    }
}
