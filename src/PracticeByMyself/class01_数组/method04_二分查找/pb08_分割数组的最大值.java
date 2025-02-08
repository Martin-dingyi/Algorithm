package PracticeByMyself.class01_数组.method04_二分查找;

/**
 * @author mdy
 * @date 2024-12-13 11:05
 * @description <a href="https://leetcode.cn/problems/split-array-largest-sum/description/">...</a>
 * 思路1：转成运货问题
 */

public class pb08_分割数组的最大值 {

    public static void main(String[] args) {
        int[] nums1 = {7, 2, 5, 10, 8};
        int[] nums2 = {1,4,4};
        System.out.println(splitArray(nums1, 2)); // 18
        System.out.println(splitArray(nums2, 3)); // 9
    }

    public static int splitArray(int[] nums, int k) {
        int left = nums[0], right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (groupCount(nums, mid) <= k) {
                // k > maxGroup，需要减小mid，才能让分组变大。
                // k在范围内也要尽量往左找
                right = mid - 1;
            } else {
                // k < minGroup，需要增大mid，才能让分组变少
                left = mid + 1;
            }
        }

        return left;
    }

    private static int groupCount(int[] nums, int sum) {
        int groupCount = 0;
        int curSum;
        int index = 0;
        while (index < nums.length) {
            curSum = sum;
            while (index < nums.length && curSum >= nums[index]) {
                curSum -= nums[index++];
            }
            groupCount++;
        }
        return groupCount;
    }

}
