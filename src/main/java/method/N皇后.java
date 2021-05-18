package method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className: 51.N皇后
 * @Description: n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * @author: lpl
 * @date: 2021/5/18 20:02
 */
public class N皇后 {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(board, 0, n);
        return res;
    }

    List<List<String>> res = new ArrayList<>();

    public void backtrack(char[][] board, Integer row, int n) {
        if (row == n) {
            res.add(conversion(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, Integer row, Integer col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //向左上推
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //向右上推
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> conversion(char[][] strings) {
        List<String> stringArrayList = new ArrayList<>();
        for (char[] chars : strings) {
            stringArrayList.add(String.valueOf(chars));
        }
        return stringArrayList;
    }
}
