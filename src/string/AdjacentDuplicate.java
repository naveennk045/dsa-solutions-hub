package string;

import java.util.Scanner;

public class AdjacentDuplicate {

    public static String removeDuplicates(String s) {
        StringBuilder result=new StringBuilder(s);
        int p1=0; //pointer1
        int p2=1; //pointer2

        while(p2<result.length()){
            if(result.charAt(p1)==result.charAt(p2)){
                result.delete(p1,p2+1);
//                System.out.println(result);
                p1=0;
                p2=1;
            }
            else{
                p1++;
                p2++;
            }

        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String word=scanner.nextLine();
        System.out.println(removeDuplicates(word));
    }
}