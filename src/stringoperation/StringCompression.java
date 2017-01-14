package stringoperation;

public class StringCompression {
    public String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        if (n == 0)
            return "";
        char p = str.charAt(1);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != p) {
                sb.append(p + "" + count);
                p = str.charAt(i);
                count = 1;
            } else {
                count++;
            }

        }
        sb.append(p + "" + count);
        if (str.length() > sb.length())
            return sb.toString();
        else
            return str;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringCompression s = new StringCompression();
        System.out.println(s.compress("aabcccccaaa"));
    }

}
