package advanced.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NearestCell {

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int[][] updateMatrix(int[][] mat) {

        int row = mat.length, col = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[row][col];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        findDistanceUsingBFS(mat, queue, distance);
        return distance;
    }

    public static void findDistanceUsingBFS(int[][] matrix, Queue<int[]> queue, int[][] distance) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];


        while (!queue.isEmpty()) {

            int[] removedCell = queue.poll();
            int rRow = removedCell[0];
            int rCol = removedCell[1];
            visited[rRow][rCol] = true;

            for (int[] direction : directions) {

                int newRow = direction[0] + rRow;
                int newCol = direction[1] + rCol;

                if (!isValidCell(matrix, newRow, newCol)) continue;

                if (!visited[newRow][newCol] &&
                        distance[newRow][newCol] > distance[rRow][rCol] + 1) {
                    visited[newRow][newCol] = true;
                    distance[newRow][newCol] = distance[rRow][rCol] + 1;

                    queue.add(new int[]{newRow, newCol});
                }
            }

        }

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
