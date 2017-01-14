package LeetCode;

public class ValidNumber {

    // pass leetcode both
    public static boolean isNumber2(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        int i = 0, e = len - 1;
        while (i <= e && Character.isWhitespace(s.charAt(i)))
            i++;
        if (i > len - 1)
            return false;
        while (e >= i && Character.isWhitespace(s.charAt(e)))
            e--;
        // skip leading +/-
        if (s.charAt(i) == '+' || s.charAt(i) == '-')
            i++;
        boolean num = false; // is a digit
        boolean dot = false; // is a '.'
        boolean exp = false; // is a 'e'
        while (i <= e) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (exp || dot)
                    return false;
                dot = true;
            } else if (c == 'e') {
                if (exp || num == false)
                    return false;
                exp = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e')
                    return false;
            } else {
                return false;
            }
            i++;
        }
        return num;
    }

    // really ambiguos
    public static boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        try {
            double result = Double.parseDouble(s);
            System.out.println(result);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    enum InputType {
        INVALID, // 0
        SPACE, // 1
        SIGN, // 2
        DIGIT, // 3
        DOT, // 4
        EXPONENT, // 5
        NUM_INPUTS // 6
    }

    ;

    public static boolean isNumber1(String s) {

        int transitionTable[][] = {{-1, 0, 3, 1, 2, -1}, // next states for
                // state
                // 0
                {-1, 8, -1, 1, 4, 5}, // next states for state 1
                {-1, -1, -1, 4, -1, -1}, // next states for state 2
                {-1, -1, -1, 1, 2, -1}, // next states for state 3
                {-1, 8, -1, 4, -1, 5}, // next states for state 4
                {-1, -1, 6, 7, -1, -1}, // next states for state 5
                {-1, -1, -1, 7, -1, -1}, // next states for state 6
                {-1, 8, -1, 7, -1, -1}, // next states for state 7
                {-1, 8, -1, -1, -1, -1}, // next states for state 8
        };

        int state = 0;
        int i = 0;
        while (i < s.length()) {
            InputType inputType = InputType.INVALID;
            char c = s.charAt(i);
            if (c == ' ')
                inputType = InputType.SPACE;
            else if (c == '+' || c == '-')
                inputType = InputType.SIGN;
            else if (c >= '0' && c <= '9')
                inputType = InputType.DIGIT;
            else if (c == '.')
                inputType = InputType.DOT;
            else if (c == 'e' || c == 'E')
                inputType = InputType.EXPONENT;

            // Get next state from current state and input symbol
            state = transitionTable[state][inputType.ordinal()];

            // Invalid input
            if (state == -1)
                return false;
            else
                i++;
        }
        // If the current state belongs to one of the accepting (final) states,
        // then the number is valid
        return state == 1 || state == 4 || state == 7 || state == 8;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(isNumber1("0xFFFF"));
    }

}
