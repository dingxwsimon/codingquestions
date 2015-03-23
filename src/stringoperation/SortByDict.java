package stringoperation;

import java.util.HashMap;
import java.util.List;

public class SortByDict {
    public String sortByD(String s, List<Character> dict) {
	String output = "";
	HashMap<Character, String> m = new HashMap<Character, String>();
	for (char c : dict)
	    m.put(c, "");
	for (int i = 0; i < s.length(); ++i)
	    m.put(s.charAt(i), m.get(s.charAt(i)) + s.charAt(i));
	for (char c : dict)
	    output += m.get(c);
	return output;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
