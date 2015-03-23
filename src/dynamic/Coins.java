package dynamic;

import java.util.ArrayList;

public class Coins {
    public static void coins(int amount, int[] bills,
	    ArrayList<Integer> sumArray) {
	int sum = 0;
	for (int i : sumArray)
	    sum += i;
	if (sum == amount)
	    System.out.println(sumArray);

	if (sum > amount)
	    return;

	if (sum < amount) {
	    for (int i : bills) {
		sumArray.add(i);
		coins(amount, bills, sumArray);
		sumArray.remove(sumArray.size() - 1);
	    }
	}
    }

    // define the recursive method header
    // notice we have 4 arguments in this method
    // coins are the sorted coins in descending order, larger positioned more
    // front
    // counts record the number of coins at certain location
    // start index is keep tracking of from which coin we start processing after
    // choosing one larger coin amount
    // total amount keep track of remaining amount left processing
    public static void PringCombination(int[] coins, int[] counts,
	    int startIndex, int totalAmount) {
	// firstly decide if we should proceed or not by track startIndex
	if (startIndex >= coins.length)// we have processed all coins
	{
	    // format the print out as "amount=?*25 + ?*10+..."
	    for (int i = 0; i < coins.length; i++)
		System.out.print("" + counts[i] + "*" + coins[i] + " ");
	    // need a new line per case
	    System.out.print("\n");
	    return;
	}

	// other wise we need proceed
	// but notice if startIndex is the last one, we need check if it can be
	// dividable by the smallest coin
	// if so, this is a good combination, otherwise, this is not possible
	// combination thus discarded
	if (startIndex == coins.length - 1) {
	    if (totalAmount % coins[startIndex] == 0)// good combination
	    {
		// set the counts of coins at start index
		counts[startIndex] = totalAmount / coins[startIndex];
		// proceed to recursive call
		PringCombination(coins, counts, startIndex + 1, 0);// notice
								   // startIndex+1
								   // and
								   // remaining
								   // amount =
								   // 0
	    }
	} else// we still have option to choose 0-N larger coins
	{
	    for (int i = 0; i <= totalAmount / coins[startIndex]; i++) {
		// for every cycle in a loop, we choose an arbitrary number of
		// larger
		// coins and proceed next
		counts[startIndex] = i;
		PringCombination(coins, counts, startIndex + 1, totalAmount
			- coins[startIndex] * i);
		// notice we need update the remaining amount
	    }
	}
    }

    public static int makeChange(int n, int denom) {
	int next_denom = 0;
	switch (denom) {
	case 25:
	    next_denom = 10;
	    break;
	case 10:
	    next_denom = 5;
	    break;
	case 5:
	    next_denom = 1;
	    break;
	case 1:
	    return 1;
	}
	int ways = 0;
	for (int i = 0; i * denom <= n; i++) {
	    ways += makeChange(n - i * denom, next_denom);
	}
	return ways;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] coins = { 25, 10, 5, 1 };// set as usual coins we use
	int[] counts = new int[coins.length];// set the default counts array
	System.out.println("All possible coin combinations of 25 cents are: ");
	PringCombination(coins, counts, 0, 25);// let's test the case of 25
					       // cents,
					       // and notice default initial
					       // startIndex = 0
	System.out.println(makeChange(25, 25));
    }

}
