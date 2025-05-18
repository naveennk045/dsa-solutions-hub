package arrays.twoDarrays;

public class Traversal {
    public static void basicTraversal(int[][] matrix){
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void findSumOfElements(int[][] matrix) {
        int sum=0;
        for (int[] row : matrix) {
            for(int val :  row) {
                sum+=val;
            }
        }
        System.out.println(sum);
    }



    public static void printRowSums(int[][] matrix){

        for (int[] row : matrix) {
            int sum=0;
            for (int val : row) {
                sum+=val;
            }
            System.out.println(sum);
        }
    }

    public static void printColumnSum(int[][] matrix){
        for (int i = 0; i < matrix[0].length; i++) {
            int sum=0;
            for (int j = 0; j < matrix.length; j++) {
                sum+=matrix[j][i];
            }
            System.out.println(sum);
        }

    }
    public static void main(String[] args) {
        int[][] matrix = {
                {2,4,6,8},
                {9,7,5,3},
                {0,1,3,5}
        };

        System.out.println("Matrix : ");
        basicTraversal(matrix);
        System.out.print("Sum ");
        findSumOfElements(matrix);
        System.out.println("Row wise : ");
        printRowSums(matrix);
        System.out.println("Column wise : ");
        printColumnSum(matrix);



    }


}