package stringoperation;

public class Regex {

    public static boolean match(String s, String matcher) {
        if (s == null || matcher == null) {
            return false;
        }

        if (matcher.equals("*")) {
            return true;
        }

        return match(s, matcher, 0, 0);
    }

    private static boolean match(String s, String matcher, int sp, int mp) {
        boolean matchAny = false;

        while (sp < s.length() && mp < matcher.length()) {
            if (matchAny) {
                if (matcher.charAt(mp) == s.charAt(sp)) {
                    if (match(s, matcher, sp, mp)) {
                        return true;
                    } else {
                        sp++;
                    }
                } else {
                    sp++;
                }
            } else if (matcher.charAt(mp) == '.') {
                sp++;
                mp++;
            } else if (matcher.charAt(mp) == '*') {
                mp++;
                matchAny = true;
            } else if (matcher.charAt(mp) == '+') {
                mp++;
                sp++;
                matchAny = true;
            } else {
                if (matcher.charAt(mp) != s.charAt(sp)) {
                    return false;
                } else {
                    sp++;
                    mp++;
                }
            }
        }

        if (matchAny || mp != matcher.length()) {
            boolean eatAll = true;

            while (mp < matcher.length()) {
                if (matcher.charAt(mp++) != '*') {
                    eatAll = false;
                    break;
                }
            }

            return eatAll;
        }

        if (sp != s.length()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.printf("%s %s: %b\n", "abc", "abc", match("abc", "abc"));
        System.out.printf("%s %s: %b\n", "abc", "bcd", match("abc", "bcd"));
        System.out.printf("%s %s: %b\n", "abc", "abcd", match("abc", "abcd"));
        System.out.printf("%s %s: %b\n", "abcd", "abc", match("abcd", "abc"));
        System.out.printf("%s %s: %b\n", "abc", "a.c", match("abc", "a.c"));
        System.out.printf("%s %s: %b\n", "abc", "ab.", match("abc", "ab."));
        System.out.printf("%s %s: %b\n", "abc", "a.", match("abc", "a."));
        System.out.printf("%s %s: %b\n", "a", "a.", match("a", "a."));
        System.out.printf("%s %s: %b\n", "", "", match("", ""));

        System.out.printf("%s %s: %b\n", "", "+", match("", "+"));
        System.out.printf("%s %s: %b\n", "a", "+", match("a", "+"));
        System.out.printf("%s %s: %b\n", "abc", "+", match("abc", "+"));
        System.out.printf("%s %s: %b\n", "abc", "a+", match("abc", "a+"));
        System.out.printf("%s %s: %b\n", "abc", "ab+", match("abc", "ab+"));
        System.out.printf("%s %s: %b\n", "abc", "abc+", match("abc", "abc+"));
        System.out.printf("%s %s: %b\n", "ac", "a+c", match("ac", "a+c"));
        System.out.printf("%s %s: %b\n", "abc", "a+c", match("abc", "a+c"));
        System.out.printf("%s %s: %b\n", "abbbc", "a+c", match("abbbc", "a+c"));

        System.out.printf("%s %s: %b\n", "", "*", match("", "*"));
        System.out.printf("%s %s: %b\n", "a", "*", match("a", "*"));
        System.out.printf("%s %s: %b\n", "abc", "*", match("abc", "*"));
        System.out.printf("%s %s: %b\n", "abc", "a*", match("abc", "a*"));
        System.out.printf("%s %s: %b\n", "abc", "ab*", match("abc", "ab*"));
        System.out.printf("%s %s: %b\n", "abc", "abc*", match("abc", "abc*"));
        System.out.printf("%s %s: %b\n", "ac", "a*c", match("ac", "a*c"));
        System.out.printf("%s %s: %b\n", "abc", "a*c", match("abc", "a*c"));
        System.out.printf("%s %s: %b\n", "abbbc", "a*c", match("abbbc", "a*c"));

        System.out.printf("%s %s: %b\n", "dccccqz", "dc+",
                match("dccccqz", "dc+"));

    }
}
