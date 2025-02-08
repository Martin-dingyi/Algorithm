package PracticeByMyself.class05_图.DFS;

/**
 * @author Martin
 * @date 2025/1/28 18:23
 * @description <a href="https://leetcode.cn/problems/word-search/description/">...</a>
 * 思路：只要知道起始位置和终止位置，就可以利用dfs遍历出所有路径，然后通过题目限定条件进行剪枝即可
 */

public class pb22_单词搜索 {

    public static void main(String[] args) {
        char[][] board  ={{'a'}};
        System.out.println(exist(board, "a"));
    }

    static boolean[][] visited;
    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[m][n];
                    if (traverse(board, i, j, 0, word.toCharArray())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 定义：检查chars是否存在于board中
    static boolean traverse(char[][] board, int x, int y, int index, char[] chars) {
        if (index == chars.length) {
            return true;
        }

        int m = board.length, n = board[0].length;
        if (x >= m || x < 0 || y >= n || y < 0) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        if (board[x][y] != chars[index]) {
            return false;
        }

        visited[x][y] = true;
        boolean res1 = traverse(board, x + 1, y, index + 1, chars);
        boolean res2 = traverse(board, x - 1, y, index + 1, chars);
        boolean res3 = traverse(board, x, y + 1, index + 1, chars);
        boolean res4 = traverse(board, x, y - 1, index + 1, chars);
        visited[x][y] = false;
        return res1 || res2 || res3 || res4;
    }

}
