package PracticeByMyself.class05_图.DFS;

/**
 * @author Martin
 * @date 2025/1/27 13:11
 * @description <a href="https://leetcode.cn/problems/unique-paths-iii/">...</a>
 */

public class pb15_不同路径3 {

    public static void main(String[] args) {

    }

    static int[][] dirs = new int[][]{{1, 0}, {0, 1},{-1, 0}, {0, -1}};
    static int pathCount, beginX, beginY, endX, endY, zeroCount;
    public static int uniquePathsIII(int[][] grid) {
        pathCount = 0;
        int m = grid.length, n = grid[0].length;
        // 找到起始点、终止点坐标，并统计无障碍路标个数
        zeroCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                if (val == 1) {
                    beginX = i;
                    beginY = j;
                } else if (val == 2) {
                    endX = i;
                    endY = j;
                } else if (val == 0) {
                    zeroCount++;
                }
            }
        }
        traverse(grid, beginX, beginY, -1);

        return pathCount;
    }

    static void traverse(int[][] grid, int x, int y, int pathZero) {
        int val = grid[x][y];
        if (val == -1) {
            return;
        }

        if (val == 2) {
            if (pathZero == zeroCount) pathCount++;
            return;
        }

        int m = grid.length, n = grid[0].length;
        grid[x][y] = -1;
        if (x + 1 < m) traverse(grid, x + 1, y, pathZero + 1);
        if (x - 1 >= 0) traverse(grid, x - 1, y, pathZero + 1);
        if (y + 1 < n) traverse(grid, x, y + 1, pathZero + 1);
        if (y - 1 >= 0) traverse(grid, x, y - 1, pathZero + 1);
        grid[x][y] = 0;
    }
}
