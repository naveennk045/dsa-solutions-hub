package stack;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {

    static HashMap<Character, Integer> order = new HashMap<>();

    static {
        order.put('+', 1);
        order.put('-', 1);
        order.put('*', 2);
        order.put('/', 2);
    }

    public static boolean isOperator(char token) {
        return token == '/' || token == '*' || token == '+' || token == '-';
    }

    public static String infixToPostfix(String s) {
        StringBuilder postfixExp = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char token : s.toCharArray()) {
            if (token == '(') {
                stack.push(token);

            } else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixExp.append(stack.pop());
                }
                stack.pop();

            } else if (isOperator(token)) {
                while (!stack.isEmpty() && stack.peek() != '('
                        && order.get(stack.peek()) >= order.get(token)) {
                    postfixExp.append(stack.pop());
                }
                stack.push(token);

            } else {
                postfixExp.append(token);
            }
        }

        // pop remaining operators
        while (!stack.isEmpty()) {
            postfixExp.append(stack.pop());
        }

        return postfixExp.toString();
    }
}