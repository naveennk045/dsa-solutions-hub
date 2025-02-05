package string;

import java.util.Scanner;

public class RemoveDuplicate {
    public static String removeDuplicateElement(String word){
        StringBuilder result=new StringBuilder();
        for(char ch:word.toCharArray()){
            if(result.indexOf(String.valueOf(ch))==-1){
                result.append(ch);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String word=scanner.next();
        System.out.println(removeDuplicateElement(word));
    }
}