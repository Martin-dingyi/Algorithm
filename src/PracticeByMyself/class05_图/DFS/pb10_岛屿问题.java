package PracticeByMyself.class05_图.DFS;

/**
 * @author Martin
 * @date 2025/1/26 19:47
 * @description <a href="https://leetcode.cn/problems/number-of-islands/">...</a>
 * 思路1：遇到1就让岛屿数量+1，然后淹没掉这座岛屿，接着寻找下一个岛
 */

public class pb10_岛屿问题 {

    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 找到岛屿，岛屿数量+1
                if (grid[i][j] == '1') {
                    count++;
                    // 淹没这座岛屿
                    traverse(grid, i, j);
                }
            }
        }

        return count;
    }

    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static void traverse(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }
        
        grid[x][y] = '0';
        for (int[] d : dirs) {
            int nextX = x + d[0], nextY = y + d[1];
            traverse(grid, nextX, nextY);
        }
    }

}
