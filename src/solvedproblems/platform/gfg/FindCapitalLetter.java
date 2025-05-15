package solvedproblems.platform.gfg;

import java.util.Scanner;

public class FindCapitalLetter {
    public static char findCaps(char[] chars,int ind){
        if(ind==chars.length) return ' ';
        if(chars[ind]>='A' && chars[ind]<='Z') return chars[ind];
        return findCaps(chars,ind+1);

    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        System.out.println( findCaps(str.toCharArray(),0));

    }
}