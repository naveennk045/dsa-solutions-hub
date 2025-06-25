package matrix.dfs;

public class WordSearch {
    public static boolean search(char[][] board, String word, int r, int c, int index) {

        if (index == word.length()) return true;
        if (r < 0 || r > board.length - 1 || c < 0 || c > board[0].length - 1 || board[r][c] == '#') return false;

        if (word.charAt(index) != board[r][c]) {
            return false;
        }
        System.out.print(board[r][c]);
        board[r][c] = '#';


        boolean found = search(board, word, r - 1, c, index + 1) ||
                search(board, word, r + 1, c, index + 1) ||
                search(board, word, r, c - 1, index + 1) ||
                search(board, word, r, c + 1, index + 1);

        board[r][c] = word.charAt(index);
        return found;
    }

    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (search(board, word, i, j, 0)) return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCE";

        System.out.println(exist(board, word));


    }
}