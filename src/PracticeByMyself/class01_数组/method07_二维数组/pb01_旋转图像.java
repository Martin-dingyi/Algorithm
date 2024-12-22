package PracticeByMyself.class01_数组.method07_二维数组;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-12-19 17:57
 * @description <a href="https://leetcode.cn/problems/rotate-image/description/">...</a>
 * 思路：先沿着对角线翻转矩阵，然后再左右交换。特殊技巧，记住就行。
 */
public class pb01_旋转图像 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        // 沿着对角线镜像翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j < i) {
                    swapTwoDimension(matrix, i, j, j, i);
                }
            }
        }

        // 左右互换
        for (int col = 0; col < matrix[0].length / 2; col++) {
            for (int row = 0; row < matrix.length; row++) {
                swapTwoDimension(matrix, row, col, row, matrix[0].length - col - 1);
            }
        }
    }

    public static void swapTwoDimension(int[][] arr, int aRow, int aCol, int bRow, int bCol) {
        int temp = arr[aRow][aCol];
        arr[aRow][aCol] = arr[bRow][bCol];
        arr[bRow][bCol] = temp;
    }
}
