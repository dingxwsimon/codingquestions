package number;

import java.util.Date;
import java.util.Random;

public class MonteCarloPi {

    public static class NaiveRandom {
	private int x; // seed

	private int m = 134456; // modulus
	private int a = 8121; // multiplier
	private int c = 28411; // increment

	public NaiveRandom() {
	    x = 0;
	}

	public NaiveRandom(int seed) {
	    this.x = seed;
	}

	public double next() {
	    x = (x * a + c) % m;
	    return x / (double) m;
	}
    }

    public static void main(String[] args) {
	// seed for NaiveRandom
	Date now = new Date();
	int seconds = (int) now.getTime();

	// create random number generators
	NaiveRandom nrand = new NaiveRandom(seconds);
	Random rand = new Random();

	// total number of sample points to take
	int numPoints = 1000000;

	int inNaiveCircle = 0;
	double xn, yn, zn;
	// xn and yn will be the random point
	// zn will be the calculated distance to the center

	int inRandCircle = 0;
	double xr, yr, zr;
	// xr and yr will be the random point
	// zr will be the calculated distance to the center

	for (int i = 0; i < numPoints; ++i) {
	    xn = nrand.next();
	    yn = nrand.next();

	    xr = rand.nextDouble();
	    yr = rand.nextDouble();

	    zn = (xn * xn) + (yn * yn);
	    if (zn <= 1.0)
		inNaiveCircle++;

	    zr = (xr * xr) + (yr * yr);
	    if (zr <= 1.0)
		inRandCircle++;
	}

	// calculate the Pi approximations
	double naivePi = approxPi(inNaiveCircle, numPoints);
	double randomPi = approxPi(inRandCircle, numPoints);

	// calculate the % error
	double naiveError = calcError(naivePi);
	double randomError = calcError(randomPi);

	System.out.println("Naive Pi Approximation: " + naivePi + ", Error: "
		+ naiveError);
	System.out.println("Random Pi Approximation: " + randomPi + ", Error: "
		+ randomError);
    }

    static double approxPi(int inCircle, int totalPoints) {
	return (double) inCircle / totalPoints * 4.0;
    }

    static double calcError(double pi) {
	return (pi - Math.PI) / Math.PI * 100;
    }
}
