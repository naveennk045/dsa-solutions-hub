package advanced.graph;

public class NoOfIslands {

    public static int numIslands(char[][] grid) {

        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int row, int col, boolean[][] visited) {

        if (!isValidCell(grid, row, col)) return;
        if (visited[row][col] || grid[row][col] == '0') return;

        visited[row][col] = true;
        dfs(grid, row - 1, col, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row, col + 1, visited);
    }

    public static boolean isValidCell(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    static void main() {

    }
}
