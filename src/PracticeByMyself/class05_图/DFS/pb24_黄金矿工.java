package PracticeByMyself.class05_图.DFS;

/**
 * @author Martin
 * @date 2025/1/28 19:16
 * @description <a href="https://leetcode.cn/problems/path-with-maximum-gold/description/">...</a>
 */

public class pb24_黄金矿工 {

    public static void main(String[] args) {

    }

    static int max;
    static boolean[][] visited;
    public static int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    visited = new boolean[m][n];
                    traverse(grid, i, j, 0);
                }
            }
        }
        return max;
    }

    static void traverse(int[][] grid, int x, int y, int path) {
        int m = grid.length, n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            max = Math.max(max, path);
            return;
        }


        if (grid[x][y] == 0 || visited[x][y]) {
            max = Math.max(max, path);
            return;
        }

        visited[x][y] = true;
        traverse(grid, x + 1, y, path + grid[x][y]);
        traverse(grid, x - 1, y, path + grid[x][y]);
        traverse(grid, x, y + 1, path + grid[x][y]);
        traverse(grid, x, y - 1, path + grid[x][y]);
        visited[x][y] = false;
    }
}
