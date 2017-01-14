package LeetCode;

public class LongestCommonPrefix {

    // pass both
    public static String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        StringBuffer sb = new StringBuffer();

        int minlen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minlen) {
                minlen = strs[i].length();
            }
        }

        for (int i = 0; i < minlen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c)
                    return sb.toString();
            }
            sb.append(c);
        }

        return sb.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] strs = {"ababa", "aba", "abc"};
        System.out.println(longestCommonPrefix(strs));
    }

}
