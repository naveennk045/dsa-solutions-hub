package companywise;


//https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/description/

import java.util.Arrays;

public class TicTacGame {

    public static String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];

        // Fill the board
        boolean isA = true;
        for (int[] move : moves) {
            board[move[0]][move[1]] = isA ? 'X' : 'O';
            isA = !isA;
        }

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return board[i][0] == 'X' ? "A" : "B";
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return board[0][i] == 'X' ? "A" : "B";
        }

        // Check diagonals
        if (board[1][1] != 0 &&
                ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                        (board[0][2] == board[1][1] && board[1][1] == board[2][0])))
            return board[1][1] == 'X' ? "A" : "B";

        return moves.length == 9 ? "Draw" : "Pending";
    }

    public static void main(String[] args) {

        int[][] moves={
                {0,0},{2,0},{1,1},{2,1},{2,2}
        };
        String winner=tictactoe(moves);
        System.out.println(winner);


    }
}