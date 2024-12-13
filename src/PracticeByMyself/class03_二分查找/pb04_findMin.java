package PracticeByMyself.class03_二分查找;

/**
 * @author mdy
 * @date 2024-12-12 22:48
 * @description <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/">...</a>
 */
public class pb04_findMin {

    public static void main(String[] args) {
        int[] nums1 = {3,1,2};
        int[] nums2 = {5,1,2,3,4};
        System.out.println(findMin(nums1));
    }

    private static int findMin(int[] nums) {
        int res = nums[0];
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) >> 1;
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
