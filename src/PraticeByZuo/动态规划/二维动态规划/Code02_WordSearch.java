package ByMartinPratice.动态规划.二维动态规划;

// 单词搜索（无法改成动态规划）
// 给定一个 m x n 二维字符网格 board 和一个字符串单词 word
// 如果 word 存在于网格中，返回 true ；否则，返回 false 。
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成
// 其中"相邻"单元格是那些水平相邻或垂直相邻的单元格
// 同一个单元格内的字母不允许被重复使用
// 测试链接 : https://leetcode.cn/problems/word-search/
public class Code02_WordSearch {

    public static boolean exist(char[][] board, String word) {
        char[] s = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == s[0]) {
                    if (findChar(board, i, j, s, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 递归函数作用：判断从该位置字母开始，网格中有没有合法路径。
    public static boolean findChar(char[][] board, int rowIndex, int colIndex, char[] s, int strIndex) {
        if (strIndex == s.length) {
            return true;
        }
        if (rowIndex < 0 || colIndex < 0 ||
                rowIndex == board.length ||
                colIndex == board[0].length ||
                board[rowIndex][colIndex] != s[strIndex]) {
            return false;
        }
        strIndex++;
        // 将这条路径中已经被访问过的位置置为0，因为s中没有ascll码为0的字母，所以相当于将该位置变为不可再被访问。
        char temp = board[rowIndex][colIndex];
        board[rowIndex][colIndex] = 0;
        // 判断该位置从四个方向走，是否至少有一个方向合法。
        boolean success =
                findChar(board, rowIndex + 1, colIndex, s, strIndex) ||
                findChar(board, rowIndex, colIndex + 1, s, strIndex) ||
                findChar(board, rowIndex - 1, colIndex, s, strIndex) ||
                findChar(board, rowIndex, colIndex - 1, s, strIndex);
        board[rowIndex][colIndex] = temp;
        return success;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = {{'a', 'b'}};
        String word = "ba";
        System.out.println(exist(board, word));
    }

}
