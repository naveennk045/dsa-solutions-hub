package advanced.graph;

import java.util.ArrayList;
import java.util.HashSet;

public class NoOfDistinctIsLands {

    public static int numIslands(int[][] grid) {

        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        HashSet<ArrayList<String>> coordinates = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ArrayList<String> currentCoordinates = new ArrayList<>();
                    dfs(grid, i, j, i, j, visited, currentCoordinates);
                    coordinates.add(currentCoordinates);
                }
            }
        }
        return coordinates.size();
    }

    private static void dfs(int[][] grid, int sRow, int sCol, int row, int col, boolean[][] visited, ArrayList<String> currentCoordinates) {

        if (!isValidCell(grid, row, col)) return;
        if (visited[row][col] || grid[row][col] == 0) return;

        visited[row][col] = true;

        currentCoordinates.add(String.format("%d,%d", sRow - row, sCol - col));

        dfs(grid, sRow, sCol, row - 1, col, visited, currentCoordinates);
        dfs(grid, sRow, sCol, row + 1, col, visited, currentCoordinates);
        dfs(grid, sRow, sCol, row, col - 1, visited, currentCoordinates);
        dfs(grid, sRow, sCol, row, col + 1, visited, currentCoordinates);
    }

    public static boolean isValidCell(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    static void main() {

    }

}
