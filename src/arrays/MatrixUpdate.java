package arrays;
public class MatrixUpdate {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 1, 1}
        };

        int rows = mat.length;
        int cols = mat[0].length;

        // Copy of the matrix
        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(mat[i], 0, copy[i], 0, cols);
        }

        // Traverse original matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    // Top
                    if (i - 1 >= 0) copy[i - 1][j] = 0;
                    // Bottom
                    if (i + 1 < rows) copy[i + 1][j] = 0;
                    // Left
                    if (j - 1 >= 0) copy[i][j - 1] = 0;
                    // Right
                    if (j + 1 < cols) copy[i][j + 1] = 0;
                }
            }
        }

        // Print the result
        System.out.println("Output:");
        for (int[] row : copy) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}