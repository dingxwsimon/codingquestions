package regex;

public class Regex {
    // c < 256 means the character on the state transition edge
    // c = 256 means split
    // c = 257 means Match
    public static class State {
	int c;
	State out;
	State out1;
	int lastlist;
    }

    public static class Frag {
	State start;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
