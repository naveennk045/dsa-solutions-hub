package patternPrinting;

import java.sql.SQLOutput;

public class Basics {
    public static void printMatrixFormat(int n){
        n=(n%2==0)?n-1:n;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(n/2==j || n/2==i){
                    System.out.print(0);
                }
                else{
                    System.out.print(1);
                }
            }
            System.out.println();
        }
    }
    public static void oneDimensional(int n){
        System.out.println("Row\n");
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println("\nColumn\n");
        for (int i = 0; i < n; i++) {
            System.out.println("* ");
        }
    }

    public static void printSquare(int side){
        for (int i = 0; i < side; i++) {
            for (int j = 0; j <side ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printRectangle(int length,int breath){
        for (int i = 0; i <length ; i++) {
            for (int j = 0; j < breath; j++) {
                System.out.print("* ");
            }
            System.out.println("* ");
        }
    }

    public static void printRightTriangle(int height){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printXPattern(int n){
        if(n<5 || n%2==0){
            System.out.println("Give valid Input");
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                if(j==i || j==(n-1)-i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();


        }

    }

    public static void printPyramid(int height){
        for (int i = 0; i <height ; i++) {
            for (int j = 0; j < height-i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <(2*i-1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        oneDimensional(5);
        System.out.println("\nSquare\n");
        printSquare(5);
        System.out.println("\nRectangle\n");
        printRectangle(4,5);
        System.out.println("\nRight Triangle\n");
        printRightTriangle(5);
        System.out.println("\nPyramid\n");
        printPyramid(7);
        System.out.println("\nXPattern");
        printXPattern(5);
        printXPattern(6);
        printMatrixFormat(5);
        System.out.println();
    }
}