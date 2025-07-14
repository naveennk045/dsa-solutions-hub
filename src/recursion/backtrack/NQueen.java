package recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NQueen {
    public static boolean isValidBoard(List<String> board) {
        HashSet<Integer> columns = new HashSet<>();
        HashSet<Integer> mainDiagonals = new HashSet<>();
        HashSet<Integer> antiDiagonals = new HashSet<>();
        int n = board.size();

        for (int row = 0; row < n; row++) {
            String line = board.get(row);
            for (int col = 0; col < n; col++) {
                if (line.charAt(col) == '.') continue;

                if (columns.contains(col) ||
                        mainDiagonals.contains(row - col) ||
                        antiDiagonals.contains(row + col)) {
                    return false;
                }
                columns.add(col);
                mainDiagonals.add(row - col);
                antiDiagonals.add(row + col);
            }
        }
        return true;
    }

    public static void helper(int n, int row, List<String> board, List<List<String>> boards, boolean[] used) {
        if (row == n) {
            if (isValidBoard(board)) {
                boards.add(new ArrayList<>(board));
            }
            return;
        }

        for (int col = 0; col < n; col++) {
            if (used[col]) continue;

            used[col] = true;

            char[] line = new char[n];
            Arrays.fill(line, '.');
            line[col] = 'Q';

            board.add(new String(line));
            helper(n, row + 1, board, boards, used);
            board.removeLast();
            used[col] = false;

        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        boolean[] used = new boolean[n];
        helper(n, 0, new ArrayList<>(), list, used);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));


    }
}