package solvedproblems.platform.leetcode;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Iterate through the board to find the first letter of the word
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int r, int c, String word, int index) {
        if (index == word.length()) { // Found entire word
            return true;
        }

        // Check boundaries and if the character matches
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark cell as visited by modifying it temporarily
        char temp = board[r][c];
        board[r][c] = '#';

        // Explore all 4 directions (up, down, left, right)
        boolean found = dfs(board, r + 1, c, word, index + 1) || // Down
                dfs(board, r - 1, c, word, index + 1) || // Up
                dfs(board, r, c + 1, word, index + 1) || // Right
                dfs(board, r, c - 1, word, index + 1);   // Left

        // Restore the cell after exploration
        board[r][c] = temp;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };

        String word = "ABEF";
        System.out.println("Word Found: " + exist(board, word));
    }
}