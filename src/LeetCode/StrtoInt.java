package LeetCode;

public class StrtoInt {
    private static final int maxDiv10 = Integer.MAX_VALUE / 10;

    public int atoi2(String str) {
	if (str == null || str.length() == 0)
	    return 0;
	int i = 0, n = str.length();
	while (i < n && Character.isWhitespace(str.charAt(i)))
	    i++;
	int sign = 1;
	if (str.charAt(i) == '+') {
	    i++;
	} else if (str.charAt(i) == '-') {
	    sign = -1;
	    i++;
	}
	int num = 0;
	while (i < n && Character.isDigit(str.charAt(i))) {
	    int digit = Character.getNumericValue(str.charAt(i));
	    if (num > maxDiv10 || (num == maxDiv10 && digit >= 8)) {
		return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	    }
	    num = num * 10 + digit;
	    i++;
	}
	return sign * num;
    }

    // pass both
    public static int atoi(String str) {
	// Start typing your Java solution below
	// DO NOT write main() function
	boolean neg = false;
	boolean space = false;
	boolean plus = false;
	int idxb = 0;
	int idxe = str.length() - 1;
	for (int i = 0; i < str.length(); i++) {
	    if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
		idxb = i;
		while (i < str.length()) {
		    if (str.charAt(i) < '0' || str.charAt(i) > '9') {
			break;
		    }
		    i++;
		}
		idxe = i - 1;
		break;
	    } else if (str.charAt(i) == ' ') {
		if (neg || plus)
		    return 0;
		space = true;
	    } else if (str.charAt(i) == '-') {
		if (neg || plus)
		    return 0;
		neg = true;
	    } else if (str.charAt(i) == '+') {
		if (neg || plus)
		    return 0;
		plus = true;
	    } else {
		return 0;
	    }
	}
	int size = idxe - idxb + 1;
	char[] arr = str.substring(idxb, idxe + 1).toCharArray();
	long sum = 0;
	for (int i = size - 1; i >= 0; i--) {
	    int idx = size - 1 - i;
	    sum += (arr[idx] - 48) * Math.pow(10, i);
	}
	if (neg) {
	    if (sum > Integer.MAX_VALUE)
		return Integer.MIN_VALUE;
	    return (0 - (int) sum);
	}
	if (sum >= Integer.MAX_VALUE)
	    return Integer.MAX_VALUE;
	return (int) sum;
    }

    // simpler
    public static int atoi1(String str) {
	if (str == null || str.isEmpty())
	    return 0;
	boolean negative = false;
	int idx = 0;
	while (str.charAt(idx) == ' ')
	    idx++;
	if (str.charAt(idx) == '-') {
	    negative = true;
	    idx++;
	} else if (str.charAt(idx) == '+') {
	    idx++;
	}
	int num = 0;
	while (idx < str.length() && str.charAt(idx) >= '0'
		&& str.charAt(idx) <= '9') {
	    if (((num == 214748364) && ((str.charAt(idx) - '0' > 7)))
		    || (num > 214748364)) {
		return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	    }
	    num = 10 * num + str.charAt(idx) - '0';
	    idx++;
	}
	return negative ? num * -1 : num;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(atoi("-2147483648"));
	System.out.println(atoi1("1"));
    }

}
