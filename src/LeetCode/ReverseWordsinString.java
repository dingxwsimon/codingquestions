package LeetCode;

public class ReverseWordsinString {

    public String reverseWords(String s) {
        if (s == null || s.isEmpty())
            return s;
        StringBuilder sb = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                j = i;
            else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(s.substring(i, j));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
