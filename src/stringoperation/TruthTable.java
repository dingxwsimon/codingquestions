package stringoperation;

public class TruthTable {
    public static void print(String str, int k) {
	if (k == 0) {
	    System.out.println(str);
	    return;
	}
	print(str + "T", k - 1);
	print(str + "F", k - 1);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	print("", 3);
    }

}
