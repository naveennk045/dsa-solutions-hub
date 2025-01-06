package patternPrinting;

import java.util.Scanner;

public class Problems {

        public static void printXPattern(int side){
//                * * * * * * * * *
//                - * * * * * * * -
//                - - * * * * * - -
//                - - - * * * - - -
//                - - - - * - - - -
//                - - - * * * - - -
//                - - * * * * * - -
//                - * * * * * * * -
//                * * * * * * * * *
                side=(side*2)-1;
        for (int i = 0; i < side; i++) {
            for (int j = 0; j <side; j++) {
                if(j>=i && j<=(side-1)-i || j<=i && j>=(side-1)-i){
                    System.out.print("* ");
                }
                else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Side : ");
        int side=scan.nextInt();
        printXPattern(side);



    }
}