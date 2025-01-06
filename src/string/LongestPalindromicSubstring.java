package string;

import java.util.Scanner;

//Longest SubString without the repeating characters
public class LongestPalindromicSubstring {

    public static String longestPalindromicSubstring(String word){
        String maxSubstring="";
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
               String subString= word.substring(i,j);
                System.out.println(subString);
               if(isPalindrome(subString) && subString.length()>maxSubstring.length()){
                   maxSubstring=subString;
                }
            }
        }
        return maxSubstring;
    }

    public static boolean isPalindrome(String str){
       String reversedString=reverse(str);
       return reversedString.equals(str);
    }

    public static String reverse(String str){
        StringBuilder reversedString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString.append(str.charAt(i));
        }
        return reversedString.toString();
    }

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        System.out.print("Enter word : ");
        String word=scan.next();

        System.out.println(longestPalindromicSubstring(word));


    }

}