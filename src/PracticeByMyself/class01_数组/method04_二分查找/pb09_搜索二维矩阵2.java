package PracticeByMyself.class01_数组.method04_二分查找;

/**
 * @author Martin
 * @date 2024/12/23
 * @description <a href="https://leetcode.cn/problems/search-a-2d-matrix-ii/">...</a>
 *
 */

public class pb09_搜索二维矩阵2 {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix1, 5));
        System.out.println(searchMatrix(matrix1, 20));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int[] rows : matrix) {
            int left = 0;
            int right = matrix[0].length - 1;
            int mid;
            while (left <= right) {
                mid = left - ((left - right) >> 1);
                if (rows[mid] > target) {
                    right = mid - 1;
                } else if (rows[mid] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
