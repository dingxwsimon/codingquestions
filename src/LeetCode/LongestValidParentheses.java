package LeetCode;

import java.util.Stack;

public class LongestValidParentheses {
    // Use a stack to keep track of the positions of non-matching '('s.
    // Also need to keep track of the position of the last ')'.
    public int longestValidParentheses1(String s) {
        int maxLen = 0, last = -1;
        Stack<Integer> lefts = new Stack<Integer>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                lefts.push(i);
            } else {
                if (lefts.isEmpty()) {
                    // no matching left
                    last = i;
                } else {
                    // find a matching pair
                    lefts.pop();
                    if (lefts.isEmpty()) {
                        maxLen = Math.max(maxLen, i - last);
                    } else {
                        maxLen = Math.max(maxLen, i - lefts.peek());
                    }
                }
            }
        }
        return maxLen;
    }

    public static int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = 0, right = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right && right + left > max) {
                max = right + left;
            } else if (left < right) {
                left = 0;
                right = 0;
            }
            // left > right, just go on
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right && right + left > max) {
                max = right + left;
            } else if (left > right) {
                left = 0;
                right = 0;
            }
            // left < right, just go on
        }

        return max;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(longestValidParentheses(")))((())"));
    }

}
