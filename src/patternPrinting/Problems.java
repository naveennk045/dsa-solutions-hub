package patternPrinting;

import java.util.Scanner;

public class Problems {
        public static void butterFly(int n){
/*          *                 *
            * *             * *
            * * *         * * *
            * * * *     * * * *
            * * * * * * * * * *
            * * * *     * * * *
            * * *         * * *
            * *             * *
            *                 *
*/
            n=n*2;
            for(int i=0;i<n-1;i++){
                for(int j=0;j<n;j++){
                    if(j>=i+1&& j<=n-2-i || j<i+1 && j>n-2-i){
//                        System.out.printf("col %d : (%d,%d) ",j,j,n-i);
                        System.out.print("  ");
                    }
                    else{
//                        System.out.printf("(%d,%d) ",i,j);
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
        }
        public static void printKPattern(int n){
            int row=2*n-1;
            int col=n;

            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <=col ; j++) {
                    if(j>=1 && j<=col+1-i) {
//                    System.out.printf("col %d : (%d,%d) ",j ,col-i,col+i);
                        System.out.print("* ");
                    }else{
                        System.out.print(" ");
                    }
//                System.out.print("* ");
                }
                System.out.println();
            }
            for (int i = 2; i <=n; i++) {
                for (int j = 1; j <=i ; j++) {

                    System.out.print("* ");
                }
                System.out.println();
            }
        }

        public static void printXPattern(int side){
/*              * * * * * * * * *
                - * * * * * * * -
                - - * * * * * - -
                - - - * * * - - -
                - - - - * - - - -
                - - - * * * - - -
                - - * * * * * - -
                - * * * * * * * -
                * * * * * * * * *
*/
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
    public static void printDiamond(int n){
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= 2*n-1; j++) {
                if(j>n-i && j<n+i){
//                    System.out.printf("col %d : (%d,%d) ",j ,n-i,n+i);
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int i = 1; i <=n-1; i++) {
            for (int j = 1; j <= 2*n-1; j++) {
                if(j>=i+1 && j<=(2*n-1)-i){
//                    System.out.printf("col %d : (%d,%d) ",j ,n-i,n+i);
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void printSquare(int n){
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
    public static void printHollowSquare(int n){
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if(j==0 || j==n-1 || i==0 || i==n-1){
//                    System.out.printf("col:(%d)",j);
                System.out.print(" * ");
                }
                else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
    public static void printParallelogram(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n*2; j++) {
                if(j>=i && j<=n+i){
//                    System.out.printf("col:(%d)",j);
                    System.out.print(" * ");
                }
                else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
    public static void printMirrorParallelogram(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n*2; j++) {
                if(j<=i && j>=n+i){
//                    System.out.printf("col:(%d)",j);
                    System.out.print(" * ");
                }
                else{
                    System.out.print("   ");
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
        System.out.println();
        butterFly(side);
        System.out.println();
        printDiamond(side);
        System.out.println();
        printSquare(side);
        System.out.println();
        printHollowSquare(side);
        System.out.println();
        printParallelogram(side);
        System.out.println();
        printMirrorParallelogram(side);
        System.out.println();
        printKPattern(side);



    }
}