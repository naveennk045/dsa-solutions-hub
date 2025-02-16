// You are using Java

import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner scan=new Scanner(System.in);

        char[] word1=scan.nextLine().toCharArray();
        char[] word2=scan.nextLine().toCharArray();
        int min=0;
        int max=0;
        for(int i=0;i<word1.length;i++){
            char ch1=word1[i];
            char ch2=word2[i];

            if(ch1!=ch2 && ch1!='?' && ch2 !='?'){
                min++;
            }
            if(ch1!=ch2 || ch1=='?' || ch2 =='?'){
                max++;
            }
        }
        System.out.print(min+" ");
        System.out.print(max);
    }
}