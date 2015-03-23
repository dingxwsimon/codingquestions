package LeetCode;

public class Pow {
    public double pow1(double x, int n) {
	if (n < 0)
	    return 1 / helper(x, 0 - n);
	else
	    return helper(x, n);
    }

    public double helper(double x, int n) {
	if (n == 0)
	    return 1;
	double half = helper(x, n / 2);
	return n % 2 == 1 ? x * half * half : half * half;
    }

    public double pow(double x, int n) {
	if (n == 0)
	    return 1.0;
	if (x == 0.0)
	    return 0.0;
	boolean reverse = false;
	if (n < 0) {
	    reverse = true;
	    n *= -1;
	}

	double result = 1.0;
	double power = x;
	while (n > 0) {
	    if ((n & 1) == 1) {
		result *= power;
	    }
	    power *= power;
	    n >>= 1;
	}

	if (reverse)
	    return 1 / result;
	else
	    return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(Math.pow(17, 2));
    }

}
