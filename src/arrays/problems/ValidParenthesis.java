package arrays.problems;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "()[{}]";
        System.out.println(validParenthesis(s));
}


   static boolean validParenthesis(String s){
       Stack<Character> stack = new Stack<>();
       for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           if (c == '[' || c == '{' || c == '(') {
               stack.push(c);
           }
           else {
               if (stack.isEmpty()) {return false;}
               char tc=stack.pop();
               if ((c==')'&& tc=='(' )|| (c=='}'&& tc=='{') ||( c==']'&& tc=='[')){
                   continue;
               }
               return false;
               }
           }
      return stack.isEmpty(); }

}