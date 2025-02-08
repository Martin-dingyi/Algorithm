package PracticeByMyself.class05_图.DFS;

/**
 * @author Martin
 * @date 2025/1/26 20:23
 * @description <a href="https://leetcode.cn/problems/count-sub-islands/description/">...</a>
 * 思路1：找grid2中的岛屿，没找到一个就和grid1进行比较，如果是子岛就count+1，然后淹掉2中的这个岛，在继续比
 * 思路2：将2中肯定不是子岛的岛淹掉，然后再计算2中的剩下岛的数量。
 */

public class pb13_统计子岛屿 {

    public static void main(String[] args) {

    }


    static int count;
    static boolean exits;
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        count = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1) {
                    if (grid1[i][j] == grid2[i][j]) {
                        // 判断是否存在子岛屿
                        exits = true;
                        isExists(grid1, grid2, i, j);
                        if (exits) {
                            count++;
                        }
                    }
                }

            }
        }
        return count;
    }

    // 边比较边将2中的这个岛屿淹没
    private static void isExists(int[][] grid1, int[][] grid2, int x, int y) {
        if (x < 0 || y < 0 || x >= grid2.length || y >= grid2[0].length || grid2[x][y] == 0) {
            return;
        }

        if (grid2[x][y] == 1 && grid1[x][y] == 0) {
            exits = false;
        }

        grid2[x][y] = 0;
        for (int[] d : dirs) {
            int nextX = x + d[0], nextY = y + d[1];
            isExists(grid1, grid2, nextX, nextY);
        }

    }

    static void traverse(int[][] grid2, int x, int y) {
        if (x < 0 || y < 0 || x >= grid2.length || y >= grid2[0].length || grid2[x][y] == 0) {
            return;
        }

        grid2[x][y] = 0;
        for (int[] d : dirs) {
            int nextX = x + d[0], nextY = y + d[1];
            traverse(grid2, nextX, nextY);
        }
    }

}
