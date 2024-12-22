package PracticeByMyself.class01_数组.method07_二维数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mdy
 * @date 2024-12-20 9:53
 * @description <a href="https://leetcode.cn/problems/shift-2d-grid/description/">...</a>
 * 思路1：利用两次反转的技巧来做；需要将数组拉伸为一维数组
 */
public class pb05_二维网格迁移 {

    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] grid2 = {
                {3, 8, 1, 9},
                {19, 7, 2, 5},
                {4, 6, 11, 10},
                {12, 0, 21, 13}
        };

        System.out.println(get(grid2, 7));
        System.out.println(shiftGrid(grid1, 1));
        System.out.println(shiftGrid(grid2, 4));

    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int size = m * n;
        k = k % size;
        List<List<Integer>> res = new ArrayList<>();
        // 反转整个数组
        reverse(grid, 0, size - 1);
        // 再分别反转两部分
        reverse(grid, 0, k - 1);
        reverse(grid, k, size - 1);

        for (int[] row : grid) {
            List<Integer> rowList = new ArrayList<>();
            for (int num : row) {
                rowList.add(num);
            }
            res.add(rowList);
        }

        return res;
    }

    private static void reverse(int[][] grid, int begin, int end) {
        while (begin < end) {
            int temp = get(grid, begin);
            set(grid, begin, get(grid, end));
            set(grid, end, temp);
            begin++;
            end--;
        }
    }

    // 通过一维数组的索引访问二维数组的元素
    static int get(int[][] grid, int index) {
        int n = grid[0].length;
        int i = index / n, j = index % n;
        return grid[i][j];
    }

    // 通过一维数组的索引修改二维数组的元素
    static void set(int[][] grid, int index, int val) {
        int n = grid[0].length;
        int i = index / n, j = index % n;
        grid[i][j] = val;
    }
}
