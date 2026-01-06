package advanced.recursion;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) &&
                        existUtils(board, word, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean existUtils(char[][] board, String word, int idx, int row, int col, boolean[][] visited) {

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col])
            return false;

        if (idx >= word.length() || board[row][col] != word.charAt(idx))
            return false;

        visited[row][col] = true;

        boolean up = existUtils(board, word, idx + 1, row - 1, col, visited);
        boolean down = existUtils(board, word, idx + 1, row + 1, col, visited);
        boolean left = existUtils(board, word, idx + 1, row, col - 1, visited);
        boolean right = existUtils(board, word, idx + 1, row, col + 1, visited);

        return up || down || left || right;
    }


    public static void main(String[] args) {

    }
}
