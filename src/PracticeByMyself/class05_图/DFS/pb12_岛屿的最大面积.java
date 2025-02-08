package PracticeByMyself.class05_图.DFS;

/**
 * @author Martin
 * @date 2025/1/26 20:19
 * @description <a href="https://leetcode.cn/problems/max-area-of-island/">...</a>
 */

public class pb12_岛屿的最大面积 {

    public static void main(String[] args) {

    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = 0;
                    traverse(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    static int area;
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static void traverse(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }

        grid[x][y] = 0;
        area++;
        for (int[] d : dirs) {
            int nextX = x + d[0], nextY = y + d[1];
            traverse(grid, nextX, nextY);
        }
    }


}
