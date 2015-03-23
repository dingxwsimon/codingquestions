package dynamic;

import java.util.ArrayList;

public class CokeMachine {

    /*
     * Three coke machines. Each one has two values min & max, which means if
     * you get coke from this machine it will load you a random volume in the
     * range [min, max]. Given a cup size n and minimum soda volume m, show if
     * it's possible to make it from these machines.
     */

    static class Interval {
	double min;
	double max;

	Interval(double min, double max) {
	    this.min = min;
	    this.max = max;
	}
    }

    /*
     * Assume (x1,y1) , (x2,y2), (x3,y3) are the ranges of the three coke
     * machines. You have a range (m,n).
     * 
     * As stated before, m < X < Y < n for some (X,Y) to be obtained by a linear
     * combination of the three machines.
     * 
     * Which means K1*x1 + K2*x2 + K3*x3 (= X) > m and K1*y1 + K2*y2 + K3 * y3
     * (=Y) < n
     * 
     * Take the second equation , we need to find all (K1,K2,K3) < n Start from
     * n-1 (assume everything is an integer here. If not then we can scale the
     * numbers till they become integers). For every (k1,k2,k3) which satisfies
     * the second equation see if it also satisfies the first equation. If yes ,
     * the problem can be solved . If no, decrement Sigma Ki*Xi to n-2 and
     * repeat the algorithm.
     */

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
