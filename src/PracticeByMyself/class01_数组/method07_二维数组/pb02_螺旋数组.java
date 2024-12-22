package PracticeByMyself.class01_数组.method07_二维数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mdy
 * @date 2024-12-19 18:17
 * @description <a href="https://leetcode.cn/problems/spiral-matrix/description/">...</a>
 */
public class pb02_螺旋数组 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1},
                {4},
                {7}
        };

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println(spiralOrder(matrix));
        // [1,2,3,4,8,12,11,10,9,5,6,7]
        System.out.println(spiralOrder(matrix2));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int upperBound = 0, underBound = m - 1;
        int leftBound = 0, rightBound = n - 1;

        while (res.size() != m * n) {
            for (int i = leftBound; i <= rightBound; i++) {
                res.add(matrix[upperBound][i]);
            }
            upperBound++;

            for (int i = upperBound; i <= underBound; i++) {
                res.add(matrix[i][rightBound]);
            }
            rightBound--;

            // 如果一轮螺旋遍历还没有结束就遍历完成，就可能导致下面两次访问溢出
            // 所以要加边界条件
            for (int i = rightBound; i >= leftBound && upperBound <= underBound; i--) {
                res.add(matrix[underBound][i]);
            }
            underBound--;

            for (int i = underBound; i >= upperBound && leftBound <= rightBound; i--) {
                res.add(matrix[i][leftBound]);
            }
            leftBound++;
        }
        return res;
    }
}
