package number;

import java.util.HashMap;
import java.util.Map;

public class ImplementOperators {
    final static Map<Integer, Integer> bitMap = new HashMap<Integer, Integer>();

    public ImplementOperators() {
	for (int i = 0; i < 32; i++) {
	    bitMap.put(1 << i, i);
	}
    }

    // check http://www.sureinterview.com/shwqst/43005/
    int add(int a, int b) {
	int cry, add;
	do {
	    add = a ^ b;
	    cry = (a & b) << 1;

	    a = add;
	    b = cry;
	} while (cry != 0);
	return add;
    }

    // check http://www.sureinterview.com/shwqst/43005/
    int divide(int dividend, int divisor) {
	if (divisor == 0)
	    throw new ArithmeticException();

	boolean neg = (dividend > 0) ^ (divisor > 0);
	if (dividend < 0) {
	    dividend = -dividend;
	}

	if (divisor < 0) {
	    divisor = -divisor;
	}

	if (dividend < divisor)
	    return 0;

	int msb = 0;
	for (msb = 0; msb < 32; msb++) {
	    if ((divisor << msb) >= dividend) {
		break;
	    }
	}

	int q = 0;
	for (int i = msb; i >= 0; i--) {
	    if ((divisor << i) > dividend) {
		continue;
	    }
	    q |= (1 << i);
	    dividend -= (divisor << i);
	}

	if (neg)
	    return -q;

	return q;
    }

    // check http://www.sureinterview.com/shwqst/43005/
    int multiply(int a, int b) {
	boolean neg = (b < 0);
	if (b < 0) {
	    b = -b;
	}

	int sum = 0;
	while (b > 0) {
	    int lastBit = bitMap.get(b & ~(b - 1));
	    sum += a << lastBit;
	    b &= b - 1;
	}

	if (neg) {
	    sum = -sum;
	}

	return sum;
    }

    // check http://www.sureinterview.com/shwqst/43005/
    int subtract(int a, int b) {
	return add(a, add(~b, 1));
    }

    public void test() {
	for (int i = 0; i < 100000; i++) {
	    int a = (int) (Math.random() * 10000) - 5000;
	    int b = (int) (Math.random() * 3000) - 1500;
	    add(a, b);
	    subtract(a, b);
	    multiply(a, b);
	    divide(a, b);
	}
    }
}
