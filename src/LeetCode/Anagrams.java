package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Anagrams {
    // pass both
    public static ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();
        ArrayList<String> r = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            String key = sortWord(strs[i]);
            if (!result.containsKey(key)) {
                ArrayList<String> value = new ArrayList<String>();
                value.add(strs[i]);
                result.put(key, value);
            } else {
                ArrayList<String> value = result.get(key);
                value.add(strs[i]);
            }
        }

        Iterator<ArrayList<String>> it = result.values().iterator();
        while (it.hasNext()) {
            ArrayList<String> v = it.next();
            if (v.size() >= 2) {
                r.addAll(v);
            }
        }

        return r;
    }

    public static String sortWord(String word) {
        char[] charArr = word.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] test = new String[]{"tea", "and", "ate", "eat", "den"};
        anagrams(test);
    }

}
