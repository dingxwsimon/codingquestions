package interviewStreet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RomanToDecimal {

    static String romanStr = "IVXLCDM";

    static int[] romanVal = new int[] { 1, 5, 10, 50, 100, 500, 1000 };

    // not working
    public static int GetRomanValue(String input) {
	int total = 0, temp = 0;

	for (int i = 0; i < input.length(); i++) {
	    int index = romanStr.indexOf(input.charAt(i));
	    total += romanVal[index] > temp ? romanVal[index]
		    : -romanVal[index];
	    temp = romanVal[index];
	}

	return total;
    }

    public static int get(String s) {
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
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String input = br.readLine().toUpperCase();
	System.out.println(GetRomanValue(input));
    }

}
