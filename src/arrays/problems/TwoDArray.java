package arrays.problems;

import java.util.Arrays;

public class TwoDArray {
    public static boolean isIdentity(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i==j && arr[i][j]!=1){
                    return false;
                }
                if(i!=j && arr[i][j]!=0){
                    return false;
                }
            }
        }
        return true;
    }

    public static String sparseOrDense(int[][] mat){
        int zeroCount=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0)
                    zeroCount++;
            }
        }
        int total=mat.length*mat[0].length;
        return (total-zeroCount)>zeroCount ? "DenseMatrix" : "SparseMatrix";
    }

    public static int lowerTriangle(int[][] mat){
        int sum=0;
        int k=0;
        for (int i = mat.length-1; i>=0; i--) {
            for (int j = k; j <mat[i].length; j++) {
                sum += mat[i][j];
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
            k++;
        }
        return sum;
    }

    public static int upperTriangle(int[][] mat){
        int sum=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length-i; j++) {
                sum += mat[i][j];
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        return sum;
    }


    public static int sumOfDiagonal(int[][] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i][i];
        }
        return sum;
    }
    public static int sumOfDiagonalI(int[][] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i==j || j==arr[0].length-i-1) sum+=arr[i][j];
            }
        }
        return sum;
    }
    public static void printX(String word) {
        int n = word.length();
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                if (i == j) {
                    System.out.print(word.charAt(i));
                } else if (j == n - i - 1) {
                    System.out.print(word.charAt(n-i-1));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void sumOfRowWise(int[][] arr){
        for(int row=0;row<arr.length;row++){
            int sum=0;
            for(int col=0;col<arr[row].length;col++){
                sum+=arr[row][col];
            }
            System.out.printf("Row %d : %d%n",row,sum);
        }
    }
    public static void sumOfColumnWise(int[][] arr){
        for(int col=0;col<arr[0].length;col++){
            int sum=0;
            for(int row=0;row<arr.length;row++){
                sum+=arr[col][row];
            }
            System.out.printf("col %d : %d%n",col,sum);
        }
    }



    public  static void print(int[][] arr) {
        for(int row=0;row<arr.length;row++) {
            System.out.println(Arrays.toString(arr[row]));
        }
    }
    public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);
////
//        int rowSize=scan.nextInt();
//        int[][] arr=new int[rowSize][];
//
//        for(int row=0;row<rowSize;row++){
//            int colSize= scan.nextInt();
//            arr[row]=new int[colSize];
//            for (int col = 0; col < colSize; col++) {
//                arr[row][col]=scan.nextInt();
//            }
//        }
//
//        System.out.println(isIdentity(arr));
//        System.out.println(sumOfDiagonal(arr));
//        sumOfRowWise(arr);
//        sumOfColumnWise(arr);
//        System.out.println(sumOfDiagonalI(arr));
//        printX("Program");
        int[][] mat={
                {1,0,0},
                {1,0,1},
                {0,0,1},
                {0,0,0}
            };
        System.out.println(upperTriangle(mat));
        System.out.println(lowerTriangle(mat));
        System.out.println(sparseOrDense(mat));



//        print(arr);
    }


}