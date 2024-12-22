package PracticeByMyself.class01_数组.method07_二维数组;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-12-19 18:17
 * @description <a href="https://leetcode.cn/problems/spiral-matrix-ii/description/">...</a>
 */
public class pb03_螺旋数组2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int upperBound = 0, underBound = n - 1;
        int leftBound = 0, rightBound = n - 1;

        int num = 1;

        while (num <= n * n) {
            for (int i = leftBound; i <= rightBound; i++) {
                matrix[upperBound][i] = num++;
            }
            upperBound++;

            for (int i = upperBound; i <= underBound; i++) {
                matrix[i][rightBound] = num++;
            }
            rightBound--;

            // 如果一轮螺旋遍历还没有结束就遍历完成，就可能导致下面两次访问溢出
            // 所以要加边界条件
            for (int i = rightBound; i >= leftBound && upperBound <= underBound; i--) {
                matrix[underBound][i] = num++;
            }
            underBound--;

            for (int i = underBound; i >= upperBound && leftBound <= rightBound; i--) {
                matrix[i][leftBound] = num++;
            }
            leftBound++;
        }

        return matrix;
    }

}
