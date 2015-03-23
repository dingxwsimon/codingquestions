package number;

public class Prime {
    public boolean[] sieveOfEratosthenes(final int max) {
	if (max < 0) {
	    throw new IllegalArgumentException("max cannot be less than zero: "
		    + max);
	}
	final boolean[] primeCandidates = new boolean[max]; // defaults to false
	for (int i = 2; i < max; i++) {
	    primeCandidates[i] = true;
	}

	final double maxRoot = Math.sqrt(max);
	for (int candidate = 2; candidate < maxRoot; candidate++) {
	    if (primeCandidates[candidate] == true) {
		for (int j = 2 * candidate; j < max; j += candidate) {
		    primeCandidates[j] = false;
		}
	    }

	}
	return primeCandidates;
    }

    // generate all the prime number from 1 to n
    void prime_sieve(int n, boolean prime[]) {
	prime[0] = false;
	prime[1] = false;
	int i;
	for (i = 2; i <= n; i++)
	    prime[i] = true;

	int limit = (int) Math.sqrt(n);
	for (i = 2; i <= limit; i++) {
	    if (prime[i]) {
		for (int j = i + i; j <= n; j += i)
		    prime[j] = false;
	    }
	}
    }

    // Take any string and print all the prime numbers in it
    /**
     * @param args
     */
    public static boolean isInteger(char c) {
	try {
	    Integer.parseInt(String.valueOf(c));
	    return true;
	} catch (NumberFormatException nfe) {
	}
	return false;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	String str = "ibby37primete61s43";
	findprime(str);
    }

    static boolean isPrime(int x) {
	for (int i = 2; i <= Math.sqrt(x); i++) {
	    if (x % i == 0)
		return false;
	}

	return true;
    }

    private static void findprime(String str) {
	// TODO Auto-generated method stub

	for (int i = 0; i < str.length(); i++) {
	    if (isInteger(str.charAt(i))) {
		if (isPrime(Integer.parseInt(String.valueOf(str.charAt(i))))) {
		    if (str.charAt(i) != '1')
			System.out.println(str.charAt(i) + " ");

		}
		checknext(str, i, String.valueOf(str.charAt(i)));
	    }
	}

    }

    private static void checknext(String str, int i, String current) {
	// TODO Auto-generated method stub
	int k = 0;
	String temp = current;
	for (int m = i + 1; m < str.length(); m++) {
	    if (isInteger(str.charAt(m))) {
		temp = temp + String.valueOf(str.charAt(m));
		if (isPrime(Integer.parseInt(String.valueOf(temp)))) {
		    System.out.println(temp);
		}
	    } else {
		// System.out.println("broke once");
		break;
	    }
	}
    }

}
