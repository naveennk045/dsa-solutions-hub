package recursion.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidParenthesis {

    public static boolean isOpenParenthesis(char ch) {
        return ch == '{' || ch == '[' || ch == '(';
    }

    public static boolean isMatch(char ch1, char ch2) {
        System.out.println(ch1 + " == " + ch2);
        return (
                ch1 == '(' && ch2 == ')' ||
                        ch1 == '{' && ch2 == '}' ||
                        ch1 == '[' && ch2 == ']'
        );
    }

    private static boolean isValidHelper(char[] chars, int currIdx, int[] lastIdx, ArrayList<Character> stack) {
        if (currIdx == chars.length) {
            return true;
        }


        System.out.println("Chars : " + Arrays.toString(chars));
        System.out.println("CurrIdx : " + chars[currIdx]);
        System.out.println("LastIdx : " + lastIdx[0]);
        System.out.println("Top char : " + stack);
        System.out.println("        ---------       ");

        if (isOpenParenthesis(chars[currIdx])) {
            stack.add(chars[currIdx]);
            if (!isValidHelper(chars, currIdx + 1, lastIdx, stack)) return false;
            return isValidHelper(chars, lastIdx[0] + 1, lastIdx, stack);
        }
        lastIdx[0] = currIdx;

        return !stack.isEmpty() && isMatch(stack.removeLast(), chars[currIdx]);

    }

    public static boolean isValid(String str) {
        char[] chars = str.toCharArray();
        return isValidHelper(chars, 0, new int[1], new ArrayList<>());
    }

    public static void main(String[] args) {
        System.out.println(isValid("([]"));
    }
}