package LeetCode;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }

        return true;
    }

    public boolean isPalindrome1(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!isAlphanumeric(s.charAt(i)))
                i++;
            if (!isAlphanumeric(s.charAt(j)))
                j++;
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }

        return true;
    }

    public boolean isAlphanumeric(char c) {
        if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z')
            return true;
        else
            return false;
    }

    public static boolean isPalindrome2(String s) {
        if (s == null)
            return false;
        if (s.length() == 0)
            return true;
        s = s.trim();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        isPalindrome2("aA");
    }

}
