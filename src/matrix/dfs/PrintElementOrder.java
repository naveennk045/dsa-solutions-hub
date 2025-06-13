package matrix.dfs;

public class PrintElementOrder {
    public static void dfs(int[][] matrix, int r, int c, boolean[][] visited) {
        if (r < 0 || r > matrix.length - 1 || c < 0 || c > matrix[0].length - 1 || visited[r][c]) return;

        visited[r][c] = true;
        System.out.print(matrix[r][c] + " ");

        dfs(matrix, r - 1, c, visited); // up
        dfs(matrix, r + 1, c, visited); // down
        dfs(matrix, r, c - 1, visited); // left
        dfs(matrix, r, c + 1, visited); // right
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        dfs(matrix, 0, 0, visited);
    }
}