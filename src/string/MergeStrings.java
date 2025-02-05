package string;

import java.util.Scanner;

public class MergeStrings {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        String word1= scan.nextLine();
        String word2=scan.nextLine();
        StringBuilder sb=new StringBuilder();
        int length= Math.max(word2.length(), word1.length());
        int i=0;
        while(i<length){
            if(i<word1.length()){
              sb.append(word1.charAt(i));
            }
            if(i<word2.length()){
                sb.append(word2.charAt(i));
            }
            i++;
        }
        System.out.println(sb.toString());
    }
}