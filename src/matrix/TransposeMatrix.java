package matrix;

import java.util.Arrays;

public class TransposeMatrix {
    // only applicable for square matrix
    public static void transposeInPlace(int[][] matrix){
        int n=matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    public static int[][] transpose(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 3, 25},
                {7, 15, 1},
                {20, 2, 8}
        };


//        matrix = transpose(matrix);
        transposeInPlace(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

    }
}