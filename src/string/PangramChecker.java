package string;

import java.util.Scanner;

public class PangramChecker {

    public static boolean isPangram(String sentence){

        boolean[] alphabet =new boolean[26];
        int index;
        for (int i = 0; i < sentence.length(); i++) {

            char character=sentence.charAt(i);
            if('a'<=character && character <= 'z'){
                index=character - 'a';
                alphabet[index]=true;
            }
        }


        for (boolean flag : alphabet){
            if(!flag){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        System.out.print("Enter Sentence : ");
        String sentence=scan.nextLine();

         if(isPangram(sentence.toLowerCase())){
             System.out.println("This Sentence is palindrome");
         }
         else{
             System.out.println("This is not palindrome");
         }
    }
}