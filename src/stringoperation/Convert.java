package stringoperation;

public class Convert {
    public static void convert(String s) {
	for (char c : s.toCharArray()) {
	    if (c < ' ') {
		int ci = c - ' ';
		System.out.println(ci);
		System.out.println("\\0" + Integer.toString(ci, 8));
	    }
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Convert.convert("a\tb");
    }

}
