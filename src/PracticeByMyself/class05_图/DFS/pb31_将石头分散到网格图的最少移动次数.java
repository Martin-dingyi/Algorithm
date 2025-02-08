package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/29 19:01
 * @description <a href="https://leetcode.cn/problems/minimum-moves-to-spread-stones-over-grid/description/">...</a>
 * 思路1：将多的石子分配给数量为0的位置，穷举出所有分法
 * 思路2：盒子选球的视角：遍历grid，一旦遇到数量为0的位置，从grid中找到额外的石子给它，穷举所有可以给石子的情况
 */

public class pb31_将石头分散到网格图的最少移动次数 {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0},
                {1, 1, 1},
                {1, 2, 1}
        };
        System.out.println(minimumMoves(grid)); //
    }

    static int min;
    static List<int[]> redundantList, zeroList;
    public static int minimumMoves(int[][] grid) {
        min = Integer.MAX_VALUE;
        int m = grid.length, n = grid[0].length;
        redundantList = new ArrayList<>();
        zeroList = new ArrayList<>();
        int zeroCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = grid[i][j];
                if (cur == 0) {
                    zeroCount++;
                    zeroList.add(new int[]{i, j});
                } else if (cur > 1) {
                    redundantList.add(new int[]{i, j});
                }
            }
        }
        traverse(grid, zeroCount, 0);

        return min;
    }

    static void traverse(int[][] grid, int zeroCount, int count) {
        if (count >= min) {
            return;
        }
        if (zeroCount == 0) {
            min = count;
            return;
        }

        int m = grid.length, n = grid[0].length;
        for (int[] redundant : redundantList) {
            int x = redundant[0], y = redundant[1];
            if (grid[x][y] == 1) {
                continue;
            }
            for (int[] zero : zeroList) {
                int zeroX = zero[0], zeroY = zero[1];
                if (grid[zeroX][zeroY] > 0) {
                    continue;
                }
                grid[x][y]--;
                grid[zeroX][zeroY]++;
                traverse(grid, zeroCount - 1, count + Math.abs(x - zeroX) + Math.abs(y - zeroY));
                grid[zeroX][zeroY]--;
                grid[x][y]++;
            }
        }
    }

}
