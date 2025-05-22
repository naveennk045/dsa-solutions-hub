package matrix;

public class ValidSudoku {
// https://leetcode.com/problems/valid-sudoku/
    public static boolean isValidRowColumns(char[][] board) {
        for (int i = 0; i < 9; i++) {

            int[] rowFreq = new int[10];
            int[] colFreq = new int[10];

            for (int j = 0; j < 9; j++) {
                int rowValue = board[i][j] - '0';
                int colValue = board[j][i] - '0';

                if (board[i][j] != '.') {
                    rowFreq[rowValue]++;
                    if (rowFreq[rowValue] > 1) return false;
                }
                if (board[j][i] != '.') {
                    colFreq[colValue]++;
                    if (colFreq[colValue] > 1) return false;

                }
            }
        }
        return true;
    }

    public static boolean idValidSubBoxes(char[][] board) {

        for (int rowStart = 0; rowStart < 9; rowStart += 3) {
            for (int columnStart = 0; columnStart < 9; columnStart += 3) {

                int[] freq = new int[10];
                for (int i = rowStart; i < rowStart + 3; i++) {
                    for (int j = columnStart; j < columnStart + 3; j++) {
                        if (board[i][j] != '.') {
                            freq[board[i][j] - '0']++;
                            if (freq[board[i][j] - '0'] > 1) return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {

        return isValidRowColumns(board) && idValidSubBoxes(board);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}