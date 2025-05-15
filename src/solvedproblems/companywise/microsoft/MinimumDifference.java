package solvedproblems.companywise.microsoft;

import java.util.Scanner;

public class MinimumDifference {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);

        System.out.print("Enter S : ");
        String s= scan.next();

        System.out.print("Enter T : ");
        String t= scan.next();

        StringBuilder tempS=new StringBuilder(s);
        StringBuilder tempT=new StringBuilder(t);

        int difference=0;
        int minDifference=Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < s.length(); j++) {

                tempS.setCharAt(j, t.charAt(j));
                tempT.setCharAt(j, s.charAt(j));

                difference=Math.abs((Integer.valueOf(tempS.toString()) -Integer.valueOf(tempT.toString())));
                if(difference < minDifference){
                    minDifference=difference;
                }
                System.out.println(tempS);
                System.out.println(tempT);
                System.out.println();
            }

        }
        System.out.println( "Difference : "+minDifference );
    }
}