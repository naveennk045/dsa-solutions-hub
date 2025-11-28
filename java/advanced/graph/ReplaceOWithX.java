package advanced.graph;

import java.util.Arrays;


public class ReplaceOWithX {

    public static void fill(char[][] grid) {
        /*
         * Approach is going to be using DFS by adding all the boundary O's into queue
         */

        int row = grid.length, col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && grid[i][j] == 'O') {
                    fillUsingDFS(grid, visited, i, j);
                }

            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j]) {
                    grid[i][j] = 'X';
                }
            }
        }

        System.out.println(Arrays.stream(visited)
                .map(Arrays::toString)
                .toList());


    }

    public static void fillUsingDFS(char[][] grid, boolean[][] visited, int row, int col) {

        if (!isValidCell(grid, row, col)) return;

        if (grid[row][col] == 'X' || visited[row][col]) return;

        visited[row][col] = true;
        fillUsingDFS(grid, visited, row - 1, col);
        fillUsingDFS(grid, visited, row + 1, col);
        fillUsingDFS(grid, visited, row, col - 1);
        fillUsingDFS(grid, visited, row, col + 1);

    }

    public static boolean isValidCell(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }


    static void main() {

    }
}
