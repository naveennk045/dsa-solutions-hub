package stack;

import java.util.Stack;

public class RedundantBraces {

    public static int braces(String A) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {

            char item = A.charAt(i);

            if (item != ')') {
                stack.push(item);
            } else {
                boolean hasOperator = false;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    if (isOperator(stack.pop())) hasOperator = true;
                }
                stack.pop();
                if (!hasOperator) return 1;
            }
            System.out.println(stack);
        }
        return 0;
    }

    private static boolean isOperator(char item) {
        return item == '+' || item == '-' || item == '*' || item == '/';
    }

    public static void main(String[] args) {
        System.out.println(braces("(a+(a+b))"));
    }
}
