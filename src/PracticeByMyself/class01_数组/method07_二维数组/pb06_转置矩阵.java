package PracticeByMyself.class01_数组.method07_二维数组;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-12-20 11:09
 * @description
 */
public class pb06_转置矩阵 {
    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(Arrays.deepToString(transpose(grid1)));
    }

    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = matrix[j][i];
            }
        }

        return res;
    }

}
