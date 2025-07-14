package recursion.backtrack;

import java.util.ArrayList;

public class RatInMaze {

    public static void ratInMaze(int[][] maze, int row, int col, ArrayList<String> paths, StringBuilder path) {
        int n = maze.length;

        if (row < 0 || row >= n || col < 0 || col >= n || maze[row][col] == 0) {
            return;
        }

        if (row == n - 1 && col == n - 1) {
            paths.add(path.toString());
            return;
        }

        maze[row][col] = 0;

        // Move Down
        path.append('D');
        ratInMaze(maze, row + 1, col, paths, path);
        path.deleteCharAt(path.length() - 1);

        // Move Left
        path.append('L');
        ratInMaze(maze, row, col - 1, paths, path);
        path.deleteCharAt(path.length() - 1);

        // Move Right
        path.append('R');
        ratInMaze(maze, row, col + 1, paths, path);
        path.deleteCharAt(path.length() - 1);

        // Move Up
        path.append('U');
        ratInMaze(maze, row - 1, col, paths, path);
        path.deleteCharAt(path.length() - 1);

        maze[row][col] = 1;
    }

    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        if (maze[0][0] == 1) {
            ratInMaze(maze, 0, 0, ans, new StringBuilder());
        }

        System.out.println(ans);
    }
}