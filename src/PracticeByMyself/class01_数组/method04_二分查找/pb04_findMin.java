package PracticeByMyself.class01_数组.method04_二分查找;

/**
 * @author mdy
 * @date 2024-12-12 22:48
 * @description <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/">...</a>
 * 思路1：
 */

public class pb04_findMin {

    public static void main(String[] args) {
        int[] nums1 = {3,1,2};
        int[] nums2 = {5,1,2,3,4};
        int[] nums3 = {1,2,3,4,5};
        System.out.println(findMin(nums1)); // 1
        System.out.println(findMin(nums2)); // 1
        System.out.println(findMin(nums3)); // 1
    }

    private static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int res = nums[0];
        while (left <= right) {
            int mid = (left +right) >> 1;
            res = Math.min(res, nums[mid]);
            // 只要mid在左边，就往右移；只要mid在右边，就往左移，必然遍历到最小值
            if (nums[mid] >= nums[left] && nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }


    private static int findMin1(int[] nums) {
        int res = nums[0];
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[left] > nums[right]) {
                if (nums[mid] < nums[right]) {
                    right = mid - 1;
                    res = Math.min(res, nums[mid]);
                } else {
                    left = mid + 1;
                    res = Math.min(res, nums[right]);
                }
            } else {
                return Math.min(res, nums[left]);
            }
        }

        return res;
    }
}
