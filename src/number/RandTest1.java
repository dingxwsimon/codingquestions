package number;

import java.io.IOException;
import java.util.Random;

// CS 1538 Fall 2009
// This program compares the predefined nextInt(n) method with a programmer-
// derived value of nextInt() % n and with a simple linear congruential
// generator
// provided in a CS 0445 text. The test used is the Chi-Square test for
// uniformity
// (note that we are not testing independence here, but we should to determine
// if
// the generator is useable or not -- see Section 7.4 for other tests).

// The generator from the CS 0445 text is included for a couple reasons:
// 1) It has a smaller range than the standard Java generators. This lowers the
// density of the generator and can lead to poor results in some situations
// (see Rand1.java for more details).
// 2) It has a variation that uses the lower-order bits to demonstrate their
// decidedly non-random behavior (see Rand1.java for more details)

// An exact even distribution is also tested to show that a distribution can be
// "too good" -- in this case having the exact expected value for each number
// shows
// not random behavior but rather a lack thereof. In this case, we would look at
// the "left side" of the Chi-Square distribution rather than the right tail.
// See
// the "Critical Values of the Chi-Square Distribution" handout for more
// details.
// Look at the R4 generator below in a few of the examples to see a fit that is
// likely "too good" to be random.

public class RandTest1 {

    // CS 1538 Fall 2009
    // This is a mixed linear congruetial generator taken from an old
    // CS 0445 textbook (Data Structures in C++ by Ford and Topp -- I
    // changed some things to make it work in Java but it is essentially the
    // same as the generator presented in the Ford and Topp textbook).

    // Note that value returned by this generator is only 16 bits, giving
    // it a maximum range of 2^16. This was common with older C++ compilers in
    // which a long int was only 32 bits (and in fact many implementations of
    // the rand() function in C/C++ still have a range of 2^16). It is
    // well-known
    // that the lower-order bits in a linear congruential generator with a
    // modulus
    // of 2^b do not have a very good "random" distribution. However, a modulus
    // of 2^b is easier and faster to calculate than other moduli, so it is
    // frequently used. Thus, most linear congruential generators of this type
    // will shift out the lower order bits so that the "usable" range of results
    // is actually smaller than the entire range of the generator.

    // If you examine m, a and c, you will see that they meet the criteria for a
    // full-period generator. The shortcomings of the smaller range can be seen
    // when the desired subrange of values is a significant (but not divisible)
    // part of the overall range. In this case, assuming that the original value
    // generated is uniform, when it is "mapped" onto the desired subrange the
    // probabilities will no longer be uniform. See notes on board for more
    // details.

    // Also note the last method, bogusInt. This uses all of the 32 bits
    // generated and will likely have very poor results, due to the lack of
    // "randomness" of those lower order bits. However, note that this poor
    // behavior may not necessarily be detected by a uniformity test such
    // as Chi-Square. We need to also test for independence.
    public static class Rand1 {

	private final long mask = (1L << 32) - 1; // this is "m" = 2^32
	private final long multiplier = 1194211693L; // this is "a"
	private final long adder = 12345L; // this is "c"
	private long randSeed;

	public Rand1() {
	    randSeed = System.currentTimeMillis();
	}

	public Rand1(long s) {
	    randSeed = s;
	}

	public int nextShort(int n) {
	    randSeed = (multiplier * randSeed + adder) & mask;
	    int shortAns = Math.abs((int) randSeed >> 16);
	    return (shortAns % n);
	}

	public int bogusInt(int n) {
	    randSeed = (multiplier * randSeed + adder) & mask;
	    int intAns = Math.abs((int) randSeed);
	    return (intAns % n);
	}

    }

    public static void main(String[] args) throws IOException {

	long[] A1 = null, A2 = null, A3 = null, A4 = null, Aequal = null;

	// Note the different ranges shown, and note in particular how
	// generator R3 performs on the different values within the
	// range array. In particular, note that R3 gives an acceptable
	// distribution (or at least close to an acceptable distribution)
	// up until range = 10000 and 25000, where it is terrible. However,
	// it is again acceptable (at least to the naked eye) for range =
	// 32768. See Rand1.java and notes on board for more about this.

	// Note also that the R4 generator which is using the lower order
	// bits has somewhat odd behavior. For example, note that it always
	// gives a perfect distribution for n = 2. As stated above, this is
	// actually not "random" behavior and shows a problem with the generator
	// In fact, the problem can be better seen with independence tests such
	// as run tests and correlation tests. If you print out the values when
	// n = 2 you will see that the 0s and 1s alternate, thus giving the
	// "perfect" distribution. However, for some ranges the result seems
	// acceptable.

	// int[] ranges = { 2, 21, 64, 101, 256, 10000, 25000, 32768 };
	// double[] alphas = { 0.975, 0.95, 0.9, 0.8, 0.2, 0.1, 0.05, 0.025 };
	int[] ranges = { 64 };
	double[] alphas = { 0.9 };
	for (int r = 0; r < ranges.length; r++) {
	    int range = ranges[r];
	    int iter = 100 * range;
	    A1 = new long[range];
	    A2 = new long[range];
	    A3 = new long[range];
	    A4 = new long[range];
	    Aequal = new long[range];

	    for (int i = 0; i < range; i++) {
		A1[i] = 0;
		A2[i] = 0;
		A3[i] = 0;
		A4[i] = 0;
		Aequal[i] = iter / range;
	    } // initialize values to 0

	    long seed = System.currentTimeMillis();
	    Random R1 = new Random(seed);
	    Random R2 = new Random(seed);
	    Rand1 R3 = new Rand1(seed);
	    Rand1 R4 = new Rand1(seed);

	    for (int i = 0; i < iter; i++) {
		long num = R1.nextInt(range);
		A1[(int) num]++;
		num = Math.abs(R2.nextInt()) % range;
		A2[(int) num]++;
		num = R3.nextShort(range);
		A3[(int) num]++;
		num = R4.bogusInt(range);
		A4[(int) num]++;
	    }

	    System.out.println("---------------------------------------------");
	    int lowTop = Math.min(10, range);
	    int hiBot = Math.max(lowTop + 1, range - 10);

	    for (int i = 0; i < lowTop; i++) {
		System.out.print(A1[i] + " ");
	    }
	    System.out.println("\n ... ");
	    for (int i = hiBot; i < range; i++) {
		System.out.print(A1[i] + " ");
	    }
	    System.out.println("\n");

	    for (int i = 0; i < lowTop; i++) {
		System.out.print(A2[i] + " ");
	    }
	    System.out.println("\n ... ");
	    for (int i = hiBot; i < range; i++) {
		System.out.print(A2[i] + " ");
	    }
	    System.out.println("\n");

	    for (int i = 0; i < lowTop; i++) {
		System.out.print(A3[i] + " ");
	    }
	    System.out.println("\n ... ");
	    for (int i = hiBot; i < range; i++) {
		System.out.print(A3[i] + " ");
	    }
	    System.out.println("\n");

	    for (int i = 0; i < lowTop; i++) {
		System.out.print(A4[i] + " ");
	    }
	    System.out.println("\n ... ");
	    for (int i = hiBot; i < range; i++) {
		System.out.print(A4[i] + " ");
	    }
	    System.out.println("\n");

	    System.out.println("Array size (i.e. range) = " + range);

	    double check1 = chisquare(A1, iter);
	    double check2 = chisquare(A2, iter);
	    double check3 = chisquare(A3, iter);
	    double check4 = chisquare(A4, iter);
	    double checkeq = chisquare(Aequal, iter);

	    System.out.println("Chi Square using nextInt(n): " + check1);
	    System.out.println("Chi Square using nextInt() % n: " + check2);
	    System.out.println("Chi Square using CS 0445 gen: " + check3);
	    System.out.println("Chi Square using lower bit gen: " + check4);
	    System.out.println("Chi Square using all equal: " + checkeq);
	    System.out.println();

	    System.out.println("Critical Values of Chi-Square:");
	    for (int i = 0; i < alphas.length; i++)
		System.out.println("Alpha: " + alphas[i] + "   Chi-Square: "
			+ critical(range, alphas[i]));
	    System.out.println();
	}
    }

    // Simple algorithm to do the Chi-Square test for an array of frequencies,
    // where the possible values were assumed to have uniform probability.
    public static double chisquare(long[] A, int iter) {
	double expecti = (double) iter / A.length;
	double t = 0;
	for (int i = 0; i < A.length; i++) {
	    double diff = A[i] - expecti;
	    t += diff * diff;
	}
	double ans = t / expecti;
	return ans;
    }

    // Below is a formula for estimating the critical value of Chi-Square when
    // the
    // degrees of freedom is large. Note that most tables in books (and online)
    // don't
    // go above 100 so this formula can come in handy for our random number
    // tests.
    // The formula is taken from Simulation Modeling and Analysis Third Edition
    // by
    // Law and Kelton (McGraw-Hill). If you compare the values (even for small
    // k)
    // to
    // those in the printed tables you will see that this formula is pretty
    // good.

    // Arguments are k, the number of subintervals and alpha, the desired
    // significance
    // level
    public static double critical(int k, double alpha) {
	int kMinus1 = k - 1;
	double oneMinusAlpha = 1 - alpha;
	double temp1 = (double) 2 / (9 * kMinus1);
	double temp2 = Math.sqrt(temp1);
	// To estimate our critical value we need to use the inverse normal
	// function.
	// This takes a probability (in the CDF for N(0,1)) and returns the z
	// value
	// (i.e. the number of standard deviations that produces that
	// probability).
	// I
	// got the code from the Web (see CDF_Normal.java for more details).
	double zOneMinusAlpha = CDF_Normal.xnormi(oneMinusAlpha);
	temp2 = temp2 * zOneMinusAlpha;
	temp1 = 1 - temp1 + temp2;
	temp1 = Math.pow(temp1, 3);
	temp1 = temp1 * kMinus1;
	return temp1;
    }

}
