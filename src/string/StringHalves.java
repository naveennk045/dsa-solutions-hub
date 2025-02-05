package string;

import java.util.Scanner;

public class StringHalves {

    public static boolean isAlike(String word){

        int left=0;
        int right=word.length()-1;
        int mid=left+(right-left)/2;

        char[] word1=word.substring(left,mid+1).toCharArray();
        char[] word2=word.substring(mid+1,right+1).toCharArray();

        for(char ch1: word1){
            if(ch1=='a'|| ch1=='e'||ch1=='i'||ch1=='o'||ch1=='u'){
                for (char ch2:word2){
                    if(ch1==ch2){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String word=scanner.next().toLowerCase();

        System.out.println(isAlike(word));
    }
}