package PracticeByMyself.class01_数组.method04_二分查找;

/**
 * @author mdy
 * @date 2024-12-12 17:11
 * @description <a href="https://leetcode.cn/problems/search-a-2d-matrix/">...</a>
 * 思路1：对每一行进行二分查找，或转成二维数组再二分查找
 */
public class pb02_searchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(searchMatrix(matrix, 13));
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
