package recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> validParenthesis = new ArrayList<>();
        generateParenthesis(n, new StringBuilder(), 0, 0, validParenthesis);
        return validParenthesis;
    }

    private static void generateParenthesis(int n, StringBuilder str, int open, int close, List<String> validParenthesis) {
        if (str.length() >= n*2) {
//            System.out.println(str.toString());
            validParenthesis.add(str.toString());
            return;
        }
        if (open < n) {
            generateParenthesis(n, str.append("("), open + 1, close, validParenthesis);
            str.deleteCharAt(str.length() - 1);
        }
        if (close < open) {
            generateParenthesis(n, str.append(")"), open, close + 1, validParenthesis);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}