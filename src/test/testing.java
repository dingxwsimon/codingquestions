package test;

import java.util.ArrayList;

public class testing {
    public ArrayList<String> parseCSV(String input) {
        if (input == null || input.length() == 0)
            return null;
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int n = input.length();
        // boolean singleQuote = false;
        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if (c != ',' && c != '\"') {
                sb.append(c);
            } else if (c == ',') {
                // if(!singleQuote){
                result.add(sb.toString());
                sb = new StringBuilder();
                // }
            } else if (c == '\"') {
                i = getStringBeweenQuote(input, i, sb);
            }
        }
        result.add(sb.toString());
        return result;
    }

    private int getStringBeweenQuote(String input, int start, StringBuilder sb) {
        int i = start + 1;
        while (i < input.length()) {
            char c = input.charAt(i);
            if (c == '\"') {
                int next = i + 1;
                if (next == input.length() || input.charAt(next) != '\"') {
                    break;
                } else {
                    i = next;
                    sb.append('\"');
                }
            } else {
                sb.append(c);
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        testing s = new testing();
        ArrayList<String> result = s
                .parseCSV("alice,bob,carol");
        for (String string : result) {
            System.out.println(string);
        }
    }
}
