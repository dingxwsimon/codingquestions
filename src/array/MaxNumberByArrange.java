package array;

import java.util.Arrays;
import java.util.Comparator;

public class MaxNumberByArrange {

    public static Comparator myComparator = new Comparator<String>() {

	@Override
	public int compare(String s1, String s2) {
	    return (s2 + s1).compareTo(s1 + s2);
	}
    };

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	String[] strs = new String[] { "95", "96", "9", "54", "56", "5", "55",
		"556", "554", "1", "2", "3" };
	Arrays.sort(strs, myComparator);
	System.out.println(Arrays.toString(strs));
    }

}
