package PracticeByMyself.class01_数组.method04_二分查找;

/**
 * @author Martin
 * @date 2024/12/25 11:41
 * @description <a href="https://leetcode.cn/problems/peak-index-in-a-mountain-array/">...</a>
 */

public class pb15_山脉数组的顶峰索引 {

    public static void main(String[] args) {
        int[] nums1 = {0,10,5,2};
        int[] nums2 = {18,29,38,59,98,100,99,98,90};
        System.out.println(peakIndexInMountainArray(nums1)); // 1
        System.out.println(peakIndexInMountainArray(nums2)); // 5
    }

    public static int peakIndexInMountainArray(int[] nums) {
        int left = 1, right = nums.length - 2;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 1;
    }
}
