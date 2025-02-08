package PracticeByMyself.class05_图.DFS;

/**
 * @author Martin
 * @date 2025/1/26 20:04
 * @description <a href="https://leetcode.cn/problems/number-of-closed-islands/description/">...</a>
 * 思路1：先把边上的陆地全变成水，然后再用解经典岛屿问题的方法解题
 */

public class pb11_封闭岛屿的数量 {

    public static void main(String[] args) {

    }

    public static int closedIsland(int[][] grid) {
        int count = 0;
        // 先把边上的陆地全变成水
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            traverse(grid, i, 0);
            traverse(grid, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            traverse(grid, 0, i);
            traverse(grid, m - 1, 0);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    traverse(grid, i, j);
                }
            }
        }

        return count;
    }

    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static void traverse(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 1) {
            return;
        }

        grid[x][y] = 1;
        for (int[] d : dirs) {
            int nextX = x + d[0], nextY = y + d[1];
            traverse(grid, nextX, nextY);
        }
    }

}
