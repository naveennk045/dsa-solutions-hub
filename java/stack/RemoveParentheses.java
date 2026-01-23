package stack;

import java.util.Arrays;
import java.util.Stack;

public class RemoveParentheses {

    public static String minRemoveToMakeValid(String s) {

        StringBuilder buffer = new StringBuilder();
        Stack<String> stack = new Stack<>();


        for (char item : s.toCharArray()){

            if(item == '('){
                stack.push(buffer.toString());
                stack.push("(");
                buffer = new StringBuilder();
            }
            else if(item == ')'){


                while(!stack.isEmpty() && !stack.peek().equals("(")){
//                    System.out.println("I amd here");
                    buffer.insert(0,stack.pop());
                }

                if(!stack.isEmpty()) buffer.insert(0,stack.pop()).append(")");
                stack.push(buffer.toString());

                buffer = new StringBuilder();
            }else{
                buffer.append(item);
            }


            System.out.println(stack);

        }
        if(!buffer.isEmpty())  stack.push(buffer.toString());
        buffer = new StringBuilder();

        for (String item : stack){
            buffer.append(item);
        }

        return buffer.toString();
    }
    public static void main(String[] args) {

        minRemoveToMakeValid("lee(t(c)o)de)");
        minRemoveToMakeValid("a)b(c)d");
        minRemoveToMakeValid("))((");

    }
}
