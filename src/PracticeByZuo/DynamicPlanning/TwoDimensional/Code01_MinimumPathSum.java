package PracticeByZuo.DynamicPlanning.TwoDimensional;

import java.util.Arrays;

// 最小路径和
// 给定一个包含非负整数的 m x n 网格 grid
// 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
// 说明：每次只能向下或者向右移动一步。
// 测试链接 : https://leetcode.cn/problems/minimum-path-sum/
public class Code01_MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        // 初始化dp表
        minSumStore = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(minSumStore[i], Integer.MAX_VALUE);
        }
        return localMinPathSum(grid, 0, 0);
    }

    public static int localMinPathSum(int[][] grid, int rowIndex, int colIndex) {
        if (rowIndex == grid.length - 1 && colIndex == grid[0].length - 1) {
            return grid[rowIndex][colIndex];
        }
        if (rowIndex >= grid.length || colIndex >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        return grid[rowIndex][colIndex] + Math.min(localMinPathSum(grid, rowIndex + 1, colIndex), localMinPathSum(grid, rowIndex, colIndex + 1));
    }

    public static int[][] minSumStore;

    public static int topToBottom(int[][] grid, int rowIndex, int colIndex) {
        if (rowIndex == grid.length - 1 && colIndex == grid[0].length - 1) {
            return grid[rowIndex][colIndex];
        }
        if (minSumStore[rowIndex][colIndex] != Integer.MAX_VALUE) {
            return minSumStore[rowIndex][colIndex];
        }
        int localMinSum = grid[rowIndex][colIndex];
        if (rowIndex + 1 < grid.length && colIndex + 1 < grid[0].length) {
            localMinSum += Math.min(topToBottom(grid, rowIndex + 1, colIndex), topToBottom(grid, rowIndex, colIndex + 1));
        } else if (rowIndex + 1 < grid.length) {
            localMinSum += topToBottom(grid, rowIndex + 1, colIndex);
        } else if (colIndex + 1 < grid[0].length) {
            localMinSum += topToBottom(grid, rowIndex, colIndex + 1);
        }
        minSumStore[rowIndex][colIndex] = localMinSum;
        return localMinSum;
    }

    public static int bottomToTop(int[][] grid) {
        // 记录走到某一个格时的已经走过的最短路径
        int[] curMinPath = new int[grid[0].length];
        curMinPath[0] = grid[0][0];
        for (int i = 1; i < curMinPath.length; i++) {
            curMinPath[i] = curMinPath[i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < curMinPath.length; j++) {
                if (j == 0) {
                    curMinPath[j] += grid[i][j];
                } else {
                    curMinPath[j] = grid[i][j] + Math.min(curMinPath[j - 1], curMinPath[j]);
                }
            }
        }
        return curMinPath[curMinPath.length - 1];
    }

    public static void main(String[] args) {
        for (int times = 0; times < 100000; times++) {
            // 创建grid
            int m = (int) (Math.random() * 10) + 1;
            int n = (int) (Math.random() * 10) + 1;
            int[][] grid = new int[m][n];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = (int) (Math.random() * 7 + 1);
                }
            }
            // 初始化dp表
            minSumStore = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                Arrays.fill(minSumStore[i], Integer.MAX_VALUE);
            }
            int compare = localMinPathSum(grid, 0, 0);
            int ans = bottomToTop(grid);
            if (ans != compare) {
                for (int[] row : grid) {
                    System.out.println(Arrays.toString(row));
                }
                System.out.println("尝试答案：" + compare);
                System.out.println("正确答案：" + ans);
                System.out.println("出错");
                break;
            }
        }
        System.out.println("执行完成");
//        int[][] grid = new int[2][3];
//        grid[0][0] = 2;
//        grid[0][1] = 3;
//        grid[0][2] = 7;
//        grid[1][0] = 2;
//        grid[1][1] = 7;
//        grid[1][2] = 1;
//        System.out.println(bottomToTop(grid));
//        System.out.println(localMinPathSum(grid, 0, 0));
    }
}
