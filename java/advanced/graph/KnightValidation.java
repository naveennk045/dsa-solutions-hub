package advanced.graph;

public class KnightValidation {
    static int[][] directions = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public static boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0) return false;

        boolean[][] visited = new boolean[n][n];
        return isValidConfig(grid, 0, 0, visited, 0);
    }

    private static boolean isValidConfig(int[][] grid, int row, int col, boolean[][] visited, int currentMove) {

        if (!isValidCell(grid, row, col) || visited[row][col] || currentMove != grid[row][col]) return false;

        int n = grid.length;
        if (currentMove == n * n - 1) return true;

        visited[row][col] = true;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isValidConfig(grid, newRow, newCol, visited, currentMove + 1)) return true;
        }

        return false;
    }

    private static boolean isValidCell(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    static void main() {

    }
}
