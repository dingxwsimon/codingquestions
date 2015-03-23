package dynamic;

import java.util.Arrays;

public class ColorTheCells {
    /*
     * There are N cells in a row. The cells are numbered 0 through N-1 from
     * left to right. Magical Girl Riena wants to give magical powers to all the
     * cells by painting all of them using magic colors. Riena starts at time 0
     * in cell 0. She can do three types of actions: She can wait in her current
     * cell for as long as she wants. She may move to an adjacent cell. The move
     * takes 1 unit of time. She may paint an adjacent cell. Painting the cell
     * takes 1 unit of time. (Note that she cannot paint the cell she currently
     * stands in, only the adjacent ones.) There is one additional restriction:
     * Riena cannot enter a freshly painted cell until the paint dries. You are
     * given a int[] dryingTime with N elements. For each i, dryingTime[i] is
     * the time needed for the paint in the cell i to dry after Riena finished
     * painting the cell. Once cell i has already been painted, Riena is not
     * allowed to start moving to cell i before the paint in cell i gets dry.
     * For example, suppose that Riena is currently in cell 3 and we have
     * dryingTime[2]=7. At time 12 Riena starts painting the adjacent cell 2.
     * She will finish painting the cell at time 12+1 = 13. The paint in the
     * cell will be dry at time 13+7 = 20. Therefore, the earliest time Riena
     * can be in cell 2 again is 21. (At time 20 she can start moving from cell
     * 3 to cell 2, and the move takes 1 unit of time.) Riena wants to paint all
     * N cells, and she wants to finish painting as quickly as possible. She may
     * paint the cells in any order she likes. Compute and return the earliest
     * possible time when Riena can finish painting the last cell. (Note that
     * the return value you are trying to minimize is the moment when Riena
     * finishes painting, not the moment when the paint dries.)
     */

    public int[] time, dry;
    public int N, min;
    public int[][] dp;

    public static void main(String[] args) {
	int[] val = { 35198, 26281, 72533, 91031, 44326, 43178, 85530 };
	System.out.println(new ColorTheCells().minimalTime(val));

    }

    public int minimalTime(int[] dryingTime) {
	min = 1000000;
	N = dryingTime.length;
	dry = dryingTime;
	dp = new int[1 << N][N];
	for (int[] val : dp) {
	    Arrays.fill(val, Integer.MAX_VALUE);
	}
	time = new int[dryingTime.length];
	cal(0, 0, 0);
	return min;
    }

    public void cal(int index, int mask, int cur) {
	// System.out.println(mask + " " + cur);
	if (mask == (1 << N) - 1) {
	    min = Math.min(cur, min);
	    return;
	}
	if (cur >= min) {
	    return;
	}
	if (dp[mask][index] < cur) {
	    return;
	}
	dp[mask][index] = cur;

	if (index + 1 < N) {
	    int val = 1 << (index + 1);
	    if ((mask & val) == 0) {
		time[index + 1] = cur + 1 + dry[index + 1];
		cal(index, mask | val, cur + 1);
		time[index + 1] = 0;
		cal(index + 1, mask, cur + 1);
	    } else {
		if (time[index + 1] <= cur) {
		    cal(index + 1, mask, cur + 1);
		} else {
		    cal(index + 1, mask, time[index + 1] + 1);
		}
	    }

	}
	if (index - 1 >= 0) {
	    int val = 1 << (index - 1);
	    if ((mask & val) == 0) {
		time[index - 1] = cur + 1 + dry[index - 1];
		cal(index, mask | val, cur + 1);
		time[index - 1] = 0;
		cal(index - 1, mask, cur + 1);
	    } else {
		if (time[index - 1] <= cur) {
		    cal(index - 1, mask, cur + 1);
		} else {
		    cal(index - 1, mask, time[index - 1] + 1);
		}
	    }
	}

    }

}
