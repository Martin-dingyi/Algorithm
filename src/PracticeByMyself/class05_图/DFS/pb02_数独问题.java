package PracticeByMyself.class05_图.DFS;

import java.util.*;

/**
 * @author Martin
 * @date 2025/1/24 16:04
 * @description <a href="https://leetcode.cn/problems/sudoku-solver/description/">...</a>
 * 思路1：利用三种map记录每行、每列、每个九宫格内部所有已存在的数字，
 */

public class pb02_数独问题 {

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
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    static HashMap<Integer, Set<Character>> rowNum, colNum, grimNum;
    static boolean find;
    public static void solveSudoku(char[][] board) {
        find = false;
        rowNum = new HashMap<>();
        colNum = new HashMap<>();
        grimNum = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            rowNum.put(i, new HashSet<>());
            colNum.put(i, new HashSet<>());
            grimNum.put(i, new HashSet<>());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char curChar = board[i][j];
                if (curChar != '.') {
                    rowNum.get(i).add(curChar);
                    colNum.get(j).add(curChar);
                    int grim = i / 3 * 3 + j / 3;
                    grimNum.get(grim).add(curChar);
                }
            }
        }
        traverse(board, 0);
    }

    static void traverse(char[][] board, int index) {
        if (find) {
            return;
        }

        if (index == board.length * board[0].length) {
            find = true;
            return;
        }

        int row = index / board[0].length, col = index % board[0].length;
        int grim = row / 3 * 3 + col / 3;
        if (board[row][col] != '.') {
            traverse(board, index + 1);
            return;
        }

        for (char curChar = '1'; curChar <= '9'; curChar++) {
            if (rowNum.get(row).contains(curChar) || colNum.get(col).contains(curChar) || grimNum.get(grim).contains(curChar)) {
                continue;
            }
            board[row][col] = curChar;
            rowNum.get(row).add(curChar);
            colNum.get(col).add(curChar);
            grimNum.get(grim).add(curChar);
            traverse(board, index + 1);
            if (find) {
                return;
            }
            rowNum.get(row).remove(curChar);
            colNum.get(col).remove(curChar);
            grimNum.get(grim).remove(curChar);
            board[row][col] = '.';
        }
    }

}
