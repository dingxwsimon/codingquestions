package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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


    private static final Map<Character, Integer> A = new HashMap<Character, Integer>();

    static {
        A.put('A', 0);
        A.put('C', 1);
        A.put('G', 2);
        A.put('T', 3);
    }

    private final int A_SIZE_POW_9 = (int) Math.pow(A.size(), 9);

    public List<String> findRepeatedDnaSequences1(String s) {
        Set<String> res = new HashSet<String>();
        Set<Integer> hashes = new HashSet<Integer>();
        for (int i = 0, rhash = 0; i < s.length(); i++) {
            if (i > 9) rhash -= A_SIZE_POW_9 * A.get(s.charAt(i - 10));
            rhash = A.size() * rhash + A.get(s.charAt(i));
            if (i > 8 && !hashes.add(rhash)) res.add(s.substring(i - 9, i + 1));
        }
        return new ArrayList<String>(res);
    }
}
