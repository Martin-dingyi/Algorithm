package PracticeByMyself.class01_数组.method04_二分查找;

/**
 * @author Martin
 * @date 2024/12/25 10:47
 * @description <a href="https://leetcode.cn/problems/search-insert-position/description/">...</a>
 */

public class pb13_探索插入位置 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 2)); // 1
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
