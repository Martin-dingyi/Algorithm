package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/24 17:05
 * @description <a href="https://leetcode.cn/problems/n-queens/">...</a>
 */

public class pb03_N皇后 {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    private static Character[][] board;
    private static List<List<String>> ans;
    public static List<List<String>> solveNQueens(int n) {
        board = new Character[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        ans = new ArrayList<>();
        traverse(0, n);
        return ans;
    }

    static void traverse(int row, int n) {
        if (row == n) {
            List<String> res = new ArrayList<>();
            for (Character[] rows : board) {
                StringBuilder sb = new StringBuilder();
                for (Character ch : rows) {
                    sb.append(ch);
                }
                res.add(sb.toString());
            }
            ans.add(res);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(row, col, n)) {
                continue;
            }
            board[row][col] = 'Q';
            traverse(row + 1, n);
            board[row][col] = '.';
        }

    }

    private static boolean isValid(int row, int col, int n) {
        int diagonal = row - col;
        int iDiagonal = row - Math.abs(col - n + 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - j == diagonal || (i - Math.abs(j - n + 1) == iDiagonal) || i == row || j == col) {
                    if (board[i][j] != '.') return false;
                }
            }
        }
        return true;
    }
}
