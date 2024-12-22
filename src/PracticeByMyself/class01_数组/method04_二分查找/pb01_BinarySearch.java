package PracticeByMyself.class01_数组.method04_二分查找;

/**
 * @author mdy
 * @date 2024-12-12 17:10
 * @description <a href="https://leetcode.cn/problems/binary-search/">...</a>
 */
public class pb01_BinarySearch {

    public static void main(String[] args) {
        int[] nums1 = {-1,0,3,5,9,12};
        System.out.println(search(nums1, 9)); // 4
    }


    public static int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left < 0 || left >= nums.length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }
}
