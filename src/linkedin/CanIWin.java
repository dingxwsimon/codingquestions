package linkedin;

public class CanIWin {
    /*
     * In "the 100 game," two players take turns adding, to a running total, any
     * integer from 1..10. The player who first causes the running total to
     * reach or exceed 100 wins. What if we change the game so that players
     * cannot re-use integers? For example, if two players might take turns
     * drawing from a common pool of numbers of 1..15 without replacement until
     * they reach a total >= 100. This problem is to write a program that
     * determines which player would win with ideal play.
     * 
     * Write a procedure,
     * "Boolean canIWin(int maxChoosableInteger, int desiredTotal)", which
     * returns true if the first player to move can force a win with optimal
     * play.
     * 
     * Your priority should be programmer efficiency; don't focus on minimizing
     * either space or time complexity.
     */

    boolean canIWin(int maxChoosableInteger, int desiredTotal) {
	if ((maxChoosableInteger * maxChoosableInteger + maxChoosableInteger) / 2 < desiredTotal) {
	    // Neither player can win.
	    return false;
	}
	int[] numbers = new int[maxChoosableInteger];
	for (int i = 0; i < maxChoosableInteger; ++i) {
	    numbers[i] = i + 1;
	}
	return canWin(numbers, desiredTotal);
    }

    boolean canWin(int[] numbers, int desiredTotal) {
	if (desiredTotal <= 0) {
	    return false;
	}
	for (int i = 0; i < numbers.length; ++i) {
	    int newTotal = desiredTotal - numbers[i];
	    if (!canWin(remove(numbers, i), newTotal)) {
		return true;
	    }
	}
	return false;
    }

    int[] remove(int[] a, int k) {
	int[] b = new int[a.length - 1];
	for (int i = 0, j = 0; i < a.length; i++) {
	    if (i != k) {
		b[j++] = a[i];
	    }
	}
	return b;
    }

    public static void main(String[] args) {
	CanIWin c = new CanIWin();
	System.out.println(c.canIWin(15, 100));

    }

}
