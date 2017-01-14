package LeetCode;

public class PalindromeNum {

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int div = 1;
        // get the div that has the same number of digits as x
        while (x / div >= 10) {
            div *= 10;
        }
        while (x != 0) {
            int l = x / div;
            int r = x % 10;
            if (l != r)
                return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(isPalindrome(1));
    }

}
