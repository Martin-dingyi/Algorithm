package PracticeByMyself.class01_数组;

import java.util.HashSet;

/**
 * @author mdy
 * @date 2024-12-09 15:10
 * @description <a href="https://leetcode.cn/problems/valid-sudoku/">...</a>
 * 思路1：利用二维数组的特性，用哈希表保存各行、各列、各个九宫格里的数字，有重复即无效
 */
public class pb07_是有效的数独吗 {

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(board));

    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> numSet = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            numSet.clear();
            for (int j = 0; j < board[0].length; j++) {
                // 先遍历行
                if (board[i][j] == '.') {
                    continue;
                }
                if (!numSet.add(board[i][j])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            numSet.clear();
            for (int j = 0; j < board[0].length; j++) {
                // 遍历行
                if (board[j][i] == '.') {
                    continue;
                }
                if (!numSet.add(board[j][i])) {
                    return false;
                }
            }
        }

        int row = 0;
        int col = 0;


        for (int z = 0; z < 3; z++) {
            for (int i = 0; i < 3; i++) {
                numSet.clear();

                // 遍历一个九宫格
                for (int j = 0; j < 3; j++) {
                    boolean b1 = board[row + j][col] == '.' || numSet.add(board[row + j][col]);
                    boolean b2 = board[row + j][col + 1] == '.' || numSet.add(board[row + j][col + 1]);
                    boolean b3 = board[row + j][col + 2] == '.' || numSet.add(board[row + j][col + 2]);
                    if (!(b1 && b2 && b3)) {
                        return false;
                    }
                }
                col += 3;
            }
            col = 0;
            row += 3;
        }

        return true;
    }
}
