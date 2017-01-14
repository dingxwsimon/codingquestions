package LeetCode;

public class LengthofLastWord {
    // pass both
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s.length() - 1;
        int res = 0;

        int i = n;
        while (i >= 0 && s.charAt(i) == ' ')
            i--;
        if (i == 0 && s.charAt(i) == ' ')
            return res;
        if (i == 0 && s.charAt(i) != ' ')
            return 1;

        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                res++;
            } else
                break;
        }
        return res;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LengthofLastWord l = new LengthofLastWord();
        System.out.println(l.lengthOfLastWord("a "));
    }

}
