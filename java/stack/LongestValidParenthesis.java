package stack;

import java.util.Stack;

public class LongestValidParenthesis {

    public static int longestValidParentheses(String s) {
        int n = s.length();

        boolean[] isValid = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            char currChar = s.charAt(i);

            if (currChar == '(') {
                stack.push(i);
            } else if (currChar == ')') {
                if (!stack.isEmpty()) {
                    isValid[stack.pop()] = true;
                    isValid[i] = true;
                }
            }
        }

        int maxLength = 0;
        int count = 0;
        for (boolean item : isValid) {
            if (item) count++;
            else count = 0;

            maxLength = Math.max(count, maxLength);
        }
        return maxLength;
    }
}