package matrix;

public class ZigZagFashion {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11,23}
        };


        printZigZagForm(matrix);
    }

    private static void printZigZagForm(int[][] matrix) {
        int maxLength = Math.max(matrix.length, matrix[0].length);
        boolean timeToDown = true;
        for (int i = 0; i < maxLength; i++) {

            if (i == 0 ) {
                System.out.print(matrix[i][i] + " ");
                System.out.println();
                continue;
            }
            if (timeToDown) {
                goDown(matrix, 0, i);
            } else {
                goUp(matrix, i, 0);
            }

            timeToDown = !timeToDown;
            System.out.println();
        }
    }




    private static void goDown(int[][] matrix, int row, int col) {
        while ((row < matrix.length) && (col >= 0)) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col--;
        }
    }

    private static void goUp(int[][] matrix, int row, int col) {
        while ((row >= 0) && (col < matrix[0].length)) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
    }
}