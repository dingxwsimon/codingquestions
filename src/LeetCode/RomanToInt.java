package LeetCode;

import java.util.HashMap;

public class RomanToInt {

    public static int romanToInt1(String s) {
	int n = s.length();
	if (n == 0)
	    return 0;
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	map.put('M', 1000);
	map.put('D', 500);
	map.put('C', 100);
	map.put('L', 50);
	map.put('X', 10);
	map.put('V', 5);
	map.put('I', 1);
	int sum = map.get(s.charAt(n - 1));

	for (int i = n - 2; i >= 0; i--) {
	    if (map.get(s.charAt(i + 1)) <= map.get(s.charAt(i)))
		sum += map.get(s.charAt(i));
	    else
		sum -= map.get(s.charAt(i));
	}

	return sum;

    }

    // pass both
    public static int romanToInt(String s) {
	int size = s.length();
	int decimal = 0, j;
	for (int i = 0; i < size; i++) {
	    if (size >= 2)
		j = i - 1;
	    else
		j = 0;
	    char ch = s.charAt(i);
	    switch (ch) {
	    case 'M': {
		if (i != 0 && 'C' == s.charAt(j)) {
		    decimal -= 100;
		    decimal += 900;
		} else
		    decimal += 1000;
		break;
	    }
	    case 'D': {
		if (i != 0 && 'C' == s.charAt(j)) {
		    decimal -= 100;
		    decimal += 400;
		} else
		    decimal += 500;
		break;
	    }
	    case 'C': {
		if (i != 0 && 'X' == s.charAt(j)) {
		    decimal -= 10;
		    decimal += 90;
		} else
		    decimal += 100;
		break;
	    }
	    case 'L': {
		if (i != 0 && 'X' == s.charAt(j)) {
		    decimal -= 10;
		    decimal += 40;
		} else
		    decimal += 50;
		break;
	    }
	    case 'X': {
		if (i != 0 && 'I' == s.charAt(j)) {
		    decimal -= 1;
		    decimal += 9;
		} else
		    decimal += 10;
		break;
	    }
	    case 'V': {
		if (i != 0 && 'I' == s.charAt(j)) {
		    decimal -= 1;
		    decimal += 4;
		} else
		    decimal += 5;
		break;
	    }
	    case 'I': {
		decimal += 1;
		break;
	    }
	    }
	}
	return decimal;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
