package matrix;

import java.util.Arrays;

public class SetMatrix {
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] column = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // set row as zero
        for (int i = 0; i < n; i++) {
            if (row[i])
                Arrays.fill(matrix[i], 0);
        }

        // set columns as zero
        for (int i = 0; i < m; i++) {
            if (!column[i])
                continue;
            for (int j = 0; j < n; j++) {
                matrix[j][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 3, 25},
                {7, 15, 1},
                {20, 2, 8}
        };

        setZeroes(matrix);
    }
}