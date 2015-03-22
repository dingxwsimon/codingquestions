package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {

    /*
     * There are only four possible character A, C, G, and T, but I want to use
     * 3 bits per letter instead of 2.
     * 
     * Why? It's easier to code.
     * 
     * A is 0x41, C is 0x43, G is 0x47, T is 0x54. Still don't see it? Let me
     * write it in octal.
     * 
     * A is 0101, C is 0103, G is 0107, T is 0124. The last digit in octal are
     * different for all four letters. That's all we need!
     * 
     * We can simply use s[i] & 7 to get the last digit which are just the last
     * 3 bits, it's much easier than lookup table or switch or a bunch of if and
     * else, right?
     * 
     * We don't really need to generate the substring from the int. While
     * counting the number of occurrences, we can push the substring into result
     * as soon as the count becomes 2, so there won't be any duplicates in the
     * result.
     */
    public List<String> findRepeatedDnaSequences(String s) {
	HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
	ArrayList<String> r = new ArrayList<String>();
	for (int t = 0, i = 0; i < s.length(); i++) {
	    t = t << 3 & 0x3FFFFFFF | s.charAt(i) & 7;
	    if (m.containsKey(t)) {
		m.put(t, m.get(t) + 1);
	    } else {
		m.put(t, 1);
	    }
	    if (m.get(t) == 2) {
		r.add(s.substring(i - 9, i + 1));
	    }
	}
	return r;
    }
}
