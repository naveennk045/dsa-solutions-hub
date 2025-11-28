package advanced.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NearestCell {

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int[][] updateMatrix(int[][] mat) {

        Queue<int[]> queue = new LinkedList<>();


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        return findDistanceUsingBFS(mat, );
    }

    public static int[][] findDistanceUsingBFS(int[][] matrix, Queue<int[]> queue) {

        int row = matrix.length, col = matrix[0].length;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] distance = new int[row][col];

        int levels = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {

                int[] removedCell = queue.poll();
                for (int[] direction : directions) {

                    int newRow = removedCell[0] + direction[0];
                    int newCol = removedCell[1] + direction[1];
                    if (!isValidCell(matrix, newRow, newCol)) {
                        continue;
                    }
                    if (!visited[newRow][newCol] && matrix[newRow][newCol] == 1) {

                        visited[newRow][newCol] = true;
                        queue.add(new int[]{newRow, newCol});

                    } else if (matrix[newRow][newCol] == 0) {
                        continue;
                    }
                }
            }
            levels++;
        }

        return distance;
    }

    public static boolean isValidCell(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    public static int findDistanceUsingDFS(int[][] matrix, int row, int col
            , boolean[][] visited, int distanceSoFar) {
        /*
         * This is DFS implementation, It is not efficient for this
         * Time Complexity : O ( n * m * n * m )
         * */
        if ((row < 0) || (row >= matrix.length) || (col < 0) || (col >= matrix[0].length) ||
                visited[row][col]) {
            return Integer.MAX_VALUE;
        }

        if (matrix[row][col] == 0) return distanceSoFar;
        visited[row][col] = true;

        int up = findDistanceUsingDFS(matrix, row - 1, col, visited, distanceSoFar + 1);
        int down = findDistanceUsingDFS(matrix, row + 1, col, visited, distanceSoFar + 1);
        int left = findDistanceUsingDFS(matrix, row, col - 1, visited, distanceSoFar + 1);
        int right = findDistanceUsingDFS(matrix, row, col + 1, visited, distanceSoFar + 1);

        visited[row][col] = false;
        return Math.min(Math.min(up, down), Math.min(left, right));


    }

    public static void main(String[] args) {

    }
}
