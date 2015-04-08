package stringoperation;

public class URLshortner {
    public static String Alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static int Base = Alphabet.length();

    public static String Encode(int i) {
	if (i == 0)
	    return Alphabet.toCharArray()[0] + "";

	String s = "";

	while (i > 0) {
	    s = Alphabet.toCharArray()[i % Base] + s;
	    i = i / Base;
	}

	return s;
    }

    public static int Decode(String s) {
	int i = 0;

	for (char c : s.toCharArray()) {
	    i = (i * Base) + Alphabet.indexOf(c);
	}

	return i;
    }

    public static void main(String[] args) {
	// Simple test of encode/decode operations
	for (int i = 0; i < 10000; i++) {
	    System.out.println(i + "\t" + Encode(i));
	    if (Decode(Encode(i)) != i) {
		System.out.println(Encode(i) + " is not " + i);
		break;
	    }
	}
    }
}
